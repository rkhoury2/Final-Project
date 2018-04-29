package com.example.ramiekhoury.finalprojecttake2;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
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
    private int wordCharacters;
    private int numberCharacters;
    private int numberCorrect;
    private ImageView[] hangmanParts;
    private int numberParts = 6;
    private int currentParts;


    @Override
    protected void onCreate(Bundle instanceState) {
        super.onCreate(instanceState);
        currentWord = "";
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
}

