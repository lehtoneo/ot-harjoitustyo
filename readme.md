
  # 2048App #
  
Sovellus on melko yksinkertainen yksinpeli. Pelissä on 4x4 kokoinen ruudukko, jonka jokaisessa "laatassa" on numero. Numeroita tulee yhdistellä siten, että samat numerot yhdistyvät toisiinsa. Pelin tavoite on muodostaa luvun 2048 arvoinen laatta. Tämän jälkeen peliä voi kuitenkin jatkaa muodostaen isompiarvoisia laattoja.
  
  ## Dokumentaatio

[Käyttöohje](https://github.com/lehtoneo/ot-harjoitustyo/blob/master/ot2048/dokumentaatio/Kayttoohje.md)

[Vaatimusmäärittely](https://github.com/lehtoneo/ot-harjoitustyo/blob/master/ot2048/dokumentaatio/Vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/lehtoneo/ot-harjoitustyo/blob/master/ot2048/dokumentaatio/Arkkitehtuurikuvaus.md)

[Testausdokumentti](https://github.com/lehtoneo/ot-harjoitustyo/blob/master/ot2048/dokumentaatio/Testausdokumentti.md)

[Työaikakirjanpito](https://github.com/lehtoneo/ot-harjoitustyo/blob/master/ot2048/dokumentaatio/tuntikirjanpito.md)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla (niitä on vasta pari)

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraportin saa auki avaamalla selaimessa tiedoston _target/site/jacoco/index.html_
