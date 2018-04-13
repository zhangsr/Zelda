package me.zsr.zelda;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @description:
 * @author: Match
 * @date: 11/02/2018
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ItemViewHolder>{
    private List<Recipe> mRecipeList;
    private Activity mActivity;

    public RecipeAdapter(List<Recipe> recipeList, Activity activity) {
        mRecipeList = recipeList;
        mActivity = activity;

        LogUtil.d("count=" + mRecipeList.size());
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        ItemViewHolder holder = new ItemViewHolder(view);
        holder.image = view.findViewById(R.id.image);
        holder.name = view.findViewById(R.id.name);
        holder.material1 = view.findViewById(R.id.material1);
        holder.material2 = view.findViewById(R.id.material2);
        holder.material3 = view.findViewById(R.id.material3);
        holder.material4 = view.findViewById(R.id.material4);
        holder.heart = view.findViewById(R.id.heart_image);
        holder.heart = view.findViewById(R.id.heart_image);
        holder.effect = view.findViewById(R.id.effect_image);
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Recipe recipe = mRecipeList.get(position);
        holder.image.setImageDrawable(ImageUtil.getDrawable(recipe.getImage()));
        holder.name.setText(recipe.getName());
        if (!StringUtil.isEmpty(recipe.getMaterialList())) {
            String[] materialIdList = recipe.getMaterialList().split(",");
            for (int i = 0; i < materialIdList.length; i++) {
                if (i == 0) {
                    holder.material1.setImageDrawable(ImageUtil.getDrawable(getImageNameById(Long.parseLong(materialIdList[i]))));
                } else if (i == 1) {
                    holder.material2.setImageDrawable(ImageUtil.getDrawable(getImageNameById(Long.parseLong(materialIdList[i]))));
                } else if (i == 2) {
                    holder.material3.setImageDrawable(ImageUtil.getDrawable(getImageNameById(Long.parseLong(materialIdList[i]))));
                } else if (i == 3) {
                    holder.material4.setImageDrawable(ImageUtil.getDrawable(getImageNameById(Long.parseLong(materialIdList[i]))));
                }
            }
        }
        holder.heart.setData(recipe.getHeartMax(), recipe.getHeartRecovery());
        holder.effect.setData(recipe.getStaminaRecovery());
    }

    private String getImageNameById(Long id) {
        Material material = DBManager.getMaterialDao().queryBuilder().where(MaterialDao.Properties.Id.eq(id)).unique();
        if (material != null) {
            return material.getImage();
        }
        return "";
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView name;
        public ImageView material1;
        public ImageView material2;
        public ImageView material3;
        public ImageView material4;
        public HeartImageView heart;
        public EffectImageView effect;

        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
