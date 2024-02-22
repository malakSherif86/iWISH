/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author Ali Magdy
 */
public class userFriendsDto {
    private String friend_fname;
    private String friend_lname;
    private String friend_email;

    public userFriendsDto(String friend_fname, String friend_lname, String friend_email ) {
        this.friend_fname = friend_fname;
        this.friend_lname = friend_lname;
        this.friend_email = friend_email;
        
    }
    public userFriendsDto(String friend_email ) {
      
        this.friend_email = friend_email;
    
    }

   

    public String getFriend_fname() {
        return friend_fname;
    }

    public void setFriend_fname(String friend_fname) {
        this.friend_fname = friend_fname;
    }

    public String getFriend_lname() {
        return friend_lname;
    }

    public void setFriend_lname(String friend_lname) {
        this.friend_lname = friend_lname;
    }

    public String getFriend_email() {
        return friend_email;
    }

    public void setFriend_email(String friend_email) {
        this.friend_email = friend_email;
    }


    
    
}