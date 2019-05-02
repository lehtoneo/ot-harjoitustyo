/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lehtoneo.ot2048.domain;


import java.util.Random;

/**
 * Luokka on 2048-pelin pohja, joka huolehtii pelin sovelluslogiikasta
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
    

    
    /**
 * Alustaa uuden pelin numberOneToRandomPlace metodin avulla siten, 
 * että pelitaulukon yhden satunnaisen alkion arvo on yksi, ja muiden nolla.
 * @see #numberOneToRandomPlace() 
 */
    public void setUpGrid() {
       
        for (int x = 0; x < 4; x++) {
            
            for (int y = 0; y < 4; y++) {
                grid[y][x] = 0;
            }
            
        }
        
        numberOneToRandomPlace();
        
    }
    
    
    /**
 * Metodi tutkii, ovatko kaksi gamegrid-oliota samanlaisia.
 * @param gamegrid   toinen gamegrid-olio
 * @return  true   jos gamegrid-olioiden jokainen alkio vastaa toisiaan, muuten false
 */
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
    
    
    /**
 * Metodi laittaa peliruudukon yhden satunnaisen nolla-alkion paikalle numerom yksi.
 */
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
    
    
   
    
    
    
     /**
 * Liikuttaa jokaista peliruudukon numeroa oikealle yhden sarakkeen verran, jos oikeanpuolinen alkio on 0
 */
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
    
    


/**
 * Yhdistää ruudukon kaikki numerot oikealle, jotka voidaan yhdistää
 */
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
    
    
 /**
 * Metodi joka tekee siirron oikealle
 * @see #moveEveryNumberRight() 
 * @see #combineRight() 
 */
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
 
/**
 * Liikuttaa jokaista peliruudukon numeroa vasemmalle yhden sarakkeen verran, jos vasemmanpuolinen alkio on 0
 */
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
   
   
/**
 * Yhdistää ruudukon kaikki numerot vasemmalle, jotka voidaan yhdistää
 */
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
        
 /**
 * Metodi joka tekee siirron oikealle
 * @see #moveEveryNumberLeft() 
 * @see #combineLeft() 
 */        
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
 /**
 * Liikuttaa jokaista peliruudukon numeroa ylös yhden rivin verran, mikäli yläpuolinen alkio on 0
 */ 
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
    
 /**
 * Yhdistää ruudukon kaikki numerot ylös, jotka voidaan yhdistää
 */
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
       
   /**
 * Metodi joka tekee siirron ylös
 * @see #moveEveryNumberUp() 
 * @see #combineUp() 
 */             
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

     /**
 * Liikuttaa jokaista peliruudukon numeroa alas yhden rivin verran, mikäli alapuolinen alkio on 0
 */ 
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
     /**
 * Yhdistää ruudukon kaikki numerot alas, jotka voidaan yhdistää
 */          
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

     /**
 * Metodi joka tekee siirron alas
 * @see #moveEveryNumberDown() 
 * @see #combineDown() 
 */             
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
    
    /**
 * Alustaa pelin uusiksi siten, että ruudukossa on yksi ykkönen, ja loput nollia
 * @see #setUpGrid
 */      
    public void newGame() {
        setUpGrid();
    }
    
    /**
 * Etsii suurimman alkion ruudukosta
 * @return palauttaa ruudukon suurimman alkion arvon
 */      
    public Integer getCurrentPoints() {
        int biggest = 0;
        for (int x = 0; x < 4; x++) {
            
            for (int y = 0; y < 4; y++) {
                if (grid[y][x] > biggest) {
                    biggest = grid[y][x];
                }
            }
            
        }
        return biggest;
        
    }
    
    
    /**
     * Tarkistaa onko peliloppu
     * @return palauttaa true, jos peli on loppu, muuten false
     */
    public boolean gameOver() {
               
        GameGrid helpGrid1 = new GameGrid();
        helpGrid1.setGrid(this.getGrid());
               
        GameGrid helpGrid2 = new GameGrid();
        helpGrid2.setGrid(this.getGrid());
               
        GameGrid helpGrid3 = new GameGrid();
        helpGrid3.setGrid(this.getGrid());
               
        GameGrid helpGrid4 = new GameGrid();
        helpGrid4.setGrid(this.getGrid());
               
        helpGrid1.moveDown();
        helpGrid2.moveUp();
        helpGrid3.moveLeft();
        helpGrid4.moveRight();
               
        if (this.equals(helpGrid1) && this.equals(helpGrid2) && this.equals(helpGrid3) && this.equals(helpGrid4)) {
            return true;
        }
            
        return false;
    }
    
    
    
}