package com.example.richocet3;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import  static com.example.richocet3.GameView.screenRatioX;
import  static com.example.richocet3.GameView.screenRatioY;

public class Wall {
    int x, y, width, height;
    Bitmap wall1;
    private  GameView gameView;

    Wall (GameView gameView, int screenY, Resources res){
        this.gameView = gameView;
        wall1 = BitmapFactory.decodeResource(res, R.drawable.wall);
        width = wall1.getWidth();
        height = wall1.getHeight();


        width /= 8;
        height /= 9;
        width = (int) screenRatioX * width;
        height = (int) screenRatioY * height;

        wall1 = Bitmap.createScaledBitmap(wall1, width, height, false);
        y = screenY/2;
        x = (int) (1600* screenRatioX);




    }


        Rect getCollisionShape (){
            return  new Rect(x, y, x+width, y+height);

        }




}
