/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lehtoneo.ot2048.domain;


import java.util.Random;

/**
 *
 * @author ossij
 */
public class GameGrid {
    
    
    private int[][] grid;
    
    public GameGrid(int[][] grid) {
        this.grid = grid;
    }
            
    
    public GameGrid() {
        this.grid = new int[4][4];
        
        setUpGrid();
        
    }
    

    
    
    public final void setUpGrid() {
       
        for (int x = 0; x < 4; x++) {
            
            for (int y = 0; y < 4; y++) {
                grid[y][x] = 0;
            }
            
        }
        
        numberOneToRandomPlace();
        
    }
    
    
    public boolean equals(GameGrid gamegrid) {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (grid[y][x] != gamegrid.getGrid()[y][x]) {
                    return false;
                }
            }
        }
               
        return true;
    }
    
    public int[][] getGrid() {
        return grid;
    }
    
    public void setGrid(int[][] gridToCopy) {
        
        for (int x = 0; x < this.grid.length; x++) {
            
            for (int y = 0; y < this.grid.length; y++) {
                this.grid[y][x] = gridToCopy[y][x];
            }
        }
        
    }
    
    
    
    public void numberOneToRandomPlace() {
        Random random = new Random();
        
        while (true) {
            int y = random.nextInt(4);
            int x = random.nextInt(4);
            if (grid[y][x] == 0) {
                grid[y][x] = 1;
                break;
            }
        
        
        }
        
        
        
    }
    
    
   
    
    
    
    
    public void moveEveryNumberRight() {
        
        for (int x = 3; x > 0; x--) {
            for (int y = 3; y >= 0; y--) {
 
                if (grid[y][x] == 0) {
                    int left = grid[y][x - 1];
                    grid[y][x] = left;
                    grid[y][x - 1] = 0;
                
                }
            
            }
             
        }
        
    }
    
    



    public void combineRight() {
        for (int x = 3; x > 0; x--) {
            
            for (int y = 3; y >= 0; y--) {
                
                moveEveryNumberRight();
                
                int leftOfThisYx = grid[y][x - 1];
                
                if (grid[y][x] == leftOfThisYx) {
                
                    grid[y][x] = leftOfThisYx * 2;
                    grid[y][x - 1] = 0;
                
                }
                
                
                      
            }
                
                
                
            
        }
    }
    
    public void moveRight() {
        
        GameGrid helpGrid = new GameGrid();
        helpGrid.setGrid(this.getGrid());
        
        moveEveryNumberRight();
        combineRight();
        moveEveryNumberRight();
        
        
        if (!helpGrid.equals(this)) {
            numberOneToRandomPlace();
        }
        
    }
 

    public void moveEveryNumberLeft() {
        
        for (int x = 0; x < 3; x++) {
            for (int y = 3; y >= 0; y--) {
                
                
                if (grid[y][x] == 0) {
                    int rightOfThisX = grid[y][x + 1];
                    grid[y][x] = rightOfThisX;
                    grid[y][x + 1] = 0;
                
                }
                
                
                      
            }
                
                
                
        }
        
    }
   
   
   
    public void combineLeft() {
        for (int x = 0; x < 3; x++) {
            
            for (int y = 3; y >= 0; y--) {
                
                moveEveryNumberLeft();
                
                int rightOfThisX = grid[y][x + 1];
                
                if (grid[y][x] == rightOfThisX) {
                
                    grid[y][x] = rightOfThisX * 2;
                    grid[y][x + 1] = 0;
                
                }
            }
        }
    }
        
        
    public void moveLeft() {
        
        GameGrid helpGrid = new GameGrid();
        helpGrid.setGrid(this.getGrid());
        
        moveEveryNumberLeft();
        combineLeft();
        moveEveryNumberLeft();
        
        
        if (!helpGrid.equals(this)) {
            numberOneToRandomPlace();
        }
        
    }
  
    public void moveEveryNumberUp() {
        
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid.length - 1; y++) {
                
                
                if (grid[y][x] == 0) {
                    int belowThisY = grid[y + 1][x];
                    grid[y][x] = belowThisY;
                    grid[y + 1][x] = 0;
                
                } 
            }

        }     
    }
 
    public void combineUp() {
          
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid.length - 1; y++) {
                
                moveEveryNumberUp();
                
                
                int belowThisY = grid[y + 1][x];
                
                if (grid[y][x] == belowThisY) {
                
                    grid[y][x] = belowThisY * 2;
                    grid[y + 1][x] = 0;
                
                }
                
                
                      
            }
                
                
                
            
        }
    }
       
       
    public void moveUp() {
        
        GameGrid helpGrid = new GameGrid();
        helpGrid.setGrid(this.getGrid());
             
        moveEveryNumberUp();
        combineUp();
        moveEveryNumberUp();
        
        
        if (!helpGrid.equals(this)) {
            numberOneToRandomPlace();
        }
        
    }
     
    public void moveEveryNumberDown() {
        
        for (int y = 3; y >= 1; y--) {
            for (int x = 0; x < grid.length; x++) {
                
                
                if (grid[y][x] == 0) {
                    int aboveThisY = grid[y - 1][x];
                    grid[y][x] = aboveThisY;
                    grid[y - 1][x] = 0;
                
                }
                
                
                      
            }
            
            

        }
    }
              
    public void combineDown() {
          
        for (int y = 3; y >= 1; y--) {
            for (int x = 0; x < grid.length; x++) {
                
                moveEveryNumberDown();
                
                
                int aboveThisY = grid[y - 1][x];
                
                if (grid[y][x] == aboveThisY) {
                
                    grid[y][x] = aboveThisY * 2;
                    grid[y - 1][x] = 0;
                
                
                }
                
                
                      
            }
                
                
        }
            
    }

    public void moveDown() {
                  
        GameGrid helpGrid = new GameGrid();
        helpGrid.setGrid(this.getGrid());
        
        moveEveryNumberDown();
        combineDown();
        moveEveryNumberDown();
        
        
        if (!helpGrid.equals(this)) {
            numberOneToRandomPlace();
        }
        
    }
    
    
    public void newGame() {
        setUpGrid();
    }
    
    
    public Integer getCurrentPoints() {
        int biggest = 0;
        for (int x = 0; x < 4; x++) {
            
            for (int y = 0; y < 4; y++) {
                if( grid[y][x] > biggest) {
                    biggest = grid[y][x];
                };
            }
            
        }
        return biggest;
        
    }
    
    
    
}