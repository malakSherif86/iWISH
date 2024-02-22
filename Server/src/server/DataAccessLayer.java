/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import loginscene.NotificationDto;
/**
 *
 * @author Ali Magdy
 */
public class DataAccessLayer {
    Connection con=null;
    ResultSet rs=null;
    public DataAccessLayer(Connection con) throws SQLException{
            this.con=con;
    }

    public boolean authenticateUser(String user,String password) throws SQLException{
            PreparedStatement selectuser = con.prepareStatement("SELECT * FROM users where email=? and password=?");
            selectuser.setString(1,user);
            selectuser.setString(2,password);
            rs = selectuser.executeQuery() ;
            if (rs.next()) {
                return true;
            }
            else{
                return false;
            }
    }
    public String RegisterUser(String fname,String lname,String email ,String password) throws SQLException{
        try {
                PreparedStatement insertpst = con.prepareStatement("INSERT INTO users (email, first_name, last_name, password ) VALUES(?,?,?,?)");
                insertpst.setString(1,email);
                insertpst.setString(2,fname);
                insertpst.setString(3,lname);
                insertpst.setString(4,password);
                insertpst.executeUpdate();
                return "RegisterationSuccess";
            } 
            catch (SQLException ex) {
                    return "RegisterationFailed";
            }
                    

    }

    public profileInfo profileData(String email) throws SQLException{
        PreparedStatement pst = con.prepareStatement("SELECT first_name, wallet FROM users where email=? ");
        pst.setString(1,email);
        ResultSet rs = pst.executeQuery();
        rs.next();
        String fn = rs.getString(1);
        String wallet = rs.getString(2);
        profileInfo pf = new  profileInfo(fn,wallet);
        return pf;
    }

    public ArrayList<ItemInfo> itemsData(String email) throws SQLException
    {
        ArrayList<ItemInfo> iteminfo = new ArrayList<>();
        PreparedStatement pst = con.prepareStatement("SELECT u.itemID, i.itemName, i.itemPrice , u.amountPaid, i.ItemPhoto FROM userwishlist u join items i join users us  on i.itemID = u.itemID and u.userEmail = us.email  where u.useremail=? ");
        pst.setString(1,email);
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            ItemInfo itemInfoList = new ItemInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            iteminfo.add(itemInfoList);
        }
        return iteminfo;
    }
    
    public ArrayList<itemDto> getMarketSData() throws SQLException
    {
        ArrayList<itemDto> itemdto = new ArrayList<>();
        PreparedStatement pst = con.prepareStatement("SELECT  itemID , itemName, itemPrice, ItemPhoto from items ");
        ResultSet rs = pst.executeQuery();
        while (rs.next())
        {
            itemDto marketInfoList = new itemDto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
            itemdto.add(marketInfoList);
        }
        return itemdto;
    }
    
    public void addItemtoWishlist( String email ,String id ) throws SQLException
    {
        try{
            PreparedStatement pst = con.prepareStatement("insert into userwishlist (userEmail,itemID) values (?,?) ");
            pst.setString(1,email);
            pst.setString(2,id);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                
            } else {
                
            }
        }
        catch (SQLException e) {
        
            e.printStackTrace();
        }
    }
    
    static String getCurrentBalanceString(Connection con, String email) throws SQLException 
    {
        String selectQuery = "SELECT wallet FROM users WHERE email = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("wallet");
                }
            }
        }
        return "0,0"; 
    }
    
    public void updateBalance(String email, String amountToAdd) 
    {
   
         try {
             
             double amountToAddDouble = Double.parseDouble(amountToAdd);
             String currentBalanceString = getCurrentBalanceString(con,email);
             double currentBalance = Double.parseDouble(currentBalanceString);
             String updatedBalanceString;
             updatedBalanceString = Double.toString(currentBalance + amountToAddDouble);
             String updateQuery = "UPDATE users SET wallet = ? WHERE email = ?";
             try (PreparedStatement preparedStatement = con.prepareStatement(updateQuery)) {
                 preparedStatement.setString(1, updatedBalanceString);
                 preparedStatement.setString(2, email);
                 preparedStatement.executeUpdate();
             }
             catch (SQLException e) {
             }
         }
         catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
        public ArrayList<NotificationDto> getNotifications(String email) throws SQLException{
            ArrayList<NotificationDto> notificationDto = new ArrayList<>();
            PreparedStatement pst = con.prepareStatement("select Description from notifications where reciverEmail = ?;");
            pst.setString(1,email);
            rs = pst.executeQuery();
            while (rs.next()){
            NotificationDto DalNoteOBJ = new NotificationDto(rs.getString(1));
            notificationDto.add(DalNoteOBJ);
            }
            return notificationDto;
        }
        
        public ArrayList<userFriendsDto> getUserFriends(String email) throws SQLException{
            ArrayList<userFriendsDto> userfriendsdto = new ArrayList<>();
            PreparedStatement pst = con.prepareStatement("select first_name , last_name , email from friends , users where friends.friendEmail = users.email and friends.userEmail= ? ;");
            pst.setString(1,email);
            rs = pst.executeQuery();
            while (rs.next()){
            userFriendsDto obj = new userFriendsDto(rs.getString(1),rs.getString(2),rs.getString(3));
            userfriendsdto.add(obj);
            }
            return userfriendsdto;
        }

        public ArrayList<userFriendsDto> getUserRequests(String recieverEmail) throws SQLException{
            ArrayList<userFriendsDto> userRequestslist = new ArrayList<>();
            PreparedStatement pst = con.prepareStatement("SELECT senderEmail FROM iwish.friendrequests where recieverEmail=?;");
            pst.setString(1,recieverEmail);
            rs = pst.executeQuery();
            while (rs.next()){
            userFriendsDto obj = new userFriendsDto(rs.getString(1));
            userRequestslist.add(obj);
            }
            return userRequestslist;
        }

        public boolean removeFriend(String email,String removedEmail) throws SQLException{
           try{
            con.setAutoCommit(false);   
            PreparedStatement selectuser = con.prepareStatement("DELETE FROM friends WHERE userEmail = ? and friendEmail= ? ;");
            selectuser.setString(1,email);
            selectuser.setString(2,removedEmail);
            selectuser.addBatch();
            
            PreparedStatement selectuser1 = con.prepareStatement("DELETE FROM friends WHERE userEmail = ? and friendEmail= ? ;");
            selectuser1.setString(1,removedEmail);
            selectuser1.setString(2,email);
            selectuser1.addBatch();
            
            selectuser.executeBatch();
            selectuser1.executeBatch();
            con.commit();
            con.setAutoCommit(true);
            
            return true;
           }
           catch (SQLException ex) {
                        return false;
                    }  
        }

        public boolean addFriend(String email,String recieverEmail) throws SQLException{
            try{
                con.setAutoCommit(false);
                PreparedStatement pst = con.prepareStatement("INSERT INTO `iwish`.`friendrequests`(`senderEmail`,`recieverEmail`) SELECT ? , ? FROM DUAL WHERE ? NOT IN (SELECT friendEmail FROM `iwish`.`friends`);");
                pst.setString(1,email);
                pst.setString(2,recieverEmail);
                pst.setString(3,recieverEmail);
                pst.addBatch();
                
                PreparedStatement pst1 = con.prepareStatement("INSERT INTO `iwish`.`notifications` (`reciverEmail`, `Description`) select ? , CONCAT('you have a friend request from ', ?) FROM DUAL WHERE ? NOT IN (SELECT friendEmail FROM `iwish`.`friends`);");
                pst1.setString(1,recieverEmail);
                pst1.setString(2,email);
                pst1.setString(3,recieverEmail);
                
                pst1.addBatch();
                int[] lol = pst.executeBatch();
                pst1.executeBatch();
                con.commit();
                con.setAutoCommit(true);
                if (lol[0]!=0)
                return true;
                else return false;
           }
            catch (SQLException ex) {
                    return false;
            }  
        }
        public boolean declineRequest(String recieverEmail,String senderEmail) throws SQLException{
           try{
            con.setAutoCommit(false);   
            PreparedStatement selectuser = con.prepareStatement("DELETE FROM `iwish`.`friendrequests` WHERE recieverEmail = ? and senderEmail= ? ;");
            selectuser.setString(1,recieverEmail);
            selectuser.setString(2,senderEmail);
            selectuser.addBatch();
            
            PreparedStatement selectuser1 = con.prepareStatement("DELETE FROM `iwish`.`notifications` WHERE reciverEmail = ? and Description = CONCAT('you have a friend request from ', ?);");
            selectuser1.setString(1,recieverEmail);
            selectuser1.setString(2,senderEmail);
            selectuser1.addBatch();
            
            selectuser.executeBatch();
            selectuser1.executeBatch();
            con.commit();
            con.setAutoCommit(true);
            return true;
           }
           catch (SQLException ex) {
                        return false;
                    }  
        }

    public boolean acceptRequest(String recieverEmail, String senderEmail) throws SQLException {
        try {
            con.setAutoCommit(false);

            // Delete friend request from friendrequests table
            PreparedStatement deleteFriendRequest = con.prepareStatement("DELETE FROM `iwish`.`friendrequests` WHERE recieverEmail = ? and senderEmail= ?;");
            deleteFriendRequest.setString(1, recieverEmail);
            deleteFriendRequest.setString(2, senderEmail);
            deleteFriendRequest.executeUpdate();

            // Delete friend request notification from notifications table
            PreparedStatement deleteNotification = con.prepareStatement("DELETE FROM `iwish`.`notifications` WHERE reciverEmail = ? and Description = CONCAT('you have a friend request from ', ?);");
            deleteNotification.setString(1, recieverEmail);
            deleteNotification.setString(2, senderEmail);
            deleteNotification.executeUpdate();

            // Insert notification for accepted friend request
            PreparedStatement insertAcceptedNotification = con.prepareStatement("INSERT INTO `iwish`.`notifications` (`reciverEmail`, `Description`) VALUES (?,concat(?,' Has Accepted Your Friend Request'));");
            insertAcceptedNotification.setString(1, senderEmail);
            insertAcceptedNotification.setString(2, recieverEmail);
            insertAcceptedNotification.executeUpdate();

            // Insert records into the friends table
            PreparedStatement insertIntoFriends = con.prepareStatement("INSERT INTO `iwish`.`friends` (`userEmail`, `friendEmail`) VALUES (?,?),(?,?);");
            insertIntoFriends.setString(1, senderEmail);
            insertIntoFriends.setString(2, recieverEmail);
            insertIntoFriends.setString(3, recieverEmail);
            insertIntoFriends.setString(4, senderEmail);
            insertIntoFriends.executeUpdate();

            con.commit();
            con.setAutoCommit(true);

            return true;
        } catch (SQLException ex) {
            return false;
            }
    
    }
    
    public ArrayList<FriendList> getMyFriends(String email) throws SQLException
    {
        ArrayList<FriendList> friendList = new ArrayList<>();
        PreparedStatement pst = con.prepareStatement("SELECT u.email ,first_name ,last_name from users u ,friends f where f.friendEmail = u.email and f.userEmail = ?");
        pst.setString(1,email);
        rs = pst.executeQuery();
        while (rs.next())
        {
            FriendList myFriendList = new FriendList(rs.getString(1),rs.getString(2),rs.getString(3));
            friendList.add(myFriendList);
        }
        return friendList;
    }
    public ArrayList<FriendWishdto> getMyFriendsWishes(String email) throws SQLException
    {
        ArrayList<FriendWishdto> friendWishList = new ArrayList<>();
        PreparedStatement pst = con.prepareStatement("select ItemPhoto ,itemName ,itemPrice , sum(AmountPaid) , i.itemID from items i ,userwishlist c where i.itemID = c.itemID and c.userEmail = ? group by c.itemID;");
        pst.setString(1,email);
        rs = pst.executeQuery();
        while (rs.next())
        {
            FriendWishdto myFriendWishList = new FriendWishdto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            friendWishList.add(myFriendWishList);
        }
        return friendWishList;
    }  
    
    public String getBalance(String email) throws SQLException
    {
        String balance = "";
        PreparedStatement pst = con.prepareStatement("select wallet from users where email = ?");
        pst.setString(1,email);
        rs = pst.executeQuery();
        while (rs.next())
        {
            balance = rs.getString(1);
        }
        return balance;
    } 
    
    public void updateSumAmount(String CurrentUser ,String NewBalance,String friendUser ,String NewSumAmount,String ItemID, String notify) throws SQLException
    {   
        PreparedStatement pst = con.prepareStatement("update users set wallet = ? where email = ?");
        pst.setString(1,NewBalance);
        pst.setString(2,CurrentUser);
        pst.executeUpdate();
        PreparedStatement pst2 = con.prepareStatement("update userwishlist set amountPaid = ? where userEmail = ? and itemID = ?");
        pst2.setString(1,NewSumAmount);
        pst2.setString(2,friendUser);
        pst2.setString(3,ItemID);
       
        pst2.executeUpdate();
        
        PreparedStatement pst3 = con.prepareStatement("insert into notifications values (?,?)");
        pst3.setString(1,friendUser);
        pst3.setString(2,notify);
        pst3.executeUpdate();

    } 
    
    public void sendNotify(String friendUser,String Notify) throws SQLException
    {   
        PreparedStatement pst = con.prepareStatement("insert into notifications values (?,?)");
        pst.setString(1,friendUser);
        pst.setString(2,Notify);
        pst.executeUpdate();
    } 
    
}
