package br.usjt.ftce.deswebmob.dadosmundi;

import java.io.Serializable;
import java.text.Collator;
import java.util.ArrayList;

/**
 * @author William Morone Varga - RA: 81612389
 */

public class Pais implements Serializable, Comparable{

    private String nome;
    private String codigo3;
    private String capital;
    private String regiao;
    private String subRegiao;
    private String demonimo;
    private int populacao;
    private int area;
    private String bandeira;
    private double gini;
    private ArrayList<String> idiomas;
    private ArrayList<String> moedas;
    private ArrayList<String> dominios;
    private ArrayList<String> fusos;
    private ArrayList<String> fronteiras;
    private double latitude;
    private double longitude;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo3() {
        return codigo3;
    }

    public void setCodigo3(String codigo3) {
        this.codigo3 = codigo3;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getSubRegiao() {
        return subRegiao;
    }

    public void setSubRegiao(String subRegiao) {
        this.subRegiao = subRegiao;
    }

    public String getDemonimo() {
        return demonimo;
    }

    public void setDemonimo(String demonimo) {
        this.demonimo = demonimo;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public double getGini() {
        return gini;
    }

    public void setGini(double gini) {
        this.gini = gini;
    }

    public ArrayList<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(ArrayList<String> idiomas) {
        this.idiomas = idiomas;
    }

    public ArrayList<String> getMoedas() {
        return moedas;
    }

    public void setMoedas(ArrayList<String> moedas) {
        this.moedas = moedas;
    }

    public ArrayList<String> getDominios() {
        return dominios;
    }

    public void setDominios(ArrayList<String> dominios) {
        this.dominios = dominios;
    }

    public ArrayList<String> getFusos() {
        return fusos;
    }

    public void setFusos(ArrayList<String> fusos) {
        this.fusos = fusos;
    }

    public ArrayList<String> getFronteiras() {
        return fronteiras;
    }

    public void setFronteiras(ArrayList<String> fronteiras) {
        this.fronteiras = fronteiras;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    // Usado para mostrar o país no DetalhePaisActivity
    @Override
    public String toString() {
        return "Pais{" +
                "nome='" + nome + '\'' +
                ", codigo3='" + codigo3 + '\'' +
                ", capital='" + capital + '\'' +
                ", regiao='" + regiao + '\'' +
                ", subRegiao='" + subRegiao + '\'' +
                ", demonimo='" + demonimo + '\'' +
                ", populacao=" + populacao +
                ", area=" + area +
                ", bandeira='" + bandeira + '\'' +
                ", gini=" + gini +
                ", idiomas=" + idiomas +
                ", moedas=" + moedas +
                ", dominios=" + dominios +
                ", fusos=" + fusos +
                ", fronteiras=" + fronteiras +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    // MÉTODO CRIADO PELO PROFESSOR BONATO
    @Override
    public int compareTo(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return 0;
        } else {
            /* java.text.Collator API 1.5
             * A classe Collator executa comparacao de sequencia de caracteres sensivel a localidade.
    	     * Voce usa essa classe para criar rotinas de busca e classificacao de texto em linguagem
    	     * natural.
    	     * Referencias:
    	     * https://docs.oracle.com/javase/7/docs/api/java/text/Collator.html
    	     * http://stackoverflow.com/questions/12889760/sort-list-of-strings-with-localization
    	     * */
            Pais pais = (Pais) o;
            // Collator e uma classe abstrata. Utilize o seu factory para instanciar.
            Collator c = Collator.getInstance();
            // A atribuicao de pontos fortes aos recursos de linguagem depende da regiao.
            c.setStrength(Collator.PRIMARY);
            return c.compare(this.nome, pais.getNome());
            //usar o compareTo nao ordena corretamente caracteres acentuados
            //return getNome().compareTo(pais.getNome());
        }
    }
}
