package com.squaretyrant.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Core extends ApplicationAdapter {
    private Skin skin;
    private Stage stage;
    private Texture tempBackground;
    private SpriteBatch backgroundBatch;
    private SpriteBatch fontBatch;
    private BitmapFont font;

    @Override
    public void create () {
        skin = new Skin(Gdx.files.internal("metalui/metal-ui.json"));
        fontBatch = new SpriteBatch();

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        backgroundBatch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("FontReal.fnt"));

        tempBackground = new Texture("Backgrounds/clashroyalmad.png");

        Table root = new Table();
        root.setFillParent(true);
        stage.addActor(root);

        //Begin layout
        root.pad(10);
        TextButton textButton = new TextButton("P1", skin);
        root.add(textButton).expand().expandY().bottom();

        textButton = new TextButton("P2", skin);
        root.add(textButton).expand().expandY().bottom();

        textButton = new TextButton("P3", skin);
        root.add(textButton).expand().expandY().bottom();

        textButton = new TextButton("P4", skin);
        root.add(textButton).expand().expandY().bottom();


        textButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Test Successful");
            }
        });
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(.9f, .9f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Background
        backgroundBatch.begin();
        backgroundBatch.draw(tempBackground,0,0,640,480);
        backgroundBatch.end();
        //Text
        fontBatch.begin();
        font.draw(fontBatch,"Health: 100",260,450);
        fontBatch.end();
        //Buttons
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose () {
        skin.dispose();
        stage.dispose();
        fontBatch.dispose();
        font.dispose();;
    }
}
