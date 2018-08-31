package com.mrdo.example.switchlanguage;

import android.content.Context;

import com.utils.languagelib.SharePreferenceUtils;

import java.util.Locale;

/**
 * Created by dulijie on 2018/8/31.
 */
public class MyUtils {

    /**
     * 获取选择的语言设置  如果需要可以自行扩展
     *
     * @param context
     * @return
     */
    public static Locale getSetLanguageLocale(Context context) {

        switch (SharePreferenceUtils.getInstance(context).getSelectLanguage()) {
            case 0:
                return Locale.CHINA;
            case 1:
                return Locale.ENGLISH;
            case 2:
                //泰语
                return new Locale("th", "");
            case 3:
                //高棉语
                return new Locale("km", "");
            default:
                return Locale.ENGLISH;
        }
    }
}
