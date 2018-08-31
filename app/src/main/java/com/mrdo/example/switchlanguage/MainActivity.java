package com.mrdo.example.switchlanguage;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.utils.languagelib.LanguageManageUtils;
import com.utils.languagelib.SharePreferenceUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvTest=findViewById(R.id.tv_testView);
        tvTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        findViewById(R.id.chinese).setOnClickListener(this);
        findViewById(R.id.english).setOnClickListener(this);
        findViewById(R.id.thai).setOnClickListener(this);
        findViewById(R.id.kmer).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int index = SharePreferenceUtils.getInstance(this).getSelectLanguage();
        switch (v.getId()){
            case R.id.chinese:
                if (index != 0) {
                    LanguageManageUtils.saveSelectLanguage(this, 0);
                    recreate();
                }
                break;
            case R.id.english:
                if (index != 1) {
                    LanguageManageUtils.saveSelectLanguage(this, 1);
                    recreate();
                }
                break;
            case R.id.thai:
                if (index != 2) {
                    LanguageManageUtils.saveSelectLanguage(this, 2);
                    recreate();
                }
                break;
            case R.id.kmer:
                if (index != 3) {
                    LanguageManageUtils.saveSelectLanguage(this, 3);
                    recreate();
                }
                break;
        }
    }

//    private void restart() {
//        Intent intent = new Intent(this,MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(intent);
//        // 杀掉进程
//        android.os.Process.killProcess(android.os.Process.myPid());
//        System.exit(0);
//    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LanguageManageUtils.setLocal(newBase));
    }

}
