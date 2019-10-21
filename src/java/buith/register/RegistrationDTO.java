/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buith.register;

import java.io.Serializable;

/**
 *
 * @author buith
 */
public class RegistrationDTO implements Serializable{
    private String username;
    private String password;
    private String lastname;
    private boolean role;

    /**
     *
     */
    public RegistrationDTO() {
    }

    /**
     *
     * @param username
     * @param password
     * @param lastname
     * @param role
     */
    public RegistrationDTO(String username, String password, String lastname, boolean role) {
        this.username = username;
        this.password = password;
        this.lastname = lastname;
        this.role = role;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getLastname() {
        return lastname;
    }

    /**
     *
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     *
     * @return
     */
    public boolean isRole() {
        return role;
    }

    /**
     *
     * @param role
     */
    public void setRole(boolean role) {
        this.role = role;
    }
    
}
