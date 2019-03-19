/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

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
public class KassapaateTest {
    
    Kassapaate kassapaate;
    Maksukortti kortti;
  
    
    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
        kortti = new Maksukortti(400);
    }
    
    //ALKUTESTIT
    @Test
    public void luotuKassapaateOlemassa() {
        assertTrue(kassapaate!=null);      
    }
    
    @Test
    public void kassassaAluksiOikeaMaaraRahaa(){
        assertEquals(100000,kassapaate.kassassaRahaa());
    }
    
     @Test
    public void edullisiaLounaitaEiOleMyyty(){
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }
    
    
    //KATEISMAKSUT
   
    
    @Test
    public void myytyjenEdullistenMaaraKasvaaKateisMaksulla(){
        kassapaate.syoEdullisesti(300);
        
        assertEquals(1,kassapaate.edullisiaLounaitaMyyty());
    }
    
     @Test
    public void myytyjenMaukkaidenMaaraKasvaaKateisMaksulla(){
        kassapaate.syoMaukkaasti(400);
        
        assertEquals(1,kassapaate.maukkaitaLounaitaMyyty());
    }
    
    
    @Test
    public void kateisMaksuLisaaSaldoaEdulliselleLounaalle(){
        kassapaate.syoEdullisesti(240);
        
        assertEquals(100000+240,kassapaate.kassassaRahaa());
    }
    
    @Test
    public void kateisMaksuLisaaSaldoaMaukkaalleLounaalle(){
        kassapaate.syoMaukkaasti(400);
        
        assertEquals(100000+400,kassapaate.kassassaRahaa());
    }
    
   
    
    @Test
    public void kateisMaksuPalauttaaOikeinEdulliselleLounaalle(){
        
        assertEquals(100, kassapaate.syoEdullisesti(340));
    }
    
     @Test
    public void kateisMaksuPalauttaaOikeinMaukkalleLounaalle(){
        
        assertEquals(20, kassapaate.syoMaukkaasti(420));
    }
    
    
    
    
    
    //KORTTIMAKSUT
    @Test
    public void edullisenLounaanKorttiMaksuOttaaKortiltaRahaa(){
        kassapaate.syoEdullisesti(kortti);
        assertEquals(160,kortti.saldo());
    }
    
    
    
     @Test
    public void maukkaanLounaanKorttiMaksuOttaaRahaaKortilta(){
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(0,kortti.saldo());
    }
    
//     @Test
//    public void kortilleRahanLataaminenOnnistuu(){
//        
//        assertEquals(0,kortti.saldo());
//    }
    
    
    
}
