package com.badlogic.UniSim2;

import com.badlogic.gdx.Screen;

public class FirstScreen implements Screen {
    private Map map;
    @Override
    public void show() {
        Assets.loadTextures();
        map = new Map();
    }

    @Override
    public void render(float delta) {
        map.render();
    }

    @Override
    public void resize(int width, int height) {
        map.resize(width, height);
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
        map.dispose();
    }
}