package com.hjwachhy.only;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Administrator on 2018/2/14.
 */

public class GameBackground extends Actor
{
    TextureRegion[]frame;
    float startTime;
    Animation animation;
    Animation loveAnimation;
    Texture[] img;
    BitmapFont font;

    public GameBackground()
    {
        font=new BitmapFont(Gdx.files.internal("hjw.fnt"),Gdx.files.internal("hjw.png"),false);
        font.setColor(0f,0f,0f,1f);
        img=new Texture[8];
        frame=new TextureRegion[8];
        for(int i=0;i<8;i++)
        {
            img[i]=new Texture("game/background/IMG0000"+i+".bmp");
            frame[i]=new TextureRegion(img[i]);
        }
        startTime=0;
        animation=new Animation(0.15f,frame);
        TextureRegion[] love214=new TextureRegion[2];
        for(int i=0;i<2;i++)
        {
            love214[i]=new TextureRegion(new Texture("game/love214/"+i+".png"));
        }
        loveAnimation=new Animation(0.3f,love214);
    }

    @Override
    public void draw(Batch batch, float parentAlpha)
    {
        super.draw(batch, parentAlpha);
        startTime+= Gdx.graphics.getDeltaTime();
        batch.draw(animation.getKeyFrame(startTime,true),0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.draw(loveAnimation.getKeyFrame(startTime,true),Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()/2);
        font.draw(batch,"得分："+tool.score,Gdx.graphics.getWidth()-200,Gdx.graphics.getHeight()-100);
        font.draw(batch,"剩余生命："+tool.life,Gdx.graphics.getWidth()-200,Gdx.graphics.getHeight()-150);
    }
}
