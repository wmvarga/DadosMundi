package br.usjt.ftce.deswebmob.dadosmundi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * @author William Morone Varga - RA: 81612389
 */

public class MainActivity extends Activity {
    Spinner spinner;
    String continente = "";

    public static final String CHAVE = "br.usjt.ftce.deswebmob.dadosmundi.continente";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        Intent intent = new Intent(this, ListaPaisesActivity.class);
        intent.putExtra(CHAVE, continente);
        startActivity(intent);
    }
}
