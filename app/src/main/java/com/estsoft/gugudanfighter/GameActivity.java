package com.estsoft.gugudanfighter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private Timer timer = new Timer();
    private int result = 0;
    private int totalCount = 0;
    private int seconds = 10;
    private int gameCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        timer.schedule(new GameTimer(), 1000, 1000);
        doGame();
    }

    private void doGame() {
        TextView timeCount = (TextView) findViewById(R.id.textView3);
        timeCount.setText("" + seconds);
        Button[] buttons = new Button[9];
        buttons[0] = (Button) findViewById(R.id.button);
        buttons[1] = (Button) findViewById(R.id.button1);
        buttons[2] = (Button) findViewById(R.id.button2);
        buttons[3] = (Button) findViewById(R.id.button3);
        buttons[4] = (Button) findViewById(R.id.button4);
        buttons[5] = (Button) findViewById(R.id.button5);
        buttons[6] = (Button) findViewById(R.id.button6);
        buttons[7] = (Button) findViewById(R.id.button7);
        buttons[8] = (Button) findViewById(R.id.button8);

        TextView tva = (TextView) findViewById(R.id.textView7);
        TextView tvb = (TextView) findViewById(R.id.textView9);
        TextView TotalCount = (TextView) findViewById(R.id.textView6);

        List<Integer> numList = RandomList.getRandomList();
        Log.d("gen", numList.toString());
        int a = ((int) (Math.random() * 10) + 1);
        int b = ((int) (Math.random() * 10) + 1);
        result = a * b;

        buttons[(result % 9)].setText("" + result);

        for (int i = 0; i < 9; i++) {
            if (numList.get(i) == result && i != result % 9) {
                buttons[i].setText("" + numList.get(numList.size() - 1));

            } else if (i != result % 9) {
                buttons[i].setText("" + numList.get(i));
            }

            buttons[i].setOnClickListener(this);
        }
        tva.setText("" + a);
        tvb.setText("" + b);
        TotalCount.setText("" + totalCount + "/10");
        gameCount++;
        if (gameCount == 11) {
            timer.cancel();
            Intent intent = new Intent(GameActivity.this, ResultActivity.class);
            intent.putExtra("totalCount", "" + totalCount);
            startActivity(intent);

        }

    }

    @Override
    public void onClick(View v) {

        Button b = (Button) findViewById(v.getId());
        if (b.getText().equals("" + result)) {
            totalCount++;
        }

        doGame();
    }

    private class GameTimer extends TimerTask {


        @Override
        public void run() {
            if (--seconds < 0) {
                timer.cancel();
                Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                intent.putExtra("totalCount", "" + totalCount);
                startActivity(intent);
                return;
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    TextView tv = (TextView) findViewById(R.id.textView3);
                    tv.setText("" + seconds);
                }
            });
        }
    }
}
