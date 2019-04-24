# Arkkitehtuurikuvaus
## Sovelluslogiikka
Sovelluksen loogisen datamallin muodostavat luokat gamegrid ja user.

GameGrid sisältää kaikki peliin liittyvät toiminnot.
User luokka kuvaa käyttäjää.

Käyttöliittymän toimminnallisesta kokonaisuudesta vastaavat luokat ot2048service, sekä UserDao.

UserDao tarjoaa mm. seuraavat metodit suoraa käyttöliittymälle:
void create(User user)
Integer getHighscore(User user)
Boolean updateHighscore(User user, Int score)
User read(String username)

Näiden avulla käyttöliitymää voidaan muokata ajantasalle.

Ot2048Service tarjoaa metodit kuten:
setLoggedIn(User user)
User getLoggenIn()

Näiden avulla voidaan hallita sitä, mikä käyttäjä on kirjautunut, sekä kirjautuneen käyttäjän tietoja.



Pakkauskaavio, josta puuttuu main luokka setUpLogInUI, jolla ei ole varsinaisesti mitään muuta tehtävää, kuin avata log in näkymä, sekä luoda tietokanta juurikansioon, mikäli sitä ei ole olemassa.
<img src="https://github.com/lehtoneo/ot-harjoitustyo/blob/master/ot2048/dokumentaatio/kuvia/uusiPakkausKaavioKuva.JPG">

## Sekvenssikaavioita

### Käyttäjän luominen

Mikäli käyttäjä on syöttänyt "create a new user" -ikkunassa username kenttään hyväksyttävän käyttäjän, sekä molempiin salasanakenttiin saman salasanan, joka on hyväksyttävä, etenee sovellus seuraavalla tavalla.


<img src="https://github.com/lehtoneo/ot-harjoitustyo/blob/master/ot2048/dokumentaatio/kuvia/ohtesekvenssiuusi.JPG">

 Tässä oletetaan, että käyttäjä on syöttänyt käyttäjänimeksi "username", sekä salasanaksi "password".
 Kun käyttäjä painaa nappia submit, CreateUserController kutsuu ot2048Serviceä tarkistamaan, ovatko salasanat samoja. Koska ovat, selvitetään onko käyttäjää olemassa. Koska ei ole, luodaan metodin sisällä user olio "NewUser". Tämän jälkeen tarkistetaan User luokan metodeilla, onko käyttäjätunnus ja salasana hyväksyttäviä. Koska ovat, luodaan UserDaon avulla uusi käyttäjä sovellukseen. Tämän jälkeen ruudulle ilmestyy teksti "User created succesfully".

