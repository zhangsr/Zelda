package me.zsr.zelda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.database.Database;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Match
 * @date: 11/02/2018
 */

public class DBManager {
    private static final String DB_NAME = "zelda";
    private static DaoSession sDaoSession;
    private static Context mContext;

    public static void init(final Context context) {
        mContext = context;
        DaoMaster.OpenHelper helper = new DaoMaster.OpenHelper(context, DB_NAME) {
            public void onCreate(Database db) {
                super.onCreate(db);
                LogUtil.d("db onCreate");
                ThreadManager.post(new Runnable() {
                    public void run() {
                        DBManager.parseMaterial();
                        DBManager.parseRecipe("recipe_stamina.json");
                        DBManager.parseRecipe("recipe_heart.json");
                        LogUtil.d("parse complete");
                    }
                });
            }
        };
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        sDaoSession = daoMaster.newSession();
    }

    public static MaterialDao getMaterialDao() {
        return sDaoSession.getMaterialDao();
    }

    public static RecipeDao getRecipeDao() {
        return sDaoSession.getRecipeDao();
    }

    private static void parseMaterial() {
        try {
            JSONArray e = new JSONArray(loadJSONFromAsset("material.json"));
            LogUtil.d("parseMaterial length=" + e.length());
            ArrayList materialList = new ArrayList();

            for(int i = 0; i < e.length(); ++i) {
                JSONObject jsonObject = e.getJSONObject(i);
                Material material = new Material(Long.valueOf(jsonObject.optLong("id")), jsonObject.optString("name"), jsonObject.optString("image"), jsonObject.optString("desc"));
                materialList.add(material);
            }

            getMaterialDao().insertInTx(materialList);
        } catch (JSONException var5) {
            var5.printStackTrace();
        }

    }

    private static void parseRecipe(String fileName) {
        try {
            JSONArray jsonArray = new JSONArray(loadJSONFromAsset(fileName));
            LogUtil.d("parseRecipe length=" + jsonArray.length());
            List<Recipe> recipeList = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Recipe recipe = new Recipe(
                        jsonObject.optLong("id"),
                        jsonObject.optString("name"),
                        jsonObject.optString("image"),
                        jsonObject.optInt("price"),
                        jsonObject.optInt("heartRecovery"),
                        jsonObject.optInt("heartMax"),
                        jsonObject.optInt("speedTime"),
                        jsonObject.optInt("staminaRecovery"),
                        jsonObject.optInt("sneakTime"),
                        jsonObject.optInt("snowflakeTime"),
                        jsonObject.optInt("hotTime"),
                        jsonObject.optInt("boltTime"),
                        jsonObject.optInt("atkTime"),
                        jsonObject.optInt("defTime"),
                        jsonObject.optString("materialList")
                );
                recipeList.add(recipe);
            }
            getRecipeDao().insertInTx(recipeList);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private static String loadJSONFromAsset(String fileName) {
        String json;
        try {
            InputStream is = mContext.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
