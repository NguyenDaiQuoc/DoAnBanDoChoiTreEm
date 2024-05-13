// PromotionBUS.java
package Bus;

import Inventory.DAO.PromotionDAO;
import Inventory.DTO.PromotionDTO;
import java.util.ArrayList;

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
