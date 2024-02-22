/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginscene;

/**
 *
 * @Ahmed_Ali
 */
public class FriendWishdto {
    String ItemPhoto;
    String ItemName;
    String ItemPrice;
    String AmountPaid;
    String FriendUser;
    String ItemID;
    
    public FriendWishdto(String ItemPhoto, String ItemName, String ItemPrice, String AmountPaid,String FriendUser, String ItemID) {
        this.ItemPhoto = ItemPhoto;
        this.ItemName = ItemName;
        this.ItemPrice = ItemPrice;
        this.AmountPaid = AmountPaid;
        this.FriendUser = FriendUser;
        this.ItemID = ItemID;
    }
    
    public FriendWishdto(String ItemPhoto, String ItemName, String ItemPrice, String AmountPaid,String FriendUser) {
        this.ItemPhoto = ItemPhoto;
        this.ItemName = ItemName;
        this.ItemPrice = ItemPrice;
        this.AmountPaid = AmountPaid;
        this.FriendUser = FriendUser;
    }

    public String getItemPhoto() {
        return ItemPhoto;
    }

    public void setItemPhoto(String ItemPhoto) {
        this.ItemPhoto = ItemPhoto;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(String ItemPrice) {
        this.ItemPrice = ItemPrice;
    }

    public String getAmountPaid() {
        return AmountPaid;
    }

    public void setAmountPaid(String AmountPaid) {
        this.AmountPaid = AmountPaid;
    }
    public String getFriendUser() {
        return FriendUser;
    }

    public void setFriendUser(String FriendUser) {
        this.FriendUser = FriendUser;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String ItemID) {
        this.ItemID = ItemID;
    }
}
