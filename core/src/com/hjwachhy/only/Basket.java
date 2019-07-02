package com.hjwachhy.only;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Administrator on 2018/2/14.
 */

public class Basket extends Actor
{
    private float x,y,width,height,maxX;
    private float v;
    private  Texture basket;
    public Basket()
    {
        maxX= Gdx.graphics.getWidth();
        y=0;
        width=Gdx.graphics.getWidth()/4;
        height=width;
        basket=new Texture("game/basket.png");
        v=20;
    }

    public void toLeft()
    {
        x-=v;
    }

    public void toRight()
    {
        x+=v;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(basket,x,y,width,height);
        if(Gdx.input.isTouched())
        {
            if(Gdx.input.getX()>x+width/2+10)
                toRight();
            else if(Gdx.input.getX()<x+width/2-10)
                toLeft();
            if(x<0) x=0;
            if(x>maxX-width) x=maxX-width;
        }
        tool.basketX=x;
        tool.basketWidth=width;
        tool.basketHeight=height;
    }
}
