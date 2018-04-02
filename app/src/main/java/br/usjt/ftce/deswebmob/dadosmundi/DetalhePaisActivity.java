package br.usjt.ftce.deswebmob.dadosmundi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @author William Morone Varga - RA: 81612389
 */

public class DetalhePaisActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pais);

        Intent intent = getIntent();
        TextView textView = (TextView) findViewById(R.id.textViewPais);
        Pais pais = (Pais) intent.getSerializableExtra(ListaPaisesActivity.PAIS_SELECIONADO);
        textView.setText(pais.toString());

    }
}
