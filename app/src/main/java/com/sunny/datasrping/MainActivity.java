package com.sunny.datasrping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    TextView tv_content;
    Button btn_test;

    long lastTime = 0;
    long curTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_content = findViewById(R.id.tv_content);
        btn_test = findViewById(R.id.btn_test);

        btn_test.setOnClickListener(this);

        lastTime = Long.parseLong(SharedPreferencesUtil.getStringValue(this, CommonCons.SHARED_SYS_TIME, "0"));
        curTime = System.currentTimeMillis();
        SharedPreferencesUtil.setStringValue(this, CommonCons.SHARED_SYS_TIME, String.valueOf(curTime));

        String last = TimeUtil.convertTime(TimeUtil.FORMAT_TIME_CN, lastTime);
        String cur = TimeUtil.convertTime(TimeUtil.FORMAT_TIME_CN, curTime);

        tv_content.setText("上次登录时间：" + last+"\n" +"本次登录时间:" + cur);
        Log.e(TAG, "上次登录时间:" + last);
        Log.e(TAG, "本次登录时间:" + cur);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
                long during = curTime - lastTime;

                Log.e(TAG, "during:" + during + " , " + during / (1000 * 60 * 60));

                if (lastTime == 0) {
                    tv_content.setText("欢迎初次使用");
                } else if (during < 1000 * 60 * 60 * 24 * 3) {
                    tv_content.setText("欢迎经常使用");
                } else {
                    tv_content.setText("好久不见，欢迎再次使用");
                }
                break;
        }
    }
}
