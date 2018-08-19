/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import java.util.ArrayList;
import modelos.Articulo;

/**
 *
 * @author Usuario
 */
public class RepositorioArticulo {
    private static ArrayList<Articulo> listadoArticulos;

    public RepositorioArticulo() {
        this.listadoArticulos = new ArrayList<Articulo>();
    }
    
    public void GuardarArticulo(Articulo articulo){
        this.listadoArticulos.add(articulo);
    }

    public ArrayList<Articulo> getListadoArticulos() {
        return listadoArticulos;
    }
    
}