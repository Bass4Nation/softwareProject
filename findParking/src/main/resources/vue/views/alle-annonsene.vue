<template id="annonser">

  <section>

    <section id="stedsorter">
      <a class="btn2" href="javascript:history.back()">tilbake</a>
      <a class="btn2" href="javascript:history.back()">Reset</a>
      <section id="stedVelger">
        <select onchange="val()" id="steder">
          <option id="valg" v-for="annonse in annonser" v-if="annonse" :value="`${annonse.sted}`">{{ annonse.sted }}</option>
        </select>
      </section>
    </section>

    <ul>
      <li v-for="annonse in annonser">
        <a v-if="alle_annonser" :href="`/find-parking/${alle_annonser.name}/annonser/${annonse.tittel}`">
          <section class="single-annonse-container" >
              <section id="leftBlock">
                <img   v-if="annonse.pictureUrl" class="list-image" v-bind:src="annonse.pictureUrl">
                <img   v-else class="list-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">
              </section>
              <section id="rightBlock">
                 <h2>{{annonse.tittel}}</h2>
                  <p id="stedfelt">Sted:</p><p class="inputdata" id="sted">{{ annonse.sted }}</p> <br>
                  <p id="adressefelt">Adresse:</p><p class="inputdata" id="adress">{{ annonse.adresse }}</p>
                 <p class="infotittel">Pris:</p><p class="inputdata" id="price"> <p> {{ annonse.pris}}kr/dag </p>
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
        .catch(() => alert("Error while fetching alle annonser for dette fylket"))
    fetch(`/api/find-parking/${alleAnnonserId}/annonser`)
        .then(res => res.json())
        .then(res => this.annonser = res)
        .catch(() => alert("Error while fetching annonser detaljer"));
  }
}
);
</script>

