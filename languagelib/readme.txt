用法

//自定义语言
1.SharePreferenceUtils 中保存自己规定的索引
在工具类中重写
2.LanguageManageUtils 中 getSetLanguageLocale 方法 获取 Locale
3.在 LanguageManageUtils 中 setLocal方法设置为上述Locale 调用
public static Context setLocal(Context context, Locale locale) {
        return updateResources(context, locale);
}

用于各个位置的替换
setLocal(Context context, Locale locale)
setApplicationLanguage(Context context, Locale locale)
onConfigurationChanged(Context context, Locale locale)

=======Activity中添加
 @Override
 protected void attachBaseContext(Context newBase) {

        super.attachBaseContext(LanguageManageUtils.setLocal(newBase));
 }
 
======Application 中添加
@Override
public void onCreate() {
    LanguageManageUtils.setApplicationLanguage(this);
}

@Override
protected void attachBaseContext(Context base) {
   //保存系统选择语言
   LanguageManageUtils.saveSystemCurrentLanguage(base);
   super.attachBaseContext(LanguageManageUtils.setLocal(base));
}

 @Override
public void onConfigurationChanged(Configuration newConfig) {
   super.onConfigurationChanged(newConfig);
   //保存系统选择语言
   LanguageManageUtils.onConfigurationChanged(getApplicationContext());
}


在需要切换的位置
//获取当前选中的语言
int index = SharePreferenceUtils.getInstance(context).getSelectLanguage();
//设置选中的语言
LanguageManageUtils.saveSelectLanguage(context, 0);
