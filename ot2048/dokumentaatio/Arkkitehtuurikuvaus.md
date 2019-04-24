# Arkkitehtuurikuvaus
## Pakkauskaavio
<img src="https://github.com/lehtoneo/ot-harjoitustyo/blob/master/ot2048/dokumentaatio/kuvia/otPakkausKuva.jpg">

## Sekvenssikaavioita

### Käyttäjän luominen

Mikäli käyttäjä on syöttänyt "create a new user" -ikkunassa username kenttään hyväksyttävän käyttäjän, sekä molempiin salasanakenttiin saman salasanan, joka on hyväksyttävä, etenee sovellus seuraavalla tavalla.


<img src="https://github.com/lehtoneo/ot-harjoitustyo/blob/master/ot2048/dokumentaatio/kuvia/ohtesekvenssiuusi.JPG">

 Tässä oletetaan, että käyttäjä on syöttänyt käyttäjänimeksi "username", sekä salasanaksi "password".
 Kun käyttäjä painaa nappia submit, CreateUserController kutsuu ot2048Serviceä tarkistamaan, ovatko salasanat samoja. Koska ovat, selvitetään onko käyttäjää olemassa. Koska ei ole, luodaan metodin sisällä user olio "NewUser". Tämän jälkeen tarkistetaan User luokan metodeilla, onko käyttäjätunnus ja salasana hyväksyttäviä. Koska ovat, luodaan UserDaon avulla uusi käyttäjä sovellukseen. Tämän jälkeen ruudulle ilmestyy teksti "User created succesfully".

