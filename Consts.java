package com.badlogic.UniSim2;

import com.badlogic.gdx.graphics.Color;

public class Consts {

    public Consts(){}

    public static final int CELL_SIZE = 20;

    // Scales a value according to the size of the grid cells
    private static int scaleToCellSize(int value){
        return value * CELL_SIZE;
    }
    public static final int MAP_WIDTH = scaleToCellSize(75);
    public static final int MAP_HEIGHT = scaleToCellSize(38);
    public static final int MAP_MIN_X_BOUNDARY = scaleToCellSize(8);
    public static final int MAP_MAX_X_BOUNDARY = MAP_WIDTH;
    public static final int MAP_MIN_Y_BOUNDARY = scaleToCellSize(0);
    public static final int MAP_MAX_Y_BOUNDARY = MAP_HEIGHT;
    public static final Color BACKGROUND_COLOR = new Color(Color.BLACK);

    public static final Color GRID_COLOR = new Color(0.28f,0.56f,0.11f, 1);
    public static final int GRID_ROWS = MAP_HEIGHT / CELL_SIZE;
    public static final int GRID_COLS = MAP_WIDTH / CELL_SIZE;

    public static final int MENU_BAR_WIDTH = scaleToCellSize(8);
    public static final int MENU_BAR_HEIGHT = MAP_HEIGHT;
    public static final int MENU_BUTTON_WIDTH = scaleToCellSize(7);
    public static final int MENU_BUTTON_HEIGHT = scaleToCellSize(3);
    public static final int MENU_BUTTON_X_BOUNDARY = scaleToCellSize(1);
    public static final int MENU_BUTTON_Y_BOUNDARY = MAP_HEIGHT;
    public static final int MENU_BUTTON_GAP = scaleToCellSize(1) + MENU_BUTTON_HEIGHT;

    public static final int ACCOMODATION_WIDTH = scaleToCellSize(4);
    public static final int ACCOMODATION_HEIGHT = scaleToCellSize(6);

    public static final int LECTUREHALL_WIDTH = scaleToCellSize(6);
    public static final int LECTUREHALL_HEIGHT = scaleToCellSize(10);

    public static final int LIBRARY_WIDTH = scaleToCellSize(10);
    public static final int LIBRARY_HEIGHT = scaleToCellSize(3);

    public static final int COURSE_WIDTH = scaleToCellSize(5);
    public static final int COURSE_HEIGHT = scaleToCellSize(5);

    public static final int FOODZONE_WIDTH = scaleToCellSize(2);
    public static final int FOODZONE_HEIGHT = scaleToCellSize(2);

    public static final int RECREATIONAL_WIDTH = scaleToCellSize(3);
    public static final int RECREATIONAL_HEIGHT = scaleToCellSize(2);

    public static final int NATURE_WIDTH = scaleToCellSize(4);
    public static final int NATURE_HEIGHT = scaleToCellSize(5);
}
