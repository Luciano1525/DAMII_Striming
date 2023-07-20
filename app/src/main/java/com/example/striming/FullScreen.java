package com.example.striming;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

public class FullScreen extends VideoView {

    public FullScreen(Context context) {
        super(context);
    }

    public FullScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FullScreen(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int screenWidth = getDefaultSize(0, widthMeasureSpec);
        int screenHeight = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(screenWidth, screenHeight);
    }

}
