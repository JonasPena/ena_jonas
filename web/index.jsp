<%-- 
    Document   : index
    Created on : 13-06-2020, 18:45:18
    Author     : Edgard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <body>
        <center>
        <h1>Inicio de Sesion</h1>
        <form action="ControladorUsuario" method="post">
        <table>
            <tr>
                <td>Id</td>
                <td><input type="text" name="id"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Iniciar Sesion"/></td>
                <td><a href="registro.jsp">
                        
                    </a>
                </td>
            </tr>
        </table>
            <input type="hidden" name="accion" value="1"/>
        <% if(request.getParameter("msj")!= null){%>
        <h3><%= request.getParameter("msj") %></h3>
        <%}%>
        </form>
        </center>
    </body>
</html>
