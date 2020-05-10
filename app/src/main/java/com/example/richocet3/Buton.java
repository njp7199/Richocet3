package com.example.richocet3;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


import  static com.example.richocet3.GameView.screenRatioX;
import  static com.example.richocet3.GameView.screenRatioY;

public class Buton{
    int x, y, width, height;
    Bitmap button1;
    private GameView gameView;

    Buton(GameView gameView, int screenY,  Resources res){
        this.gameView = gameView;
        button1 = BitmapFactory.decodeResource(res, R.drawable.button);
        width = button1.getWidth();
        height = button1.getHeight();


        width /= 4;
        height /= 4;
        width = (int) screenRatioX * width;
        height = (int) screenRatioY * height;

        button1 = Bitmap.createScaledBitmap(button1, width, height, false);
        y = screenY/5;
        x = (int) (150 * screenRatioX);
    }

}
