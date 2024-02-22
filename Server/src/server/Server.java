package server;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import loginscene.LoginScene;
import loginscene.NotificationDto;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;




/**
 *
 * @author Ali Magdy
 */
public class Server {
    
    ServerSocket ser;
    Connection con;
    
    public Server(){
        try {
            ser = new ServerSocket(5005);
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iwish","root","3225883");
            while (true){
                Socket s = ser.accept();
                new ClientHandler(s,con,ser);
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
   
    public static void main(String[] args) {
        new Server();
    }
}


class ClientHandler extends Thread
    {
    DataInputStream dis;
    PrintStream ps;
    Connection con=null;
    Socket cs;
    int cur_client;
    static Vector<ClientHandler> clientsVector = new Vector<ClientHandler>();
    DataAccessLayer authen;


    public ClientHandler(Socket cs,Connection con,ServerSocket ser)
    {
        
        try {
            this.con=con;
            this.cs=cs;
            dis = new DataInputStream(cs.getInputStream());
            ps = new PrintStream(cs.getOutputStream());
            clientsVector.add(this);
            cur_client=clientsVector.indexOf(this);
            start();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public void run()
        {
        while(true)
        {
            try {
                String reqType = dis.readLine();  
                
                
                switch(reqType){
                    case "loginReq": 
                                String user = dis.readLine();
                                String pass = dis.readLine();
                                authen =new DataAccessLayer(con);
                                if (authen.authenticateUser(user,pass)){ 
                                clientsVector.get(cur_client).ps.println("loginSuccess");
                                }
                                else
                                {clientsVector.get(cur_client).ps.println("failed");};
                    break;
                                
                    case "registerReq": 
                            String fname = dis.readLine();
                            String lname = dis.readLine();
                            String email = dis.readLine();
                            String password = dis.readLine();
                            //System.out.println(LoginScene.curEmail);
                            DataAccessLayer response=new DataAccessLayer(con);
                            String str = response.RegisterUser(fname, lname, email, password);
                            System.out.println("dsasadsad"+ str);
                            if (str == "RegisterationSuccess" )
                            {clientsVector.get(cur_client).ps.println("RegisterationSuccess");}
                            else
                            {clientsVector.get(cur_client).ps.println(str);}
                    case "homeRequest":
                        String cur_Email = dis.readLine();
                        DataAccessLayer responsePf = new DataAccessLayer(con);
                        //System.out.println(cur_Email);
                        profileInfo pf =responsePf.profileData(cur_Email);
                        ps.println(pf.getName());
                        ps.println(pf.getBalance());
                        ArrayList<ItemInfo> iteminfo = responsePf.itemsData(cur_Email);
                        JSONArray jsonArray = new JSONArray();
                        for (ItemInfo item : iteminfo) {
                            JSONObject jsonItem = new JSONObject();
                            jsonItem.put("itemId", item.getItemId());
                            jsonItem.put("itemName", item.getItemName());
                            jsonItem.put("itemPrice", item.getItemPrice());
                            jsonItem.put("itemAmountLeft", item.getAmountLeft());
                            jsonItem.put("itemPhoto", item.getItemPhoto());
                            jsonArray.add(jsonItem);
                            }
                        ps.println(jsonArray.toJSONString());
                        break;
                        
                    case "addItemRequest":
                        String cur_Email2 = dis.readLine();
                        DataAccessLayer responseMarekt = new DataAccessLayer(con);
                        ArrayList<itemDto> marketInfo = responseMarekt.getMarketSData();
                        JSONArray jsonArrayMarekt = new JSONArray();
                        for (itemDto item : marketInfo) {
                            JSONObject jsonItem = new JSONObject();
                            jsonItem.put("itemId", item.getItemId());
                            jsonItem.put("itemName", item.getItemName());
                            jsonItem.put("itemPrice", item.getItemPrice());
                            jsonItem.put("itemPhoto", item.getItemPhoto());
                            jsonArrayMarekt.add(jsonItem);
                            }
                        ps.println(jsonArrayMarekt.toJSONString());
                        String itemId = dis.readLine();
                        //System.out.println(itemId);
                        responseMarekt.addItemtoWishlist(cur_Email2,itemId);
                        
                    break;
                    
                    case "updateBalanceReq":
                        try {
                             String amountString = dis.readLine();
                             String cur_Email3 = dis.readLine();
                             System.out.println(cur_Email3);
                             if (amountString != null) {
                            double amount = Double.parseDouble(amountString);

                            DataAccessLayer RemoveupdateBalance = new DataAccessLayer(con);
                            RemoveupdateBalance.updateBalance(cur_Email3, amountString);

                                    ps.println("Update balance successfully");
                                } else {
                                    ps.println("Failed to update balance: Amount string is null");
                                }
                            } catch (IOException | NumberFormatException e) {
                                e.printStackTrace();
                                ps.println("Failed to update balance");
                            }
                            break;
                        
                        case "NotificationReq":
                        String cur_Email4 = dis.readLine();
                        DataAccessLayer DALnoti = new DataAccessLayer(con);
                        
                        //notificationDto is an object from the arraylist NotificationDto
                        ArrayList<NotificationDto> notificationDto = DALnoti.getNotifications(cur_Email4);
                        //jsonArrayNoti object from the JSONArray class
                        JSONArray jsonArrayNoti = new JSONArray();
                        for (NotificationDto notifiAO : notificationDto) {
                            JSONObject jsonNoti = new JSONObject();
                           
                           
                            jsonNoti.put("nDescription", notifiAO.getNDescription());
                            jsonArrayNoti.add(jsonNoti);
                            }
                        ps.println(jsonArrayNoti.toJSONString());//cast jasonArray to JSONString
                        break; 
                        case "userFriends":
                        String cur_Email5 = dis.readLine();   
                        DataAccessLayer dal = new DataAccessLayer(con);
                        ArrayList<userFriendsDto> userfriendsdto = dal.getUserFriends(cur_Email5);
                        JSONArray jsonArray1 = new JSONArray();
                        for (userFriendsDto friend : userfriendsdto) {
                            JSONObject jsonFriends = new JSONObject();
                            jsonFriends.put("first_name", friend.getFriend_fname());
                            jsonFriends.put("last_name", friend.getFriend_lname());
                            jsonFriends.put("email", friend.getFriend_email());
                            jsonArray1.add(jsonFriends);
                            }
                        ps.println(jsonArray1.toJSONString());
                        break;
                        
                        case "userRequests":
                        String cur_Email6 = dis.readLine(); 
                        DataAccessLayer dal3 = new DataAccessLayer(con);
                        ArrayList<userFriendsDto> userRequestslist = dal3.getUserRequests(cur_Email6);
                        JSONArray jsonArray2 = new JSONArray();
                        for (userFriendsDto userReq : userRequestslist) {
                            JSONObject jsonRequests = new JSONObject();
                            jsonRequests.put("email", userReq.getFriend_email());
                            jsonArray2.add(jsonRequests);                           
                            }
                        ps.println(jsonArray2.toJSONString());
                        break;
                        
                         case "removeFriend":
                                String cur_Email7 = dis.readLine();
                                String userfriend = dis.readLine();
                                System.out.println(cur_Email7);
                                System.out.println(userfriend);
                                DataAccessLayer dal1 = new DataAccessLayer(con);
                                System.out.println(dal1);
                                if(dal1.removeFriend(cur_Email7,userfriend))
                                ps.println("removalSuccess");
                                else ps.println("removalFailed");
                        break;
                        
                        case "addFriend":
                                String cur_Email8 = dis.readLine();
                                String reciever = dis.readLine();
                                DataAccessLayer dal2 = new DataAccessLayer(con);
                                System.out.println(cur_Email8);
                                System.out.println(reciever);
                                System.out.println(dal2.addFriend(cur_Email8,reciever));
                                if(dal2.addFriend(cur_Email8,reciever))
                                ps.println("AddSuccess");
                                else ps.println("help");
                        break;
                        
                        case "declineRequest":
                                String cur_Email9 = dis.readLine();
                                String sender = dis.readLine();
                                DataAccessLayer dal4 = new DataAccessLayer(con);
                                if(dal4.declineRequest(cur_Email9,sender))
                                ps.println("declineSuccess");
                                else ps.println("help");
                        break;
                        
                        case "acceptRequest":
                                String cur_Email02 = dis.readLine();
                                String sender1 = dis.readLine();
                                DataAccessLayer dal5 = new DataAccessLayer(con);
                                if(dal5.acceptRequest(cur_Email02,sender1))
                                ps.println("acceptSuccess");
                                else ps.println("help");
                        break; 
                        
                        case "FriendList": 
                        //System.out.println("my friends wish list");
                        String cur_Email03 = dis.readLine();
                        DataAccessLayer responses = new DataAccessLayer(con);
                        ArrayList<FriendList> friendList = responses.getMyFriends(cur_Email03);
                        JSONArray jsonArray5 = new JSONArray();
                        for (FriendList friend : friendList) {
                            JSONObject jsonfriend = new JSONObject();
                            jsonfriend.put("email", friend.getEmail());
                            jsonfriend.put("FirstName", friend.getFirstName());
                            jsonfriend.put("LastName", friend.getLastName());
                            jsonArray5.add(jsonfriend);
                            }
                        ps.println(jsonArray5.toJSONString());
                        //System.out.println(jsonArray5.toJSONString());                        
                        
                    break; 
                    
                    case "showFriendWishList": 
                        String frienduser = dis.readLine();
                        System.out.println("f u "+frienduser);
                        
                        DataAccessLayer responseWish = new DataAccessLayer(con);
                        
                        ArrayList<FriendWishdto> friendWishList = responseWish.getMyFriendsWishes(frienduser);
                        JSONArray jsonArray6 = new JSONArray();
                        for (FriendWishdto friend : friendWishList) {
                            JSONObject jsonfriend = new JSONObject();
                            jsonfriend.put("ItemPhoto", friend.getItemPhoto());
                            jsonfriend.put("ItemName", friend.getItemName());
                            jsonfriend.put("ItemPrice", friend.getItemPrice());
                            jsonfriend.put("AmountPaid", friend.getAmountPaid());
                            jsonfriend.put("FriendUser", friend.getFriendUser());
                            jsonfriend.put("ItemID", friend.getFriendUser());
                            jsonArray6.add(jsonfriend);
                            }
                        ps.println(jsonArray6.toJSONString());
                       System.out.println(jsonArray6.toJSONString());
                    break;
                    
                    case "contribute": 
                        String cur_Email04 = dis.readLine();
                        DataAccessLayer responseCont = new DataAccessLayer(con);
                        //System.out.println("contribute case");
                        try{
                        String StringContribute = dis.readLine();
                        //System.out.println("StringContribute: " + StringContribute);
                        String ItemName = dis.readLine();
                        String ItemID = dis.readLine();
                        String StringItemPrice = dis.readLine();
                        String StringSumPaid = dis.readLine();
                        System.out.println("collected "+StringSumPaid);
                        String friendUser = dis.readLine();
                        //System.out.println(friendUser);
                        //System.out.println("---------------------");
                        //System.out.println(StringContribute);
                        String stringBalance = responseCont.getBalance(cur_Email04) ;
                        //////////System.out.println(stringBalance);
                        double amountPaid = Double.parseDouble(StringSumPaid);
                        int myContribute = Integer.valueOf(StringContribute) ;
                        System.out.println("StringContribute: " + myContribute);
                        int myContributeInt = (int) myContribute;
                        int AmountSumPaid = (int) amountPaid ;
                        float myBalance = Float.valueOf(stringBalance); 
                        int myBalanceInt = (int) myBalance;
                        int ItemPrice = Integer.valueOf(StringItemPrice); 
                        int AmountPaidLeft = ItemPrice - AmountSumPaid ;
                        
                        if (myContributeInt > myBalanceInt){
                            ps.println("nomoney");
                        }
                        else{
                            //System.out.println(myContributeInt);
                            //System.out.println(AmountPaidLeft);
                            if(myContributeInt > AmountPaidLeft){
                                ps.println("HugeContribute"); 
                            }
                            else{ 
                                ps.println("MyContribute");
                                int IntNewSumAmount = AmountSumPaid + myContribute;
                                float IntNewBalance = myBalance - myContribute;
                                String NewSumAmount = String.valueOf(IntNewSumAmount);
                                String NewBalance = String.valueOf(IntNewBalance);
                                //System.out.println(curr_email);
                                //System.out.println(NewBalance);
                                //System.out.println(friendUser);
                                //System.out.println(NewSumAmount);
                                //System.out.println(ItemID);
                                String not = cur_Email04+" contributed in "+ItemName+" with "+StringContribute;
                                responseCont.updateSumAmount(cur_Email04, NewBalance, friendUser, NewSumAmount, ItemID, not );
                                ps.println(String.valueOf(NewSumAmount));
                                if (IntNewSumAmount == ItemPrice){
                                    responseCont.sendNotify(friendUser, "Congratulations your "+ItemName+" is completed");
                                }
                            }
                        }
                        }catch (SQLIntegrityConstraintViolationException e) {
                            e.printStackTrace();
                        }                                
                    break; 
                }
                    
     /////////////////// end of switch
            } catch (SocketException se) {
                try {
                    dis.close();
                    ps.close();
                    this.stop();
                    System.exit(0);
                } catch (IOException ex) {
                    Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
            
            catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (NullPointerException nx) {
                return;
            }
            
        }
        }    
}
    
    


    
