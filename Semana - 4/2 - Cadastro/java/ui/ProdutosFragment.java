package br.com.atividade.telas.ui;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import br.com.atividade.telas.R;

public class ProdutosFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.produtos_fragment, container, false);
        SQLiteDatabase db = getActivity().openOrCreateDatabase("sistema.db", Context.MODE_PRIVATE, null);
        String[] campos = new String[] {"_id", "descricao", "marca", "preco"};
        int[] valores = new int[] {R.id.textViewId, R.id.textViewDescricao, R.id.textViewMarca, R.id.textViewPreco};
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(
                getContext(),
                R.layout.layout_produto,
                db.rawQuery("SELECT * FROM produtos", null),
                campos,
                valores,
                0
        );
        ListView listaProdutos = root.findViewById(R.id.listViewProdutos);
        listaProdutos.setAdapter(adaptador);
        db.close();
        return root;
    }
}