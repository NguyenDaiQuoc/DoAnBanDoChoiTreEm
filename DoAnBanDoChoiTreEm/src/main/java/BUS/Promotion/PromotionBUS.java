// PromotionBUS.java
package Bus;

import Inventory.DAO.PromotionDAO;
import Inventory.DTO.PromotionDTO;
import java.util.ArrayList;

public class PromotionBUS {
    private PromotionDAO dao = new PromotionDAO();

    public ArrayList<PromotionDTO> getAllPromotions() {
        return dao.getAllPromotions();
    }

    public ArrayList<PromotionDTO> getPromotionsByKeyword(String keyword) {
        return dao.getPromotionsByKeyword(keyword);
    }

    public ArrayList<PromotionDTO> searchPromotionById(String id) {
        return dao.searchPromotionById(id);
    }

    public void addPromotion(PromotionDTO promotion) {
        dao.addPromotion(promotion);
    }

    public void removePromotion(int id) {
        dao.removePromotion(id);
    }

    public void updatePromotion(PromotionDTO promotion) {
        dao.updatePromotion(promotion);
    }
}
