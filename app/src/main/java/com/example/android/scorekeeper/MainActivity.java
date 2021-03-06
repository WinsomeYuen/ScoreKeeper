package com.example.android.scorekeeper;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int foulsTeamA = 0;
    int scoreTeamB = 0;
    int foulsTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);
        displayForTeamA(0,0);
        displayForTeamB(0,0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        return super.onOptionsItemSelected(item);}

    /**
     * Increase the score for Team A by 1 point.
     */

    public void addOneForTeamA(View v) {
        scoreTeamA+=1;
        displayForTeamA(scoreTeamA,foulsTeamA);
    }

    public void minusOneForTeamA(View v) {
        if(scoreTeamA<=0){
            return;
        }
        scoreTeamA-=1;
        displayForTeamA(scoreTeamA,foulsTeamA);
    }
    /**
     * Increase the fouls for Team A by 1 point.
     */
    public void addFoulForTeamA(View v) {
        foulsTeamA+=1;
        displayForTeamA(scoreTeamA,foulsTeamA);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score, int fouls) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));

        TextView foulsView = (TextView) findViewById(R.id.team_a_fouls);
        foulsView.setText(String.valueOf(fouls));
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        scoreTeamB+=1;
        displayForTeamB(scoreTeamB,foulsTeamB);
    }
    public void minusOneForTeamB(View v) {
        if(scoreTeamB<=0){
            return;
        }
        scoreTeamB-=1;
        displayForTeamA(scoreTeamB,foulsTeamB);
    }

    /**
     * Increase the fouls for Team B by 1 point.
     */
    public void addFoulForTeamB(View v) {
        foulsTeamB+=1;
        displayForTeamB(scoreTeamB,foulsTeamB);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score, int fouls) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));

        TextView foulsView = (TextView) findViewById(R.id.team_b_fouls);
        foulsView.setText(String.valueOf(fouls));
    }

    public void resetScore(View v){
        scoreTeamA = 3;
        foulsTeamA = 0;
        scoreTeamB = 3;
        foulsTeamB = 0;
        displayForTeamA(scoreTeamA,foulsTeamA);
        displayForTeamB(scoreTeamB,foulsTeamB);
    }
}
