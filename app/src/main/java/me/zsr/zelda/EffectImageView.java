package me.zsr.zelda;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Match
 * @date: 11/02/2018
 */

public class EffectImageView extends View {
    private int mStaminaRecovery;
    private List<Drawable> mStaminaDrawableList = new ArrayList<>();

    public EffectImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        int side = ResTool.dpToPx(16);
        for (int i = 0; i< 15; i++) {
            String name = "stamina_green_";
            if (i + 1 < 10) {
                name += "0";
            }
            name += String.valueOf(i + 1);
            Drawable drawable = ImageUtil.getDrawable(name);
            drawable.setBounds(0, 0, side, side);
            mStaminaDrawableList.add(drawable);
        }
    }

    public void setData(int staminaRecovery) {
        mStaminaRecovery = staminaRecovery;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mStaminaRecovery > 0) {
            mStaminaDrawableList.get(mStaminaRecovery - 1).draw(canvas);
        }
    }
}
