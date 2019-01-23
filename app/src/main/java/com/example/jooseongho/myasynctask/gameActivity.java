package com.example.jooseongho.myasynctask;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Util.SharedPreferencesManager;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class gameActivity extends AppCompatActivity {
    int targetNumber = 1;

    @BindView(R.id.tv_time)
    TextView tv_time;

    @BindViews({
            R.id.btn_01,
            R.id.btn_02,
            R.id.btn_03,
            R.id.btn_04,
            R.id.btn_05,
            R.id.btn_06,
            R.id.btn_07,
            R.id.btn_08,
            R.id.btn_09,
            R.id.btn_10,

            R.id.btn_11,
            R.id.btn_12,
            R.id.btn_13,
            R.id.btn_14,
            R.id.btn_15,
            R.id.btn_16,
            R.id.btn_17,
            R.id.btn_18,
            R.id.btn_19,
            R.id.btn_20,

            R.id.btn_21,
            R.id.btn_22,
            R.id.btn_23,
            R.id.btn_24,
            R.id.btn_25,
            R.id.btn_26,
            R.id.btn_27,
            R.id.btn_28,
            R.id.btn_29,
            R.id.btn_30,

            R.id.btn_31,
            R.id.btn_32,
            R.id.btn_33,
            R.id.btn_34,
            R.id.btn_35,
            R.id.btn_36,
            R.id.btn_37,
            R.id.btn_38,
            R.id.btn_39,
            R.id.btn_40,

            R.id.btn_41,
            R.id.btn_42,
            R.id.btn_43,
            R.id.btn_44,
            R.id.btn_45,
            R.id.btn_46,
            R.id.btn_47,
            R.id.btn_48,
            R.id.btn_49,
            R.id.btn_50

    })
    List<Button> btnList;

    @OnClick({
            R.id.btn_01,
            R.id.btn_02,
            R.id.btn_03,
            R.id.btn_04,
            R.id.btn_05,
            R.id.btn_06,
            R.id.btn_07,
            R.id.btn_08,
            R.id.btn_09,
            R.id.btn_10,

            R.id.btn_11,
            R.id.btn_12,
            R.id.btn_13,
            R.id.btn_14,
            R.id.btn_15,
            R.id.btn_16,
            R.id.btn_17,
            R.id.btn_18,
            R.id.btn_19,
            R.id.btn_20,

            R.id.btn_21,
            R.id.btn_22,
            R.id.btn_23,
            R.id.btn_24,
            R.id.btn_25,
            R.id.btn_26,
            R.id.btn_27,
            R.id.btn_28,
            R.id.btn_29,
            R.id.btn_30,

            R.id.btn_31,
            R.id.btn_32,
            R.id.btn_33,
            R.id.btn_34,
            R.id.btn_35,
            R.id.btn_36,
            R.id.btn_37,
            R.id.btn_38,
            R.id.btn_39,
            R.id.btn_40,

            R.id.btn_41,
            R.id.btn_42,
            R.id.btn_43,
            R.id.btn_44,
            R.id.btn_45,
            R.id.btn_46,
            R.id.btn_47,
            R.id.btn_48,
            R.id.btn_49,
            R.id.btn_50
    })
    public void OnCLick(View v) {
        for (Button btn : btnList) {
            if (v.equals(btn) && btn.getText().equals(targetNumber + "")) {
                v.setVisibility(v.INVISIBLE);
                targetNumber++;
            }
        }
    }

    SharedPreferencesManager pref;
    TimerAsyncTask timerAsyncTask;
    long startTime;
    long currentTime;

    String[] nameList = new String[3];
    float[] timeList = new float[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);

        pref= new SharedPreferencesManager(this);
        nameList[0] = pref.getValue(pref._1ST_NAME,"");
        nameList[1] = pref.getValue(pref._2ND_NAME,"");
        nameList[2] = pref.getValue(pref._3RD_NAME,"");

        timeList[0] = pref.getValue(pref._1ST_SCORE,999999f);
        timeList[1] = pref.getValue(pref._2ND_SCORE,999999f);
        timeList[2] = pref.getValue(pref._3RD_SCORE,999999f);
        initButton();


        TimerAsyncTask timerAsyncTask = new TimerAsyncTask();
        timerAsyncTask.execute();



    }

    private void initButton() {

        ArrayList<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            intList.add(i + 1);
        }
        for (int i = 0; i < 50; i++) {
            Random r = new Random();
            int rand = r.nextInt(50);

            int temp = intList.get(i);
            intList.set(i, intList.get(rand));
            intList.set(rand, temp);
        }

        for (int i = 0; i < btnList.size(); i++) {
            btnList.get(i).setText(intList.get(i) + "");
        }

    }
    public class TimerAsyncTask extends AsyncTask<Void,Void,Void>{




        @Override
        protected void onCancelled() {//asyncTask 그만둬
            super.onCancelled();
        }

        @Override
        protected void onPreExecute() {//asyncTask 돌기 직전에 / 변수 초기화 ui
            super.onPreExecute();
            startTime = System.currentTimeMillis();
        }

        //타이머 업데이트
        @Override
        protected Void doInBackground(Void... voids) {//비동기 UI 스레드 접근불가
            while(targetNumber<=50){
                try {
                    Thread.sleep(100);//정확하게 돌아가지 않음

                    publishProgress();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {//doing 백그라운드가 돌면서 UI 에 접근할때  야 UI 업데이트좀 해줘
            super.onProgressUpdate(values);
            currentTime = System.currentTimeMillis();
            tv_time.setText((currentTime-startTime)/1000+"."+(currentTime-startTime)%1000/100);
        }

        @Override
        protected void onPostExecute(Void aVoid) {//doingbackgroud 끝나고 실행
            super.onPostExecute(aVoid);
            saveHistory(tv_time.getText());
        }
    }

    private void saveHistory(CharSequence text) {
        try {
            float time = Float.parseFloat(text.toString());

            Random r = new Random();

            if (time < timeList[0]) {
                timeList[2] = timeList[1];
                timeList[1] = timeList[0];
                timeList[0] = time;

                nameList[2] = nameList[1];
                nameList[1] = nameList[0];
                nameList[0] = "GAMER - " + r.nextInt(1000);
            } else if (time < timeList[1]) {
                timeList[2] = timeList[1];
                timeList[1] = time;

                nameList[2] = nameList[1];
                nameList[1] = "GAMER - " + r.nextInt(1000);
            } else if (time < timeList[2]) {
                timeList[2] = time;
                nameList[2] = "GAMER - " + r.nextInt(1000);
            }

            pref.put(pref._1ST_NAME, nameList[0]);
            pref.put(pref._2ND_NAME, nameList[1]);
            pref.put(pref._3RD_NAME, nameList[2]);

            pref.put(pref._1ST_SCORE, timeList[0]);
            pref.put(pref._2ND_SCORE, timeList[1]);
            pref.put(pref._3RD_SCORE, timeList[2]);

        } catch (Exception e) {
            Log.e("GameActivity", e.getMessage());
        }

        Intent intent = new Intent(gameActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        try{
        timerAsyncTask.cancel(true);
    }catch (Exception e){

        }
}}

