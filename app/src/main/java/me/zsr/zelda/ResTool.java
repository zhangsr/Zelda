package me.zsr.zelda;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * @description:
 * @author: Match
 * @date: 14/02/2018
 */

public class ResTool {
    private static Resources sResources;


    public static void init(Resources resources) {
        sResources = resources;
    }

    public static int dpToPx(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, sResources.getDisplayMetrics());
    }
}
