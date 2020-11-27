# Gruppe prosjekt - Software engineering - HIOF

#### Medlemmer: Walter, Kristoffer.S, Kristoffer.B
#### År: 2020
### Roller:
Webdev (design, HTML, CSS, layouts) | Backend | Testing | Dokumentasjon |
------------ | ------------- | ------------- | ------------- |
Walter | Kristoffer.S, Kristoffer.B | Kristoffer.S, Kristoffer.B, Walter | Walter

# Problemstilling
Vi fikk forklart at veldig mange selskap i dag. ser etter nye markeder å invistere i. slik som parkeringsplasser. så i vår setting. ønsker en oppstartsbedrift å få lagd en løsning hvor aktører kan registrere tilgjengelige plasser til utleie. mens en bruker kan se, reservere, og betale for disse plassene i den tiden de trenger.

vi ble også bedt om å dokumentere eksterne avhengigheter.

Vi skulle da lage kjernesystemet for dette prosjektet, med funskjonene som er påkrevd for at kunden får det systemet de ønsker. Vi lager da en prototype, for å vise frem / illustrere hva vi mener er viktigst i prototypen. disse egenskapene skal det også testes, for å vise at de fungeres. så det skal da lages tester.

Testene skal skje automatisk, og de skal teste funskjonalliteten, og vise hvordan eventuelle feil blir håndtert, og hva som skjer om ting går galt.

# Testing
link til et eksempel-bilde, om du ønsker å teste ut å lage en annonse.
https://i.imgur.com/nghL3nh.png

# Krav 
viktighet (“T-Shirt sizing”-estimeringsmetoden)

- krav 1
- krav 2
- krav 3
- krav 4
- krav 5
- krav 6
- krav 7
- krav 8

# Dokumentasjon:
Under vill du finne dokumentasjon for bruk av appen/prototypen. Hvordan å navigere appen/prototypen, og hva appen/prototypen trenger for å kjøres.

## Dependencies
ting nødvendig for å bygge

Nettleser | Java JRE | OS | Annet | Platform | gradle | Javalin
------------ | ------------- | ------------- | -------------| -------------| -------------| -------------|
Må strøtte CSS webkits (Chromium based anbefalt) | version 13 eller nyere | linux, windows, MacOS | internet tilgang & git | PC / Computer | 6.2 eller nyere | 3.7.0 eller nyere

## Installasjon / kjøring
her går vi utifra at du har lest Dependencies.


### Nedlastning
Start med å klone hele prosjektet via git til din lokale maskin.
dette gjør du ved å bruke enten en git klient som github/desktop, eller via en terminal.

#### Ved bruk av terminal
Åpne en terminal og skriv inn følgende;
```
git clone https://github.com/Bass4Nation/softwareProject.git
```

#### ved bruk av github desktop
klikk på "fil", og så velg " clone repository

![](https://i.imgur.com/6nNWD85.png)

da skal et vindu poppe opp som vist under. velg "URL" tabben.

![](https://i.imgur.com/8Kc7ieN.png)

og her limer du inn linken til dette repoet;
```
https://github.com/Bass4Nation/softwareProject.git
```

velg en plass du ønsker at det skal lagres på. ved å trykke på "choose" knappen. og deretter naviger dit.

### Åpne prosjektet i IntelliJ IDEA

![](https://i.imgur.com/vNxJ1sq.png)

når du åpner intellij får du valget mellom "create new project", "import project", "open", "get from version crontroll".

her velger du "Open" og naviget til der du lagret repository'et. deretter naviger til mappen "findParking" som vist på bildet under.

![](https://i.imgur.com/4i4peav.png)

### Kjøre prosjektet
når prosjektet har åpnet. kan det hende at intelliJ vill updatere gradle for deg. da vill du få en popup som forteller deg dette. etter det, kan du trykke Run ved å klikke på den grønne knappen som vist på bildet

![](https://i.imgur.com/le7yH71.png)

dersom du ikke får opp en konfigurasjon (der det står "APPLICATION" på bildet over). så klikk på den dropdown pilen og trykk på "Edit Configurations..." som vist under.

![](https://i.imgur.com/FBIIIl4.png)

deretter skal et vindu poppe opp, hvor du kan fylle ut informasjonen så den ser lik ut som på bildet under og deretter trykke "apply", så "ok" , og så endelig på "play" knappen igjen.

![](https://i.imgur.com/FBIIIl4.png)


Når du da kjører prosjektet vill en "run prompt" dukke opp nederst i IntelliJ. det vill se ut som på bildet under.

![](https://i.imgur.com/pdqjtfE.png)

her får du en link til "http://localhost:7009/" som du kan trykke på. den vill åpne din nettleser og så kan du bruke siden.



# Bruk
I prototypen er man "logget inn" som admin. dvs at man har fullstendige rettigheter. Siden dette er en Java webapp, Går vi utifra at eieren ville hostet dette ved bruk av deres egne resusjer. men for prototypen bruker vi Javalin via IntelliJ. mer info om hva som er nødvendig for å kjøre finner du i "Dependencies" delen av dokumentasjonen.

Slik vi tolket oppgaven. kom vi frem til at det viktigste av funskjonallitet var å kunne registrere en plass, bestille en plass, og se alle tilgjengelige plasser. 

Vi bruker Vue, Javalin og Java i backend. så funskjonalliteten skjer via Java, blir vist frem i Vue, og blir kjørt/hostet med Javalin i prototypen. 

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

I dette skjemaet vill du måtte fylle ut Tittel, velge fylke (prototypen har kun to fylker, så her har du valget mellom Oslo eller Viken), fylle inn adresse, sted/by, hva du ønsker å ta betalt for plassen din pr dag, bildets URL, og en liten beskrivelse av plassen

## Kjente problemer
#### Adblockere
Adblockere kan fjerne elementer som ikke skal fjernes.
ukjent hvorfor, men vi tror det er fordi java og vue sammen, skjuler / modifiserer html dokumentene. og at dette blir plukket opp som mulige inserted ads.

**Så vi anbefaler å skru av adblockere når man kjører siden, for å unngå dette.**

#### Sortering etter by
![](https://i.imgur.com/uRNBX7a.png)

Inne på siden hvor man får listet annonser for et valgt fylke. har vi laget ett slags kontrollpanel. Som vist over, har man valget mellom å trykke "tilbake" (tar deg tilbake til siden du var på sist), og en dropdown liste som får inn dynamisk alle steder/byer innenfor det fylket man har valgt utifra hva som ligger i dataene for annonsene i fylket. i denne var det meningen å kjøre en sortering på det som ble valgt i den dropdown-listen. med en reset knapp ved siden av.

Vi hadde planer om å lage json skriveren vår med en sorterings metode inni seg. denne metoden skulle også få tatt et parameter. dette parameteret skulle da bli hva man sorterte etter. og skulle da bli koblet til value i hver option tag i dropdown-listen.

så dette er logikken vi ville ha brukt.

#### Reservering / bestilling av en plass
Vi har for øyeblikket ikke fungerene reservasjon. litt fordi vi ikke implimenterer noe betalingsmåte. vi så for oss at dette burde kobles til at om en bruker reserverer en annonse, skal API'ets json fil endre en boolean entry kalt "status" til fra 0 til 1. dette kan også brukes i en sorterings dropdown liste også i fremtiden. vi gjorde ikke dette fordi vi holdt creator metoden såppas simpel. men det er mulig og utvide til dette i en senere tid.

Ved klikk på bestillingsknapp nå, blir man tatt til en side som takker for kjøpet, og en knapp som tar brukeren tilbake til forsiden. (Vist i "Bruk" delen av dokumentasjonen).
