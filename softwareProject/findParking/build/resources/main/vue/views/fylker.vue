<template id="fylket">
  <article>
  <section>
    <ul id="wrapper">
      <li v-for="fylke in sted">
        <a v-if="fylke" :href="`/find-parking/${fylke.name}/`">

          <section  id="fylkebox">
            {{console.log(fylke.name)}}

            <section>
              <h2>{{fylke.name}}</h2>
              <img  v-if="fylke.pictureUrl" class="fylkebilde" v-bind:src="fylke.pictureUrl">
            </section>
          </section>

        </a>
      </li>
    </ul>
  </section>
  </article>

</template>

<script>
Vue.component("fylker", {
  template: "#fylket",
  data: () => ({
    sted: [],
  }),
  created() {
    fetch("/api/find-parking")
        .then(res => res.json())
        .then(res => {
          this.sted = res;
        })
        .catch(() => alert("Error while fetching planetsystems"));
  }
});

</script>


<style lang="css">
  * {
    margin: 0;
    padding: 0;
    font-family: Helvetica, sans-serif;
    list-style-type: none;
  }
  body {
    background-color: #494949;
    background-image: url(https://itstud.hiof.no/~kristoss/secondYear/finnParking/views/media/background.png);
    background-attachment: fixed;
    background-repeat: no-repeat;
    background-size: cover;
    text-decoration: none;
    padding-bottom: 3em;
  }


  .single-annonse-container{
    overflow: hidden;
    color: white;
    text-align: Left;
    margin-bottom: 5em;
    background-color: #2e2e2e;
    border-radius: 5px;
    border: solid 1px #404040;
    padding-bottom: 1em;
    -webkit-box-shadow: 0px 0px 33px -3px rgba(0, 0, 0, 0.48);
    -moz-box-shadow: 0px 0px 33px -3px rgba(0, 0, 0, 0.48);
    box-shadow: 0px 0px 33px -3px rgba(0, 0, 0, 0.48);

  }
  .single-annonse-container:hover{
    background-color: #424242cc;
    transition: 1s;
  }
  .single-annonse-container img{
    max-width: 38em;
    transition: transform .2s
  }

  .single-annonse-container img:hover{
    transform: scale(1.5)
  }

  main {
    margin: auto;
    margin-top: 100px;
    min-height: 40em;
    height: auto;
    width: 80em;
  }

  header {
    text-align: center;
    margin: auto;
    margin-top: 10px;
    height: auto;
    width: 93.5%;
    background-color: #2e2e2edc;
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
    height: 20em;
    float: left;
    overflow: hidden;
  }
  #bildeBlock {
    padding: 15px;
    width: 38em;
    height: 30em;
    float: left;
    overflow: hidden;
  }

  #bildeBlock img{
  max-width: 26em;
  }

  #rightBlock {
    padding: 15px;
    width: 35em;
    min-height: 10em;
    height: auto;
    float: right;
  }

  #rightBlock h2{
    font-size: 2em;
    color: #57b962;
    margin-bottom: 2em;
  }

  #buttonBlock {
    text-align: center;
    width: 35em;
    min-height: 3em;
    float: right;
    clear: right;
    margin: 20px;
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
    width: 14em;
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
    font-size: 1.2em;
  }

  #adress{
    display: inline-block;
    margin-bottom: 2em;
  }

  #sted{
    display: inline-block;
    margin-bottom: 2em;
  }

  #adressefelt{
    display: inline-block;
    font-weight: 600;
    margin-right: 1em;
  }
  #stedfelt{
    display: inline-block;
    font-weight: 600;
    margin-right: 1em;
  }


  ::-webkit-scrollbar {
    width: 10px;
  }
  /* Track */
  ::-webkit-scrollbar-track {
    border-radius: 10px;
    background: rgba(0, 0, 0, 0.1);
    border: 1px solid rgb(31, 31, 31);
  }
  /* Handle */
  ::-webkit-scrollbar-thumb {
    border-radius: 10px;
    -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
    background-color: #696969;
  }
  /* Handle on hover */
  ::-webkit-scrollbar-thumb:hover {
    background: #a1a1a1;
  }
  .inputdata{
    font-weight: lighter!important;
    font-family: Arial;
  }

  footer{
    text-align: center;
    color: #89a67d;
    margin: auto;
    height: 3em;
    width: 90%;
    background-color: #2e2e2edc;
    border-radius: 5px;
    border: solid 1px #404040;
    -webkit-box-shadow: 0px 0px 33px -3px rgba(0, 0, 0, 0.48);
    -moz-box-shadow: 0px 0px 33px -3px rgba(0, 0, 0, 0.48);
    box-shadow: 0px 0px 33px -3px rgba(0, 0, 0, 0.48);
    padding: 10px;
  }
  #brukernavn{
    display: inline-block;
  }
  #navninput{
    display: inline-block;
  }

  #status{
    display: inline-block;
  }
  #statusinput{
    display: inline-block;
  }
  #fylkebox{
    width: 30em;
    padding: 1.5em;
    text-align: center;
    overflow: hidden;
    color: white;
    text-align: center;
    margin-bottom: 5em;
    background-color: #2e2e2e;
    border-radius: 5px;
    border: solid 1px #404040;
    padding-bottom: 1.5em;
    -webkit-box-shadow: 0px 0px 33px -3px rgba(0, 0, 0, 0.48);
    -moz-box-shadow: 0px 0px 33px -3px rgba(0, 0, 0, 0.48);
    box-shadow: 0px 0px 33px -3px rgba(0, 0, 0, 0.48);
  }

  #fylkebox img{
    max-height: 20em;
  }

  #fylkebox h2{
    font-size: 2.5em;
    color: #d4ffbf;
    text-decoration: none;
  }

  #fylkebox:hover{
    background-color: #424242cc;
    transition: 1s;
  }

  #wrapper{
    display: flex;
    justify-content: space-between;
  }

  #stedsorter{
    display: flex;
    color: white;
    text-align: center;
    margin: auto;
    width: 30em;
    margin-bottom: 5em;
    background-color: #2e2e2e;
    border-radius: 5px;
    border: solid 1px #404040;
    padding: 1.5em;
    -webkit-box-shadow: 0px 0px 33px -3px rgba(0, 0, 0, 0.48);
    -moz-box-shadow: 0px 0px 33px -3px rgba(0, 0, 0, 0.48);
    box-shadow: 0px 0px 33px -3px rgba(0, 0, 0, 0.48);
  }

  #steder{
    font-family: Ubuntu !important;
    font-weight: bold;
    background-color: #1b1b1b;
    padding: 10px;
    color: white;
    border: solid #d4ffbf 3px;
    cursor: pointer;
    width: 17em;
  }

  #valg{
    padding: 1.5em!important;
    margin-bottom: 2em;
  }

  .btn2 {
    font-family: Ubuntu !important;
    text-decoration: none;
    font-weight: bold;
    background-color: #1b1b1b;
    padding: 10px;
    color: white;
    border: solid #d4ffbf 3px;
    cursor: pointer;
    margin-right: 2em;
    width: 7em;
    -webkit-box-shadow: 0px 0px 3px 3px rgba(0, 0, 0, 0.35);
    -moz-box-shadow: 0px 0px 3px 3px rgba(0, 0, 0, 0.35);
    box-shadow: 0px 0px 3px 3px rgba(0, 0, 0, 0.35);
  }
  .btn2:hover {
    transition: .5s;
    background-color: #d4ffbf;
    padding: 10px;
    color: #1b1b1b;
    border: solid #d4ffbf 3px;
  }

  .btn3 {
    font-family: Ubuntu !important;
    text-decoration: none;
    font-weight: bold;
    background-color: #1b1b1b;
    padding: 10px;
    color: white;
    border: solid #d4ffbf 3px;
    cursor: pointer;
    margin-right: 2em;
    margin-left: 2em;
    width: 7em;
    -webkit-box-shadow: 0px 0px 3px 3px rgba(0, 0, 0, 0.35);
    -moz-box-shadow: 0px 0px 3px 3px rgba(0, 0, 0, 0.35);
    box-shadow: 0px 0px 3px 3px rgba(0, 0, 0, 0.35);
  }
  .btn3:hover {
    transition: .5s;
    background-color: #d4ffbf;
    padding: 10px;
    color: #1b1b1b;
    border: solid #d4ffbf 3px;
  }

  .beskrivelsebox{
    background-color: #1b1b1b;
    padding: 10px;
    color: white;
    border: solid #d4ffbf 3px;
    width: 37em;
    max-width: 1050px;
    -webkit-box-shadow: 0px 0px 3px 3px rgba(0, 0, 0, 0.35);
    -moz-box-shadow: 0px 0px 3px 3px rgba(0, 0, 0, 0.35);
    box-shadow: 0px 0px 3px 3px rgba(0, 0, 0, 0.35);
    margin-bottom: 3em;
  }

  #input{
    text-align: center;
  }
  .textbox{
    background-color: #1b1b1b;
    padding: 10px;
    color: white;
    border: solid #d4ffbf 3px;
    width: 37em;
    -webkit-box-shadow: 0px 0px 3px 3px rgba(0, 0, 0, 0.35);
    -moz-box-shadow: 0px 0px 3px 3px rgba(0, 0, 0, 0.35);
    box-shadow: 0px 0px 3px 3px rgba(0, 0, 0, 0.35);
    margin-bottom: 3em;
  }
  .miniinfo{
    color: #c2c2c2;
    font-style: italic;
    font-size: .7em;
    margin: .3em;
  }
  #buyblock{
    text-align: center;
  }
  #buyblock p{
    margin-bottom: 5em;
    margin-top: 1em;
    font-size: 1em;
  }

</style>
