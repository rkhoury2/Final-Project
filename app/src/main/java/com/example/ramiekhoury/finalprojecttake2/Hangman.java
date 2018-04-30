package com.example.ramiekhoury.finalprojecttake2;

import android.content.Intent;
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

public class Hangman extends AppCompatActivity implements View.OnClickListener {

    private EditText characterInput;
    private TextView hangmanDashes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);
        final Button enterButton = findViewById(R.id.enterButton);
        enterButton.setOnClickListener(this);
        final Button restartButton = findViewById(R.id.button_id);
        restartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Log.d("restart button", "The restart button works!");
            }
        });
      /**  final EditText userInput = findViewById(R.id.userinput);
        userInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    getText(actionId).toString();
                    Log.d("userinput", "User input string works!");
                   // sendMessage();
                    handled = true;
                }
                return handled;
            }
            })
       **/
        characterInput = (EditText)findViewById(R.id.userinput);
        hangmanDashes = (TextView)findViewById(R.id.ltrs);
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
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.enterButton) {
            View guess = characterInput;
            GameActivity.guessed(guess);
        }
    }
}
