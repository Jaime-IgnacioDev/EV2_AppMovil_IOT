package cl.inacap.listacompras.modelo;

public class Producto {
    //atributos
    private String nombre;
    private int cantidad;
    private String unidad;
    private boolean estado;
    //Constantes
    public static final boolean PENDIENTE=true;
    public static final boolean COMPRADO=false;

    /*
    //Ver 1 Lista de productos ARRAY
    //Lista de productos (CONSTANTES)
    public static final Producto[] productos={
            new Producto("Bebida", 1, "litro"),
            new Producto("Papas Fritas",2,"bolsas"),
            new Producto("Aceitunas",2,"paquetes")
    };
    */



    //Constructor

    public Producto(String nombre, int cantidad, String unidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.estado =PENDIENTE;
    }


    //Metodos accesores y modificadores

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        String comprado;
        if(estado==COMPRADO)
        {
            comprado="Comprado";
        }
        else{
            comprado="Pendiente";
        }
        return nombre +": " + comprado;
    }
}
