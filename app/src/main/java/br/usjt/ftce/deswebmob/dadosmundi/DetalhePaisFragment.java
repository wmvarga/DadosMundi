package br.usjt.ftce.deswebmob.dadosmundi;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author William Morone Varga - RA: 81612389
 * Turma: CCP3AN-MCA / Divisão 1
 */

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalhePaisFragment extends Fragment {


    public DetalhePaisFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalhe_pais, container, false);
    }

}
