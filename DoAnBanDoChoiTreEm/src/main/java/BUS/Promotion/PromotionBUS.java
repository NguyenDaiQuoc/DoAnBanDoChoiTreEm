// PromotionBUS.java
package Bus;

import Inventory.DAO.PromotionDAO;
import Inventory.DTO.PromotionDTO;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PromotionBUS {

    private PromotionDAO dao = new PromotionDAO();
    private ArrayList<PromotionDTO> promotionCache;

    public ArrayList<PromotionDTO> getAllPromotions() {
        if (promotionCache == null) {
            promotionCache = dao.getAllPromotions();
        }
        return new ArrayList<>(promotionCache);
    }

    public ArrayList<PromotionDTO> getPromotionsByKeyword(String keyword) {
        if (promotionCache == null) {
            promotionCache = dao.getAllPromotions();
        }
        ArrayList<PromotionDTO> result = new ArrayList<>();
        for (PromotionDTO promotion : promotionCache) {
            if (promotion.getNoiDung().contains(keyword)) {
                result.add(promotion);
            }
        }
        return result;
    }

    public ArrayList<PromotionDTO> searchPromotionById(String id) {
        if (promotionCache == null) {
            promotionCache = dao.getAllPromotions();
        }
        ArrayList<PromotionDTO> result = new ArrayList<>();
        for (PromotionDTO promotion : promotionCache) {
            if (promotion.getId().equals(id)) {
                result.add(promotion);
            }
        }
        return result;
    }

    public void exportToExcel(ArrayList<PromotionDTO> promotions, String filePath) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Promotions");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Nội dung");
        headerRow.createCell(2).setCellValue("Phần trăm giảm giá");

        // Create data rows
        for (int i = 0; i < promotions.size(); i++) {
            PromotionDTO promotion = promotions.get(i);
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(promotion.getId());
            row.createCell(1).setCellValue(promotion.getNoiDung());
            row.createCell(2).setCellValue(promotion.getPhanTramGiamGia());
        }

        // Write the output to a file
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPromotion(PromotionDTO promotion) {
        dao.addPromotion(promotion);
        promotionCache = null; // Invalidate the cache
    }

    public void removePromotion(String id) {
        dao.removePromotion(id);
        promotionCache = null; // Invalidate the cache
    }

    public void updatePromotion(PromotionDTO promotion) {
        dao.updatePromotion(promotion);
        promotionCache = null; // Invalidate the cache
    }
}
