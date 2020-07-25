/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.DepartamentoDAO;
import dao.RequerimientoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Departamento;

/**
 *
 * @author Edgard
 */
@WebServlet(name = "ControladorDepartamento", urlPatterns = {"/ControladorDepartamento"})
public class ControladoDepartamento extends HttpServlet {

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
            case "2": modificar(request,response);
            break;
            case "3": eliminar(request,response);
            break;
        }
         }else{
             response.sendRedirect("crudProductos.jsp?msj=No te pases");
         }
    }

    private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            
            String nombre = request.getParameter("nombre").trim();
           
            if(nombre.equals("")){
                response.sendRedirect("crudDepartamento.jsp?msj=valores erroneos");
            }else{
                DepartamentoDAO ed = new DepartamentoDAO();
                Departamento e = new Departamento(nombre);
                if(ed.obtenerDepartamento(e.getNombre())==null){
                    int respuesta = ed.registrar(e);
                    if(respuesta==1){
                    response.sendRedirect("crudDepartamento.jsp?msj=Departamento registrado");
                    }else{
                    response.sendRedirect("crudDepartamento.jsp?msj=Departamento no se pudo registrar");
                    }
                }else{
                    response.sendRedirect("crudDepartamento.jsp?msj=Departamento ya existe");
                }
            }
           }catch(Exception e){
               response.sendRedirect("crudDepartamento.jsp?msj="+e.getMessage());
           }
    }
    private void modificar(HttpServletRequest request, HttpServletResponse response){
        
    }
    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException{
         try{
            int id =Integer.parseInt(request.getParameter("id").trim());
            String nombre = request.getParameter("nombre").trim();
           
            if(nombre.equals("")||id<1){
                response.sendRedirect("crudDepartamento.jsp?msj=valores erroneos");
            }else{
                DepartamentoDAO ed = new DepartamentoDAO();
                Departamento e = new Departamento(id,nombre);
                if(ed.obtenerDepartamento(e.getId())!=null){
                    RequerimientoDAO pd = new RequerimientoDAO();
                    if(pd.existeDepartamento(e)){
                        response.sendRedirect("crudDepartamento.jsp?msj=No se puede eliminar por tener productos con este estado");
                    }else{
                    int respuesta = ed.eliminar(e);
                    if(respuesta==1){
                    response.sendRedirect("crudDepartamento.jsp?msj=Estado eliminado");
                    }else{
                    response.sendRedirect("crudDepartamento.jsp?msj=Estado no se pudo eliminar");
                    }}
                }else{
                    response.sendRedirect("crudDepartamento.jsp?msj=Estado no existe");
                }
            }
           }catch(Exception e){
               response.sendRedirect("crudDepartamento.jsp?msj="+e.getMessage());
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
