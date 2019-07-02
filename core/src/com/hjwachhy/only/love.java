package com.hjwachhy.only;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

import static com.badlogic.gdx.files.FileHandle.tempFile;

/**
 * Created by Administrator on 2018/2/14.
 */

public class love
{
    Loves loves;
    public float x,y,width,height;
    private float maxX,maxSize,minSize;
    private float v;
    float stateTime;
    Animation animation;
    boolean isKilled;



    public love(Loves loves)
    {
        this.loves=loves;
        isKilled=false;
        v=15+(float)Math.random()*10;
        maxSize=200;
        minSize=120;
        width=(float)Math.random()*1000 %maxSize+minSize;
        maxX= Gdx.graphics.getWidth()-width;
        height=width;
        x=(float)Math.random()*10000%maxX;
        y=Gdx.graphics.getHeight()-height;
        animation=new Animation(0.15f,loves.getTextureRegions());
        stateTime=0;
    }

    public TextureRegion getKeyFrame(float stateTime)
    {
        check();
        y-=v;
        this.stateTime=stateTime;
        return animation.getKeyFrame(stateTime,true);
    }

    private void check()
    {
        if(!isKilled)
        {
            if(y<tool.basketHeight/3)
            {
                if(x+width>tool.basketX&&x<tool.basketX+tool.basketWidth)
                {
                    tool.isIn=true;
                    isKilled=true;
                    tool.score+=10;
                }
                else
                {
                    tool.isXinsui=true;
                    isKilled=true;
                    tool.life--;
                }
            }
        }

    }



    public boolean isKill()
    {
        return isKilled&&y<tool.basketHeight/4;
    }




}
