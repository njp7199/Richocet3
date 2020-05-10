package com.example.richocet3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Background {

    int x = 0, y=0;
    Bitmap background, dead;
    Background (int screenX, int screenY, Resources res){
        background = BitmapFactory.decodeResource(res, R.drawable.mainbackground);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);


    }

    Bitmap getDead(){
        return  dead;
    }

}
