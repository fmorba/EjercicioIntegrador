/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.ArrayList;
import modelos.Articulo;
import modelos.Empleado;
import repositorios.RepositorioArticulo;
import repositorios.RepositorioEmpleados;

/**
 *
 * @author Usuario
 */
public class ServicioArticulo {

    String NombreArticulo;
    float PrecioArticulo;
    int CantidadArticulo;
    Empleado empleado;
    RepositorioArticulo repositorio;
    RepositorioEmpleados repositorioEmpleados;

    public ServicioArticulo() {
        this.repositorio = new RepositorioArticulo();
        this.repositorioEmpleados = new RepositorioEmpleados();
    }

    public void GuardarDatos(String Nombre, String Precio, String Cantidad, String Empleado) {

        this.ValidadNombre(Nombre);
        this.ValidarPrecio(Precio);
        this.ValidadCantidad(Cantidad);
        this.ValidarEmpleado(Empleado);

        Articulo articulo = new Articulo(NombreArticulo, PrecioArticulo, CantidadArticulo, empleado);
        this.repositorio.GuardarArticulo(articulo);

    }

    public void ValidadNombre(String nombre) {
        if (nombre.length() == 0) {
            throw new IllegalArgumentException("El campo articulo esta vacio.");
        } else {
            this.NombreArticulo = nombre;
        }
    }

    public void ValidarPrecio(String precio) {
        if (precio.length() == 0) {
            throw new IllegalArgumentException("El campo precio esta vacio.");
        } else {
            try {
                float auxiliar = Float.valueOf(precio);
                if (auxiliar < 0) {
                    throw new IllegalArgumentException("No ingresar numeros negativos.");
                } else {
                    this.PrecioArticulo = auxiliar;
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("El Precio debe estar conformado solamente por numeros.");
            }

        }
    }

    public void ValidadCantidad(String cantidad) {
        if (cantidad.length() == 0) {
            throw new IllegalArgumentException("El campo Cantidad esta vacio.");
        } else {
            try {
                int auxiliar = Integer.valueOf(cantidad);
                if (auxiliar < 0) {
                    throw new IllegalArgumentException("No ingresar numeros negativos.");
                } else {
                    this.CantidadArticulo = auxiliar;
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("El DNI debe estar conformado solamente por numeros.");
            }
        }
    }

    public void ValidarEmpleado(String empl) {
        if (empl.length() == 0) {
            throw new IllegalArgumentException("Seleccione un empleado.");
        } else {
            try {
                ArrayList<Empleado> empleados = this.repositorioEmpleados.getListaEmpleados();
                int indice=Integer.valueOf(empl.split(" ")[0]);
                this.empleado=empleados.get(indice);
            } catch (NullPointerException e) {
                throw new IllegalArgumentException("Problemas con el repositorio de empleados.");
            }
        }
    }

}
