package com.example.ramiekhoury.finalprojecttake2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameActivity extends Activity {
    private static String[] words = {"awkward", "bango", "dwarves", "fjord", "hyphen", "ivory",
            "jiffy", "jukebox", "caramel", "mystify", "oxygen", "rogue", "sphinx", "zigzag",
            "terrible", "leopard", "elevator", "computer", "calendar", "button", "captain",
            "goldfish", "glasses", "pencil", "budget", "bedroom", "chromatic", "latter",
            "section", "liberty", "kingdom", "acrobat", "builder", "carrot", "diamond", "enough",
            "favorite", "grapple", "history", "imagine", "jigsaw", "knotted", "lighting",
            "market", "number", "ominous", "purple", "quilted", "resonate", "simulate", "talent",
            "ultra", "warning", "extreme", "yodel", "zombie"
    };
    private LinearLayout layout;
    private String currentWord;
    private TextView[] textShown;
    private GridView ltrs;
    private int numberCharacters;
    private int numberCorrect;
    private ImageView[] hangmanParts;
    private int numberParts = 6;
    private int currentParts;


    @Override
    protected void onCreate(Bundle instanceState) {
        super.onCreate(instanceState);
        currentWord = "";
        setContentView(R.layout.activity_hangman);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        layout = (LinearLayout)findViewById(R.id.word);
        ltrs = (GridView)findViewById(R.id.word);
        hangmanParts = new ImageView[numberParts];
        hangmanParts[0] = (ImageView) findViewById(R.id.head);
        hangmanParts[1] = (ImageView) findViewById(R.id.body);
        hangmanParts[2] = (ImageView) findViewById(R.id.firstArm);
        hangmanParts[3] = (ImageView) findViewById(R.id.secondArm);
        hangmanParts[4] = (ImageView) findViewById(R.id.firstLeg);
        hangmanParts[5] = (ImageView) findViewById(R.id.secondLeg);
        game();
    }

    private void game() {
        String word = words[(int) (Math.random() * words.length)];
        while (word.equals(currentWord)) {
            word = words[(int) (Math.random() * words.length)];
        }
        currentWord = word;
        textShown = new TextView[currentWord.length()];
        layout.removeAllViews();
        for (int i = 0; i < currentWord.length(); i++) {
            textShown[i] = new TextView(this);
            textShown[i].setText("" + currentWord.charAt(i));
            layout.addView(textShown[i]);
        }
        numberCharacters = currentWord.length();
        currentParts = 0;
        numberCorrect = 0;
        for (int j = 0; j < numberParts; j++) {
            hangmanParts[j].setVisibility(View.INVISIBLE);
        }
    }

    public void guess(View input) {
        String character = ((TextView) input).getText().toString();
        char letterAt = character.charAt(0);
        boolean correctlyGuessed = false;
        for (int i = 0; i < currentWord.length(); i++) {
            if (letterAt == currentWord.charAt(i)) {
                correctlyGuessed = true;
                numberCorrect++;
                textShown[i].setVisibility(View.VISIBLE);
            }
        }
        if (correctlyGuessed) {
            if (numberCorrect == numberCharacters) {
                AlertDialog.Builder win = new AlertDialog.Builder(this);
                win.setTitle("Congratulations!!!");
                win.setMessage("You won!\n\nThe word was:\n\n" + currentWord);
                win.setPositiveButton("Play Again",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                GameActivity.this.game();
                            }
                        });
                win.setNegativeButton("Exit",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                GameActivity.this.finish();
                            }
                        });
                win.show();
            }
            else if (numberParts > numberCorrect) {
                hangmanParts[currentParts].setVisibility(View.VISIBLE);
                currentParts++;
            } else {
                AlertDialog.Builder lost = new AlertDialog.Builder(this);
                lost.setTitle("Too bad!");
                lost.setMessage("You lose!\n\nThe word was:\n\n"+currentWord);
                lost.setPositiveButton("Play Again",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                GameActivity.this.game();
                            }
                        });
                lost.setNegativeButton("Exit",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                GameActivity.this.finish();
                            }
                        });
                lost.show();
            }
        }
    }
}

