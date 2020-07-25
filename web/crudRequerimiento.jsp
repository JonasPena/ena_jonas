

<%@page import="dao.RequerimientoDAO"%>
<%@page import="modelos.Requerimiento"%>
<%@page import="dao.DepartamentoDAO"%>
<%@page import="modelos.Departamento"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crud Productos</title>
    </head>
    <body>
    <center>
        <h1>Registor de Requerimiento</h1>
      
        <form action="ControladorProducto" method="post">
            <table>
                <tr>
                    <td>Gerencia</td>
                    <td><input type="number" name="codigo"/></td>
                </tr>
                   <tr>
                    <td>Departamento</td>
                    <td>
                        <select name="departamento">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Departamento> departamento = new DepartamentoDAO().obtenerDepartamento(); 
                            for(Departamento e:departamento){%>
                            <option value="<%= e.getId() %>"><%= e %></option>
                            <% } %>
                        </select>
                    </td>
                </tr>
         
                <tr>
                    <td>Asignar A</td>
                    <td><input type="text" name="nombre"/></td>
                </tr>
                <tr>
                    <td>Encargado</td>
                    <td><input type="text" name="nombre"/></td>
                </tr>
                <tr>
                    <td>Descripcion</td>
                    <td><textarea cols="20" rows="5" name="descripcion"></textarea></td>
                </tr>
            
           
                <tr>
                    <td><input type="reset" value="Limpiar"/></td>
                    <td><a href="crudRequerimiento.jsp">
                        <input type="button" value="Registrar"/>
                    </a>
                </td>
                </tr>
                
               
                
                
            </table>
        </form>
                      
                        <br>
                        <br>
                        <br>
                        <br>
         <table>
             <tr>
                
                <td><a href="index.jsp">
                        <input type="button" value="Salir"/>
                    </a>
                    
                    <a href="intranet.jsp">
                        <input type="button" value="Volver a La Pagina Anterior"/>
                    </a>
                </td>
            </tr>
           
            
        </table>
        

    </center>
    </body>
</html>
