package me.zsr.zelda;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @description:
 * @author: Match
 * @date: 11/02/2018
 */

public class HeartImageView extends View {
    private int mHeartMax;
    private int mHeartRecovery;

    private Drawable mYellow5Drawable;
    private Drawable mYellow1Drawable;
    private Drawable mRedMaxDrawable;
    private Drawable mRed20Drawable; // 5 heart
    private Drawable mRed4Drawable; // 1 heart
    private Drawable mRed3Drawable; // 3/4 heart
    private Drawable mRed2Drawable; // 1/2 heart
    private Drawable mRed1Drawable; // 1/4 heart

    public HeartImageView(Context context) {
        this(context, null);
    }

    public HeartImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        int side = ResTool.dpToPx(16);
        mYellow5Drawable = ImageUtil.getDrawable("ic_heart_five_yellow");
        mYellow1Drawable = ImageUtil.getDrawable("ic_heart_yellow");
        mRedMaxDrawable = ImageUtil.getDrawable("ic_heart_red_max");
        mRed20Drawable = ImageUtil.getDrawable("ic_heart_five_red");
        mRed4Drawable = ImageUtil.getDrawable("ic_heart_red");
        mRed3Drawable = ImageUtil.getDrawable("ic_heart_red_three_quarter");
        mRed2Drawable = ImageUtil.getDrawable("ic_heart_red_half");
        mRed1Drawable = ImageUtil.getDrawable("ic_heart_red_quarter");

        mYellow5Drawable.setBounds(0, 0, side, side);
        mYellow1Drawable.setBounds(0, 0, side, side);
        mRedMaxDrawable.setBounds(0, 0, side, side);
        mRed20Drawable.setBounds(0, 0, side, side);
        mRed4Drawable.setBounds(0, 0, side, side);
        mRed3Drawable.setBounds(0, 0, side, side);
        mRed20Drawable.setBounds(0, 0, side, side);
        mRed1Drawable.setBounds(0, 0, side, side);
    }

    public void setData(int heartMax, int heartRecovery) {
        mHeartMax = heartMax;
        mHeartRecovery = heartRecovery;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        int maxCount = mHeartMax;
        int recoveryCount = mHeartRecovery;
        int offsetStep = ResTool.dpToPx(18);
        while (maxCount >= 5) {
            mYellow5Drawable.draw(canvas);
            canvas.translate(offsetStep, 0);
            maxCount -= 5;
        }
        while (maxCount >= 1) {
            mYellow1Drawable.draw(canvas);
            canvas.translate(offsetStep, 0);
            maxCount--;
        }
        if (recoveryCount == -1) {
            mRedMaxDrawable.draw(canvas);
        } else {
            while (recoveryCount >= 20) {
                mRed20Drawable.draw(canvas);
                canvas.translate(offsetStep, 0);
                recoveryCount -= 20;
            }
            while (recoveryCount >= 4) {
                mRed4Drawable.draw(canvas);
                canvas.translate(offsetStep, 0);
                recoveryCount -= 4;
            }
            if (recoveryCount == 3) {
                mRed3Drawable.draw(canvas);
            } else if (recoveryCount == 2) {
                mRed2Drawable.draw(canvas);
            } else if (recoveryCount == 1) {
                mRed1Drawable.draw(canvas);
            }
        }
    }
}
