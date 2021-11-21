package com.army_builder.systems;

import com.army_builder.models.Units;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

enum Direction {
    UP(-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1);

    private final int rowSteps;
    private final int colSteps;
    private Direction(int rowSteps, int colSteps)  {
        this.rowSteps = rowSteps;
        this.colSteps = colSteps;
    }
    public int getNewRowIdx(int currentRowIdx)  {
        return  (currentRowIdx + getRowSteps());
    }
    public int getNewColIdx(int currentColIdx)  {
        return  (currentColIdx + getColSteps());
    }
    public int getRowSteps()  {
        return  rowSteps;
    }
    public int getColSteps()  {
        return  colSteps;
    }
};

public class Map {

    private static Units[][] MAP_STATE;  // holds unit positions
    private int rowIndex;  // generated values note they are subtracted at 1
    private int colIndex;  // after random to maintain array index integrity


    public Map(){

    }

    public void generateMapBounds(){
        int minR, maxR, minC, maxC;

        maxR = 3;  //
        maxC = 9;  // temp values but randomly determine the mapp bounds
        int genRow = ThreadLocalRandom.current().nextInt(2, maxR + 1);
        int genCol = ThreadLocalRandom.current().nextInt(4, maxC + 1);
        this.rowIndex = genRow -1;
        this.colIndex = genCol -1;
        MAP_STATE = new Units[genRow][genCol];  // creates the map based on random values
        for(Units[] array : MAP_STATE) Arrays.fill(array, null);  // fills with null values
    }

    // simple method for now ot assign variable to map state
    public void assignInitialStart(Units startUnit, int r, int c){
        MAP_STATE[r][c] = startUnit;
    }

    public void displayUnitsOnMap(){
        // loops through map array showing units
        for (int row = 0; row <= this.rowIndex; row++) {
            for (int col = 0; col <= this.colIndex; col++) {

                if(MAP_STATE[row][col] == null) {  //if position is null shows that it is unoccupied
                    System.out.print("  Unoccupied  ");
                }else {  // gets basic info on position based on name and faction
                    System.out.printf("  %s :   %s", MAP_STATE[row][col].getName(), MAP_STATE[row][col].getFaction());
                }

                // if last columns adds a line break
                if(col == this.colIndex){
                    System.out.println();
                }

            }
        }
    }
}