package br.usjt.ftce.deswebmob.dadosmundi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author William Morone Varga - RA: 81612389
 */

public class ListaPaisesActivity extends Activity {
    public static final String PAIS_SELECIONADO = "br.usjt.ftce.deswebmob.dadosmundi.pais_selecionado";
    Activity activity;
    ArrayList<Pais> paises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);

        activity = this;
        // Pega o continente que foi selecionado
        Intent intent = getIntent();
        String continente = intent.getStringExtra(MainActivity.CHAVE);
        paises = Data.listarPaises(continente);
        ArrayList<String> nomes = Data.listarNomes(paises);

        // Pega o listView e configura os países do continente selecionado
        ListView listView = (ListView) findViewById(R.id.listViewPaises);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(activity, DetalhePaisActivity.class);
                intent.putExtra(PAIS_SELECIONADO, paises.get(i));
                startActivity(intent);
            }
        });
    }
}
