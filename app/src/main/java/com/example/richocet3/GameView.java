package com.example.richocet3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class GameView extends SurfaceView implements Runnable {

    private Thread thread;
    private boolean isPlaying, isGameOver = false, beatLevel = false, isLevelTwo = false, butpress = false;
    private int screenX, screenY, bounces = 3;
    public double mouseX, mouseY;
    public double angle;
    public double xVel, yVel;



    public double starvel = 40;
    private List<Star> stars;
    private List <Fireball> fireballs;
    private Paint paint;
    private Paint paint2;





    private Ninja ninja;
    private Wall wall;
    private Star star;
    private Wall2 wally;
    private Portal portal;
    private Sidewall sidewall;
    private Firewall firewall;
    private Sidewall2 sidewall2;
    private Star fireball;
    private Firewall2 firewall2;
    private Buton button1;




    public static float screenRatioX, screenRatioY, coins4;
    private Background background1, background2;

    public GameView(Context context, int screenX, int screenY) {

        super(context);

        this.screenX = screenX;
        this.screenY = screenY;
        screenRatioX = 1920f / screenX;
        screenRatioY = 1080f / screenY;

        background1 = new Background(screenX, screenY, getResources());
        background2 = new Background(screenX, screenY, getResources());
        background2.x = screenX;
        paint = new Paint();
        paint.setTextSize(64);
        paint.setColor(Color.BLACK);
        paint2 = new Paint();
        paint2.setColor(Color.RED);
        paint2.setTextSize(128);
        portal = new Portal(this, screenY, getResources());
        firewall = new Firewall(this, screenY, getResources());
        wall = new Wall(this, screenY, getResources());
        firewall2 = new Firewall2(this, screenY, getResources());
        stars = new ArrayList<>();

        ninja = new Ninja(this, screenY, getResources());
        //fireballs = new ArrayList<>();
        wally = new Wall2(this, screenY, getResources());
        sidewall = new Sidewall(this, screenY, getResources());
        sidewall2 = new Sidewall2(this, screenY, getResources());
        button1 = new Buton(this, screenY, getResources());
    }


    @Override
    public void run() {
        while (isPlaying) {
            update();
            if (isLevelTwo == false){
                draw();

            }
            if (isLevelTwo == true ){
                draw2();


            }


            sleep();
        }
    }


    private void update() {



        List<Star> trash = new ArrayList<>();

        for (Star star : stars) {

            if (star.x > 1800 || star.x < 0) {
                trash.add(star);

            }
            if (star.y > 1000 || star.y < 0) {
                trash.add(star);

            }




            star.x += xVel;
            star.y += yVel;

            if (isLevelTwo == false){
                if (Rect.intersects(star.getCollisionShape(), wall.getCollisionShape())) {

                    xVel = -xVel;
                    bounces = bounces - 1;
                }
                if (Rect.intersects(star.getCollisionShape(), wally.getCollisionShape())) {
                    xVel = -xVel;
                    bounces = bounces - 1;
                }

            }
            if (Rect.intersects(star.getCollisionShape(), firewall.getCollisionShape())){
                stars.remove(star);
                bounces = bounces -1;
            }

            if (isLevelTwo == true){
                if (Rect.intersects(star.getCollisionShape(), sidewall.getCollisionShape())){
                    yVel = -yVel;
                    bounces = bounces - 1;
                }
                if (Rect.intersects(star.getCollisionShape(), sidewall2.getCollisionShape())){
                    yVel = -yVel;
                    bounces = bounces - 1;
                }
                if (Rect.intersects(star.getCollisionShape(), firewall2.getCollisionShape()) ){
                    stars.remove(star);
                    bounces = bounces -1;
                }
                if (coins4 >= 10) {
                    if (Rect.intersects(star.getCollisionShape(), firewall2.getCollisionShape())) {
                        star.x += xVel;
                        star.y += yVel;

                    }
                }
            }
            if (bounces <= 0){
                stars.remove(star);
                isLevelTwo = false;
                coins4 = 0;
                bounces = 5;

            }
            if (Rect.intersects(star.getCollisionShape(), portal.getCollisionShape())){
                stars.remove(star);
                isLevelTwo = true;
                coins4 += 5;
                bounces = 5;

            }





        }

        for (Star star : trash) {
            stars.remove(star);
        }



    }



    private void draw() {

            if (getHolder().getSurface().isValid()) {
                Canvas canvas = getHolder().lockCanvas();
                canvas.drawBitmap(background1.background, background1.x, background1.y, paint);
                canvas.drawBitmap(background2.background, background2.x, background2.y, paint);
                canvas.drawBitmap(wall.wall1, wall.x, wall.y, paint);
                canvas.drawBitmap(button1.button1, button1.x, button1.y, paint);
                canvas.drawBitmap(portal.portal, portal.x, portal.y, paint);
                canvas.drawText(bounces + " Bounces:", screenX / 20f, screenY / 8f, paint);
                canvas.drawText("LEVEL1", screenX/20f, screenY/15f, paint);
                canvas.drawText(coins4 + "", screenX/1.1f, screenY/8f, paint);
                canvas.drawBitmap(firewall.firewall, firewall.x, firewall.y, paint);
                canvas.drawBitmap(ninja.ninja1, ninja.x, ninja.y, paint);
                for (Star star : stars)
                    canvas.drawBitmap(star.star, star.x, star.y, paint);
                canvas.drawBitmap(wally.wall2, wally.x, wally.y, paint);
                getHolder().unlockCanvasAndPost(canvas);

        }
    }
    private void draw2(){
        if (getHolder().getSurface().isValid()){
            Canvas canvas1 = getHolder().lockCanvas();
            canvas1.drawBitmap(background1.background, background1.x, background1.y, paint);
            canvas1.drawBitmap(background2.background, background2.x, background2.y, paint);
            ninja.x = (int) (screenRatioX * 100);
            ninja.y = (int) (screenY / 1.5);
            for (Star star : stars)
                    canvas1.drawBitmap(star.star, star.x, star.y, paint);
            canvas1.drawBitmap(sidewall.sidewall, sidewall.x, sidewall.y, paint);
            canvas1.drawBitmap(button1.button1, button1.x, button1.y, paint);
            canvas1.drawBitmap(sidewall2.sidewall2, sidewall2.x, sidewall2.y, paint);
            canvas1.drawBitmap(firewall2.firewall2, firewall2.x, firewall2.y, paint);
            canvas1.drawBitmap(portal.portal, portal.x, portal.y, paint);
            canvas1.drawText("LEVEL2", screenX/20f, screenY/15f, paint);
            canvas1.drawText(coins4 + "", screenX/1.1f, screenY/8f, paint);
            canvas1.drawText(bounces + " Bounces:", screenX / 20f, screenY / 8f, paint);
            canvas1.drawBitmap(ninja.ninja1, ninja.x, ninja.y, paint);

            getHolder().unlockCanvasAndPost(canvas1);

        }
    }


    private void sleep() {
        try {
            Thread.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void resume() {
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    public void pause() {
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mouseX = (double) event.getX();
        mouseY = (double) event.getY();
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                if (mouseX > button1.x && mouseX < button1.x + button1.width && mouseY > button1.y && mouseY < button1.y + button1.height) {
                    thread.stop();
                }
                newStar();
            }



        return true;


    }


    public void newStar() {
        Star star = new Star(getResources(), screenY);
        angle = (Math.atan2(mouseY - star.y, mouseX - star.x));
        xVel = starvel * Math.cos(angle);
        yVel = starvel * Math.sin(angle) ;
        star.x =  (int) ninja.x + ninja.width;
        star.y = (int) (ninja.y + (ninja.height / 8));
        stars.add(star);



    }
}
