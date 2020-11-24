<template id="annonser">
  <section>

    <section id="stedVelger">
      <label for="steder">Velg et sted for parkeringsplasser:</label>
      <select  id="steder">
        <option  v-for="annonse in annonser" v-if="annonse" :value="`${annonse.sted}`">{{ annonse.sted }}</option>
      </select>
    </section>

    <ul>
      <li v-for="annonse in annonser">

        <a v-if="alle_annonser" :href="`/find-parking/${alle_annonser.name}/annonser/${annonse.id}`">
          <section class="single-annonse-container" >
<!--            {{console.log(annonse.tittel)}}-->
            {{console.log(annonse.sted)}}
              <section id="leftBlock">
                <img   v-if="annonse.pictureUrl" class="list-image" v-bind:src="annonse.pictureUrl">
              </section>
              <section id="rightBlock">
                 <h2>{{annonse.tittel}}</h2>
                  <p id="stedfelt">Sted:</p><p class="inputdata" id="sted">{{ annonse.sted }}</p> <br>
                  <p id="adressefelt">Adresse:</p><p class="inputdata" id="adress">{{ annonse.adresse }}</p>
                 <p class="infotittel">pris pr time:</p><p class="inputdata" id="price"> <p> {{ annonse.pris}}kr/t </p>
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

