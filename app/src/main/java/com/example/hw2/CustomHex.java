package com.example.hw2;

import android.graphics.Canvas;


public class CustomHex extends CustomElement {


    float x;
    float y;
    float pts[] = {0,0,0,0,0,0,0,0,0,0};
    float side;



    public CustomHex(String name, int color, float x1, float y1, float s)
    {
        super(name,color);
        side = s;
        float temp[] = {x1, y1,
                        x1+s/2, (float) (y1-s*Math.sqrt(3)/2),
                        x1+3*s/2, (float) (y1-s*Math.sqrt(3)/2),
                        x1+2*s, y1,
                        x1+3*s/2, (float) (y1+s*Math.sqrt(3)/2),
                        x1+s/2, (float) (y1+s*Math.sqrt(3)/2),
                        x1, y1
        };
        this.x = (int)x1;
        this.y = (int)y1;
        pts = temp;
    }



    @Override
    public void drawMe(Canvas canvas) {

        canvas.drawLine(pts[0], pts[1], pts[2], pts[3],myPaint);
        canvas.drawLine(pts[2], pts[3], pts[4], pts[5],myPaint);
        canvas.drawLine(pts[4], pts[5], pts[6], pts[7],myPaint);
        canvas.drawLine(pts[6], pts[7], pts[8], pts[9],myPaint);
        canvas.drawLine(pts[8], pts[9], pts[10], pts[11],myPaint);
        canvas.drawLine(pts[10], pts[11], pts[12], pts[13],myPaint);
        canvas.drawLine(pts[12], pts[13], pts[0], pts[1],myPaint);


        canvas.drawLine(pts[0], pts[1], pts[2], pts[3],outlinePaint);
        canvas.drawLine(pts[2], pts[3], pts[4], pts[5],outlinePaint);
        canvas.drawLine(pts[4], pts[5], pts[6], pts[7],outlinePaint);
        canvas.drawLine(pts[6], pts[7], pts[8], pts[9],outlinePaint);
        canvas.drawLine(pts[8], pts[9], pts[10], pts[11],outlinePaint);
        canvas.drawLine(pts[10], pts[11], pts[12], pts[13],outlinePaint);
        canvas.drawLine(pts[12], pts[13], pts[0], pts[1],outlinePaint);


    }

    @Override
    public boolean containsPoint(int x_t, int y_t) {
        if(y_t < pts[3] || y_t > y)
        {
            return false;
        }
        else
        {
            if(x_t < x || x_t > x+side)
            {
                return false;
            }
            else
            {
                int diff = (int) (x_t - x);
                if(diff > 50)
                {
                    diff = 100 - diff;
                }
                if(y_t > diff*Math.tan(36)+y-TAP_MARGIN && y_t < diff*Math.tan(36)+y+TAP_MARGIN)
                {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int getSize() {
        int i = (int) (1 / 4 * (Math.sqrt(5 * (5 + 2 * Math.sqrt(5)))) * (Math.sin(36) * side / 2 / Math.sin(108)) * (Math.sin(36) * side / 2 / Math.sin(108)));
        return i;
    }

    @Override
    public void drawHighlight(Canvas canvas) {
        canvas.drawLines(pts, highlightPaint);
        canvas.drawLines(pts, outlinePaint);
    }
}
