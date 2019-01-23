package com.example.jooseongho.myasynctask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.play)
    Button play;
    @BindView(R.id.history)
    Button history;


    @OnClick({R.id.play,R.id.history})
    public void OnClick(View v){
        if(v.equals(play)){
            Intent intent = new Intent(MainActivity.this,gameActivity.class);
            startActivity(intent);
            finish();
        }
        else if(v.equals(history)){
            Intent intent = new Intent(MainActivity.this,historyActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }
}
