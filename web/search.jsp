<%-- 
    Document   : search
    Created on : Oct 1, 2019, 7:28:29 AM
    Author     : buith
--%>
<%@page import="buith.register.RegistrationDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <h1>Search Page</h1>
        <form action="DispatchController">
            Search Value <input type="text" name="txtSearchValue" value=""></br>
            <input type="submit" value="Search" name="btAction">
        </form></br>
        <%
            String searchValue = request.getParameter("txtSearchValue");
            if (searchValue != null) { //kiem tra != null vi khi login trang Search cung duoc load len
                List<RegistrationDTO> result
                        = (List<RegistrationDTO>) request.getAttribute("SEARCHRESULT");
                if (result != null) {
                    %>
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Username</th>
                                <th>Password</th>
                                <th>LastName</th>
                                <th>Role</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int count = 0;
                                for (RegistrationDTO dto : result) {
                                    String urlRewriting = "DispatchController"
                                            + "?btAction=Delete"
                                            + "&pk=" + dto.getUsername()
                                            + "&lastSearchValue=" + searchValue;
                                    %>
                        <form action="DispatchController">
                            <tr>
                                <td>
                                    <%= ++count %>
                                .</td>
                                <td>
                                    <%= dto.getUsername() %>
                                    <input type="hidden" name="txtUsername" value="<%= dto.getUsername()%>">
                                </td>
                                <td>
                                    
                                    <input type="text" name="txtPassword" value="<%= dto.getPassword()%>">
                                </td>
                                <td>
                                    <%= dto.getLastname() %>
                                </td>
                                <td>
                                    <input type="checkbox" name="chkAdmin" value="ON"
                                        <% 
                                            if(dto.isRole()) {
                                                %>
                                                checked="checked"
                                                <%
                                            }
                                        %>   
                                           
                                           />
                                </td>
                                <td>
                                    <a href="<%= urlRewriting %>">Delete</a>
                                </td>
                                <td>
                                    <input type="submit" value="Update" name="btAction" />
                                    <input type="hidden" name="txtLastSearchValue" value="<%= searchValue%>"/>
                                </td>
                            </tr>
                        </form>
                                        <%
                                    } //end for DTO
                            %>
                        </tbody>
                    </table>

                    <%
                        return;
        } else {//end if result is not null
            //tach code java va html
            %>
                <h2>No record is matched!!!</h2>
            <%
                }
            }//end if searchValue is not null


        %>
    </body>
</html>
