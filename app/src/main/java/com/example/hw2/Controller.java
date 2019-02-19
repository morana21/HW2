package com.example.hw2;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Controller implements  SeekBar.OnSeekBarChangeListener, View.OnTouchListener {


    private MyCanvas sfc_view;

    private SeekBar r_seek;
    private SeekBar g_seek;
    private SeekBar b_seek;

    private TextView r_text;
    private TextView g_text;
    private TextView b_text;

    private TextView s_name;


    /*Initializes all controller vars to constructor variables:
    sfc_view
    r_seek
    r_text
    g_seek
    g_text
    b_seek
    b_text
    s_name
     */
    public Controller(SeekBar rs, SeekBar gs, SeekBar bs,
                      TextView rt, TextView gt, TextView bt,
                      TextView sn, SurfaceView sv)
    {
        r_seek = rs;
        g_seek = gs;
        b_seek = bs;

        r_text = rt;
        g_text = gt;
        b_text = bt;

        sfc_view =  (MyCanvas) sv;

        s_name = sn;


        //Set seekbarchange listeners for each seekbar variable
        r_seek.setOnSeekBarChangeListener(this);
        g_seek.setOnSeekBarChangeListener(this);
        b_seek.setOnSeekBarChangeListener(this);

    }

    //takes o

    //Change number on corresponding textview to progress of seekbar
    //Used for changing color of shapes later
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
    {
        //Check for r_seek id and update text

        if(seekBar == r_seek)
        {
            r_text.setText("Red: " + progress);
            if(sfc_view.selected != null) sfc_view.selected.setColor(Color.argb(0xFF,progress,sfc_view.selected.g_val,sfc_view.selected.b_val));
        }
        //Check for g_seek id and update text
        if(seekBar == g_seek)
        {
            g_text.setText("Green: " + progress);
            if(sfc_view.selected != null) sfc_view.selected.setColor(Color.argb(0xFF,sfc_view.selected.r_val,progress,sfc_view.selected.b_val));
        }
        //Check for b_seek id and update text
        if(seekBar == b_seek)
        {
            b_text.setText("Blue: " + progress);
            if(sfc_view.selected != null) sfc_view.selected.setColor(Color.argb(0xFF,sfc_view.selected.r_val,sfc_view.selected.g_val,progress));
        }
        sfc_view.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar)
    {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar)
    {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int x_coord = (int) event.getX();
        int y_coord = (int) event.getY();
        if(v != sfc_view) return false;
        sfc_view.selected = null;
        s_name.setText("No Selected");
        if(sfc_view.REC_1.containsPoint(x_coord,y_coord))
        {
            sfc_view.selected = sfc_view.REC_1;
            s_name.setText(sfc_view.REC_1.getName());
            return true;
        }
        else if(sfc_view.REC_2.containsPoint(x_coord,y_coord))
        {
            sfc_view.selected = sfc_view.REC_2;
            s_name.setText(sfc_view.REC_2.getName());
            return true;
        }
        else if(sfc_view.REC_3.containsPoint(x_coord,y_coord))
        {
            sfc_view.selected = sfc_view.REC_3;
            s_name.setText(sfc_view.REC_3.getName());
            return true;
        }
        else if(sfc_view.CIRCLE_1.containsPoint(x_coord,y_coord))
        {
            sfc_view.selected = sfc_view.CIRCLE_1;
            s_name.setText(sfc_view.CIRCLE_1.getName());
            return true;
        }
        else if(sfc_view.CIRCLE_2.containsPoint(x_coord,y_coord))
        {
            sfc_view.selected = sfc_view.CIRCLE_2;
            s_name.setText(sfc_view.CIRCLE_2.getName());
            return true;
        }
        else if(sfc_view.CIRCLE_3.containsPoint(x_coord,y_coord))
        {
            sfc_view.selected = sfc_view.CIRCLE_3;
            s_name.setText(sfc_view.CIRCLE_3.getName());
            return true;
        }

        return false;
    }
}
