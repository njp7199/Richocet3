package com.example.richocet3;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import  static com.example.richocet3.GameView.screenRatioX;
import  static com.example.richocet3.GameView.screenRatioY;


public class Sidewall {
    int x, y, width, height;
    Bitmap sidewall;
    private  GameView gameView;

    Sidewall (GameView gameView, int screenY, Resources res){
        this.gameView = gameView;
        sidewall = BitmapFactory.decodeResource(res, R.drawable.sidewall);
        width = sidewall.getWidth();
        height = sidewall.getHeight();


        width /= 8;
        height /= 9;
        width = (int) screenRatioX * width;
        height = (int) screenRatioY * height;

        sidewall = Bitmap.createScaledBitmap(sidewall, width, height, false);
        y = (int) (screenY/1.5);
        x = (int) (1000* screenRatioX);




    }


    Rect getCollisionShape (){
        return  new Rect(x, y, x+width, y+height);

    }



}
