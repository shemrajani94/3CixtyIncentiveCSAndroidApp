package com.comp1008.serveranalytics.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
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
    
    private float mPosX;
    private float mPosY;
    
    private float mLastTouchX;
    private float mLastTouchY;
    
    private ScaleGestureDetector mScaleDetector;
    private float mScaleFactor = 1.0f;
    private float mScaleCenterX;
    private float mScaleCenterY;
	
	public MapView(Context context) {
		super(context);
		mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
	}
	
	public MapView(Context context, AttributeSet attribs) {
		super(context, attribs);
		mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        l = this.getLeft();
        r = this.getRight();
        t = this.getTop();
        b = this.getBottom();

        
        canvas.save();
        canvas.translate(mPosX, mPosY);
        canvas.scale(mScaleFactor, mScaleFactor, mScaleCenterX, mScaleCenterY);
        
        redPaint.setColor(Color.GREEN);
        canvas.drawRect(l,t,r,b, redPaint);     
        redPaint.setColor(Color.RED);
        canvas.drawRect(l+r/3,t+b/3,r-r/3,b-b/3, redPaint);
        
        canvas.restore();
    }
	
	//based on code from http://stackoverflow.com/questions/8122177/canvas-how-i-use-canvas-of-view-extended-class-into-activity-class
    @Override
	protected void onMeasure(int widthMS, int heightMS) {
        canvasWidth = View.MeasureSpec.getSize(widthMS);
        canvasHeight = View.MeasureSpec.getSize(heightMS);
        setMeasuredDimension(canvasWidth, canvasHeight);
    }
    //code to recognise touch events that will allow panning and zooming of map
    //based on code from http://android-developers.blogspot.co.uk/2010/06/making-sense-of-multitouch.html
    
    private static final int INVALID_POINTER_ID = -1;

    // The 'active pointer' is the one currently moving our object.
    private int mActivePointerId = INVALID_POINTER_ID;
    public boolean onTouchEvent(MotionEvent ev) {
    	// Let the ScaleGestureDetector inspect all events.
    	mScaleDetector.onTouchEvent(ev);
    
    	final int action = ev.getAction();
    	switch (action & MotionEvent.ACTION_MASK) {
    		case MotionEvent.ACTION_DOWN: {
    			final float x = ev.getX();
        		final float y = ev.getY();
        
        		mLastTouchX = x;
        		mLastTouchY = y;
        		mActivePointerId = ev.getPointerId(0);
        		break;
    		}
        
    		case MotionEvent.ACTION_MOVE: {
    			final int pointerIndex = ev.findPointerIndex(mActivePointerId);
    			final float x = ev.getX(pointerIndex);
    			final float y = ev.getY(pointerIndex);

    			// Only move if the ScaleGestureDetector isn't processing a gesture.
    			if (!mScaleDetector.isInProgress()) {
    					final float dx = x - mLastTouchX;
    					final float dy = y - mLastTouchY;

    					mPosX += dx;
    					mPosY += dy;

    					invalidate();
    			}

    			mLastTouchX = x;
    			mLastTouchY = y;

    			break;
    		}
        
    		case MotionEvent.ACTION_UP: {
    			mActivePointerId = INVALID_POINTER_ID;
    			break;
    		}
        
    		case MotionEvent.ACTION_CANCEL: {
    			mActivePointerId = INVALID_POINTER_ID;
    			break;
    		}	
    
    		case MotionEvent.ACTION_POINTER_UP: {
    			final int pointerIndex = (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) 
    					>> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
                final int pointerId = ev.getPointerId(pointerIndex);
                if (pointerId == mActivePointerId) {
                	// This was our active pointer going up. Choose a new
                	// active pointer and adjust accordingly.
                	final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
                	mLastTouchX = ev.getX(newPointerIndex);
                	mLastTouchY = ev.getY(newPointerIndex);
                	mActivePointerId = ev.getPointerId(newPointerIndex);
                }		
                break;
    		}
    	}
    
    	return true;
    }


    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    @Override
    	public boolean onScale(ScaleGestureDetector detector) {
    		mScaleFactor *= detector.getScaleFactor();
        
    		// Don't let the object get too small or too large.
    		mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 5.0f));
    		mScaleCenterX = detector.getFocusX();
    		mScaleCenterY = detector.getFocusY();
    		invalidate();
    		return true;
    	}
    }

}
