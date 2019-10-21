package buith.register;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import bth.DBU.DBUtilities;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author buith
 */
public class RegistrationDAO implements Serializable {

    /**
     *
     * @param username
     * @param password
     * @return
     * @throws SQLException
     * @throws NamingException
     */
    public boolean checkLogin(String username, String password) throws SQLException, NamingException {
        //1. Open Connection
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Select username, password, lastname, isAdmin "
                        + "From Registration "
                        + "Where username = ? And password = ?";
                //3. Create Statement and set value to parameter
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //4. Execute Query 
                rs = stm.executeQuery();
                //5. Process result
                if (rs.next()) {
                    return true;
                }
            } //end if con exist
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    private List<RegistrationDTO> listAccount;

    /**
     *
     * @return
     */
    public List<RegistrationDTO> getListAccount() {
        return listAccount;
    }

    /**
     *
     * @param searchValue
     * @throws SQLException
     * @throws NamingException
     */
    public void searchLastName(String searchValue)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "Select username, password, lastname, isAdmin "
                        + "From Registration "
                        + "Where lastname Like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String lastName = rs.getString("lastname");
                    boolean isAdmin = rs.getBoolean("isAdmin");

                    RegistrationDTO dto = new RegistrationDTO(username, password, lastName, isAdmin);
                    if (this.listAccount == null) {
                        this.listAccount = new ArrayList<>();
                    }
                    this.listAccount.add(dto);
                } //end of while
            } //end if con
        } finally {
            if (con != null) {
                con.close();
            }
            if (stm != null) {
                stm.close();
            }
        }
    }

    /**
     *
     * @param username
     * @return
     * @throws SQLException
     * @throws NamingException
     */
    public boolean deleteAccount(String username) throws SQLException, NamingException {
        //1. Open Connection
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Delete From Registration "
                        + "Where username = ?";
                //3. Create Statement and set value to parameter
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                //4. Execute Query 
                int row = stm.executeUpdate();
                //5. Process result
                if (row > 0) {
                    return true;
                }
            } //end if con exist
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean updateAccount(String username, String password, boolean role) throws NamingException, SQLException {
         // 1. Open Connection
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Update Registration "
                        + "Set password = ?, isAdmin = ? Where username = ?";
                //3. Create Statement and set value to parameter
                stm = con.prepareStatement(sql);
                stm.setString(1, password);
                stm.setBoolean(2, role);
                stm.setString(3, username);
                //4. Execute Query 
                int row = stm.executeUpdate();
                //5. Process result
                if (row > 0) {
                    return true;
                }
            } //end if con exist
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
