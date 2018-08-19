/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentadores;

import javax.swing.JOptionPane;
import servicios.ServicioArticulo;
import servicios.ServicioVerificador;
import vistas.VistaInicio;

/**
 *
 * @author Usuario
 */
public class PresentadorDatos {
    private final VistaInicio vista;
    private final ServicioVerificador servicio;
    private final ServicioArticulo servicioArticulo;
    
    public PresentadorDatos(VistaInicio vista){
        this.vista=vista;
        
        this.servicio=new ServicioVerificador();
        this.servicioArticulo=new ServicioArticulo();
    }
    
    public void GuardarDatosPersonalesButton(){
        String Nombre = this.vista.getNombreTextField().getText();
        String Apellido = this.vista.getApellidoTextField().getText();
        String DNI = this.vista.getDNITextField().getText();
        String Sueldo = this.vista.getSueldoTextField().getText();
                
        try {
            int ID = servicio.ObtenerEmpleados().length;
            this.servicio.GuardarDatos(Nombre, Apellido, DNI, Sueldo, ID);
            
            this.vista.getNombreTextField().setText("");
            this.vista.getApellidoTextField().setText("");
            this.vista.getDNITextField().setText("");
            this.vista.getSueldoTextField().setText("");
            
            JOptionPane.showMessageDialog(null, "Datos guardados.");
            
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        String Lista[] = this.servicio.ObtenerEmpleados();
        this.vista.getEmpleadosComboBox().setModel(new javax.swing.DefaultComboBoxModel(Lista));
        this.vista.getEmpleadosCalcularComboBox().setModel(new javax.swing.DefaultComboBoxModel(Lista));
    }
    
    public void GuardarDatosArticuloButton(){
        String NombreArticulo = this.vista.getNombreArticuloTextField().getText();
        String PrecioArticulo = this.vista.getPrecioTextField().getText();
        String CantidadArticulo = this.vista.getCantidadTextField().getText();
        String EmpleadoSeleccionado = this.vista.getEmpleadosComboBox().getSelectedItem().toString();
        
        try {
            this.servicioArticulo.GuardarDatos(NombreArticulo, PrecioArticulo, CantidadArticulo,EmpleadoSeleccionado);
            
            this.vista.getNombreArticuloTextField().setText("");
            this.vista.getPrecioTextField().setText("");
            this.vista.getCantidadTextField().setText("");
            
            JOptionPane.showMessageDialog(null, "Datos guardados.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void CalcularSueldoButton(){
        String EmpleadoSeleccionado = this.vista.getEmpleadosCalcularComboBox().getSelectedItem().toString();
        try {
            this.servicio.CalcularSueldoTotal(EmpleadoSeleccionado);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
            
    }
    
}
