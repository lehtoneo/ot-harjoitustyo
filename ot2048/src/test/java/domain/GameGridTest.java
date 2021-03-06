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
    GameGrid fullTestGrid;
    
    
   
    @Before
    public void setUp() {
        grid1 = new GameGrid();
        grid2 = new GameGrid();
        grid3 = new GameGrid();
        grid4 = new GameGrid();
        grid5 = new GameGrid();
        
        
        int[][] testArray = new int[4][4];
        int[][] fullTestArray = new int[4][4];
        
        
        for (int x = 0; x < 4; x++) {
            
            for (int y = 0; y < 4; y++) {
                testArray[y][x] = 0;
                
            }
            
        }
        int numbr = 1;
        for (int x = 0; x < 4; x++) {
            
            for (int y = 0; y < 4; y++) {
                fullTestArray[y][x] = numbr;
                numbr++;
            }
            
        }
        
        
        testArray[3][1] = 1;
        testArray[3][2] = 1;
        testArray[2][1] = 1;
        testArray[2][2] = 2;
        testArray[0][3] = 4;
        
        testGrid = new GameGrid(testArray);
        fullTestGrid = new GameGrid(fullTestArray);
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
        
        assertEquals(1, shouldBeOne);
    }
    
   
    
    @Test
    public void combineLeftCombinesNumbersIfTheyAreEqual() {
        
        testGrid.combineLeft();
        
        int shouldBeTwo = testGrid.getGrid()[3][0];
        
        assertEquals(2, shouldBeTwo);
    }
    
    @Test 
    public void combineLeftDoesntCombineNumbersIfTheyAreNotEqual() {
        
        testGrid.combineLeft();
        
        int shouldBeOne = testGrid.getGrid()[2][0];
        
        assertEquals(1, shouldBeOne);
    }
    
    @Test
    public void moveLeftMethodDoesntChangeGridIfMoveDoesntChangeGrid() {
        
        GameGrid shouldBeSame = new GameGrid(fullTestGrid.getGrid());
        
        fullTestGrid.moveLeft();
        
        assertTrue(shouldBeSame.equals(fullTestGrid));
    }
    
    @Test
    public void moveEveryNumberRighMethodMovesEveryNumberRightOnce() {
        
        testGrid.moveEveryNumberRight();
        
        int shouldBeTwo = testGrid.getGrid()[2][3];
        
        assertEquals(2, shouldBeTwo);
        
    }
    
    @Test
    public void combineRightCombinesNumbersIfTheyAreEqual() {
        
        testGrid.combineRight();
        
        int shouldBeTwo = testGrid.getGrid()[3][3];
        
        assertEquals(2, shouldBeTwo);
    }
    
    @Test 
    public void combineRightDoesntCombineNumbersIfTheyAreNotEqual() {
        
        testGrid.combineRight();
        
        int shouldBeTwo = testGrid.getGrid()[2][3];
        
        assertEquals(2, shouldBeTwo);
    }
    
    @Test
    public void moveNumbersDownMovesEveryNumberDownOnce() {
        
        testGrid.moveEveryNumberDown();
        
        int shouldBeFour = testGrid.getGrid()[1][3];
        
        assertEquals(4, shouldBeFour);
        
    }
    
    @Test
    public void combineDownCombinesNumbersIfTheyAreEqual() {
        
        testGrid.combineDown();
        
        int shouldBeTwo = testGrid.getGrid()[3][1];
        
        assertEquals(2, shouldBeTwo);
    }
    
    @Test
    public void combineDownDoesntCombineNumbersIfTheyAreNotEqual() {
        
        testGrid.combineDown();
        int shouldBeOne = testGrid.getGrid()[3][2];
        
        assertEquals(1, shouldBeOne);
    }
    
    
    @Test
    public void getCurrentPointsReturnsBiggestNumberInGrid() {
        
        int shouldBeFour = testGrid.getCurrentPoints();
        
        assertEquals(4, shouldBeFour);
        
    }
    
    @Test
    public void moveEveryNumberUpMethodMovesEveryNumberUpOnce(){
        
        testGrid.moveEveryNumberUp();
        
        int shouldBeOne = testGrid.getGrid()[1][1];
        
        assertEquals(1, shouldBeOne);
    }
  
    @Test
    public void combineUpMethodCombinesNumbersIfTheyAreEqual() {
        testGrid.combineUp();
        
        int shouldBeTwo = testGrid.getGrid()[0][1];
        
        assertEquals(2, shouldBeTwo);
    }
    
    
    @Test
    public void combineUpMethodDoesntCombineNumbersIfTheyAreNotEqual() {
        testGrid.combineUp();
        
        int shouldBeTwo = testGrid.getGrid()[0][2];
        
        assertEquals(2, shouldBeTwo);
    }
    
    @Test
    public void moveUpMethodActsRight() {
        testGrid.moveUp();
        
        int shouldBeTwo = testGrid.getGrid()[0][1];
        int shouldBeFour = testGrid.getGrid()[0][3];
        
        assertEquals(2, shouldBeTwo);
        assertEquals(4, shouldBeFour);
        
    }
    
    
    @Test
    public void moveDownMethodActsRight() {
        testGrid.moveDown();
        
        int shouldBeTwo = testGrid.getGrid()[3][1];
        int shouldBeFour = testGrid.getGrid()[3][3];
        
        assertEquals(2, shouldBeTwo);
        assertEquals(4, shouldBeFour);
        
    }
    
    @Test
    public void moveRIghtMethodActsRight() {
        testGrid.moveRight();
        
        int shouldBeTwo = testGrid.getGrid()[3][3];
        int shouldBeFour = testGrid.getGrid()[0][3];
        
        assertEquals(2, shouldBeTwo);
        assertEquals(4, shouldBeFour);
        
    }
    
}
