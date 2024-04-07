package com.squaretyrant.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Test_Scene extends ApplicationAdapter {

    private Skin skin;

    private Stage stage;
    private Stage backdrop;
    SpriteBatch spriteBatch;

    SpriteBatch fontBatch;
    Texture Background;
    private Viewport viewport;
    private Camera camera;
    String yapping;

    BitmapFont font;

    @Override
    public void create () {
        camera = new PerspectiveCamera();
        fontBatch = new SpriteBatch();



        skin = new Skin(Gdx.files.internal("metalui/metal-ui.json"));

        float width = 520f;
        float height = 520f;
        stage = new Stage(new StretchViewport(width, height));
        Gdx.input.setInputProcessor(stage);
        backdrop = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        spriteBatch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("FontReal.fnt"));


        Background = new Texture("Backgrounds/minecraftmap.png");
        //Image test =  new Image(Background);
        //stage.addActor(test);


        Table root = new Table();
        root.setFillParent(true);
        stage.addActor(root);


        //Begin layout
        root.defaults().grow().pad(100);
        TextButton one = new TextButton("1", skin);
        root.add(one).width(120).expandX().left().expandY().top();
        TextButton two = new TextButton("2", skin);
        root.add(two).width(120).expandX().right().expandY().top();
        root.row();
        TextButton three = new TextButton("3", skin);
        root.add(three).width(120).expandX().left().expandY().bottom();
        TextButton four = new TextButton("4", skin);
        root.add(four).width(120).expandX().right().expandY().bottom();








    }

    @Override
    public void render () {

        Gdx.gl.glClearColor(1f, 1f, 1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Background
        spriteBatch.begin();
        spriteBatch.draw(Background,0,0,640,480);
        spriteBatch.end();
        //Text
        fontBatch.begin();
        font.draw(fontBatch,"Mission Selection",205,450);
        fontBatch.end();
        //Buttons
        stage.act();
        stage.draw();


    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        backdrop.getViewport().update(width, height, true);
    }

    @Override
    public void dispose () {
        skin.dispose();
        stage.dispose();
        backdrop.dispose();
        spriteBatch.dispose();
        Background.dispose();
        fontBatch.dispose();
    }
}


