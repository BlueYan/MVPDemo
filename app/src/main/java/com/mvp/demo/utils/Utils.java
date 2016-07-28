package com.mvp.demo.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * 创建人：
 * 创建时间： 2016/7/28 19
 * 功能概述:
 * 修改人：
 * 修改时间：
 */
public class Utils {

    public static File getCacheDir(Context context) {
        File mCacheFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/mvpdemo", "mvpdemo");
        if ( !mCacheFile.exists() ) {
            try {
                mCacheFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mCacheFile;
    }

    public static boolean networkIsAvailable(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            return true;
        }
        return false;
    }

}
