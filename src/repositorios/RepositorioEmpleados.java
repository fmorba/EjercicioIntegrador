/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import java.util.ArrayList;
import modelos.Empleado;

/**
 *
 * @author Usuario
 */
public class RepositorioEmpleados {
    private static ArrayList <Empleado> listaEmpleados;

    public RepositorioEmpleados() {
        this.listaEmpleados= new ArrayList<Empleado>();
    }
    
    public void GuardarEmpleado(Empleado empleado){
        this.listaEmpleados.add(empleado);       
        
    }
    
    public Empleado ObtenerEmpleado(int id){
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getID()==id) {
                return empleado;
            }
        }
        return  null;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
    
    
}
