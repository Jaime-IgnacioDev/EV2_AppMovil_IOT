package cl.inacap.listacompras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cl.inacap.listacompras.modelo.ListaDeCompras;
import cl.inacap.listacompras.modelo.Producto;

public class DetallesActivity extends AppCompatActivity {

    public Producto producto;
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        //Obtener el ID desd el intent
        intent=getIntent();
        int id=(Integer) intent.getExtras().get("idProducto");

        //Recuperar el producto desde el ARRAY
        //producto=Producto.productos[id];

        //Recuperamos el producto desde la lista
        producto= ListaDeCompras.getInstancia().getProducto(id);

        //Mostramos la información del PRODUCTO

        //Nombre del Producto
        TextView txtNombre=(TextView) findViewById(R.id.txtNombre);
        txtNombre.setText(producto.getNombre());

        //Cantidad y Unidad
        TextView txtCantidad=(TextView) findViewById(R.id.txtCantidad);
        txtCantidad.setText("Cantidad: "+producto.getCantidad()+" "+producto.getUnidad());

        //Estado Textview y Boton
        TextView txtEstado=(TextView) findViewById(R.id.txtEstado);
        Button estado=(Button) findViewById(R.id.estado);
        if(producto.isEstado()==Producto.COMPRADO)
        {
            txtEstado.setText("Estado: COMPRADO!");
            estado.setText("Marcar como PENDIENTE");
        }
        else
        {
            txtEstado.setText("Estado: PENDIENTE!");
            estado.setText("Marca como COMPRADO");
        }
        estado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                producto.setEstado(!producto.isEstado());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}