package com.estsoft.gugudanfighter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Button NoButton = (Button) findViewById(R.id.button9);
        Button YesButton = (Button) findViewById(R.id.button10);

        Intent intent = getIntent();
        String s = intent.getStringExtra("totalCount");
        TextView tv = (TextView) findViewById(R.id.textView13);
        tv.setText(s);

        YesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentre = new Intent(ResultActivity.this, GameActivity.class);
                startActivity(intentre);
            }
        });


        NoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFinish = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intentFinish);
            }
        });

    }
}
