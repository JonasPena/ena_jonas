/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Edgard
 */
public class Requerimiento {
   private int id;
   private String nombre;

    public Requerimiento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Requerimiento(String nombre){
        this.nombre = nombre;
    }

    public Requerimiento(long codigo, String nombre, String descripcion, int cantidad, int precio, Estado obtenerEstado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
            
}
