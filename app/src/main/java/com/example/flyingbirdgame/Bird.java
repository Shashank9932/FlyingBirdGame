package com.example.flyingbirdgame;

public class Bird {
    private int birdX, birdY, currentFrame, velocity;
    public static int maxFrame;

    public Bird(){
        birdX = AppConstants.SCREEN_WIDTH/2 - AppConstants.getBitmapBank().getBirdWidth()/2;
        birdY = AppConstants.SCREEN_HEIGHT/2 - AppConstants.getBitmapBank().getBirdHeight()/2;
        currentFrame = 0;
        maxFrame = 3;
        velocity = 0;
    }

    //
    public int getVelocity(){
        return velocity;
    }

    public void setVelocity(int velocity){
        this.velocity = velocity;
    }
    public int getCurrentFrame(){
        return currentFrame;
    }

    public int getMaxFrame(){
        return maxFrame;
    }

    public void setCurrentFrame(int currentFrame){
        this.currentFrame = this.currentFrame;
    }

    public int getX(){
        return birdX;
    }
    public int getY(){
        return birdY;
    }
    public void setX(int birdX){
        this.birdX=birdX;
    }

    //setter method for setting the Y-coordinate
    public void setY(int birdY){
        this.birdY =  birdY;


    }

}
