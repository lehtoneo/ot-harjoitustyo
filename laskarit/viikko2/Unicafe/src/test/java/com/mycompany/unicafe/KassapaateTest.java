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
    
    @Test
    public void maukkaitaLounaitaEiOlemyyty(){
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
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
        kassapaate.syoMaukkaasti(400);
        
        assertEquals(2,kassapaate.maukkaitaLounaitaMyyty());
    }
    
    
    @Test
    public void kateisMaksuLisaaSaldoaEdulliselleLounaalle(){
        kassapaate.syoEdullisesti(240);
        
        assertEquals(100000+240,kassapaate.kassassaRahaa());
    }
    
    @Test
    public void kateisMaksuLisaaSaldoaEdulliselleLounaalleKunEiTasaRaha(){
        kassapaate.syoEdullisesti(250);
        assertEquals(100000+240, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void kateisMaksuLisaaSaldoaMaukkaalleLounaalleKunEiTasaRaha(){
        kassapaate.syoMaukkaasti(450);
        assertEquals(100000+400, kassapaate.kassassaRahaa());
    }
    
    
    @Test
    public void kateisMaksuLisaaSaldoaMaukkaalleLounaalle(){
        kassapaate.syoMaukkaasti(400);
        
        assertEquals(100000+400,kassapaate.kassassaRahaa());
    }
    
   
    
    @Test
    public void kateisMaksuPalauttaaOikeinEdulliselleLounaalleJosRahaaOn(){
        
        assertEquals(100, kassapaate.syoEdullisesti(340));
    }
    
     @Test
    public void kateisMaksuPalauttaaOikeinMaukkalleLounaalleJosRahaaOn(){
        
        assertEquals(20, kassapaate.syoMaukkaasti(420));
    }
    
    @Test
    public void josKateisMaksuEiOleRiittavaKassapaateEiMuutuKunOstetaanEdullinen(){
        
        kassapaate.syoEdullisesti(10);
        assertEquals(100000, kassapaate.kassassaRahaa());
        
    }
    
    @Test
    public void josKateisMaksuEiOleRiittavaKassapaateEiMuutuKunOstetaanMaukas(){
        
        kassapaate.syoMaukkaasti(10);
        assertEquals(100000, kassapaate.kassassaRahaa());
        
    }
    
    @Test
    public void josKateisMaksuEiOleRiittavaPalautetaanKaikkiEdullinen(){
        
        
        assertEquals(10, kassapaate.syoEdullisesti(10));
        
    }
    
    @Test
    public void josKateisMaksuEiOleRiittavaPalautetaanKaikkiMaukas(){
        
        
        assertEquals(20, kassapaate.syoMaukkaasti(20));
        
    }
    
    @Test
    public void josKateisMaksuEiOleRiittavaMyytyjenMaaraEiNouseEdullinen(){
        kassapaate.syoEdullisesti(10);
        
        assertEquals(0,kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void josKateisMaksuEiOleRiittavaMyytyjenMaaraEiNouseMaukas(){
        kassapaate.syoMaukkaasti(10);
        
        assertEquals(0,kassapaate.maukkaitaLounaitaMyyty());
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
    
    
    @Test
    public void korttiMaksuPalauttaaTrueJosMaksuOnnistuuEdullinen(){
        
        assertEquals(true,kassapaate.syoEdullisesti(kortti));
    }
    
    @Test
    public void korttiMaksuPalauttaaTrueJosMaksuOnnistuuMaukas(){
        
        assertEquals(true,kassapaate.syoMaukkaasti(kortti));
    }
    
    @Test
    public void korttiMaksuLisaaOstettujenHintaaEdullinen(){
        
        kassapaate.syoEdullisesti(kortti);
        
        assertEquals(1,kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void korttiMaksuLisaaOstettujenHintaaMaukas(){
        
        kassapaate.syoMaukkaasti(kortti);
        
        assertEquals(1,kassapaate.maukkaitaLounaitaMyyty());
    }
    
    
    
    @Test
    public void josKortillaEiTarpeeksiRahaaKortinRahaMaaraEimuutuEdullinen(){
        Maksukortti kortti2 = new Maksukortti(10);
        kassapaate.syoEdullisesti(kortti2);
        
        assertEquals(10, kortti2.saldo());
    }
    
    @Test
    public void josKortillaEiTarpeeksiRahaaKortinRahaMaaraEimuutuMaukas(){
        Maksukortti kortti2 = new Maksukortti(10);
        kassapaate.syoMaukkaasti(kortti2);
        
        assertEquals(10, kortti2.saldo());
    }
    
    
      @Test
    public void josKortillaEiTarpeeksiRahaaPalautetaanFalseEdullinen(){
        Maksukortti kortti2 = new Maksukortti(10);
        
        
        assertEquals(false, kassapaate.syoEdullisesti(kortti2));
    }
    
      @Test
    public void josKortillaEiTarpeeksiRahaaPalautetaanFalseMaukas(){
        Maksukortti kortti2 = new Maksukortti(10);
        
        
        assertEquals(false, kassapaate.syoMaukkaasti(kortti2));
    }
    
    @Test
    public void josKortillaEiTarpeeksiRahaaMyytyjenMaaraEiMuutuEdullinen(){
         Maksukortti kortti2 = new Maksukortti(10);
         kassapaate.syoEdullisesti(kortti2);
         
         assertEquals(0,kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
     public void josKortillaEiTarpeeksiRahaaMyytyjenMaaraEiMuutuMaukas(){
         Maksukortti kortti2 = new Maksukortti(10);
         kassapaate.syoMaukkaasti(kortti2);
         
         assertEquals(0,kassapaate.maukkaitaLounaitaMyyty());
    }
     @Test
   public void edullisenOstaminenKortillaEiMuutaKassapaatetta(){
       
       kassapaate.syoEdullisesti(kortti);
       
       assertEquals(100000, kassapaate.kassassaRahaa());
       
   }
   
   @Test
   public void maukkaanOstaminenKortillaEiMuutaKassapaatetta(){
       
       kassapaate.syoMaukkaasti(kortti);
       
       assertEquals(100000, kassapaate.kassassaRahaa());
       
   }
   
   @Test
   public void kortilleRahaaLadattaessaKortinSaldoMuuttuu(){
       
       kassapaate.lataaRahaaKortille(kortti, 100);
       
       assertEquals(500,kortti.saldo());
   }
   
   @Test
   public void kortilleRahaaLadattaessaKassanSaldoMuuttuu(){
       
       kassapaate.lataaRahaaKortille(kortti, 100);
       
       assertEquals(100100,kassapaate.kassassaRahaa());
   }
   
   @Test
   public void josKortilleKoitetaanLataaNegatiivistaKortinSaldoEimuutu(){
       
       kassapaate.lataaRahaaKortille(kortti, -100);
       assertEquals(400, kortti.saldo());
   }
   
   @Test
   public void josKortilleKoitetaanLataaNegatiivistaKassapaatteenSaldoEimuutu(){
       kassapaate.lataaRahaaKortille(kortti, -100);
       assertEquals(100000, kassapaate.kassassaRahaa());
   }
   
   
    
    //TODO
   //myydyt palauttaa oikein
   
   //kateismaksuun
   //jos maksu ei ole riittävä: kassassa oleva rahamäärä ei muutu!! x?
   //kaikki rahat palautetaan vaihtorahana x!!! ja myytyjen lounaiden määrässä ei muutosta x!!
   
   
   
   
    //jos kortilla on tarpeeksi rahaa, veloitetaan summa kortilta x ja PALAUTETAAN TRUE x
    //jos kortilla ei ole tarpeeksi rahaa, kortin rahamäärä ei muutu x, myytyjen lounaiden määrä muuttumaton x ja palautetaan false x
    //kassassa oleva rahamäärä ei muutu kortilla ostettaessa x
    //kortille rahaa ladattaessa kortin saldo muuttuu x ja kassassa oleva rahamäärä kasvaa ladatulla summalla x
    
    
    
}
