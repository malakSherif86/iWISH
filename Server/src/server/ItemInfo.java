/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author M.El-fiqy
 */
public class ItemInfo {
    private String itemId;
    private String itemPhoto;

    public String getItemPhoto() {
        return itemPhoto;
    }

    public void setItemPhoto(String itemPhoto) {
        this.itemPhoto = itemPhoto;
    }

    public String getItemAmountLeft() {
        return itemAmountLeft;
    }

    public void setItemAmountLeft(String itemAmountLeft) {
        this.itemAmountLeft = itemAmountLeft;
    }
    private String itemName;
    private String itemPrice;
    private String itemAmountLeft;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getAmountLeft() {
        return itemAmountLeft;
    }

    public void setAmountLeft(String amountLeft) {
        this.itemAmountLeft = amountLeft;
    }

    public ItemInfo(String itemId, String itemName, String itemPrice, String itemAmountLeft, String itemPhoto) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemAmountLeft = itemAmountLeft;
        this.itemPhoto = itemPhoto;
    }
    
    
}
