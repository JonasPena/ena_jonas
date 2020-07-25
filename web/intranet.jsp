
<%@page import="dao.UsuarioDAO"%>
<%@page import="util.UsuarioUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Intranet</title>
    </head>
    <body>
    <center>
        <h1>Bienvenido
            <% if(session.getAttribute("usuario")!= null){
             Usuario u = (Usuario) session.getAttribute("usuario");
            %>
        <h3><%= u.getNombre()+" "+u.getApellido() %></h3>
        <%}else{response.sendRedirect("index.jsp?msj=acceso denegado");}%>
        </h1>
        <a href="Salir"><input type="button" value="Cerrar Sesion"/></a>
    
        <h1>Seleccione una Opcion</h1>
        <table>
        <tr>
                
                <td><a href="crudRequerimiento.jsp">
                        <input type="button" value="Registrar Requerimiento"/>
                    </a>
                </td>
            </tr>
        </table>
        <br>
        <table>
         <tr>
                
                <td><a href="cruRLista.jsp">
                        <input type="button" value="Consultar Requerimiento"/>
                    </a>
                </td>
            </tr>
        </table>
        <br>
         <table>
         <tr>
                
                <td><a href="cruRListaCerrar.jsp">
                        <input type="button" value="Cerrar Requerimiento"/>
                    </a>
                </td>
            </tr>
        </table>
      </center>
</html>
