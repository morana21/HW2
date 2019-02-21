package com.example.hw2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;

public class MyCanvas extends SurfaceView {

    CustomElement selected;

    CustomRect REC_1=null;
    CustomRect REC_2=null;
    CustomRect REC_3=null;
    CustomCircle CIRCLE_1=null;
    CustomCircle CIRCLE_2=null;
    CustomCircle CIRCLE_3=null;

    public MyCanvas(Context context) {
        super(context);
        init();
    }

    public MyCanvas(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
        setZOrderOnTop(true);
        setVisibility(View.VISIBLE);


    }

    private void init()
    {
        setWillNotDraw(false);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(0x0000000);

        CustomRect rec_1;
        if(REC_1 == null) rec_1= new CustomRect("Rectangle_1", Color.RED, 50,50,250, 250);
        //need else for when user changes the color manually
        else rec_1= REC_1;
        rec_1.drawMe(canvas);


        CustomCircle circ_1;
        if(CIRCLE_1 == null) circ_1= new CustomCircle("Circle_1", Color.BLUE, 500, 150, 100);
         //need else for when user changes the color manually
        else circ_1= CIRCLE_1;
        circ_1.drawMe(canvas);

        CustomRect rec_2;
        if(REC_2 == null) rec_2 = new CustomRect("Rectangle_2", Color.MAGENTA, 800,50,900, 150);
        //need else for when user changes the color manually
        else rec_2 = REC_2;
        rec_2.drawMe(canvas);

        CustomCircle circ_2;
        if(CIRCLE_2 == null)circ_2 = new CustomCircle("Circle_2", Color.GREEN, 150, 475, 50);
        //need else for when user changes the color manually
        else circ_2 = CIRCLE_2;
        circ_2.drawMe(canvas);

        CustomRect rec_3;
        if(REC_3 == null) rec_3 = new CustomRect("Rectangle_3", Color.GRAY , 750,400,900, 550);
        //need else for when user changes the color manually
        else rec_3 = REC_3;
        rec_3.drawMe(canvas);

        CustomCircle circ_3;
        if(CIRCLE_3== null)circ_3 = new CustomCircle("Circle_3", Color.CYAN, 500, 500, 75);
        //need else for when user changes the color manually
        else circ_3 = CIRCLE_3;
        circ_3.drawMe(canvas);

        if(selected != null) selected.drawHighlight(canvas);

        //Update surfaceview objects
        REC_1 = rec_1;
        REC_2 = rec_2;
        REC_3 = rec_3;
        CIRCLE_1 = circ_1;
        CIRCLE_2 = circ_2;
        CIRCLE_3 = circ_3;

    }


}
