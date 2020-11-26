# Gruppe prosjekt - Software engineering - HIOF

#### Medlemmer: Walter, Kristoffer.S, Kristoffer.B
#### År: 2020
### Roller:
Webdev (design, HTML, CSS, layouts) | Backend | Testing | Dokumentasjon |
------------ | ------------- | ------------- | ------------- |
Walter | Kristoffer.S, Kristoffer.B | Kristoffer.S, Kristoffer.B, Walter | Walter

# Dokumentasjon:
Under vill du finne dokumentasjon for bruk av appen/prototypen. Hvordan å navigere appen/prototypen, og hva appen/prototypen trenger for å kjøres
# Bruk
I prototypen er man "logget inn" som admin. dvs at man har fullstendige rettigheter. Siden dette er en Java webapp, Går vi utifra at eieren ville hostet dette ved bruk av deres egne resusjer. men for prototypen bruker vi Javalin via IntelliJ. mer info om hva som er nødvendig for å kjøre finner du i "Dependencies" delen av dokumentasjonen.

### Velg /sorter etter fylke
![](https://i.imgur.com/xxW5sj8.png)

for vise annonser fra ønsket fylke. Klikker man på det fylket man ønsker å se annonser fra. siden vill så sortere basert på brukerens valg. og vise riktige annonser.

### Vis detaljer fra en annonse
![](https://i.imgur.com/FpYzfI0.png)

får å lese mer om en annonse, klikker du på annonsen i listen. så blir du tatt til annonsens detaljer. Under er ett eksempel.

![](https://i.imgur.com/LTLYVVw.png)

### Bestille en annonse
![](https://i.imgur.com/MfUEobj.png)

Når du har funnet en plass du liker. kan du velge å trykke "bestill". dette vill i prototypen, ta deg videre til en "takk for ditt kjøp" side. i prototypen skipper vi rett og slett betalingsmotoder. ettersom den løsningen vill være opp til eieren av siden

![](https://i.imgur.com/Fkifynt.png)

### Min side
![valg av bilde](https://i.imgur.com/wy7JoYC.png)

for å navigere til din egen brusers side. trykker man på "min side" knappen i headeren på siden. den vill være tilgjengelig her, uansett hvor du er navigert på siden.

under kan du se hvordan "min side" ser ut.

![](https://i.imgur.com/obBr90C.png)

### Lage annonse
![](https://i.imgur.com/2J2EudS.png)

som vist over. Må du først gå opp i headeren og trykke "ny annonse" knappen. Dette vil ta deg til skjemaet for utfylling av annonsens detaljer.

![](https://i.imgur.com/qn1ZR0A.png)

I dette skjemaet vill du måtte fylle ut Tittel, velge fylke (prototypen har kunn to fylker, så her har du valget mellomn Oslo eller Viken), fylle inn andresse, sted/by, hva du ønsker å ta betalt for plassen din pr dag, bildets URL, og en liten beskrivelse av plassen


## Dependencies
ting nødvendig for å bygge

Nettleser | Java JRE | OS | Annet | Platform
------------ | ------------- | ------------- | -------------| -------------|
Må strøtte CSS webkits (Chromium based anbefalt) | version 13 eller nyere | linux, windows, MacOS | Må ha internet (ikke nødvendig for prototypen) | PC / Computer

## Kjente problemer
Adblockere kan fjerne elementer som ikke skal fjernes.
ukjent hvorfor, men vi tror det er fordi java og vue sammen, skjuler / modifiserer html dokumentene. og at dette blir plukket opp som mulige inserted ads.

**Så vi anbefaler å skru av adblockere når man kjører siden, for å unngå dette.**
