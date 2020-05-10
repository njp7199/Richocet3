package com.example.richocet3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import  static com.example.richocet3.GameView.screenRatioX;
import  static com.example.richocet3.GameView.screenRatioY;

public class Wall2 {
    int x, y, width, height, width1, height1;
    Bitmap wall2;
    Bitmap sidewall2;
    private  GameView gameView;

    Wall2 (GameView gameView, int screenY, Resources res) {
        this.gameView = gameView;


        wall2 = BitmapFactory.decodeResource(res, R.drawable.wall2);
        width = wall2.getWidth();
        height = wall2.getHeight();

        sidewall2 = BitmapFactory.decodeResource(res, R.drawable.sidewall);
        width1 = sidewall2.getWidth();
        height1 = sidewall2.getHeight();



        width /= 8;
        height /= 9;
        width = (int) screenRatioX * width;
        height = (int) screenRatioY * height;

        wall2 = Bitmap.createScaledBitmap(wall2, width, height, false);
        y = (int) (screenY / 3.5);
        x = (int) (0 * screenRatioX);
    }
    Rect getCollisionShape (){
        return  new Rect(x, y, x+width, y+height);

    }


}
