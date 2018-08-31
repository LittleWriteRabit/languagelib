package com.utils.languagelib;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import android.util.Log;

import java.util.Locale;

/**
 * Created by dulijie on 2018/8/31.
 * 语言处理工具类
 */
public class LanguageManageUtils {
    private static final String TAG = LanguageManageUtils.class.getSimpleName();

    public static final String LANG_CHINESE = "中文";
    public static final String LANG_ENGLISH = "English";
    public static final String LANG_THAI = "ถามไทย";
    public static final String LANG_KHMER = "កម្ពុជា";

    /**
     * LocalManageUtil
     * 获取系统的locale
     *
     * @return Locale对象
     */
    public static Locale getSystemLocale(Context context) {
        return SharePreferenceUtils.getInstance(context).getSystemCurrentLocale();
    }

    public static String getSelectLanguage(Context context) {
        switch (SharePreferenceUtils.getInstance(context).getSelectLanguage()) {
            case 0:
                return LANG_CHINESE;
            case 1:
                return LANG_ENGLISH;
            case 2:
                return LANG_THAI;
            case 3:
                return LANG_KHMER;
            default:
                return LANG_ENGLISH;
        }
    }

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

    public static void saveSelectLanguage(Context context, int select) {
        SharePreferenceUtils.getInstance(context).saveLanguage(select);
        setApplicationLanguage(context);
    }

    public static Context setLocal(Context context) {
        return updateResources(context, getSetLanguageLocale(context));
    }

    private static Context updateResources(Context context, Locale locale) {
        Locale.setDefault(locale);
        Resources res = context.getResources();
        Configuration config = new Configuration(res.getConfiguration());
        if (Build.VERSION.SDK_INT >= 17) {
            config.setLocale(locale);
            context = context.createConfigurationContext(config);
        } else {
            config.locale = locale;
            res.updateConfiguration(config, res.getDisplayMetrics());
        }
        return context;
    }

    /**
     * 设置语言类型
     */
    public static void setApplicationLanguage(Context context) {
        Resources resources = context.getApplicationContext().getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        Locale locale = getSetLanguageLocale(context);
        config.locale = locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            LocaleList localeList = new LocaleList(locale);
            LocaleList.setDefault(localeList);
            config.setLocales(localeList);
            context.getApplicationContext().createConfigurationContext(config);
            Locale.setDefault(locale);
        }
        resources.updateConfiguration(config, dm);
    }


    public static void saveSystemCurrentLanguage(Context context) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            locale = LocaleList.getDefault().get(0);
        } else {
            locale = Locale.getDefault();
        }
        Log.d(TAG, locale.getLanguage());
        SharePreferenceUtils.getInstance(context).setSystemCurrentLocale(locale);
    }

    public static void onConfigurationChanged(Context context) {
        saveSystemCurrentLanguage(context);
        setLocal(context);
        setApplicationLanguage(context);
    }

    /**
     * 可以使用此方法 通过 select 索引自行重写 {@link #getSetLanguageLocale}
     *
     * @param context
     * @param locale
     * @return
     */
    public static Context setLocal(Context context, Locale locale) {
        return updateResources(context, locale);
    }


    /**
     * 设置语言类型 如果上述内容不满足则可以根据SharePreference 存储的index 查找后传入locale
     * {@link #setApplicationLanguage}
     */
    public static void setApplicationLanguage(Context context, Locale locale) {
        Resources resources = context.getApplicationContext().getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        config.locale = locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            LocaleList localeList = new LocaleList(locale);
            LocaleList.setDefault(localeList);
            config.setLocales(localeList);
            context.getApplicationContext().createConfigurationContext(config);
            Locale.setDefault(locale);
        }
        resources.updateConfiguration(config, dm);
    }

    /**
     * 内置的几个不满足时，可以重写
     * {@link #onConfigurationChanged}
     *
     * @param context
     */
    public static void onConfigurationChanged(Context context, Locale locale) {
        saveSystemCurrentLanguage(context);
        setLocal(context,locale);
        setApplicationLanguage(context, locale);
    }
}
