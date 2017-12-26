package dev.com.jongewaard.fragmentsapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import dev.com.jongewaard.fragmentsapp.R;
import dev.com.jongewaard.fragmentsapp.fragments.DetailsFragment;
import dev.com.jongewaard.fragmentsapp.fragments.ListFragment;
import dev.com.jongewaard.fragmentsapp.models.Mail;

public class MainActivity extends AppCompatActivity implements ListFragment.OnFragmentInteractionListener {


    private boolean isMultiPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMultiPanel();

    }

    @Override
    public void onListClick(Mail mail) {

        if (isMultiPanel) {
            DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentDetailsMail);
            detailsFragment.renderMail(mail);
        } else {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("subject", mail.getSubject());
            intent.putExtra("message", mail.getMessage());
            intent.putExtra("senderName", mail.getSenderName());
            startActivity(intent);
        }

    }

    private void setMultiPanel() {
        isMultiPanel = (getSupportFragmentManager().findFragmentById(R.id.fragmentDetailsMail) != null);
    }
}
