package dev.com.jongewaard.fragmentsapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dev.com.jongewaard.fragmentsapp.R;
import dev.com.jongewaard.fragmentsapp.fragments.DetailsFragment;
import dev.com.jongewaard.fragmentsapp.models.Mail;

/**
 * Created by german on 21-12-17.
 */

public class DetailsActivity extends AppCompatActivity {


    private String subject;
    private String message;
    private String sender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        if (getIntent().getExtras() != null) {
            subject = getIntent().getStringExtra("subject");
            message = getIntent().getStringExtra("message");
            sender = getIntent().getStringExtra("senderName");
        }

        Mail mail = new Mail(subject, message, sender);

        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentDetailsMail);
        detailsFragment.renderMail(mail);

    }
}
