package com.hjwachhy.only;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Administrator on 2018/2/14.
 */

public class Loves extends Actor
{
    private Array<love> loves;
    private float stateTime;
    Sound in;
    Sound xinsui;
    int lovesNUM =6;

    static Array<TextureRegion[]> lovesTextureRegion;
    public Loves()
    {
        lovesTextureRegion=new Array<TextureRegion[]>();
        for(int i = 0; i< lovesNUM; i++)
            lovesTextureRegion.add(getFromFile(i));
        in=Gdx.audio.newSound(Gdx.files.internal("game/in.wav"));
        xinsui=Gdx.audio.newSound(Gdx.files.internal("game/sui.mp3"));
        stateTime=0;
        loves=new Array<love>();
        loves.add(new love(this));
    }

    private void update()
    {
        for(int i=0;i<loves.size;i++)
        {
            if(loves.get(i).isKill())
                loves.removeIndex(i);
        }
        if(loves.size<1)
            loves.add(new love(this));
        if(tool.isIn)
        {
            in.play();
            tool.isIn=false;
        }
        if(tool.isXinsui)
        {xinsui.play();
            tool.isXinsui=false;

        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        stateTime+= Gdx.graphics.getDeltaTime();
        for(int i=0;i<loves.size;i++)
        {
            love t=loves.get(i);
            batch.draw(t.getKeyFrame(stateTime),t.x,t.y,t.width,t.height);
        }
        update();
    }

    public TextureRegion[] getTextureRegions()
    {

        int select=(int)(Math.random()* lovesNUM);
        return lovesTextureRegion.get(select);

    }

    private TextureRegion[] getFromFile(int index)
    {
        TextureRegion[] frame=new TextureRegion[2];
        switch (index)
        {
            case 0:
                frame=new TextureRegion[2];
                for(int i=0;i<2;i++)
                    frame[i]=new TextureRegion(new Texture("game/love/1/love"+(i+1)+".png"));
                break;
            case 1:
                frame=new TextureRegion[3];
                for(int i=0;i<3;i++)
                    frame[i]=new TextureRegion(new Texture("game/love/2/xin2.gif_00"+(i+1)+".png"));
                break;
            case 2:
                frame=new TextureRegion[2];
                for(int i=0;i<2;i++)
                    frame[i]=new TextureRegion(new Texture("game/love/3/"+(i)+".png"));
                break;
            case 3:
                frame=new TextureRegion[9];
                for(int i=0;i<9;i++)
                    frame[i]=new TextureRegion(new Texture("game/love/4/"+(i)+".png"));
                break;
            case 4:
                frame=new TextureRegion[2];
                for(int i=0;i<2;i++)
                    frame[i]=new TextureRegion(new Texture("game/love/5/timg.png"));
                break;
            case 5:
                frame=new TextureRegion[2];
                for(int i=0;i<2;i++)
                    frame[i]=new TextureRegion(new Texture("game/love/6/"+(i)+".png"));
                break;
        }
        return frame;
    }
}
