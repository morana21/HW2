package com.example.hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create variable for surfaceview and assign id
        SurfaceView sf = findViewById(R.id.shape_layout);

        //Create variable for seekbars and assign respective ids
        SeekBar rs = findViewById(R.id.r_seek);
        SeekBar gs = findViewById(R.id.g_seek);
        SeekBar bs = findViewById(R.id.b_seek);


        //Create variables for textviews and assign respective ids
        TextView rt = findViewById(R.id.r_text);
        TextView gt = findViewById(R.id.g_text);
        TextView bt = findViewById(R.id.b_text);


        TextView sn = findViewById(R.id.shape_name);

        //Create controller var with all views
        Controller controller = new Controller(rs,gs,bs,rt,gt,bt,sn,sf);

        sf.setOnTouchListener(controller);







    }
}
