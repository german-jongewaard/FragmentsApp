package dev.com.jongewaard.fragmentsapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import dev.com.jongewaard.fragmentsapp.R;
import dev.com.jongewaard.fragmentsapp.fragments.DataFragment;
import dev.com.jongewaard.fragmentsapp.fragments.DetailsFragment;

public class MainActivity extends FragmentActivity implements DataFragment.DataListener {

    private boolean isMultiPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMultiPanel();
    }

    @Override
    public void sendData(String text) {

         if(isMultiPanel){
/* Llamar al método renderizarTexto del DetailsFragment, pasando el texto que recibimos por el
parámetro, en este mismo método. */
//aqui creo una instancia del fragmento al que quiero comunicarme
/* El findFragmentById me trae un Fragment GENERICO por eso le hago el Casting con DetailsFragments
No creo un fragment, lo encuentro, lo traigo con el findFragmentById */
             DetailsFragment detailsFragment = (DetailsFragment)getSupportFragmentManager()
                     .findFragmentById(R.id.detailsFragment);
             detailsFragment.renderText(text);
         } else {

             Intent intent = new Intent(this, DetailsActivity.class);
             intent.putExtra("text", text);
             startActivity(intent);
         }






    }

    private void setMultiPanel(){
            //Si tengo dos Fragment va a dar verdadero, si solo tiene uno va a dar falso
        isMultiPanel = (getSupportFragmentManager().findFragmentById(R.id.detailsFragment) != null);
    }
}
