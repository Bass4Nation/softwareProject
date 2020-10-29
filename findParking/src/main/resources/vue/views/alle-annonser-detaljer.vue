<template id="planet-system-detail">
  <div class="content-wrapper">

    <ul class="planet-overview-list">
      <li v-for="planet in planets">
        <a v-if="planetSystem" class="link-to-planet-details" :href="`/alle-annonser/${planetSystem.name}/annonser/${planet.name}`">
          <div class="single-planet-container" >
            <h1>{{planet.tittel}}</h1>
            {{console.log(planet.tittel)}}
            {{console.log(planet.pictureUrl)}}
            <img v-if="planet.pictureUrl" class="list-image" v-bind:src="planet.pictureUrl">
            <img v-else class="list-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">
          </div>
        </a>
      </li>
    </ul>
  </div>
</template>
<script>
Vue.component("alle-annonser-detaljer", {
  template: "#planet-system-detail",
  data: () => ({
    planetSystem: null,
    planets: [],
    star: null,
    sorting: "name",
  }),
  created() {
    const planetSystemId = this.$javalin.pathParams["alle-annonser-id"];

    fetch(`/api/alle-annonser/${planetSystemId}`)
        .then(res => res.json())
        .then(res => {
          this.planetSystem = res
        })
        .catch(() => alert("Error while fetching planet system"))
    fetch(`/api/alle-annonser/${planetSystemId}/annonser`)
        .then(res => res.json())
        .then(res => this.planets = res)
        .catch(() => alert("Error while fetching annonser side 2"));
  }
});
</script>

