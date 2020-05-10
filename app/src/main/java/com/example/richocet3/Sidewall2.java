package com.example.richocet3;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import  static com.example.richocet3.GameView.screenRatioX;
import  static com.example.richocet3.GameView.screenRatioY;


public class Sidewall2 {
    int x, y, width, height;
    Bitmap sidewall2;
    private GameView gameView;

    Sidewall2(GameView gameView, int screenY, Resources res) {
        this.gameView = gameView;
        sidewall2 = BitmapFactory.decodeResource(res, R.drawable.sidewall);
        width = sidewall2.getWidth();
        height = sidewall2.getHeight();

        width /= 8;
        height /= 9;
        width = (int) screenRatioX * width;
        height = (int) screenRatioY * height;

        sidewall2 = Bitmap.createScaledBitmap(sidewall2, width, height, false);
        y = (int) (screenY / 10);
        x = (int) (500 * screenRatioX);


    }


    Rect getCollisionShape() {
        return new Rect(x, y, x + width, y + height);

    }
}