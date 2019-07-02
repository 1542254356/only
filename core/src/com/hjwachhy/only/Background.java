package com.hjwachhy.only;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Administrator on 2018/2/14.
 */

public class Background extends Actor
{
    TextureRegion[]frame;
    float startTime;
    Animation animation;
    Texture[] img;

    public Background()
    {
        img=new Texture[4];
        frame=new TextureRegion[4];
        for(int i=0;i<4;i++)
        {
            img[i]=new Texture("start/background/IMG0000"+i+".bmp");
            frame[i]=new TextureRegion(img[i]);
        }
        startTime=0;
        animation=new Animation(0.15f,frame);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        startTime+= Gdx.graphics.getDeltaTime();
        batch.draw(animation.getKeyFrame(startTime,true),0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }
}
