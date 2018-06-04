package br.usjt.ftce.deswebmob.dadosmundi.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.usjt.ftce.deswebmob.dadosmundi.R;
import br.usjt.ftce.deswebmob.dadosmundi.model.Pais;
import br.usjt.ftce.deswebmob.dadosmundi.model.Util;
import br.usjt.ftce.deswebmob.dadosmundi.presenter.DetalhePaisPresenter;

/**
 * @author William Morone Varga - RA: 81612389
 * Turma: CCP3AN-MCA / Divisão 1
 */

public class DetalhePaisActivity extends FragmentActivity implements DetalhePaisView {

    DetalhePaisPresenter presenter = new DetalhePaisPresenter(this);
    DetalhePaisView view = this;
    TextView txtNomePais, txtCodigo3, txtRegiao, txtCapital, txtSubRegiao,
            txtDemonimo, txtPopulacao, txtArea, txtGini, txtLatitude,
            txtLongitude, txtTodasInformacoes;
    ImageView bandeira;

    Pais pais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pais);
        Intent intent = getIntent();
        pais = (Pais) intent.getSerializableExtra(ListaPaisesActivity.PAIS_SELECIONADO);

        System.out.println(pais.getNome());

        txtNomePais = (TextView) findViewById(R.id.txtNomePais);
        txtCodigo3 = (TextView) findViewById(R.id.txtCodigo3);
        txtRegiao = (TextView) findViewById(R.id.txtRegiao);
        txtCapital = (TextView) findViewById(R.id.txtCapital);
        txtSubRegiao = (TextView) findViewById(R.id.txtSubRegiao);
        txtDemonimo = (TextView) findViewById(R.id.txtDemonimo);
        txtPopulacao = (TextView) findViewById(R.id.txtPopulacao);
        txtArea = (TextView) findViewById(R.id.txtArea);
        txtGini = (TextView) findViewById(R.id.txtGini);
        txtLatitude = (TextView) findViewById(R.id.txtLatitude);
        txtLongitude = (TextView) findViewById(R.id.txtLongitude);
        txtTodasInformacoes = (TextView) findViewById(R.id.txtTodasInformacoes);
        bandeira = (ImageView) findViewById(R.id.imagemBandeira);

        mostrar(view);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        presenter.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    public void mostrar(DetalhePaisView view){
        presenter.mostrar(getPais());
    }

    @Override
    public void configurarView(Pais pais) {

        txtNomePais.setText(this.pais.getNome());
        txtCodigo3.setText(this.pais.getCodigo3());
        txtRegiao.setText(this.pais.getRegiao());
        txtCapital.setText(this.pais.getCapital());
        txtSubRegiao.setText(this.pais.getSubRegiao());
        txtDemonimo.setText(this.pais.getDemonimo());
        txtPopulacao.setText(String.format("%1$,d", this.pais.getPopulacao()));
        txtArea.setText(String.format("%1$,d km\u00B2", this.pais.getArea()));
        txtGini.setText(String.format("%.2f", this.pais.getGini()));
        txtLatitude.setText(String.format("%.2f", this.pais.getLatitude()));
        txtLongitude.setText(String.format("%.2f", this.pais.getLongitude()));
        txtTodasInformacoes.setText(this.pais.toString());
        bandeira.setImageDrawable(Util.getDrawable(this, this.pais.getCodigo3().toLowerCase()));

    }

    public Pais getPais() {
        return this.pais;
    }
}
