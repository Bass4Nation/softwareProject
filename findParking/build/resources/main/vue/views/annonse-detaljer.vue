<template id="annonse">
  <section  v-if="annonse" class="single-annonse-container" >
    <section id="postHeader">
      <h2>{{annonse.tittel}}</h2>

    </section>
    {{console.log(this.annonse)}}

    {{console.log(annonse.tittel)}}
    {{console.log(annonse.pictureUrl)}}
    <section id="leftBlock">
      <img   v-if="annonse.pictureUrl" class="list-image" v-bind:src="annonse.pictureUrl">
      <img   v-else class="list-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">
    </section>
    <section id="rightBlock">
      <p class="infotittel">Sted:</p>
      <p id="sted">{{ annonse.sted }}</p>
      <p class="infotittel">Adresse:</p>
      <p id="adress">{{ annonse.adresse }}</p>
      <p class="infotittel">Pris:</p><p id="price"> <p> {{ annonse.pris}}kr/dag </p>
      <p class="infotittel">Beskrivelse:</p><p> {{ annonse.beskrivelse}}</p>
    </section>
    <section id="buttonBlock">
      <a class="btn" type="button" :href="`/find-parking/annonse/order`"  id="buyBtn">BESTILL</a>
    </section>

  </section>

</template>

<script>
  Vue.component("annonse-detaljer", {
    template: "#annonse",
    data: () => ({
      annonse: null,
    }),
    created() {
      const alleAnnonserId = this.$javalin.pathParams["alle-annonser-id"];
      console.log("Alle annonser id: " + alleAnnonserId);
      const annonseId = this.$javalin.pathParams["annonse-id"];
      console.log("Annonse id: " + annonseId);
      fetch(`/api/find-parking/${alleAnnonserId}/annonser/${annonseId}`)

              .then(res => res.json())
              .then(res => this.annonse = res)
      .catch(() => alert("Error while fetching annonse"));
    }
  });
</script>