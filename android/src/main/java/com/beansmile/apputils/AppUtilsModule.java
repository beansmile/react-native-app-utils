package com.beansmile.apputils;

import com.facebook.react.bridge.ReactApplicationContext;
import com.beansmile.apputils.NativeAppUtilsSpec;

import android.content.Intent;
import android.content.Context;

public class AppUtilsModule extends NativeAppUtilsSpec {

    public AppUtilsModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public void exitApp() {
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    @Override
    public void restartApp() {
        Context context = getReactApplicationContext();
        Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntent != null) {
            launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(launchIntent);
        }
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}