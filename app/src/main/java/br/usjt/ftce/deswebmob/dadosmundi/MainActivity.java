package br.usjt.ftce.deswebmob.dadosmundi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.IOException;
import java.util.ArrayList;

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

        new DownloadJsonPaises().execute("https://restcountries.eu/rest/v2/" + finalUrl);
    }

    // Classe para a thread que busca o JSON que vai vir pelo serviço
    private class DownloadJsonPaises extends AsyncTask<String, Void, ArrayList<Pais>> {

        protected ArrayList<Pais> doInBackground(String... strings) {
            ArrayList<Pais> paises = new ArrayList<>();
            if (PaisesNetworking.isConnected(contexto)) {
                try {
                    paises = PaisesNetworking.buscarPaises(strings[0]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
