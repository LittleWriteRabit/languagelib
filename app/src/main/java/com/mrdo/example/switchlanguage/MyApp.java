package com.mrdo.example.switchlanguage;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.utils.languagelib.LanguageManageUtils;

/**
 * Created by dulijie on 2018/8/31.
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LanguageManageUtils.setApplicationLanguage(this,MyUtils.getSetLanguageLocale(this));
    }

    @Override
    protected void attachBaseContext(Context base) {
        //保存系统选择语言
        LanguageManageUtils.saveSystemCurrentLanguage(base);
        super.attachBaseContext(LanguageManageUtils.setLocal(base,MyUtils.getSetLanguageLocale(this)));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //保存系统选择语言
        LanguageManageUtils.onConfigurationChanged(getApplicationContext(),MyUtils.getSetLanguageLocale(this));
    }

//    @Override
//    public void onCreate() {
//        super.onCreate();
//        LanguageManageUtils.setApplicationLanguage(this);
//    }
//
//    @Override
//    protected void attachBaseContext(Context base) {
//        //保存系统选择语言
//        LanguageManageUtils.saveSystemCurrentLanguage(base);
//        super.attachBaseContext(LanguageManageUtils.setLocal(base));
//    }
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        //保存系统选择语言
//        LanguageManageUtils.onConfigurationChanged(getApplicationContext());
//    }
}
