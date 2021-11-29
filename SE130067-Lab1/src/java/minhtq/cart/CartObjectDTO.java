/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtq.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import minhtq.Cake.CakeDTO;

/**
 *
 * @author Khoa Pham
 */
public class CartObjectDTO implements Serializable{
    
    private Map<String, CakeDTO> items;
    
    public CartObjectDTO() {
    }
    
    public CartObjectDTO(Map<String, CakeDTO> items) {
        this.items = items;
    }
    
    public Map<String, CakeDTO> getItems() {
        return items;
    }
    
    public void setItems(Map<String, CakeDTO> items) {
        this.items = items;
    }
    
    
    // Lỗi
    public void addFoodToCart(CakeDTO dto) {
        if (this.items == null) {
            this.items = new HashMap<>();
        }
        if (this.items.containsKey(dto.getCakeID())) {
            int tmp = dto.getQuantity() - items.get(dto.getCakeID()).getQuantity();
            dto.setQuantity(dto.getQuantity() - tmp + 1);
        } else {
            dto.setQuantity(1);
        }
        this.items.put(dto.getCakeID(), dto);
    }
    
    public void removeCakeFromCart(String cakeID) {
        if (this.items == null) {
            return;
        }
        if (this.items.containsKey(cakeID)) {
            items.remove(cakeID);
            if (this.items.isEmpty()) {
                this.items = null;
            }
        }
    }
    
    public void updateCart(CakeDTO dto){
        if(items != null){
            if(items.containsKey(dto.getCakeID())){
                this.items.replace(dto.getCakeID(), dto);
            }
        }
    }
}
