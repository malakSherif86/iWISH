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
public class UserData {
    private String email;
    // Other user-specific fields

    public UserData(String email) {
        this.email = email;
        // Initialize other fields as needed
    }

    public String getEmail() {
        return email;
    }

    // Getter and setter methods for other fields
}