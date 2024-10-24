package com.badlogic.UniSim2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class Map {

    private final int width;
    private final int height;

    private Buildings buildings; // Used to control all the buildings in the game

    private BuildingMenu buildingMenu; // Used to make and display the menu

    private final int cellSize; // Size of each cell in the grid
    
    private final StretchViewport viewport;
    private final SpriteBatch spriteBatch;
    private final Grid grid;

    public static Array<Sprite> collidableSprites;

    public Map() {
        width = Consts.MAP_WIDTH;
        height = Consts.MAP_HEIGHT;
        cellSize = Consts.CELL_SIZE;

        viewport = new StretchViewport(width, height);
        spriteBatch = new SpriteBatch();
        buildings = new Buildings();
        buildingMenu = new BuildingMenu(viewport, buildings);
        grid = new Grid();
        collidableSprites = new Array<Sprite>();
    }

    public void render() {
        input();
        draw();
    }

    // Handles when a user clicks or applies any input
    private void input() {
        Vector2 mousePos = new Vector2(Gdx.input.getX(), Gdx.input.getY()); // Gets the position of the mouse
        viewport.unproject(mousePos);

        boolean clicked = Gdx.input.justTouched(); // True when the mouse is clicked
        buildings.handleInput(mousePos, clicked); 
    }

    private void draw() {
        drawSetup();
        drawBackground();
        grid.drawGrid(viewport);
        buildingMenu.render();
        buildings.drawBuildings(spriteBatch); 
    }

    // Required to start drawing 
    private void drawSetup(){
        ScreenUtils.clear(Consts.BACKGROUND_COLOR);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.enableBlending();
    }


    private void drawBackground() {
        spriteBatch.begin();
        spriteBatch.draw(Assets.backgroundTexture, 0, 0, width, height);
        spriteBatch.end();
    }

    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public StretchViewport getViewport() {
        return viewport;
    }

    public int getCellSize() {
        return cellSize;
    }

    public void dispose(){
        grid.dispose();
        buildings.dispose();
        buildingMenu.dispose();
    }
}
