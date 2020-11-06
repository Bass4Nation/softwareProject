<template id="annonser">
  <section >
    <ul>
      <li v-for="annonse in annonser">
        <a v-if="alle_annonser" :href="`/alle-annonser/${alle_annonser.name}/annonser/${annonse.id}`">
          <section class="single-annonse-container" >
            {{console.log(annonse.tittel)}}
            {{console.log(annonse.pictureUrl)}}
              <section id="leftBlock">
                <img   v-if="annonse.pictureUrl" class="list-image" v-bind:src="annonse.pictureUrl">
                <img   v-else class="list-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">
              </section>
              <section id="rightBlock">
                 <h2>{{annonse.tittel}}</h2>
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

    fetch(`/api/alle-annonser/${alleAnnonserId}`)
        .then(res => res.json())
        .then(res => {
          this.alle_annonser = res
        })
        .catch(() => alert("Error while fetching planet system"))
    fetch(`/api/alle-annonser/${alleAnnonserId}/annonser`)
        .then(res => res.json())
        .then(res => this.annonser = res)
        .catch(() => alert("Error while fetching annonser side 2"));
  }
});
</script>

