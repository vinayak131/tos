package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText text;
    Button btnText;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.editTextTextPersonName2);
        btnText = findViewById(R.id.button);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });

        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.speak(text.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
}