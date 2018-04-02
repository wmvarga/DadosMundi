package br.usjt.ftce.deswebmob.dadosmundi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author William Morone Varga - RA: 81612389
 * Turma: CCP3AN-MCA / Divisão 1
 */

public class DetalhePaisActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pais);
        Intent intent = getIntent();
        Pais pais = (Pais) intent.getSerializableExtra(ListaPaisesActivity.PAIS_SELECIONADO);
        ImageView bandeira = (ImageView) findViewById(R.id.imagemBandeira);
        TextView textView = (TextView) findViewById(R.id.textViewPais);
        bandeira.setImageDrawable(Util.getDrawable(this, pais.getCodigo3().toLowerCase()));
        textView.setText(pais.toString());
    }
}
