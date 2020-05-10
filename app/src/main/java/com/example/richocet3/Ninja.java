package com.example.richocet3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import static com.example.richocet3.GameView.screenRatioX;
import static com.example.richocet3.GameView.screenRatioY;
import static com.example.richocet3.ChooseChar.purple;

public class Ninja {
    int toShoot = 0;
    int x,  width, height, shootCounter = 1;
    Bitmap ninja1, star1, fireball1;
    float y;
    private GameView gameView;

    Ninja (GameView gameView, int screenY, Resources res){
        this.gameView = gameView;
        if (purple >= 5){
            ninja1 = BitmapFactory.decodeResource(res, R.drawable.ninja4);
        }
        if (purple < 5) {
            ninja1 = BitmapFactory.decodeResource(res, R.drawable.ninja3);


        }
        width = ninja1.getWidth();
        height = ninja1.getHeight();
        width /= 4;
        width = (int) screenRatioX * width;
        height = (int) screenRatioY * height;
        height /= 4;
        ninja1 = Bitmap.createScaledBitmap(ninja1, width, height, false);
        y = (float) (screenY /1.5);
        x = (int) (64 * screenRatioX);



    }



}
