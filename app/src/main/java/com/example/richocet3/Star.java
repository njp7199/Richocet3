package com.example.richocet3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.view.MotionEvent;

import static com.example.richocet3.GameView.screenRatioX;
import static com.example.richocet3.GameView.screenRatioY;
import static com.example.richocet3.GameView.coins4;

public class Star  {
    int x, y, width, height;


    Bitmap star;





    Star(Resources res, int screenY) {

        if (coins4 <= 10){
            star = BitmapFactory.decodeResource(res, R.drawable.star2);

        }

        if (coins4 >= 10){
            star = BitmapFactory.decodeResource(res, R.drawable.firestar);

        }


        width = star.getWidth();
        height = star.getHeight();


        width /= 48;
        height /= 48;
        y = (int) ((float) screenY / 2);
        x = (int) ((float) screenRatioX * 64);
        width =  (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);


        star = Bitmap.createScaledBitmap(star, width, height, false);


    }




    Rect getCollisionShape (){
        return  new Rect(x, y, x+width, y+height);

    }

}
