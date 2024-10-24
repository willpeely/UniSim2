package com.badlogic.UniSim2;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Buildings {

    private Array<Building> buildings; // Array of all the buildings on the map in order of when placed

    private Building currentBuilding; // References the building currently selected

    private boolean currentlySelecting; // True when a building is selected and being being dragged 

    public Buildings() {
        buildings = new Array<>();
        currentBuilding = null;
        currentlySelecting = false;
    }
    
    public void addBuilding(Building building){
        buildings.add(building);
    }

    // Used to determine what to do when the mouse is clicked on a menu button
    public void handleInput(Vector2 mousePos, boolean clicked) {

        // If a click has happened
        if(clicked){
            // If we are currently selecting a building
            if(currentlySelecting){
                handlePlacing(); // Place the building in the location of the click
            }
        }
        // Otherwise continue dragging the building
        if(currentlySelecting){
            handleDragging(mousePos);
        }
    }

    public void handlePlacing(){

        // If the current building is not colliding 
        if(!isColliding(currentBuilding)){
            currentBuilding.placeBuilding(); // Place building
            currentlySelecting = false; // No longer selecting a building
        }
    }

    // Called when a menu button has been pressed, deals with placing a new building 
    // corresponding to the button pressed determined with type
    public void handleSelection(Building.BuildingTypes type){

        handleType(type); // Sets current building to the type of building selected
        currentlySelecting = true; // Sets currently selecting to true as we have selected a building to drag and place
        currentBuilding.selectBuilding();
        buildings.add(currentBuilding); // Adds the new building to the building list
        Map.collidableSprites.add(currentBuilding);
    }

    public void handleType(Building.BuildingTypes type){
        switch(type){
            case Accomodation:
                currentBuilding = new Accomodation();
                break;
            case LectureHall:
                currentBuilding = new LectureHall();
                break;
            case Library:
                currentBuilding = new Library();
            default:
                break;
        }
    }

    // Updates the position of the building to mousePos and changes its texture depending on colliding
    public void handleDragging(Vector2 mousPos){
        boolean colliding = isColliding(currentBuilding);
        currentBuilding.handleDragging(mousPos, colliding);
    }


    public boolean isColliding(Building building){
        
        for(Sprite collidableSprite : Map.collidableSprites){
            boolean overlaps = building.getBoundingRectangle().overlaps(collidableSprite.getBoundingRectangle());
            if(!building.equals(collidableSprite) && overlaps){
                return true;
            }
        }
        return false;
    }

    public boolean isCurrentlySelecting(){
        for(Building building : buildings){
            if(building.getIsSelected()){
                return true;
            }
        }
        return false;
    }

    public void drawBuildings(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        for (Building building : buildings) {
            building.clampPosition();
            if(!building.equals(currentBuilding)){
            building.draw(spriteBatch);
            }
        }
        if(currentBuilding != null){
            currentBuilding.draw(spriteBatch);
        }
        spriteBatch.end();
    }

    public Array<Building> getBuildings() {
        return buildings;
    }

    public void setCurrentlySelecting(boolean setter){
        currentlySelecting = setter;
    }

    public void dispose(){
        for(Building building : buildings){
            building.dispose();
        }
    }
}
