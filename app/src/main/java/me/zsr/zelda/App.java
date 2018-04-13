package me.zsr.zelda;

import android.app.Application;
import android.support.annotation.RestrictTo;

/**
 * @description:
 * @author: Match
 * @date: 11/02/2018
 */

// TODO: 18/02/2018 stamina max
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // environment
        ThreadManager.init();
        LogUtil.enable(BuildConfig.DEBUG);

        // data
        DBManager.init(this);

        // resource
        ResTool.init(getResources());
        ImageUtil.init(getAssets());
    }
}
