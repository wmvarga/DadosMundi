package br.usjt.ftce.deswebmob.dadosmundi.model;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author William Morone Varga - RA: 81612389
 * Turma: CCP3AN-MCA / Divisão 1
 */

public class ViewHolderPais {
    ImageView bandeira;
    TextView nome, regiao, capital;

    public ViewHolderPais(ImageView bandeira, TextView nome, TextView regiao, TextView capital) {
        this.bandeira = bandeira;
        this.nome = nome;
        this.regiao = regiao;
        this.capital = capital;
    }

    public ImageView getBandeira() {
        return bandeira;
    }

    public void setBandeira(ImageView bandeira) {
        this.bandeira = bandeira;
    }

    public TextView getNome() {
        return nome;
    }

    public void setNome(TextView nome) {
        this.nome = nome;
    }

    public TextView getRegiao() {
        return regiao;
    }

    public void setRegiao(TextView regiao) {
        this.regiao = regiao;
    }

    public TextView getCapital() {
        return capital;
    }

    public void setCapital(TextView capital) {
        this.capital = capital;
    }
}
