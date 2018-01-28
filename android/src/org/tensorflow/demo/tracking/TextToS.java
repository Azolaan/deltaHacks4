package org.tensorflow.demo.tracking;

/**
 * Created by Lawrence C on 1/28/2018.
 */

import android.speech.tts.TextToSpeech;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import java.util.Locale;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

import org.tensorflow.demo.R;

public class TextToS extends Activity{

    TextToSpeech speech;
    TextView textView;
    String text;
    private TextToSpeech myTTS;
    private int MY_DATA_CHECK_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_connection_fragment_tracking);
        textView = (TextView) findViewById(R.id.textView);
        String words = textView.getText().toString();
        Log.d("WORDSCOMING TEST:", words);
        speakWords(words);
    }

    private void speakWords(String speech){
//        myTTS = new TextToSpeech()
//        myTTS.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
    }

    /*protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                myTTS = new TextToSpeech(this, this);
            } else {
                Intent installTTSIntent = new Intent();
                installTTSIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installTTSIntent);
            }
        }
    }*/

    public void onInit(int initStatus) {
        if (initStatus == TextToSpeech.SUCCESS) {
            if (myTTS.isLanguageAvailable(Locale.US) == TextToSpeech.LANG_AVAILABLE)
                myTTS.setLanguage(Locale.US);
            myTTS.setLanguage(Locale.US);
        } else if (initStatus == TextToSpeech.ERROR) {
            Toast.makeText(this, "Sorry! Text To Speech failed...", Toast.LENGTH_LONG).show();
        }
    }
}
