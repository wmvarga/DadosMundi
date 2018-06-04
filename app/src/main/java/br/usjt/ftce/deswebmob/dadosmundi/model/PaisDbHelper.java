package br.usjt.ftce.deswebmob.dadosmundi.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by William on 19/04/2018.
 */

/**
 * @author William Morone Varga - RA: 81612389
 * Turma: CCP3AN-MCA / Divisão 1
 */

public final class PaisDbHelper extends SQLiteOpenHelper {

    public static final String SQL_CREATE_PAIS =
            "CREATE TABLE IF NOT EXISTS " + PaisDbContract.PaisBanco.TABLE_NAME + " ( " +
                    PaisDbContract.PaisBanco._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PaisDbContract.PaisBanco.NOME + " TEXT, " +
                    PaisDbContract.PaisBanco.CODIGO3 + " TEXT, " +
                    PaisDbContract.PaisBanco.CAPITAL + " TEXT, " +
                    PaisDbContract.PaisBanco.REGIAO + " TEXT, " +
                    PaisDbContract.PaisBanco.SUBREGIAO + " TEXT, " +
                    PaisDbContract.PaisBanco.DEMONIMO + " TEXT, " +
                    PaisDbContract.PaisBanco.POPULACAO + " INTEGER, " +
                    PaisDbContract.PaisBanco.AREA + " INTEGER, " +
                    PaisDbContract.PaisBanco.GINI + " DOUBLE, " +
                    PaisDbContract.PaisBanco.LATITUDE + " DOUBLE, " +
                    PaisDbContract.PaisBanco.LONGITUDE + " DOUBLE)";

    public  static  final  String SQL_DROP_PAIS =
            "DROP TABLE IF EXISTS " + PaisDbContract.PaisBanco.TABLE_NAME;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Pais.db";

    public PaisDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public PaisDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PAIS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_PAIS);
        db.execSQL(SQL_CREATE_PAIS);
    }
}
