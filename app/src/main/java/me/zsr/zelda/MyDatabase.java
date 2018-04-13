package me.zsr.zelda;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * @description:
 * @author: Match
 * @date: 10/02/2018
 */

public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "zelda";
    private static final int DATABASE_VERSION = 1;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
