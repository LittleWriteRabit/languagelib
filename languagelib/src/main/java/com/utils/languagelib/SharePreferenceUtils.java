package com.utils.languagelib;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Locale;

/**
 * Created by dulijie on 2018/8/31.
 * 用于保存语言类型
 */
public class SharePreferenceUtils {
    private final String SP_NAME= "language_setting";
    private final String SELECT_LANGUAGE="language_select";
    private static volatile SharePreferenceUtils instance;

    private final SharedPreferences mSharePreferences;

    private Locale systemCurrentLocale = Locale.ENGLISH;

    public SharePreferenceUtils(Context context){
        mSharePreferences = context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
    }

    /**
     * 保存语言
     * @param select
     */
    public void saveLanguage(int select){
        if(mSharePreferences!= null) {
            SharedPreferences.Editor editor = mSharePreferences.edit();
            editor.putInt(SELECT_LANGUAGE,select);
            editor.commit();
        }
    }

    /**
     * 获取选中的语言 可以设置默认值 即为默认语言
     * @return
     */
    public int getSelectLanguage(){
        if(mSharePreferences!= null){
            return mSharePreferences.getInt(SELECT_LANGUAGE,0);
        }
        return 0;
    }

    public Locale getSystemCurrentLocale(){
        return systemCurrentLocale;
    }

    public void setSystemCurrentLocale(Locale locale){
        this.systemCurrentLocale=locale;
    }

    public static SharePreferenceUtils getInstance(Context context){
        if( instance == null){
            synchronized (SharePreferenceUtils.class){
                if(instance== null){
                    instance = new SharePreferenceUtils(context);
                }
            }
        }
        return instance;
    }
}
