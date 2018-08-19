/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Usuario
 */
public class Articulo {
    private final String NombreArticulo;
    private final float PrecioArticulo;
    private final int CantidadArticulo;
    private final Empleado empleado;

    public Articulo(String NombreArticulo, float PrecioArticulo, int CantidadArticulo, Empleado empleado) {
        this.NombreArticulo = NombreArticulo;
        this.PrecioArticulo = PrecioArticulo;
        this.CantidadArticulo = CantidadArticulo;
        this.empleado=empleado;
    }

    public String getNombreArticulo() {
        return NombreArticulo;
    }

    public float getPrecioArticulo() {
        return PrecioArticulo;
    }

    public int getCantidadArticulo() {
        return CantidadArticulo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }
    
    
}
