
<html>
<head>
  <meta charset="utf-8">
  <title>Software Oppgave</title>
  <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i,700,700i|Ubuntu:300,400,500,700" rel="stylesheet">
  <link rel="stylesheet" href="media/stil/master.css">
  <script src="media/js/temp.js"></script>
</head>


<body>
<header>
  <img src="https://itstud.hiof.no/~kristoss/secondYear/finnParking/views/media/logo.png" alt="logo" id="logo"/>

</header>
<main>
  <section id="postHeader">
    <h2>Annonse Tittel</h2>

  </section>
  <section id="leftBlock">
    <img src="https://itstud.hiof.no/~kristoss/secondYear/finnParking/views/media/image-placeholder.png" alt="placeholder image">
  </section>
  <section id="rightBlock">
    <p class="infotittel">Adress:</p><p id="adress">adresseveien 123 Stedestad</p>
    <br>
    <p class="infotittel">Utleier:</p><p id="name"> Navn Navnesen</p>
    <br>
    <p class="infotittel">pris pr time:</p><p id="price"> <p> 20 kr/t </p>
    <br>
    <p class="infotittel"> Informasjon & beskrivelse:</p>
    <p id="infoblock">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
  </section>
  <section id="buttonBlock">
    <button class="btn" type="button" id="buyBtn">BESTILL</button>
    <button class="btn" type="button" id="picBtn">SE PÅ KART</button>
  </section>

</main>

</body>
</html>

<script>
Vue.component("annonse", {
  template: "#annonse",
  data: () => ({
    observations: [],
  }),
  created() {
    fetch("/api/observations")
        .then(res => res.json())
        .then(res => {
          this.observations = res;
        })
        .catch(() => alert("Error while fetching observations"));
  }
});
</script>

<script lang="js">

window.onload = oppstart;

function oppstart() {
  document.getElementById("buyBtn").onclick = buyTrykk;
  document.getElementById("picBtn").onclick = mapTrykk;

  function buyTrykk() {
    alert('Du har bestillt plass.')
  }

  function mapTrykk() {
    alert('Bytter fra bilde, til kart')
  }
}

</script>
<style lang="css">
* {
  margin: 0;
  padding: 0;
}

body {
  background-color: #1c1c1c;
  background-image: url(https://itstud.hiof.no/~kristoss/secondYear/finnParking/views/media/background.png);
  background-attachment: fixed;
  background-repeat: no-repeat;
  background-size: cover;
}

main {
  margin: auto;
  margin-top: 100px;
  min-height: 40em;
  height: auto;
  width: 80em;
  background-color: #2e2e2e;
  border-radius: 5px;
  border: solid 1px #404040;
  -webkit-box-shadow: 0px 0px 33px -3px rgba(0, 0, 0, 0.48);
  -moz-box-shadow: 0px 0px 33px -3px rgba(0, 0, 0, 0.48);
  box-shadow: 0px 0px 33px -3px rgba(0, 0, 0, 0.48);
}

header {
  text-align: center;
  margin: auto;
  margin-top: 10px;
  height: auto;
  width: 90%;
  background-color: #2e2e2e;
  border-radius: 5px;
  border: solid 1px #404040;
  -webkit-box-shadow: 0px 0px 33px -3px rgba(0, 0, 0, 0.48);
  -moz-box-shadow: 0px 0px 33px -3px rgba(0, 0, 0, 0.48);
  box-shadow: 0px 0px 33px -3px rgba(0, 0, 0, 0.48);
  padding: 5px;
}

#logo {
  display: inline-block;

}

.headTitle {
  display: inline-block;
}

#postHeader {
  font-family: Ubuntu !important;
  color: #d4ffbf;
  text-align: center;
  border-bottom: solid 2px #d4ffbf;
  padding-bottom: 5px;
  clear: both;
  font-size: 1.5em;
  margin-bottom: 15px;
}

#leftBlock {
  padding: 15px;
  width: 38em;
  height: 40em;
  float: left;
  overflow: hidden;
}

#rightBlock {
  padding: 15px;
  width: 35em;
  min-height: 20em;
  height: auto;
  float: right;
}

#buttonBlock {
  width: 35em;
  min-height: 3em;
  float: right;
  clear: right;
  margin: 20px;
  text-align: left;
  margin-bottom: 5em;
}

.btn {
  font-family: Ubuntu !important;
  font-weight: bold;
  background-color: #1b1b1b;
  padding: 10px;
  color: white;
  border: solid #d4ffbf 3px;
  cursor: pointer;
  margin-right: 3em;
  width: 10em;
  -webkit-box-shadow: 0px 0px 3px 3px rgba(0, 0, 0, 0.35);
  -moz-box-shadow: 0px 0px 3px 3px rgba(0, 0, 0, 0.35);
  box-shadow: 0px 0px 3px 3px rgba(0, 0, 0, 0.35);
}

.btn:hover {
  transition: .5s;
  background-color: #d4ffbf;
  padding: 10px;
  color: #1b1b1b;
  border: solid #d4ffbf 3px;
}

.infotittel {
  color: #d4ffbf;
  font-weight: bold;
  font-family: Ubuntu !important;
}

section p {
  color: white;
  font-family: helvetica, sans-serif;
}

::-webkit-scrollbar {
  width: 10px;
}

/* Track */
::-webkit-scrollbar-track {
  border-radius: 10px;
  background: rgba(0, 0, 0, 0.1);
  border: 1px solid #ccc;
}

/* Handle */
::-webkit-scrollbar-thumb {
  border-radius: 10px;
  -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, .3);
  background-color: #696969;
}

/* Handle on hover */
::-webkit-scrollbar-thumb:hover {
  background: #a1a1a1;
}

</style>