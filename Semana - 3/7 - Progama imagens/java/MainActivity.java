package br.com.ativade.progamaimagens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imagem;
    private Button  btnPrimeiro, btnSegundo;

    public void onClickBtnPrimeiro(View view) {
        imagem.setImageResource(R.drawable.primeira);
        btnPrimeiro.setEnabled(false);
        btnSegundo.setEnabled(true);
    }

    public void onClickBtnSegundo(View view) {
        imagem.setImageResource(R.drawable.segunda);
        btnSegundo.setEnabled(false);
        btnPrimeiro.setEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPrimeiro = findViewById(R.id.btnPrimeiro);
        btnSegundo = findViewById(R.id.btnSegundo);
        imagem = findViewById(R.id.imagem);
        imagem.setImageResource(R.drawable.primeira);
    }
}