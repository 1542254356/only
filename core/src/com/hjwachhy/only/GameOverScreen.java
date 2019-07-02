package com.hjwachhy.only;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Administrator on 2018/2/14.
 */

public class GameOverScreen implements Screen
{
    private BitmapFont font;
    private SpriteBatch batch;
    private  float stateTime;
    Only only;

    public GameOverScreen(Only only)
    {
        this.only=only;
    }
    @Override
    public void show() {
        font=new BitmapFont(Gdx.files.internal("hjw.fnt"),Gdx.files.internal("hjw.png"),false);
        font.setColor(0f,0f,0f,1f);
        font.getData().setScale(2);
        batch=new SpriteBatch();
        stateTime=0;
    }

    @Override
    public void render(float delta) {
        stateTime+=delta;
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        font.getData().setScale(4);
        font.draw(batch,"GameOver",only.width/4,only.height/4*3);
        if(stateTime>2)
        {
            font.getData().setScale(2);
            font.draw(batch,"触摸屏幕继续",only.width/4,only.height/4);
        }
        batch.end();
        if(stateTime>2)
        {
            if(Gdx.input.isTouched())
            {
                only.setScreen(new StartScreen(only));
                tool.reset();
            }
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
