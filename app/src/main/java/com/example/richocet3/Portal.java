package com.example.richocet3;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.constraintlayout.solver.widgets.Rectangle;

import java.security.Key;

import static com.example.richocet3.GameView.screenRatioX;
import static com.example.richocet3.GameView.screenRatioY;


public class Portal {
    int x, y, width, height;
    Bitmap portal;
    private GameView gameView;


    Portal(GameView gameView, int screenY, Resources res){
        this.gameView = gameView;
        portal = BitmapFactory.decodeResource(res,R.drawable.portal2);
        width = portal.getWidth();
        height = portal.getHeight();

        width /= 1.2;
        height /= 1.2;
        width = (int) (screenRatioX * width);
        height = (int) (screenRatioX * height);



        portal = Bitmap.createScaledBitmap(portal, width, height, false);
        y = (int) (screenY / 5.5);
        x = (int) (1400 * screenRatioX);
    }

    Rect getCollisionShape (){
        return  new Rect(x, y, x+width, y+height);

    }

}
