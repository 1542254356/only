package com.hjwachhy.only;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * Created by Administrator on 2018/2/14.
 */

public class GameScreen implements Screen {
    private Only only;
    private SpriteBatch batch;
    private Texture img;
    private Basket basket;
    private BitmapFont font;
    private Stage stage;
    private Music backgroundmusic;

    GameScreen(Only only)
    {
        this.only=only;
    }
    @Override
    public void show()
    {
        backgroundmusic = Gdx.audio.newMusic(Gdx.files.internal("game/background.m4a"));
        backgroundmusic.setLooping(true);
        backgroundmusic.play();
        stage=new Stage(new ScreenViewport());
        batch=new SpriteBatch();
        img = new Texture("badlogic.jpg");
        font=new BitmapFont(Gdx.files.internal("hjw.fnt"),
                Gdx.files.internal("hjw.png"),false);
        GameBackground backgroud=new GameBackground();
        basket=new Basket();
        Loves loves=new Loves();
        stage.addActor(backgroud);
        stage.addActor(loves);
        stage.addActor(basket);

        Gdx.input.setInputProcessor(stage);

    }



    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        stage.act();
        stage.draw();
        batch.end();
        if(tool.life<0)
        {
            only.setScreen(new GameOverScreen(only));
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
