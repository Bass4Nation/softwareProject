<template id="annonser">
  <section >
    <ul>
      <li v-for="annonse in annonser">
        <a v-if="alle_annonser" :href="`/find-parking/${alle_annonser.name}/annonser/${annonse.id}`">
          <section class="single-annonse-container" >
            {{console.log(annonse.tittel)}}
            {{console.log(annonse.pictureUrl)}}
              <section id="leftBlock">
                <img   v-if="annonse.pictureUrl" class="list-image" v-bind:src="annonse.pictureUrl">
                <img   v-else class="list-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">
              </section>
              <section id="rightBlock">
                 <h2>{{annonse.tittel}}</h2>
                  <p id="adressefelt">Adresse:</p>
                  <p id="adress">{{ annonse.adresse }}</p>
                 <p class="infotittel">pris pr time:</p><p id="price"> <p> {{ annonse.pris}}kr/t </p>
              </section>
          </section>
        </a>
      </li>
    </ul>
  </section>




</template>

<script>
Vue.component("alle-annonsene", {
  template: "#annonser",
  data: () => ({
    alle_annonser: null,
    annonser: [],
  }),
  created() {
    const alleAnnonserId = this.$javalin.pathParams["alle-annonser-id"];

    fetch(`/api/find-parking/${alleAnnonserId}`)
        .then(res => res.json())
        .then(res => {
          this.alle_annonser = res
        })
        .catch(() => alert("Error while fetching planet system"))
    fetch(`/api/find-parking/${alleAnnonserId}/annonser`)
        .then(res => res.json())
        .then(res => this.annonser = res)
        .catch(() => alert("Error while fetching annonser side 2"));
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
        width: 90%;
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
        font-size: 1.2em;
    }

    #adress{
      display: inline-block;
      margin-bottom: 2em;
    }

    #adressefelt{
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

</style>

