package br.usjt.ftce.deswebmob.dadosmundi.presenter;

/**
 * @author William Morone Varga - RA: 81612389
 * Turma: CCP3AN-MCA / Divisão 1
 */

public interface Presenter {
    void onCreate();
    void onStart();
    void onRestart();
    void onPause();
    void onStop();
    void onResume();
    void onDestroy();
}
