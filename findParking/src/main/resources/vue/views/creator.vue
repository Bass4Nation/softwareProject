<template id="lagAnnonse" @annonse-submitted="creator">
    <section class="single-annonse-container" >
        <section id="postHeader">
            <h2>Anonnse kontrollpanel</h2>

        </section>
        <section id="input">
          <form class="create" @submit="checkForm" :action=`/api/find-parking/creator` method="post">

            <div v-if="errors.length">
              <b>Please correct the following error(s):</b>
              <ul>
                <li v-for="error in errors">{{ error }}</li>
              </ul>
            </div>

            <p class="infotittel">Tittel:</p>
            <p class="miniinfo">Anonnsens tittel</p>
            <input type="text" class="textbox" name="tittel" v-model="tittel">

            <p class="infotittel">Fylke:</p>
            <p class="miniinfo">eks: Viken eller Oslo</p>
            <select id="steder" name="fylke" v-model="fylke">
              <option  value="Viken"  >Viken</option>
              <option  value="Oslo"  >Oslo</option>
            </select>

            <p class="infotittel">Sted:</p>
            <p class="miniinfo">eks: Halden</p>
            <input type="text" class="textbox" name="sted" v-model="sted">

            <p class="infotittel">Adresse:</p>
            <p class="miniinfo">eks: stedsveien 69</p>
            <input type="text" class="textbox" name="adresse" v-model="adresse">

            <p class="infotittel">Pris (kr/dag):</p><p>
            <p class="miniinfo">kun tall. eks: 90</p>
            <input type="number" class="textbox" name="pris" value="100" v-model="pris" min="0">

            <p class="infotittel">Bilde URL</p><p >
            <p class="miniinfo">link til bildet du ønsker i annonsen</p>
            <input type="url" class="textbox" name="pictureUrl" value="https://archinect.imgix.net/uploads/3d/3ddb00ec0feb2ed25b6804cfbc16c7d1.jpg" v-model="pictureUrl">

            <p class="infotittel">Beskrivelse:</p>
            <p class="miniinfo">kort beskrivelse ang plass / omgivelse</p>
            <textarea name="beskrivelse" rows="10" cols="30" class="beskrivelsebox" v-model="beskrivelse"> safsdaf asdf asdf asdf asdfra, unde, vitae! Ad, tempora.</textarea>
            <br>
            <br>
            <input class="btn3" type="submit" value="Publiser">
          </form>
        </section>

    </section>

</template>

<script>
Vue.component("creator", {
  template: "#lagAnnonse",
  data: () => ({
    //Fylke for en rar grunn (name)
    fylke: null,
    telefonnummer: null,
    epost : null,
    adresse: null,
    sted: null,
    beskrivelse: null,
    tittel: null,
    pris: null,
    pictureUrl: null,
    errors: []
  }),
  // created() {
  //   this.alle_annonser = this.$javalin.pathParams["alle-annonse-id"];
  // },
  methods:{
    checkForm:function(e) {
      const urlRegex = "/^(?:(?:(?:https?|ftp):)?\\/\\/)(?:\\S+(?::\\S*)?@)?(?:(?!(?:10|127)(?:\\.\\d{1,3}){3})(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\\.(?:[a-z\u00a1-\uffff]{2,})))(?::\\d{2,5})?(?:[/?#]\\S*)?$/i";
      if(this.fylke && this.pictureUrl) return true;
      this.errors = [];
      if (!this.fylke) this.errors.push("Fylke required");
      if (!this.pris) this.errors.push("pris required");
      if (!this.pictureUrl) this.errors.push("Bilde required");
      e.preventDefault();
    }
  }

});
</script>
