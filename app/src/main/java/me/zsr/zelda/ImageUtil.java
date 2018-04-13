package me.zsr.zelda;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: Match
 * @date: 11/02/2018
 */

public class ImageUtil {
    private static AssetManager mAssetmanager;

    public static void init(AssetManager assetManager) {
        mAssetmanager = assetManager;
    }

    public static Drawable getDrawable(String imageName) {
        if (StringUtil.isEmpty(imageName)) {
            return null;
        }
        try {
            InputStream ims = mAssetmanager.open("image" + File.separator + imageName + ".png");
            return Drawable.createFromStream(ims, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
