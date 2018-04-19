package br.usjt.ftce.deswebmob.dadosmundi;

/**
 * Created by William on 19/04/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static br.usjt.ftce.deswebmob.dadosmundi.PaisDbContract.PaisBanco;

import java.util.ArrayList;

/**
 * @author William Morone Varga - RA: 81612389
 * Turma: CCP3AN-MCA / Divisão 1
 */

public class PaisDb {

    private PaisDbHelper paisDbHelper;

    public PaisDb(Context context) {
        paisDbHelper = new PaisDbHelper(context);
    }

    public void inserirPais(ArrayList<Pais> paises) {

        SQLiteDatabase db = paisDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        for (Pais pais : paises) {
            values.put(PaisBanco.NOME, pais.getNome());
            values.put(PaisBanco.CODIGO3, pais.getCodigo3());
            values.put(PaisBanco.CAPITAL, pais.getCapital());
            values.put(PaisBanco.REGIAO, pais.getRegiao());
            values.put(PaisBanco.SUBREGIAO, pais.getSubRegiao());
            values.put(PaisBanco.DEMONIMO, pais.getDemonimo());
            values.put(PaisBanco.POPULACAO, pais.getPopulacao());
            values.put(PaisBanco.AREA, pais.getArea());
            values.put(PaisBanco.GINI, pais.getGini());
            values.put(PaisBanco.LATITUDE, pais.getLatitude());
            values.put(PaisBanco.LONGITUDE, pais.getLongitude());

            db.insert(PaisBanco.TABLE_NAME, null, values);

        }

        db.close();

    }

    public ArrayList<Pais> listarPaises() {

        ArrayList<Pais> paises = new ArrayList<>();

        SQLiteDatabase db = paisDbHelper.getReadableDatabase();
        String[] colunas = {
                PaisBanco.NOME,
                PaisBanco.CODIGO3,
                PaisBanco.CAPITAL,
                PaisBanco.REGIAO,
                PaisBanco.SUBREGIAO,
                PaisBanco.DEMONIMO,
                PaisBanco.POPULACAO,
                PaisBanco.AREA,
                PaisBanco.GINI,
                PaisBanco.LATITUDE,
                PaisBanco.LONGITUDE
        };
        String orderBy = PaisBanco.NOME;

        Cursor cursor = db.query(
                PaisBanco.TABLE_NAME,
                colunas,
                null,
                null,
                null,
                null,
                orderBy
        );

        if (cursor.moveToFirst()) {
            do {
                Pais pais = new Pais();
                pais.setNome(cursor.getString(cursor.getColumnIndex(PaisBanco.NOME)));
                pais.setCodigo3(cursor.getString(cursor.getColumnIndex(PaisBanco.CODIGO3)));
                pais.setCapital(cursor.getString(cursor.getColumnIndex(PaisBanco.CAPITAL)));
                pais.setRegiao(cursor.getString(cursor.getColumnIndex(PaisBanco.REGIAO)));
                pais.setSubRegiao(cursor.getString(cursor.getColumnIndex(PaisBanco.SUBREGIAO)));
                pais.setDemonimo(cursor.getString(cursor.getColumnIndex(PaisBanco.DEMONIMO)));
                pais.setPopulacao(cursor.getInt(cursor.getColumnIndex(PaisBanco.POPULACAO)));
                pais.setArea(cursor.getInt(cursor.getColumnIndex(PaisBanco.AREA)));
                pais.setGini(cursor.getDouble(cursor.getColumnIndex(PaisBanco.GINI)));
                pais.setLatitude(cursor.getDouble(cursor.getColumnIndex(PaisBanco.LATITUDE)));
                pais.setLongitude(cursor.getDouble(cursor.getColumnIndex(PaisBanco.LONGITUDE)));

                // Adiciona o país na lista
                paises.add(pais);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // Provando no console que está realmente pegando os dados do SQLite
        System.out.println("SQLite está funcionando!");

        return paises;

    }

    public ArrayList<Pais> listarPaises(String continente) {

        ArrayList<Pais> paises = new ArrayList<>();

        SQLiteDatabase db = paisDbHelper.getReadableDatabase();
        String[] colunas = {
                PaisBanco.NOME,
                PaisBanco.CODIGO3,
                PaisBanco.CAPITAL,
                PaisBanco.REGIAO,
                PaisBanco.SUBREGIAO,
                PaisBanco.DEMONIMO,
                PaisBanco.POPULACAO,
                PaisBanco.AREA,
                PaisBanco.GINI,
                PaisBanco.LATITUDE,
                PaisBanco.LONGITUDE
        };

        String orderBy = PaisBanco.NOME;
        String selection = PaisBanco.REGIAO + "=?";
        String[] selectionArgs = {continente};

        Cursor cursor = db.query(
                PaisBanco.TABLE_NAME,
                colunas,
                selection,
                selectionArgs,
                null,
                null,
                orderBy
        );

        if (cursor.moveToFirst()) {
            do {
                Pais pais = new Pais();
                pais.setNome(cursor.getString(cursor.getColumnIndex(PaisBanco.NOME)));
                pais.setCodigo3(cursor.getString(cursor.getColumnIndex(PaisBanco.CODIGO3)));
                pais.setCapital(cursor.getString(cursor.getColumnIndex(PaisBanco.CAPITAL)));
                pais.setRegiao(cursor.getString(cursor.getColumnIndex(PaisBanco.REGIAO)));
                pais.setSubRegiao(cursor.getString(cursor.getColumnIndex(PaisBanco.SUBREGIAO)));
                pais.setDemonimo(cursor.getString(cursor.getColumnIndex(PaisBanco.DEMONIMO)));
                pais.setPopulacao(cursor.getInt(cursor.getColumnIndex(PaisBanco.POPULACAO)));
                pais.setArea(cursor.getInt(cursor.getColumnIndex(PaisBanco.AREA)));
                pais.setGini(cursor.getDouble(cursor.getColumnIndex(PaisBanco.GINI)));
                pais.setLatitude(cursor.getDouble(cursor.getColumnIndex(PaisBanco.LATITUDE)));
                pais.setLongitude(cursor.getDouble(cursor.getColumnIndex(PaisBanco.LONGITUDE)));

                // Adiciona o país na lista
                paises.add(pais);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // Provando no console que está realmente pegando os dados do SQLite
        System.out.println("SQLite está funcionando!");

        return paises;

    }

}
