package cl.inacap.listacompras;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.listacompras.modelo.ListaDeCompras;
import cl.inacap.listacompras.modelo.Producto;

public class ListaProductosActivity extends ListActivity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cargarLista();
    }
    public void cargarLista()
    {
        lista=getListView(); //LLamamos al listview

        ArrayList<Producto> productos= ListaDeCompras.getInstancia().getListaDeCompras();

        //Creamos el ADAPTADOR
        ArrayAdapter<Producto> listaAdapter= new ArrayAdapter<Producto>(this,
                android.R.layout.simple_list_item_1,
                productos);
        //Agregamos al ADAPTADOR = Listview
        lista.setAdapter(listaAdapter);
    }

    @Override
    public void onListItemClick(ListView listView, View view, int posicion, long id)
    {
        Intent intent=new Intent(ListaProductosActivity.this, DetallesActivity.class);
        intent.putExtra("idProducto",(int)id);
        startActivityForResult(intent, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1)
        {
            if (resultCode==RESULT_OK)
            {
                cargarLista();
            }
        }
    }

}