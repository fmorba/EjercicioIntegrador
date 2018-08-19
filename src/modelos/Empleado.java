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
public class Empleado {
    private final String Nombre;
    private final String Apellido;
    private final String DNI;
    private final int Sueldo;
    private final int ID;

    public Empleado(String Nombre, String Apellido, String DNI, int Sueldo, int id) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DNI = DNI;
        this.Sueldo = Sueldo;
        this.ID=id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public int getSueldo() {
        return Sueldo;
    }

    public int getID() {
        return ID;
    }
    
    
    
}
