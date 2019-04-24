
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

Testit voi suorittaa komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn test jacoco:report
```

Jos ylläoleva testikattavuusraportin luonti ei onnistu jostain syystä, voi yrittää ensin cleanata projektin eli antaa seuraavat komennot (samassa järjestyksessä)

```
mvn clean
mvn test jacoco:report
```

Testikattavuusraportin tulokset saa auki avaamalla selaimella tiedoston target/site/jacoco/index.html

### Checkstyle

Checkstylen havaitsemien virheiden määrä saadaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mikäli haluaa tutkia projektin mahdollisten checkstyle virheiden sijaintia ja/tai tyyppiä, voi avata  selaimella tiedoston _target/site/checkstyle.html_

### Jarin generointi

```
mvn package
```
Komento luo hakemistoon target jar-tiedoston ot2048-1.0-SNAPSHOT.jar

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto _target/site/apidocs/index.html_
