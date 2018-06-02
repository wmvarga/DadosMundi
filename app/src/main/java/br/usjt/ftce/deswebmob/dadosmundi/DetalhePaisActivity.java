package br.usjt.ftce.deswebmob.dadosmundi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author William Morone Varga - RA: 81612389
 * Turma: CCP3AN-MCA / Divisão 1
 */

public class DetalhePaisActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pais);
        Intent intent = getIntent();
        Pais pais = (Pais) intent.getSerializableExtra(ListaPaisesActivity.PAIS_SELECIONADO);

        TextView txtNomePais = (TextView) findViewById(R.id.txtNomePais);
        txtNomePais.setText(pais.getNome());

        TextView txtCodigo3 = (TextView) findViewById(R.id.txtCodigo3);
        txtCodigo3.setText(pais.getCodigo3());

        TextView txtRegiao = (TextView) findViewById(R.id.txtRegiao);
        txtRegiao.setText(pais.getRegiao());

        TextView txtCapital = (TextView) findViewById(R.id.txtCapital);
        txtCapital.setText(pais.getCapital());

        TextView txtSubRegiao = (TextView) findViewById(R.id.txtSubRegiao);
        txtSubRegiao.setText(pais.getSubRegiao());

        TextView txtDemonimo = (TextView) findViewById(R.id.txtDemonimo);
        txtDemonimo.setText(pais.getDemonimo());

        TextView txtPopulacao = (TextView) findViewById(R.id.txtPopulacao);
        txtPopulacao.setText(String.format("%1$,d", pais.getPopulacao()));

        TextView txtArea = (TextView) findViewById(R.id.txtArea);
        txtArea.setText(String.format("%1$,d km\u00B2", pais.getArea()));

        TextView txtGini = (TextView) findViewById(R.id.txtGini);
        txtGini.setText(String.format("%.2f", pais.getGini()));

        TextView txtLatitude = (TextView) findViewById(R.id.txtLatitude);
        txtLatitude.setText(String.format("%.2f", pais.getLatitude()));

        TextView txtLongitude = (TextView) findViewById(R.id.txtLongitude);
        txtLongitude.setText(String.format("%.2f", pais.getLongitude()));

        TextView txtTodasInformacoes = (TextView) findViewById(R.id.txtTodasInformacoes);
        txtTodasInformacoes.setText(pais.toString());

        ImageView bandeira = (ImageView) findViewById(R.id.imagemBandeira);
        bandeira.setImageDrawable(Util.getDrawable(this, pais.getCodigo3().toLowerCase()));

    }
}
