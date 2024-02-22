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
public class profileInfo {
    public String name;
    public String balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public profileInfo(String name, String balance) {
        this.name = name;
        this.balance = balance;
    }
    
    
}
