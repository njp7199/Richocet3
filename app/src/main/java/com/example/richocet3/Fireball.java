package com.example.richocet3;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.view.MotionEvent;

import static com.example.richocet3.GameView.screenRatioX;
import static com.example.richocet3.GameView.screenRatioY;

public class Fireball {
    int x, y, width, height, firevel, mouseX1, mouseY1;
    Bitmap fireball;

    Fireball(Resources res, int screenY) {

        fireball = BitmapFactory.decodeResource(res, R.drawable.fireball);

        width = fireball.getWidth();
        height = fireball.getHeight();
        width /= 24;
        height /= 24;
        firevel = 20;
        y = screenY / 2;
        x = (int) screenRatioX * 64;
        width =  (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        fireball = Bitmap.createScaledBitmap(fireball, width, height, false);


    }


    Rect getCollisionShape (){
        return  new Rect(x, y, x+width, y+height);

    }
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mouseX1 = (int) event.getX();
                mouseY1 = (int) event.getY();
                break;
        }

        return true;


    }


}
