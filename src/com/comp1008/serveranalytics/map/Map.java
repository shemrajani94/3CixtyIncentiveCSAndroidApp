package com.comp1008.serveranalytics.map;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;

import com.comp1008.serveranalytics.R;
/*
 * Objects of this class hold all the objects in a map, the map can then be drawn to
 * a canvas using the draw(Canvas canvas) function.
 * Will later be able to load in objects on the map from a file and save objects on map
 * to a file.
 */
public class Map {
	
	private ArrayList<MapDoor> doors = new ArrayList<MapDoor>();
	private ArrayList<MapComputer> computers = new ArrayList<MapComputer>();
	
	
	public Map(Context context)
	{
		Bitmap computerImage = getResizedBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.computer_pic),70,70);
		computers.add(new MapComputer(20f,20f,computerImage));
		computers.add(new MapComputer(-60f,20f,computerImage));
		
	}
	
	public void draw(Canvas canvas)
	{
		for(MapComputer computer : computers)
		{
			computer.draw(canvas);
		}
	}
	
	//getResizedBitmap() taken from http://stackoverflow.com/questions/8327846/how-to-resize-a-bitmap-eficiently-and-with-out-losing-quality-in-android
	private Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth)
	{
		//get current bitmap width and height
	    int width = bm.getWidth();
	    int height = bm.getHeight();
	    //calculate the scale factor for width and height
	    float scaleWidth = ((float) newWidth) / width;
	    float scaleHeight = ((float) newHeight) / height;
	    // create a matrix for the manipulation
	    Matrix matrix = new Matrix();
	    // resize the bit map
	    matrix.postScale(scaleWidth, scaleHeight);
	    // recreate the new Bitmap with the scaling matrix
	    Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
	    return resizedBitmap;
	}

}
