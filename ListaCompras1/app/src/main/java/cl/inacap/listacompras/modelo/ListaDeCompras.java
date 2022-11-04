package cl.inacap.listacompras.modelo;

import java.util.ArrayList;
import java.util.List;

public class ListaDeCompras {

    private static ListaDeCompras instancia=new ListaDeCompras();
    private ArrayList<Producto> listaDeCompras;

    //ver 2 Lista de productos AGREGAR
    //clase privada solo para crear objetos
    private ListaDeCompras() {
        listaDeCompras=new ArrayList<>();
        //agregarProducto(new Producto("pan", 1, "kilo"));

    }

    // patron single
    public static ListaDeCompras getInstancia()
    {
        return instancia;
    }

    public void agregarProducto(Producto producto)
    {
        listaDeCompras.add(producto);
    }

    public Producto getProducto(int id)
    {
        return listaDeCompras.get(id);
    }

    public ArrayList<Producto> getListaDeCompras()
    {
        return listaDeCompras;
    }

    public void eliminarComprados()
    {
        for (int i=0; i<listaDeCompras.size();i++)
        {
            if (listaDeCompras.get(i).isEstado()==Producto.COMPRADO)
            {
                listaDeCompras.remove(i);
                i--;
            }
        }
    }

}
