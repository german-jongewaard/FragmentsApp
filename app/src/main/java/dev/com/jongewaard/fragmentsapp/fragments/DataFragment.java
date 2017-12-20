package dev.com.jongewaard.fragmentsapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import dev.com.jongewaard.fragmentsapp.R;

public class DataFragment extends Fragment {

    private EditText textData;
    private Button btnSend;

    private DataListener callback;


    public DataFragment() {
        // Required empty public constructor
    }

    /* */

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback = (DataListener) context;
        }catch (Exception e){
            //el Log es para mostrarme info en el "Logcat"
            //Log.i(e.toString());
            throw new ClassCastException(context.toString() + "Should implement DataListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    //
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        //Lógica para capturar los elementos de la UI


        textData = (EditText)view.findViewById(R.id.editTextData);
        btnSend = (Button)view.findViewById(R.id.buttonSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendText("");
            }
        });

        return view;
    }

    private void sendText(String text) {

    }

    //método que comunica
    public interface DataListener{
        void sendData(String text);
    }

}
