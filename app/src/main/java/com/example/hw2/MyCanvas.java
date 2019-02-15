package com.example.hw2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;

public class MyCanvas extends SurfaceView {



    public MyCanvas(Context context) {
        super(context);
        init();
    }

    private void init()
    {
        setWillNotDraw(false);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        CustomRect rec = new CustomRect("Rect", Color.RED, 50,50,100, 100);
        rec.drawMe(canvas);
    }

}
