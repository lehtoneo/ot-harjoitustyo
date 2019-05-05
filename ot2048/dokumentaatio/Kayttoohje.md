# Käyttöohje

### Lataaminen

Lataa sovellus painamalla linkkiä [ot2048.jar](https://github.com/lehtoneo/ot-harjoitustyo/releases/download/Viikko7/ot2048.jar)

Sovellus kannattaa siirtää pois ladatuista tiedostoista, sillä jos sovellus sijaitsee ladatuissa tiedostoissa, se ei välttämättä toimi halutullu tavalla.

### Käynnistys

Sovelluksen saa käynnistettyä komennolla   java -jar ot2048.jar

### Kirjautuminen
Sovellus aukeaa tällä näkymällä.


<img src="https://github.com/lehtoneo/ot-harjoitustyo/blob/master/ot2048/dokumentaatio/kuvia/logInKuva.JPG">


Mikäli käyttäjä on luotu, voi tunnukset antaa kenttiin username ja password. Klikkaamalla log in pääsee peliin omalla käyttäjällään.
Log in as a quest napilla pääsee pelaamaan questina. Samana questina ei voi kuitenkaan enää kirjautua uusiksi.
Create user napilla pääsee luomaan uuden käyttäjätunnuksen.
### Uuden käyttäjän luominen

Mikäli log in ruudussa painaa create a new user nappia, pääsee tähän näkymään.

<img src="https://github.com/lehtoneo/ot-harjoitustyo/blob/master/ot2048/dokumentaatio/kuvia/createUserKuva.JPG">

Tästä näkymästä voi luoda uuden käyttäjän, antamalla ensin käyttäjätunnuksen, jonka jälkeen salasanan kahteen otteeseen.
Painamalla submit, käyttäjä luodaan, mikäli vain mahdollista ja näkymä suljetaan.

### Pelaaminen ja tallentaminen

Kun on joko kirjautunut omilla tunnuksillaan tai questina peliin, pääsee peli näkymään, joka näyttää tältä:

<img src="https://github.com/lehtoneo/ot-harjoitustyo/blob/master/ot2048/dokumentaatio/kuvia/ohtePeliKuva.JPG">

Peliä voi pelata näppäimillä a, s, w ja d. A liikuttaa ruudukkoa vasemmalle, s alas, d oikealle ja w ylös. Mikäli haluaa tallentaa omat pisteensä, voi painaa save score nappia. Alhaalla näkyy tämän hetkinen tallennettu highscore. Quit game napilla poistutaan pelistä (tallentamatta) ja avataan taas log in screen. Painamalla new game nappia, peli aloitetaan alusta (tallentamatta).

### Highscoret

<img src="https://github.com/lehtoneo/ot-harjoitustyo/blob/master/ot2048/dokumentaatio/kuvia/highScoreKuva.JPG">

Tämän ikkunan saa auki painamalla peliruudulla olevaa nappia "View highscores".
