package com.example.hw2;

import android.graphics.Canvas;


public class CustomPent extends CustomElement {


    float x;
    float y;
    float pts[] = {0,0,0,0,0,0,0,0,0,0};
    float dist;



    public CustomPent(String name, int color, float x1, float y1, float d)
    {
        super(name,color);
        dist = d;
        float temp[] = {x1, y1,
                        x1+dist/2, (float) (y+dist/(2*Math.tan(54))),
                        x1, y1+dist,
                       (float) (x1-(dist/(2*Math.cos(36)))*Math.cos(72)), (float) (y1+dist*Math.cos(18)),
                       (float) (x1+(dist/(2*Math.cos(36)))*Math.cos(72)), (float) (y1+dist*Math.cos(16))};
        this.x = (int)x1;
        this.y = (int)y1;
        pts = temp;
    }



    @Override
    public void drawMe(Canvas canvas) {
        canvas.drawLines(pts, myPaint);
        canvas.drawLines(pts, outlinePaint);
    }

    @Override
    public boolean containsPoint(int x_t, int y_t) {
        int xDist = (int) Math.abs(x_t - x+dist/2);
        int yDist = (int) Math.abs(y_t - y+dist/2*Math.tan(18));
        int dist = (int)Math.sqrt(xDist*xDist + yDist*yDist);  //Thanks, Pythagoras :)

        return (dist < (dist/2)*Math.sin(72) +  TAP_MARGIN);
    }

    @Override
    public int getSize() {
        int i = (int) (1 / 4 * (Math.sqrt(5 * (5 + 2 * Math.sqrt(5)))) * (Math.sin(36) * dist / 2 / Math.sin(108)) * (Math.sin(36) * dist / 2 / Math.sin(108)));
        return i;
    }

    @Override
    public void drawHighlight(Canvas canvas) {
        canvas.drawLines(pts, highlightPaint);
        canvas.drawLines(pts, outlinePaint);
    }
}
