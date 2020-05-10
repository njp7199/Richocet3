package com.example.richocet3;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import  static com.example.richocet3.GameView.screenRatioX;
import  static com.example.richocet3.GameView.screenRatioY;

public class Firewall2 {
    int x, y, width, height;
    Bitmap firewall2;
    private  GameView gameView;

    Firewall2 (GameView gameView, int screenY, Resources res){
        this.gameView = gameView;
        firewall2 = BitmapFactory.decodeResource(res, R.drawable.firewall);
        width = firewall2.getWidth();
        height = firewall2.getHeight();


        width /= 8;
        height /= 9;
        width = (int) screenRatioX * width;
        height = (int) screenRatioY * height;

        firewall2 = Bitmap.createScaledBitmap(firewall2, width, height, false);
        y = (int) (screenY/2);
        x = (int) (700* screenRatioX);




    }


    Rect getCollisionShape (){
        return  new Rect(x, y, x+width, y+height);

    }
}
