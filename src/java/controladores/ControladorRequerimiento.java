/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.EstadoDAO;
import dao.RequerimientoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Requerimiento;

/**
 *
 * @author Edgard
 */
@WebServlet(name = "ControladorProducto", urlPatterns = {"/ControladorProducto"})
public class ControladorRequerimiento extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if(request.getParameter("accion")!=null){
        String accion = request.getParameter("accion");
        switch(accion){
            case "1": registrar(request,response);
                break;
            
     
         }
    }
           }

         private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
           try{
            long id =Long.parseLong(request.getParameter("codigo").trim());
            String nombre = request.getParameter("nombre").trim();
            String descripcion = request.getParameter("descripcion").trim();
            //int cantidad = Integer.parseInt(request.getParameter("cantidad").trim());
            int precio = Integer.parseInt(request.getParameter("precio").trim());
            int estado =Integer.parseInt( request.getParameter("estado").trim());
               int cantidad = 0;
            if(id<1||nombre.equals("")||descripcion.equals("")||cantidad<1||precio<1||estado<1){
                response.sendRedirect("crudProductos.jsp?msj=valores erroneos");
            }else{
                EstadoDAO ed = new EstadoDAO();
                Requerimiento nuevoRequerimiento = new Requerimiento (id,nombre,descripcion,
                        cantidad,precio,ed.obtenerEstado(estado));
                RequerimientoDAO pd = new RequerimientoDAO();
                if(pd.obtenerRequerimiento(nuevoRequerimiento.getId())==null){
                    int respuesta = pd.registrar(nuevoRequerimiento);
                    if(respuesta==1){
                    response.sendRedirect("crudProductos.jsp?msj=Producto registrado");
                    }else{
                    response.sendRedirect("crudProductos.jsp?msj=Producto no se pudo registrar");
                    }
                }else{
                    response.sendRedirect("crudProductos.jsp?msj=Producto ya existe");
                }
            }
           }catch(Exception e){
               response.sendRedirect("crudProductos.jsp?msj="+e.getMessage());
           }
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
