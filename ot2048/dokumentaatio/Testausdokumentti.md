# Testausdokumentti


### sovelluslogiikan testaus

Sovelluslogiikkaa eli domain pakkauksen luokkia on testattu yksikkötestein laajasti, sekä hieman integraatiotesteillä. Testit löytyvät tarkemmin [täältä](https://github.com/lehtoneo/ot-harjoitustyo/tree/master/ot2048/src/test/java/domain).

User luokan testit ovat yksikkötestejä, jotka kattavat laajasti kaikki luokan metodit.

GameGrid luokan metodit ovat yksikkötestejä, sekä melko toisteisia johtuen luokan rakenteesta sekä toteutuksesta.

Ot2048ServiceTest luokan testit käyttävät (valitettavasti) samaa tietokantaa, kuin sovellus itse. Eli mitään testitietokantaa ei ole.

### UserDaon testaus

Userdaota testataan luomalla väliaikaisia käyttäjiä sovelluksen tietokantaan, ja sitä kautta tutkimalla, että luokan metodit toimivat halutulla tavalla. Ajanpuutteen vuoksi testitietokantaa ei ole tehty, joka on tietenkin hieman ongelmallista. UserDaon testit löytyvät [täältä](https://github.com/lehtoneo/ot-harjoitustyo/blob/master/ot2048/src/test/java/dao/UserDaoTest.java).


### Testikattavuus

<img src="https://github.com/lehtoneo/ot-harjoitustyo/blob/master/ot2048/dokumentaatio/kuvia/testiKattavuus.JPG" width = "900">
