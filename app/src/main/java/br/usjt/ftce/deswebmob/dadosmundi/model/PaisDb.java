package br.usjt.ftce.deswebmob.dadosmundi.model;

/**
 * Created by William on 19/04/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
            values.put(PaisDbContract.PaisBanco.NOME, pais.getNome());
            values.put(PaisDbContract.PaisBanco.CODIGO3, pais.getCodigo3());
            values.put(PaisDbContract.PaisBanco.CAPITAL, pais.getCapital());
            values.put(PaisDbContract.PaisBanco.REGIAO, pais.getRegiao());
            values.put(PaisDbContract.PaisBanco.SUBREGIAO, pais.getSubRegiao());
            values.put(PaisDbContract.PaisBanco.DEMONIMO, pais.getDemonimo());
            values.put(PaisDbContract.PaisBanco.POPULACAO, pais.getPopulacao());
            values.put(PaisDbContract.PaisBanco.AREA, pais.getArea());
            values.put(PaisDbContract.PaisBanco.GINI, pais.getGini());
            values.put(PaisDbContract.PaisBanco.LATITUDE, pais.getLatitude());
            values.put(PaisDbContract.PaisBanco.LONGITUDE, pais.getLongitude());

            db.insert(PaisDbContract.PaisBanco.TABLE_NAME, null, values);

        }

        db.close();

    }

    public ArrayList<Pais> listarPaises() {

        ArrayList<Pais> paises = new ArrayList<>();

        SQLiteDatabase db = paisDbHelper.getReadableDatabase();
        String[] colunas = {
                PaisDbContract.PaisBanco.NOME,
                PaisDbContract.PaisBanco.CODIGO3,
                PaisDbContract.PaisBanco.CAPITAL,
                PaisDbContract.PaisBanco.REGIAO,
                PaisDbContract.PaisBanco.SUBREGIAO,
                PaisDbContract.PaisBanco.DEMONIMO,
                PaisDbContract.PaisBanco.POPULACAO,
                PaisDbContract.PaisBanco.AREA,
                PaisDbContract.PaisBanco.GINI,
                PaisDbContract.PaisBanco.LATITUDE,
                PaisDbContract.PaisBanco.LONGITUDE
        };
        String orderBy = PaisDbContract.PaisBanco.NOME;

        Cursor cursor = db.query(
                PaisDbContract.PaisBanco.TABLE_NAME,
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
                pais.setNome(cursor.getString(cursor.getColumnIndex(PaisDbContract.PaisBanco.NOME)));
                pais.setCodigo3(cursor.getString(cursor.getColumnIndex(PaisDbContract.PaisBanco.CODIGO3)));
                pais.setCapital(cursor.getString(cursor.getColumnIndex(PaisDbContract.PaisBanco.CAPITAL)));
                pais.setRegiao(cursor.getString(cursor.getColumnIndex(PaisDbContract.PaisBanco.REGIAO)));
                pais.setSubRegiao(cursor.getString(cursor.getColumnIndex(PaisDbContract.PaisBanco.SUBREGIAO)));
                pais.setDemonimo(cursor.getString(cursor.getColumnIndex(PaisDbContract.PaisBanco.DEMONIMO)));
                pais.setPopulacao(cursor.getInt(cursor.getColumnIndex(PaisDbContract.PaisBanco.POPULACAO)));
                pais.setArea(cursor.getInt(cursor.getColumnIndex(PaisDbContract.PaisBanco.AREA)));
                pais.setGini(cursor.getDouble(cursor.getColumnIndex(PaisDbContract.PaisBanco.GINI)));
                pais.setLatitude(cursor.getDouble(cursor.getColumnIndex(PaisDbContract.PaisBanco.LATITUDE)));
                pais.setLongitude(cursor.getDouble(cursor.getColumnIndex(PaisDbContract.PaisBanco.LONGITUDE)));

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
                PaisDbContract.PaisBanco.NOME,
                PaisDbContract.PaisBanco.CODIGO3,
                PaisDbContract.PaisBanco.CAPITAL,
                PaisDbContract.PaisBanco.REGIAO,
                PaisDbContract.PaisBanco.SUBREGIAO,
                PaisDbContract.PaisBanco.DEMONIMO,
                PaisDbContract.PaisBanco.POPULACAO,
                PaisDbContract.PaisBanco.AREA,
                PaisDbContract.PaisBanco.GINI,
                PaisDbContract.PaisBanco.LATITUDE,
                PaisDbContract.PaisBanco.LONGITUDE
        };

        String orderBy = PaisDbContract.PaisBanco.NOME;
        String selection = PaisDbContract.PaisBanco.REGIAO + "=?";
        String[] selectionArgs = {continente};

        Cursor cursor = db.query(
                PaisDbContract.PaisBanco.TABLE_NAME,
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
                pais.setNome(cursor.getString(cursor.getColumnIndex(PaisDbContract.PaisBanco.NOME)));
                pais.setCodigo3(cursor.getString(cursor.getColumnIndex(PaisDbContract.PaisBanco.CODIGO3)));
                pais.setCapital(cursor.getString(cursor.getColumnIndex(PaisDbContract.PaisBanco.CAPITAL)));
                pais.setRegiao(cursor.getString(cursor.getColumnIndex(PaisDbContract.PaisBanco.REGIAO)));
                pais.setSubRegiao(cursor.getString(cursor.getColumnIndex(PaisDbContract.PaisBanco.SUBREGIAO)));
                pais.setDemonimo(cursor.getString(cursor.getColumnIndex(PaisDbContract.PaisBanco.DEMONIMO)));
                pais.setPopulacao(cursor.getInt(cursor.getColumnIndex(PaisDbContract.PaisBanco.POPULACAO)));
                pais.setArea(cursor.getInt(cursor.getColumnIndex(PaisDbContract.PaisBanco.AREA)));
                pais.setGini(cursor.getDouble(cursor.getColumnIndex(PaisDbContract.PaisBanco.GINI)));
                pais.setLatitude(cursor.getDouble(cursor.getColumnIndex(PaisDbContract.PaisBanco.LATITUDE)));
                pais.setLongitude(cursor.getDouble(cursor.getColumnIndex(PaisDbContract.PaisBanco.LONGITUDE)));

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
