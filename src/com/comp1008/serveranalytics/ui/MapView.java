package com.comp1008.serveranalytics.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

/*
 * This class is the canvas where the map is drawn
 * It can be embedded in regular activities
 */

public class MapView extends View {
	private int l;
	private int r;
	private int t;
	private int b;
	private Paint redPaint = new Paint();
    private int canvasWidth;
    private int canvasHeight;
	
	public MapView(Context context) {
		super(context);
	}
	
	public MapView(Context context, AttributeSet attribs) {
		super(context, attribs);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        l = this.getLeft();
        r = this.getRight();
        t = this.getTop();
        b = this.getBottom();
        redPaint.setColor(Color.GREEN);
        canvas.drawRect(l,t,r,b, redPaint);
        
        redPaint.setColor(Color.RED);
        redPaint.setStyle(Style.FILL);

        canvas.drawRect(l+r/3,t+b/3,r-r/3,b-b/3, redPaint);

        
        canvas.save();
    }
	
	//based on code from http://stackoverflow.com/questions/8122177/canvas-how-i-use-canvas-of-view-extended-class-into-activity-class
    @Override
	protected void onMeasure(int widthMS, int heightMS) {
        canvasWidth = View.MeasureSpec.getSize(widthMS);
        canvasHeight = View.MeasureSpec.getSize(heightMS);
        setMeasuredDimension(canvasWidth, canvasHeight);
    }

}
