<template id="order-page">
  <section  v-if="user" class="single-annonse-container" >

    {{console.log(user.navn)}}
    <section id="postHeader">
      <h2>Bestilling</h2>

    </section>
    <section id="buyblock">
      <h1>{{user.navn}}, Takk for din bestilling!</h1>
      <p>husk, at bestillinger er kun for en dag av gangen.</p>

      <a class="btn3" :href="`/find-parking/`"> Tilbake </a><br><br>
    </section>

  </section>

</template>

<script>
Vue.component("order", {
  template: "#order-page",
  data: () => ({
    user: null,
  }),
  created() {
    const brukerId = this.$javalin.pathParams["bruker-id"];
    console.log("Bruker id: " + brukerId);
    fetch(`/api/find-parking/minSide/Admin`)

        .then(res => res.json())
        .then(res => this.user = res)
    // .catch(() => alert("Error while fetching Bruker"));
  }

});
</script>