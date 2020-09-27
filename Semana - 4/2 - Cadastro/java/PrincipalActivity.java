package br.com.atividade.telas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_cadastro,
                R.id.navigation_produtos,
                R.id.navigation_inicio,
                R.id.navigation_dashboard,
                R.id.navigation_notificacao)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        criarBanco();
    }

    public void criarBanco() {
        SQLiteDatabase db = openOrCreateDatabase("sistema.db", Context.MODE_PRIVATE, null);
        StringBuilder sqlProduto = new StringBuilder();
        sqlProduto.append("CREATE TABLE IF NOT EXISTS ");
        sqlProduto.append("produtos(_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sqlProduto.append("descricao VARCHAR(30), ");
        sqlProduto.append("marca VARCHAR(20), ");
        sqlProduto.append(("preco DOUBLE);"));
        db.execSQL(sqlProduto.toString());
        db.close();
    }
}