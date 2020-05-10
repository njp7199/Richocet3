package com.example.richocet3;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import  static com.example.richocet3.GameView.screenRatioX;
import  static com.example.richocet3.GameView.screenRatioY;
public class Firewall {
    int x, y, width, height;
    Bitmap firewall;
    private  GameView gameView;

    Firewall (GameView gameView, int screenY, Resources res){
        this.gameView = gameView;
        firewall = BitmapFactory.decodeResource(res, R.drawable.firewall);
        width = firewall.getWidth();
        height = firewall.getHeight();


        width /= 8;
        height /= 9;
        width = (int) screenRatioX * width;
        height = (int) screenRatioY * height;

        firewall = Bitmap.createScaledBitmap(firewall, width, height, false);
        y = (int) (screenY/1.85);
        x = (int) (600* screenRatioX);




    }


    Rect getCollisionShape (){
        return  new Rect(x, y, x+width, y+height);

    }

}
