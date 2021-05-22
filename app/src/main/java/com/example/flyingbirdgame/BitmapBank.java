package com.example.flyingbirdgame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background;
    public BitmapBank(Resources res){
        background = BitmapFactory.decodeResource(res,R.drawable.background);
        background =scaleImage(background);
    }

    public Bitmap getBackground(){
        return background;
    }
    public int getBackgroundWidth(){
        return background.getWidth();
    }
    public int getBackgroundHeight(){
        return background.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap){

        float widthHeightRatio = getBackgroundWidth() / getBackgroundHeight();
        int backgroundScaledWidth = (int) widthHeightRatio * AppConstants.SCREEN_HEIGHT;
        return Bitmap.createScaledBitmap(bitmap,backgroundScaledWidth,AppConstants.SCREEN_HEIGHT,false);
    }
}
