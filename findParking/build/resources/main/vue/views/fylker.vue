<template id="fylket">
  <section >
    <ul>
      <li v-for="fylke in sted">
        <a v-if="fylke" :href="`/find-parking/${fylke.name}/`">
          <section class="single-annonse-container" >
            {{console.log(fylke.name)}}
            <section id="leftBlock">
              <img   v-else class="list-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">
            </section>
            <section id="rightBlock">
              <h2>{{fylke.name}}</h2>
            </section>
          </section>
        </a>
      </li>
    </ul>
  </section>




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