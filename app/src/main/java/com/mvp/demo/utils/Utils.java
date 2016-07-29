package com.mvp.demo.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.util.Log;

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

    private static final String TAG = Utils.class.getSimpleName();

    private static final String SDDIR = Environment.getExternalStorageDirectory().getAbsolutePath() + "/mvpdemo";

    public static File getCacheDir() {
        File mCacheFileDir = new File(SDDIR);
        Log.i(TAG, "dir = " + mCacheFileDir.getAbsolutePath());
        if ( !mCacheFileDir.exists() ) {
            mCacheFileDir.mkdirs();
        }
        return mCacheFileDir;
    }

    public static File getCacheFile() {
        getCacheDir();
        File mCacheFile = new File(SDDIR, "httpCache");
        Log.i(TAG, "cache = " + mCacheFile.getAbsolutePath());
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
