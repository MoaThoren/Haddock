package com.homework5.haddock;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fetchSwearing(View view) {
        new FetchCitation().execute();
    }

    public void changeCitation(String newMessage) {
        TextView textView = findViewById(R.id.citationBox);
        textView.setText(newMessage);

    }

    private class FetchCitation extends AsyncTask<Void, Void, String> {


        @Override
        protected String doInBackground(Void... voids) {
            String citation;
            try {
                WordHandler wh = new WordHandler(getResources().openRawResource(R.raw.words));
                citation = wh.randomWord();
            } catch (IOException e) {
                citation = "Nä nu blommar asfalten och skam går på torra land, det blev något knas på skutan...";
            }
            return citation;
        }

        @Override
        protected void onPostExecute(String msg) {
            changeCitation(msg);
        }

    }

}

