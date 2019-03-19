package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinSaldoAlussaOikein(){
        
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void positiivisenSummanLisaysOnnistuu(){
    
        kortti.lataaRahaa(5);
        assertEquals(15, kortti.saldo());
        
}
//    
//     @Test
//    public void eiVoiLisataNegatiivistaSummaa(){
//    
//        kortti.lataaRahaa(-5);
//        assertEquals(10, kortti.saldo());
//        
//}
    
      @Test
    public void rahanOttaminenToimiiJosRahaaOnTarpeeksi(){
    
        kortti.otaRahaa(5);
        assertEquals(5, kortti.saldo());
        
}
    
    
      @Test
    public void saldoMeneeNollaanJosTasaRaha(){
    
        kortti.otaRahaa(5);
        kortti.otaRahaa(5);
        
        assertEquals(0, kortti.saldo());
        
}
    
       @Test
    public void saldoEiMeneMiinukselleJosRahatEiRiita(){
    
        kortti.otaRahaa(5);
        kortti.otaRahaa(3);
        kortti.otaRahaa(5);
        assertEquals(2, kortti.saldo());
        
}
    
    @Test
    public void rahanOttaminenPalauttaaTrueJosKortilleJaaRahaa(){
        boolean onnistuiko = kortti.otaRahaa(5);
        
        
        assertEquals(true, onnistuiko);
    }
    
     @Test
    public void rahanOttaminenPalauttaaTrueJosKortilleJaaNollaEuroa(){
        kortti.otaRahaa(5);
        boolean onnistuiko = kortti.otaRahaa(5);
        
        
        assertEquals(true, onnistuiko);
    }
    
     @Test
    public void rahanOttaminenPalauttaaFalseJosEionnistu(){
        kortti.otaRahaa(8);
        boolean onnistuiko = kortti.otaRahaa(5);
        
        
        assertEquals(false, onnistuiko);
    }
    
    @Test
    public void toStringPalauttaaOikein(){
        
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    
    
}
