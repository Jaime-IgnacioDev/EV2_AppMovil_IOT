package cl.inacap.listacompras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import cl.inacap.listacompras.modelo.ListaDeCompras;
import cl.inacap.listacompras.modelo.Producto;

public class NuevoProductoActivity extends AppCompatActivity {

    private ListaDeCompras listaDeCompras=ListaDeCompras.getInstancia();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_producto);
        Button botonIngresarProducto=(Button) findViewById(R.id.botonIngresarProducto);
        botonIngresarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresarProducto(view);
            }
        });
    }

    public void ingresarProducto(View view)
    {
        String nombre=((TextView) findViewById(R.id.ingresarNombre)).getText().toString();
        String cantidadStr=((TextView) findViewById(R.id.ingresarCantidad)).getText().toString();
        String unidad=((Spinner) findViewById(R.id.ingresarUnidad)).getSelectedItem().toString();
        String unidadNueva=((TextView) findViewById(R.id.otraUnidad)).getText().toString();


        if (cantidadStr.isEmpty())
        {
            Toast.makeText(this, "Ingrese la cantidad", Toast.LENGTH_SHORT).show();
        }
        else {

            int cantidad=Integer.parseInt(cantidadStr);

            if (cantidad<=0)
            {
                Toast.makeText(this, "La cantidad debe ser mayor a cero", Toast.LENGTH_SHORT).show();
            }
            else if (nombre.isEmpty())
            {
                Toast.makeText(this, "Debe ingresar el nombre del producto", Toast.LENGTH_SHORT).show();
            }
            //si no hay errores
            else {
                if (unidad.equals("Otro") && !unidadNueva.isEmpty()) {
                    unidad = unidadNueva;
                }
                Producto producto = new Producto(nombre, cantidad, unidad);
                listaDeCompras.agregarProducto(producto);
                finish();
            }

        }

    }

}