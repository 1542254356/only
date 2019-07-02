package com.hjwachhy.only;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Administrator on 2018/2/14.
 */

public class tool
{
    static public float basketX;
    static public float basketWidth;
    static public float basketHeight;
    static public boolean isIn;
    static public boolean isXinsui;
    static public int score;
    static  public  int life;
    static public void reset()
    {
        score=0;
        life=5;
        isIn=false;
        isXinsui=false;
    }
}
