/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Departamento;
import modelos.Estado;
import modelos.Requerimiento;

/**
 *
 * @author Edgard
 */
public class RequerimientoDAO extends Conexion {
    
    public int registrar(Requerimiento requerimiento) throws SQLException{
        try{
            String sentencia ="Insert into requerimiento values (?,?,?,?,?,?)";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setLong(1, requerimiento.getId());
            ps.setString(2, requerimiento.getNombre());
        
          
        
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }


    public Requerimiento obtenerRequerimiento(long codigo) throws SQLException{
        try{
            String sentencia = "select * from v_Requerimiento where codigo = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            Requerimiento p = null;
            if(rs.next()){
                Estado e = new Estado(rs.getInt("id"),rs.getString("e_nombre"));
                p = new Requerimiento(rs.getLong("codigo"),rs.getString("nombre"),rs.getString("descripcion"),
                rs.getInt("cantidad"),rs.getInt("precio"),e);
            }
            return p;
        }catch(Exception e){
            return null;
        }finally{
            desconectar();
        }
    }
    public ArrayList<Requerimiento> obtenerRequerimiento() throws SQLException{
        try{
            String sentencia = "select * from v_Requerimiento";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ResultSet rs = ps.executeQuery();
            ArrayList<Requerimiento> requerimientos = new ArrayList();
            while(rs.next()){
                Estado e = new Estado(rs.getInt("id"),rs.getString("e_nombre"));
                requerimiento.add(new Requerimiento(rs.getLong("codigo"),rs.getString("nombre"),rs.getString("descripcion"),
                rs.getInt("cantidad"),rs.getInt("precio"),e));
            }
            return requerimientos;
        }catch(Exception e){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
    public boolean existeEstado(Estado estado) throws SQLException{
        try{
            String sentencia = "select * from v_Requerimiento where id = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, estado.getId());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }catch(Exception e){
            return false;
        }finally{
            desconectar();
        }
    }

    public boolean existeDepartamento(Departamento e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
