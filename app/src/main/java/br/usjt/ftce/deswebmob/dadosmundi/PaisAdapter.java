package br.usjt.ftce.deswebmob.dadosmundi;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * @author William Morone Varga - RA: 81612389
 * Turma: CCP3AN-MCA / Divisão 1
 */

public class PaisAdapter extends BaseAdapter{
    Context context;
    ArrayList<Pais> paises;

    public PaisAdapter(Context context, ArrayList<Pais> paises) {
        this.context = context;
        this.paises = paises;
    }

    @Override
    public int getCount() {
        return paises.size();
    }

    @Override
    public Object getItem(int i) {
        return paises.get(i);
    }

    @Override
    public long getItemId(int i) {
        // Retornaria o id do país:
        // return paises.get(i).getId();
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        // view -> convertView (PDF)
        if (convertView == null) {
            // Inflando o  layout
            LayoutInflater  inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.linha_pais, parent, false);

            ImageView bandeira = (ImageView) convertView.findViewById(R.id.imgBandeira);
            TextView nome = (TextView) convertView.findViewById(R.id.txtNomePais);
            TextView regiao = (TextView) convertView.findViewById(R.id.txtRegiao);
            TextView capital = (TextView) convertView.findViewById(R.id.txtCapital);

            ViewHolderPais viewHolderPais = new ViewHolderPais(bandeira, nome, regiao, capital);
            convertView.setTag(viewHolderPais);
        }

        ViewHolderPais viewHolderPais = (ViewHolderPais) convertView.getTag();
        viewHolderPais.getNome().setText(paises.get(i).getNome());
        viewHolderPais.getRegiao().setText(paises.get(i).getRegiao());
        viewHolderPais.getCapital().setText(paises.get(i).getCapital());
        // drawable do país para pegar a img (codigo3: BRA -> bra.png)
        Drawable drawable = Util.getDrawable(context, paises.get(i).getCodigo3().toLowerCase());
        if (drawable == null) {
            drawable = context.getDrawable(R.drawable.bandeira);
        }
        viewHolderPais.getBandeira().setImageDrawable(drawable);

        return convertView;
    }
}