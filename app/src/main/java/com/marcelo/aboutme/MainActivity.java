package com.marcelo.aboutme;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView nombre = findViewById(R.id.nombre);
        final TextView carrera = findViewById(R.id.carrera);
        final TextView github = findViewById(R.id.TVgithub);
        final TextView twitter = findViewById(R.id.TVtwitter);
        final TextView wa = findViewById(R.id.TVwa);
        final TextView gmail = findViewById(R.id.TVgmail);


        Button but = findViewById(R.id.btncompartir);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
                shareIntent.setType("*/*");
                shareIntent.putExtra(Intent.EXTRA_TEXT, nombre.getText().toString() + "\nCarrera: " + carrera.getText().toString() +
                        "\nGithub: " + github.getText().toString()+ "\nTwitter: "+ twitter.getText().toString()+ "\nWhatsapp: "+ wa.getText().toString()+"\nGmail: " +
                        gmail.getText().toString());
                shareIntent.putExtra(Intent.EXTRA_HTML_TEXT, "https://imgur.com/a/7Mc2X");


                //Esta verificacion es necesaria
                if (shareIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(shareIntent);
                }
            }
        });
    }
}
