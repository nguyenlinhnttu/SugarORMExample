package com.example.sugarorm;

import android.app.Application;

import com.orm.SugarApp;
import com.orm.SugarContext;

/**
 * Created by nguyenvanlinh on 12/21/17.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
    }
}

