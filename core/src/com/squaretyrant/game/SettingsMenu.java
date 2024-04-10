package com.squaretyrant.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;

public class SettingsMenu extends ApplicationAdapter {

    private Skin skin;
    private Stage stage;

    public void create () {
        skin = new Skin(Gdx.files.internal("metalui/metal-ui.json"));


        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Table root = new Table();
        root.setFillParent(true);
        stage.addActor(root);

        //Begin Layout
        root.pad(10);
        TextButton textButton = new TextButton("ON/OFF", skin);
        root.add(textButton).expand().expandY().bottom();

        textButton = new TextButton("ON/OFF", skin);
        root.add(textButton).expand().expandY().bottom();

        textButton = new TextButton("Quit", skin);
        root.add(textButton).expand().expandY().bottom();

        Slider musicSlider = new Slider(0, 10, 2, true, skin);
        root.add(musicSlider).expand().expandY().bottom();

        Slider sfxSlider = new Slider(0, 10, 2, true, skin);
        root.add(sfxSlider).expand().expandY().bottom();


    }

    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    public void render () {
        Gdx.gl.glClearColor(.9f, .9f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    public void dispose () {
        skin.dispose();
        stage.dispose();
    }

}
