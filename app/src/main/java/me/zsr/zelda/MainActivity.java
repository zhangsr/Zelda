package me.zsr.zelda;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecipeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: optimize 16/02/2018 verify db ready
        ThreadManager.post(new Runnable() {
            @Override
            public void run() {
                init();
            }
        });
    }

    private void init() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecipeAdapter(DBManager.getRecipeDao().loadAll(), this);
        mRecyclerView.setAdapter(mAdapter);
        LogUtil.d("set adapter");
    }

    @Override
    public void onClick(View v) {
        if (v == null) {
            return;
        }
        List<Material> materialList = DBManager.getMaterialDao().loadAll();
        for (Material material : materialList) {
            Log.e("zhangsr", "name=" + material.getName());
        }
//        switch (v.getId()) {
//            case R.id.btn_heart:
//                break;
//        }
    }
}
