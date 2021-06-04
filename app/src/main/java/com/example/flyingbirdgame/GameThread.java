package com.example.flyingbirdgame;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends Thread {

    SurfaceHolder surfaceHolder;
    boolean isRunning;
    long startTime , loopTime;
    long DELAY = 33;

    public GameThread(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        isRunning = true;
    }

    @Override
    public void run() {
//Looping until the boolean is false

        while (isRunning) {
            startTime = SystemClock.uptimeMillis();
            //locking the Canvas
            Canvas canvas = surfaceHolder.lockCanvas(null);
            if (canvas != null) {
                synchronized (surfaceHolder) {
                    AppConstants.getGameEngine().updateAndDrawBackgroundImage(canvas);
                    AppConstants.getGameEngine().updateAndDrawBird(canvas);
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            loopTime = SystemClock.uptimeMillis()- startTime;
            //pausing here to make sure we update the right amount per second
            if(loopTime < DELAY){
                try{
                    Thread.sleep(DELAY-loopTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Log.e("Interrupted","Interrupted while sleeping");
                }
            }
        }
    }

    //Return whether the thread is running
    public boolean isRunning(){
        return isRunning;
    }
    //sets the Threadstate
    public void setIsRunning(boolean state){
        isRunning=state;
    }
}
