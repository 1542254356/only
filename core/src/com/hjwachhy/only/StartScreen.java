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
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * Created by Administrator on 2018/2/14.
 */

public class StartScreen implements Screen
{
    private Only only;
    private SpriteBatch batch;
    private ImageButton startGameButton;
    private Stage stage;
    private Button.ButtonStyle buttonStyle;



    StartScreen(Only only)
    {
        this.only=only;
    }
    @Override
    public void show()
    {

        only.width= Gdx.graphics.getWidth();
        only.height=Gdx.graphics.getHeight();
        stage=new Stage(new ScreenViewport());
        batch=new SpriteBatch();
        BitmapFont font=new BitmapFont(Gdx.files.internal("hjw.fnt"),
                Gdx.files.internal("hjw.png"),false);

        TextureRegionDrawable bnt_clicked=new TextureRegionDrawable(new TextureRegion(new Texture("start/bnt_clicked.png")));
        TextureRegionDrawable bnt=new TextureRegionDrawable(new TextureRegion(new Texture("start/bnt_ksyx.png")));

        startGameButton=new ImageButton(bnt);
        startGameButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                only.setScreen(new GameScreen(only));
            }
        });
        startGameButton.setPosition(only.width/4,only.height/2);

        Background backgroud=new Background();
        stage.addActor(backgroud);
        stage.addActor(startGameButton);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        stage.act();
        stage.draw();
        batch.end();

    }

    @Override
    public void resize(int width, int height)
    {
    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void hide()
    {

    }

    @Override
    public void dispose()
    {
        batch.dispose();

    }
}
