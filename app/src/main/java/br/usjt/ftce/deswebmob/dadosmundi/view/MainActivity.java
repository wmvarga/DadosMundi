package br.usjt.ftce.deswebmob.dadosmundi.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.ftce.deswebmob.dadosmundi.R;
import br.usjt.ftce.deswebmob.dadosmundi.model.Pais;
import br.usjt.ftce.deswebmob.dadosmundi.model.PaisDb;
import br.usjt.ftce.deswebmob.dadosmundi.model.PaisesNetworking;

/**
 * @author William Morone Varga - RA: 81612389
 *         Turma: CCP3AN-MCA / Divisão 1
 */

public class MainActivity extends Activity {
    Spinner spinner;
    String continente = "";
    Context contexto;

    public static final String CHAVE = "br.usjt.ftce.deswebmob.dadosmundi.paises";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contexto = this;

        // Pega o spinner do layout
        spinner = (Spinner) findViewById(R.id.spinnerContinentes);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //
                continente = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void listarPaises(View view) {
        /*
        * Se não escolher nenhum, pega todos os países
        * Caso contrário ele pega da region (continente) que selecionou:
        *
        * Documentaçâo:
        * REGION
            Search by region: Africa, Americas, Asia, Europe, Oceania
            e.g. https://restcountries.eu/rest/v2/region/europe
        * */
        String finalUrl;
        if (continente == "" || continente.equals("Todos")) {
            finalUrl = "all";
        } else {
            finalUrl = "region/" + continente.toLowerCase();
        }

        // Se tiver internet, baixa o json e popula o banco, caso contrário tenta pegar o que já tem
        if (PaisesNetworking.isConnected(this)) {
            new DownloadJsonPaises().execute("https://restcountries.eu/rest/v2/" + finalUrl);
        } else {
            new BuscaBancoPaises().execute();
        }

    }

    // Classe para a thread que busca o JSON que vai vir pelo serviço
    private class DownloadJsonPaises extends AsyncTask<String, Void, ArrayList<Pais>> {

        protected ArrayList<Pais> doInBackground(String... strings) {
            ArrayList<Pais> paises = new ArrayList<>();

            try {
                // Busca o JSON
                paises = PaisesNetworking.buscarPaises(strings[0]);
                // Popula o banco do SQLite
                PaisDb paisDb = new PaisDb(contexto);
                paisDb.inserirPais(paises);


            } catch (IOException | SQLiteException e) {
                e.printStackTrace();
            }

            return paises;
        }

        protected void onPostExecute(ArrayList<Pais> paises) {
            Intent intent = new Intent(contexto, ListaPaisesActivity.class);
            intent.putExtra(CHAVE, paises);
            startActivity(intent);
        }
    }

    // Classe para buscar os paises do SQLite
    private class BuscaBancoPaises extends AsyncTask<String, Void, ArrayList<Pais>> {

        protected ArrayList<Pais> doInBackground(String... strings) {
            ArrayList<Pais> paises = new ArrayList<>();

            try {
                // Popula o banco do SQLite
                PaisDb paisDb = new PaisDb(contexto);

                // Só pega os países do continente selecionado (ou todos)
                if (continente.equals("Todos")) {
                    paises = paisDb.listarPaises();
                } else {
                    paises = paisDb.listarPaises(continente);
                }

            } catch (SQLiteException e) {
                e.printStackTrace();
            }

            return paises;
        }

        protected void onPostExecute(ArrayList<Pais> paises) {
            Intent intent = new Intent(contexto, ListaPaisesActivity.class);
            intent.putExtra(CHAVE, paises);
            startActivity(intent);
        }
    }
}
