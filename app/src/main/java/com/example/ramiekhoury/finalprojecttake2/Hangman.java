package com.example.ramiekhoury.finalprojecttake2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Hangman extends AppCompatActivity {
    public static void main(String[] args) {
        String[] words = {"awkward", "bango", "dwarves", "fjord", "hyphen", "ivory",
                "jiffy", "jukebox", "caramel", "mystify", "oxygen", "rogue", "sphinx", "zigzag",
                "terrible", "leopard", "elevator", "computer", "calendar", "button", "captain",
                "goldfish", "glasses", "pencil", "budget", "bedroom", "chromatic", "latter",
        };
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);
        final Button restartButton = findViewById(R.id.button_id);
        restartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Log.d("restart button", "The restart button works!");
            }
        });
        EditText userInput = findViewById(R.id.userinput);
        userInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    Log.d("userinput", "User input string works!");
                   // sendMessage();
                    handled = true;
                }
                return handled;
            }
            })
    ;}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hangman, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
