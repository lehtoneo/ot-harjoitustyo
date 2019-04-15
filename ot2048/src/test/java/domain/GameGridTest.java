/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.lehtoneo.ot2048.domain.GameGrid;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ossij
 */
public class GameGridTest {
    
    GameGrid grid1;
    GameGrid grid2;
    GameGrid grid3;
    GameGrid grid4;
    GameGrid grid5;
    GameGrid testGrid;
    
    
   
    @Before
    public void setUp() {
        grid1 = new GameGrid();
        grid2 = new GameGrid();
        grid3 = new GameGrid();
        grid4 = new GameGrid();
        grid5 = new GameGrid();
        
        
        int[][] testArray = new int[4][4];
        
        for (int x = 0; x < 4; x++) {
            
            for (int y = 0; y < 4; y++) {
                testArray[y][x] = 0;
            }
            
        }
        testArray[3][1] = 1;
        testArray[3][2] = 1;
        testArray[2][1] = 1;
        testArray[2][2] = 2;
        
        testGrid = new GameGrid(testArray);
    }
    
    @After
    public void tearDown() {
    }
    
    
    
    @Test
    public void numberOneToRandomPlacePlacesNumberOneToRandomPlace() {
        Boolean true1 = grid1.equals(grid1);
        Boolean true2 = grid1.equals(grid2);
        Boolean true3 = grid1.equals(grid3);
        Boolean true4 = grid1.equals(grid4);
        Boolean true5 = grid1.equals(grid5);
        
        Boolean testTrue = true1 && true2 && true3 && true4 && true5;
        
        assertFalse(testTrue);
        
    }
    
    @Test
    public void moveEveryNumberLeftMethodMovesEveryNumberToTheLeftOnce(){
        
        testGrid.moveEveryNumberLeft();
        
        int shouldBeOne = testGrid.getGrid()[3][0];
        
        assertEquals(shouldBeOne, 1);
    }
    
   
    
    @Test
    public void combineNumbersLeftCombinesNumbersIfTheyAreEqual() {
        
        testGrid.combineNumbersLeft();
        
        int shouldBeTwo = testGrid.getGrid()[3][0];
        
        assertEquals(shouldBeTwo, 2);
    }
    
    @Test 
    public void combineNumbersLeftDoesntCombineNumbersIfTheyAreNotEqual() {
        
        testGrid.combineNumbersLeft();
        
        int shouldBeOne = testGrid.getGrid()[2][0];
        
        assertEquals(shouldBeOne,1);
    }
    
    @Test
    public void moveEveryNumberRighMethodMovesEveryNumberRightOnce() {
        
        testGrid.moveEveryNumberRight();
        
        int shouldBeTwo = testGrid.getGrid()[2][3];
        
        assertEquals(shouldBeTwo, 2);
        
    }
    
    @Test
    public void combineNumbersRightCombinesNumbersIfTheyAreEqual() {
        
        testGrid.combineNumbersRight();
        
        int shouldBeTwo = testGrid.getGrid()[3][3];
        
        assertEquals(shouldBeTwo, 2);
    }
    
    @Test 
    public void combineNumbersRightDoesntCombineNumbersIfTheyAreNotEqual() {
        
        testGrid.combineNumbersRight();
        
        int shouldBeTwo = testGrid.getGrid()[2][3];
        
        assertEquals(shouldBeTwo,2);
    }
    
}
