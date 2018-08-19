/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Articulo;
import modelos.Empleado;
import repositorios.RepositorioArticulo;
import repositorios.RepositorioEmpleados;

/**
 *
 * @author Usuario
 */
public class ServicioVerificador {

    String Nombre;
    String Apellido;
    String DNI;
    int Sueldo;
    RepositorioEmpleados repositorio;
    RepositorioArticulo repositorioArticulo;
    
    public ServicioVerificador(){
        this.repositorio = new RepositorioEmpleados();        
        this.repositorioArticulo = new RepositorioArticulo();
        
    }

    public void GuardarDatos(String nombre, String apellido, String dni, String sueldo, int id) {
        
        this.ValidarNombre(nombre);
        this.ValidarApellido(apellido);
        this.ValidarDNI(dni);
        this.ValidarSueldo(sueldo);

        Empleado empleado = new Empleado(Nombre, Apellido, DNI, Sueldo, id);
        this.repositorio.GuardarEmpleado(empleado);

    }

    private void ValidarNombre(String nombre) {
        if (nombre.length() == 0) {
            throw new IllegalArgumentException("El campo nombre esta vacio.");
        } else {
            this.Nombre = nombre;
        }
    }

    private void ValidarApellido(String apellido) {
        if (apellido.length() == 0) {
            throw new IllegalArgumentException("El campo apellido esta vacio.");
        } else {
            this.Apellido = apellido;
        }
    }

    private void ValidarDNI(String dni) {
        if (dni.length() == 0) {
            throw new IllegalArgumentException("El campo DNI esta vacio.");
        } else if (dni.length()<6 || dni.length()>8) {
            throw new IllegalArgumentException("El DNI ingresado no es valido.");
        } else {
            try {
                int auxiliar = Integer.valueOf(dni);
                if (auxiliar<0) {
                    throw new IllegalArgumentException("No ingresar numeros negativos.");
                }else{
                    this.DNI = dni;
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("El DNI debe estar conformado solamente por numeros.");
            }

        }
    }

    private void ValidarSueldo(String sueldo) {
        if (sueldo.length() == 0) {
            throw new IllegalArgumentException("El campo Sueldo esta vacio.");
        } else {

            try {
                this.Sueldo = Integer.valueOf(sueldo);
                if (Sueldo<0) {
                  throw new IllegalArgumentException("No ingresar numeros negativos.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("El sueldo debe estar conformado solamente por numeros.");
            }
        }
    }
    
    
    
    public void CalcularSueldoTotal(String EmpleadoElegido){
        ArrayList<Articulo> listado = this.repositorioArticulo.getListadoArticulos();
        ArrayList<Articulo> articulos = new ArrayList<Articulo>();
        Empleado empleado = this.repositorio.ObtenerEmpleado(Integer.valueOf(EmpleadoElegido.split(" ")[0]));
        for (Articulo articulo : listado) {
            if (articulo.getEmpleado().getID()!=empleado.getID()){
               articulos.add(articulo);
            }
        }
        
        
        try {
            float total=0;
            float sueldoCalculado=0;         
            
            for (Articulo articulo : articulos) {
                total+=articulo.getCantidadArticulo()*articulo.getPrecioArticulo();               
            }
            
            sueldoCalculado=(float) (empleado.getSueldo()+(total*0.05));
            
            JOptionPane.showMessageDialog(null, "El sueldo de : "+empleado.getNombre()+" "+empleado.getApellido()+"\n"+"Da un total de: "+sueldoCalculado);
            
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Algun dato esta incompleto, revise haber ingresado toda la infomración necesaria.");
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("Problema con los valores ingresados");
        }
        
    }

    public String[] ObtenerEmpleados(){
        ArrayList<Empleado> empleados=this.repositorio.getListaEmpleados();
        String List[]=new String[empleados.size()];
        int i=0;
        for (Empleado empleado:empleados) {            
            List[i]=empleados.indexOf(empleado)+" "+empleado.getNombre()+" "+empleado.getApellido();
            i++;
        }
        return List;
    }
        
    
    
}
