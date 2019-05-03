# Arkkitehtuurikuvaus
## Käyttöliittymä
Käyttöliittymässä on neljä erilaista näkymää.
- Kirjautumisnäkymä
- Pelinäkymä
- Uuden käyttäjän luomisnäkymä
- Top 3 highscoret

näykmät ovat toteutettu fxml tiedostoina, jotka avataan FXMLLoaderin avulla niihin siirryttäessä. Jokaisen käyttöliittymäkomponentin toiminnallisuudesta vastaa komponenttien omat eventHandler metodit, jotka sijaitsevat Controller luokissa. EventHandlerit sitten kutsuvat sopivalla tavalla sovelluslogiikan (sekä muita käyttöliittymän) metodeja. 

## Sovelluslogiikka
Sovelluksen loogisen datamallin muodostavat luokat gamegrid ja user. GameGrid sisältää kaikki peliin liittyvät toiminnot. User luokka kuvaa käyttäjää.


Luokat ot2048service, gamegrid sekä UserDao ovat vastuussa toiminnallisesta kokonaisuudesta.
UserDao tarjoaa mm. seuraavat metodit suoraan käyttöliittymälle:

- void create(User user)
- Integer getHighscore(User user)
- Boolean updateHighscore(User user, Int score)
- User read(String username)



Ot2048Service tarjoaa metodit kuten:
- setLoggedIn(User user)
- User getLoggenIn()
- boolean isPasswordCorrect()

GameGridin metodeja kuten:
- moveRight()
- moveUp()
- moveDown()
- moveLeft()

käytetään pelin toiminnallisuuteen.








Pakkauskaavio, josta puuttuu main luokka setUpLogInUI, jolla ei ole varsinaisesti mitään muuta tehtävää, kuin avata log in näkymä, sekä luoda tietokanta juurikansioon, mikäli sitä ei ole olemassa. Pakkauskaaviosta puuttuuu myös HighScoreController -luokka, jonka tehtävänä on ainoastaan avata highscore näkymä.
<img src="https://github.com/lehtoneo/ot-harjoitustyo/blob/master/ot2048/dokumentaatio/kuvia/uusiPakkausKaavioKuva.JPG">

## Päätoiminnallisuudet

### Käyttäjän luominen

Mikäli käyttäjä on syöttänyt "create a new user" -ikkunassa username kenttään hyväksyttävän käyttäjän, sekä molempiin salasanakenttiin saman salasanan, joka on hyväksyttävä, etenee sovellus seuraavalla tavalla.


<img src="https://github.com/lehtoneo/ot-harjoitustyo/blob/master/ot2048/dokumentaatio/kuvia/ohtesekvenssiuusi.JPG">

 Tässä oletetaan, että käyttäjä on syöttänyt käyttäjänimeksi "username", sekä salasanaksi "password".
 Kun käyttäjä painaa nappia submit, CreateUserController kutsuu ot2048Serviceä tarkistamaan, ovatko salasanat samoja. Koska ovat, selvitetään onko käyttäjää olemassa. Koska ei ole, luodaan metodin sisällä user olio "NewUser". Tämän jälkeen tarkistetaan User luokan metodeilla, onko käyttäjätunnus ja salasana hyväksyttäviä. Koska ovat, luodaan UserDaon avulla uusi käyttäjä sovellukseen. Tämän jälkeen suljetaan create user screen.

### Kirjautuminen käyttäjätunnuksilla

Mikäli käyttäjä on luonut itselleen tunnuksen, sekä syöttänyt tunnuksen oikein log in screenin kenttiin, etenee sovellus seuraavalla tavalla.

<img src="https://github.com/lehtoneo/ot-harjoitustyo/blob/master/ot2048/dokumentaatio/kuvia/logInSekvenssi.JPG">

### Pelin toiminta

Itse peli toimii siten, että sen käyttöliittymän pohjalla on 4x4 kokoinen grid-olio, jonka sisälle on scene builderin avulla alustettu jokaiseen gridin alkioon label, jonka alkutekstinä on 0. Kun tiedosto game.fxml avataan, GameController luokan initialize() metodia kutsutaan. Tämä  initialize() -metodi sitten alustaa uuden GameGrid-olion, jonka jälkeen grid-olion sisällä olevat labelit alustetaan vastaamaan GameGrid olion alkioita (eli siis se taulukon kohta, joka GameGrid oliossa on 1, on nyt myös grid-olion labeleissa numero 1 ja loput nollia). Tämän jälkeen käyttäjältä jäädään odottamaan jonkun napin a, s, d tai w painallusta. Kun käyttäjä painaa esimerkiksi nappia "W", keyPressed(KeyEvent event) metodi tunnistaa tämän ja kutsuu GameGridin metodia moveUp(). Tämän jälkeen keyPressed(KeyEvent event) kutsuu oman luokkansa metodia update(), joka päivittää grid-olion sisällä olevat labelit vastaamaan GameGrid-olion numeroarvoja. 

### muita toiminnallisuuksia

Muut toiminnallisuudet, eli erilaisten nappien painallukset noudattaa samanlaista kaavaa: eventHandler -metodeita kutsutaan, jotka sitten sopivalla tavalla kutsuvat ot2048Servicen, GameGridin ja/tai UserDao luokkien metodeita. Tämän jälkeen käyttöliittymää päivitetään näyttämään sovelluslogiikan tekemät muutokset, jos tarvetta.

## Tietojen tallennus paikalliseen tietokantaan
com.mycompany.ot2048.dao pakkauksesta löytyvä luokka UserDao huolehtii käyttäjän tietojen tallentamisesta tietokantaan.

### Tietokanta

Sovelluksessa käyttäjien tiedot, eli käyttäjänimi, salasana sekä highscore tallennetaan yhteen tietokantaan, nimeltään kayttajatJaHighscoret. Tietokannassa on yksi taulu, joka on seuraavanlainen:
- [User|id;username;password;highscore]

## Rakenteen heikkoudet

### Gamegrid-luokka

GameGrid -luokassa on hieman copypasten tyyppistä koodia, joka olisi tietenkin hyvä saada pois. Tyyli, jolla pelin toiminnallisuus eli numeroiden liikuttelu eri suuntiin on toteutettu, on kuitenkin sellainen, että samanlaista koodia syntyy väkisinkin aika paljon. Koodi on lisäksi melko kryptistä, joka vaikeuttaa tietenkin sen lukemista.

### Pelin toteutus

Tyyli, jolla itse peli/pelaaminen on toteutettu (ks. pelin toiminta), on sellainen, joka ei hirveästi mahdollista jatkokehittämistä kuten animaatioiden lisäämistä. 

