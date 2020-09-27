package br.com.atividade.telas.ui;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.com.atividade.telas.R;

public class CadastroFragment extends Fragment implements View.OnClickListener {

    EditText editTextDescricao, editTextMarca, editTextValor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.cadastro_fragment, container, false);
        FloatingActionButton btnCadastro = root.findViewById(R.id.btnCadastro);
        btnCadastro.setOnClickListener(this);
        editTextDescricao = root.findViewById(R.id.editTextDescricao);
        editTextMarca = root.findViewById(R.id.editTextMarca);
        editTextValor = root.findViewById(R.id.editTextValor);
        return root;
    }

    @Override
    public void onClick(View v) {
        SQLiteDatabase db = getActivity().openOrCreateDatabase("sistema.db", Context.MODE_PRIVATE, null);
        ContentValues conteudo = new ContentValues();
        conteudo.put("descricao", editTextDescricao.getText().toString());
        conteudo.put("marca", editTextMarca.getText().toString());
        conteudo.put("preco", Double.parseDouble(editTextValor.getText().toString()));
        if (db.insert("produtos", "_id", conteudo) > 0) {
            Toast.makeText(getContext(), "Registro Inserido com sucesso", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getContext(), "Erro ao inserir registro", Toast.LENGTH_LONG).show();
        }
        db.close();
    }
}