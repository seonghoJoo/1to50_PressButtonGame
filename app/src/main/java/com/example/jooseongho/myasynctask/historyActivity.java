package com.example.jooseongho.myasynctask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import Util.SharedPreferencesManager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class historyActivity extends AppCompatActivity {

    @BindView(R.id._1st_name)
    TextView _1st_name;
    @BindView(R.id._1st_time)
    TextView _1st_time;
    @BindView(R.id._2nd_name)
    TextView _2nd_name;
    @BindView(R.id._2nd_time)
    TextView _2nd_time;
    @BindView(R.id._3rd_name)
    TextView _3rd_name;
    @BindView(R.id._3rd_time)
    TextView _3rd_time;


    SharedPreferencesManager pref;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(historyActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);

        pref = new SharedPreferencesManager(this);
        if(pref.getValue(pref._1ST_NAME,"").equals("")){

        }
        else{
            _1st_name.setText(pref.getValue(pref._1ST_NAME,""));
            _1st_time.setText(pref.getValue(pref._1ST_SCORE,0f)+"");
        }
        if(pref.getValue(pref._2ND_NAME,"").equals("")){

        }
        else{
            _1st_name.setText(pref.getValue(pref._2ND_NAME,""));
            _1st_time.setText(pref.getValue(pref._2ND_SCORE,0f)+"");
        }
        if(pref.getValue(pref._3RD_NAME,"").equals("")){

        }
        else{
            _1st_name.setText(pref.getValue(pref._3RD_NAME,""));
            _1st_time.setText(pref.getValue(pref._3RD_SCORE,0f)+"");
        }
    }
}
