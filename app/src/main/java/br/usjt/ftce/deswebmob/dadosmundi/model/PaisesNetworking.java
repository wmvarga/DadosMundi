package br.usjt.ftce.deswebmob.dadosmundi.model;

/**
 * Created by William on 18/04/2018.
 */

import android.content.Context;
import android.net.ConnectivityManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.ftce.deswebmob.dadosmundi.model.Pais;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author William Morone Varga - RA: 81612389
 *         Turma: CCP3AN-MCA / Divisão 1
 */

public class PaisesNetworking {

    public static ArrayList<Pais> buscarPaises(String url) throws IOException {
        ArrayList<Pais> paises = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        String json = response.body().string();

        try {
            JSONArray lista = new JSONArray(json);
            for (int i = 0; i < lista.length(); i++) {
                JSONObject item = (JSONObject) lista.get(i);
                Pais pais = new Pais();
                pais.setNome(item.getString("name"));
                pais.setCodigo3(item.getString("alpha3Code"));
                pais.setCapital(item.getString("capital"));
                pais.setRegiao(item.getString("region"));
                pais.setSubRegiao(item.getString("subregion"));
                pais.setDemonimo(item.getString("demonym"));
                pais.setPopulacao(item.getInt("population"));

                try {
                    pais.setArea(item.getInt("area"));
                } catch (Exception e){
                    pais.setArea(0);
                }

                ArrayList<Double> latLng = new ArrayList<>();
                JSONArray jsonArray = item.getJSONArray("latlng");
                for (int j = 0; j < jsonArray.length(); j++) {
                    latLng.add(jsonArray.getDouble(j));
                }

                try {
                    pais.setLatitude(latLng.get(0));
                    pais.setLongitude(latLng.get(1));
                } catch (Exception e){
                    pais.setLatitude(0);
                    pais.setLongitude(0);
                }

                ArrayList<String> idiomas = new ArrayList<>();
                jsonArray = item.getJSONArray("languages");
                for (int j = 0; j < jsonArray.length(); j++) {
                    idiomas.add(jsonArray.getString(j));
                }

                pais.setIdiomas(idiomas);

                ArrayList<String> moedas = new ArrayList<>();
                jsonArray = item.getJSONArray("currencies");
                for (int j = 0; j < jsonArray.length(); j++) {
                    moedas.add(jsonArray.getString(j));
                }

                pais.setMoedas(moedas);

                ArrayList<String> dominios = new ArrayList<>();
                jsonArray = item.getJSONArray("regionalBlocs");
                for (int j = 0; j < jsonArray.length(); j++) {
                    dominios.add(jsonArray.getString(j));
                }

                pais.setDominios(dominios);

                ArrayList<String> fusos = new ArrayList<>();
                jsonArray = item.getJSONArray("timezones");
                for (int j = 0; j < jsonArray.length(); j++) {
                    fusos.add(jsonArray.getString(j));
                }

                pais.setDominios(fusos);

                ArrayList<String> fronteiras = new ArrayList<>();
                jsonArray = item.getJSONArray("borders");
                for (int j = 0; j < jsonArray.length(); j++) {
                    fronteiras.add(jsonArray.getString(j));
                }

                pais.setDominios(fronteiras);
                paises.add(pais);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            throw new IOException(e);
        }

        return paises;
    }

    public static boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null &&
                connectivityManager.getActiveNetworkInfo().isConnected();
    }
}