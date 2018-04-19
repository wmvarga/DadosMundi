package br.usjt.ftce.deswebmob.dadosmundi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static br.usjt.ftce.deswebmob.dadosmundi.PaisDbContract.PaisBanco;

/**
 * Created by William on 19/04/2018.
 */

/**
 * @author William Morone Varga - RA: 81612389
 * Turma: CCP3AN-MCA / Divisão 1
 */

public final class PaisDbHelper extends SQLiteOpenHelper {

    public static final String SQL_CREATE_PAIS =
            "CREATE TABLE IF NOT EXISTS " + PaisBanco.TABLE_NAME + " ( " +
                    PaisBanco._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PaisBanco.NOME + " TEXT, " +
                    PaisBanco.CODIGO3 + " TEXT, " +
                    PaisBanco.CAPITAL + " TEXT, " +
                    PaisBanco.REGIAO + " TEXT, " +
                    PaisBanco.SUBREGIAO + " TEXT, " +
                    PaisBanco.DEMONIMO + " TEXT, " +
                    PaisBanco.POPULACAO + " INTEGER, " +
                    PaisBanco.AREA + " INTEGER, " +
                    PaisBanco.GINI + " DOUBLE, " +
                    PaisBanco.LATITUDE + " DOUBLE, " +
                    PaisBanco.LONGITUDE + " DOUBLE)";

    public  static  final  String SQL_DROP_PAIS =
            "DROP TABLE IF EXISTS " + PaisBanco.TABLE_NAME;

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
