package com.badlogic.UniSim2;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class BuildingMenu {
    private Stage stage;
    private Buildings buildings;
    private Array<Texture> buildingButtonTextures;
    
    public BuildingMenu(StretchViewport viewport, Buildings buildings){
        this.buildings = buildings;
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        buildingButtonTextures = new Array<>();
        buildingButtonTextures.addAll(Assets.accomodationButtonTexture, Assets.lectureHallButtonTexture, Assets.libraryButtonTexture);
        createMenu();
    }

    public void createMenu(){
        //createMenuBar();
        createImageButtons();
    }

    // Creates a button for each building type with a gap between them
    public void createImageButtons() {
        int buttonGap = Consts.MENU_BUTTON_GAP;
        for(Building.BuildingTypes type : Building.BuildingTypes.values()){
            createImageButton(type, buttonGap);
            buttonGap += Consts.MENU_BUTTON_GAP;
        }
    }

    public void createImageButton(Building.BuildingTypes type, int buttonGap){
        ImageButton button = setupImageButton(type, buttonGap); // Creates a button for the building type defined by type
        addImageButtonClick(button, type); // Adds a click listener to the button so we can do something when clicked     
        stage.addActor(button);
    }

    // Sets the texture, the building type, size and position of the button
    public ImageButton setupImageButton(Building.BuildingTypes type, int buttonGap){
        int index = type.ordinal();
        Texture buttonTexture = Assets.buttonTextures[index];
        Drawable buttonImage = new TextureRegionDrawable(buttonTexture);
        ImageButton button = new ImageButton(buttonImage);
        button.setSize(Consts.MENU_BUTTON_WIDTH, Consts.MENU_BUTTON_HEIGHT);
        button.setPosition(Consts.MENU_BUTTON_X_BOUNDARY, Consts.MENU_BUTTON_Y_BOUNDARY - buttonGap);
        return button;
    }

    // Adds a click listener so it can handle being clicked
    public void addImageButtonClick(ImageButton button, Building.BuildingTypes type){
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y){
                buildings.handleSelection(type); // Creates a building of whatever type the button pressed is
            }
        });
    }

    // Setup and create the menu bar
    public void createMenuBar(){
        Image menuBar = new Image(new TextureRegionDrawable(Assets.meunBarTexture));
        menuBar.setPosition(0, 0);
        menuBar.setSize(Consts.MENU_BAR_WIDTH, Consts.MENU_BAR_HEIGHT);
        stage.addActor(menuBar);
    }

    public void render(){
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    public void dispose(){
        stage.dispose();
    } 
}

    