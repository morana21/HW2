package com.example.hw2;

import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class Controller implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    SurfaceView sfc_view;

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

        sfc_view = sv;

        s_name = sn;


        //Set seekbarchange listeners for each seekbar variable
        r_seek.setOnSeekBarChangeListener(this);
        g_seek.setOnSeekBarChangeListener(this);
        b_seek.setOnSeekBarChangeListener(this);

    }

    //takes on tap x y coordinates, not used
    @Override
    public void onClick(View v)
    {
        int x_tap = (int) v.getX();
        int y_tap = (int) v.getY();


    }

    //Change number on corresponding textview to progress of seekbar
    //Used for changing color of shapes later
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
    {
        //Check for r_seek id and update text
        if(seekBar == r_seek)
        {
            r_text.setText("" + progress);
        }
        //Check for g_seek id and update text
        if(seekBar == g_seek)
        {
            g_text.setText("" + progress);
        }
        //Check for b_seek id and update text
        if(seekBar == b_seek)
        {
            b_text.setText("" + progress);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar)
    {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar)
    {

    }

}
