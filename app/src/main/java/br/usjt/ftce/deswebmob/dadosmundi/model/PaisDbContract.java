package br.usjt.ftce.deswebmob.dadosmundi.model;

import android.provider.BaseColumns;

/**
 * Created by William on 19/04/2018.
 */

/**
 * @author William Morone Varga - RA: 81612389
 * Turma: CCP3AN-MCA / Divisão 1
 */
public final class PaisDbContract {

    public PaisDbContract() {}

    public static abstract class PaisBanco implements BaseColumns {

        public static final String TABLE_NAME = "Pais";
        public static final String NOME = "nome";
        public static final String CODIGO3 = "codigo3";
        public static final String CAPITAL = "capital";
        public static final String REGIAO = "regiao";
        public static final String SUBREGIAO = "subRegiao";
        public static final String DEMONIMO = "demonimo";
        public static final String POPULACAO ="populacao";
        public static final String AREA = "area";
        public static final String GINI = "gini";
        public static final String LATITUDE = "latitude";
        public static final String LONGITUDE = "longitude";

    }

}
