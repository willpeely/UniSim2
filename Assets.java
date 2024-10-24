package com.badlogic.UniSim2;

import com.badlogic.gdx.graphics.Texture;

public class Assets {

    public static Texture backgroundTexture;

    public static Texture meunBarTexture;
    public static Texture accomodationButtonTexture;
    public static Texture lectureHallButtonTexture;
    public static Texture libraryButtonTexture;
    public static Texture courseButtonTexture;
    public static Texture foodZoneButtonTexture;
    public static Texture recreationalButtonTexture;
    public static Texture natureButtonTexture;
    public static Texture[] buttonTextures;

    public static Texture accomodationPlacedTexture;
    public static Texture accomodationCollisionTexture;
    public static Texture accomodationDraggingTexture;

    public static Texture lectureHallPlacedTexture;
    public static Texture lectureHallCollisionTexture;
    public static Texture lectureHallDraggingTexture;

    public static Texture libraryPlacedTexture;
    public static Texture libraryCollisionTexture;
    public static Texture libraryDraggingTexture;

    public static Texture coursePlacedTexture;
    public static Texture courseCollisionTexture;
    public static Texture courseDraggingTexture;

    public static Texture foodZonePlacedTexture;
    public static Texture foodZoneCollisionTexture;
    public static Texture foodZoneDraggingTexture;

    public static Texture recreationalPlacedTexture;
    public static Texture recreationalCollisionTexture;
    public static Texture recreationalDraggingTexture;

    public static Texture naturePlacedTexture;
    public static Texture natureCollisionTexture;
    public static Texture natureDraggingTexture;

    private Assets() {};

    public static void loadTextures(){

        // Background texture
        backgroundTexture = new Texture("background.png");

        // Menu textures 
        meunBarTexture = new Texture("menuBar.png");
        accomodationButtonTexture = new Texture("accomodationButton.png");
        lectureHallButtonTexture = new Texture("lectureHallButton.png");
        libraryButtonTexture = new Texture("libraryButton.png");
        courseButtonTexture = new Texture("courseButton.png");
        foodZoneCollisionTexture = new Texture("foodZoneButton.png");
        recreationalButtonTexture = new Texture("recreationalButton.png");

        buttonTextures = new Texture[]
        {
            accomodationButtonTexture,
            lectureHallButtonTexture,
            libraryButtonTexture,
            courseButtonTexture,
            foodZoneButtonTexture,
            recreationalButtonTexture,
            natureButtonTexture
        };

        //Building textures
        accomodationPlacedTexture = new Texture("accomodationPlaced.png");
        accomodationCollisionTexture = new Texture("accomodationCollision.png");
        accomodationDraggingTexture = new Texture("accomodationDragging.png");

        lectureHallPlacedTexture = new Texture("lectureHallPlaced.png");
        lectureHallCollisionTexture = new Texture("lectureHallCollision.png");
        lectureHallDraggingTexture = new Texture("lectureHallDragging.png");

        libraryPlacedTexture = new Texture("libraryPlaced.png");
        libraryCollisionTexture = new Texture("libraryCollision.png");
        libraryDraggingTexture = new Texture("libraryDragging.png");

        coursePlacedTexture = new Texture("coursePlaced.png");
        courseCollisionTexture = new Texture("courseCollision.png");
        courseDraggingTexture = new Texture("courseDraggingTexture");
        
        foodZonePlacedTexture = new Texture("foodZonePlaced.png");
        foodZoneCollisionTexture = new Texture("foodZoneCollision.png");
        foodZoneDraggingTexture = new Texture("foodZoneDragging.png");

        recreationalPlacedTexture = new Texture("recreationalPlaced.png");
        recreationalCollisionTexture = new Texture("recreationalCollision.png");
        recreationalDraggingTexture = new Texture("recreationalDragging.png");

        naturePlacedTexture = new Texture("naturePlaced.png");
        natureCollisionTexture = new Texture("natureCollision.png");
        natureDraggingTexture = new Texture("natureDragging");
    }
}
