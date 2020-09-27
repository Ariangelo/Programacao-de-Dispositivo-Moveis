package br.com.ativade.programalista;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listViewAgenda = findViewById(R.id.listViewAgenda);
        listViewAgenda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posicao, long id) {
                Object objeto = listViewAgenda.getAdapter().getItem(posicao);
                if(objeto != null){
                    AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                    dialogo.setTitle("Planeta selecionado");
                    dialogo.setMessage(objeto.toString());
                    dialogo.setNeutralButton("Sair", null);
                    dialogo.show();
                }
            }
        });
    }
}