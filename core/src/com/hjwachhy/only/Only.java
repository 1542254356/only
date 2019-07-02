package com.hjwachhy.only;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

/**
 * Created by Administrator on 2018/2/14.
 */

public class Only extends Game {
    public  float width;
    public  float height;

    @Override
    public void create()
    {
        tool.reset();
        setScreen(new StartScreen(this));
    }
}
