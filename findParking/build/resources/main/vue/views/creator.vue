<template id="lagAnnonse" @annonse-submitted="creator">
    <section class="single-annonse-container" >
        <section id="postHeader">
            <h2>Anonnse kontrollpanel</h2>

        </section>
        <section id="input">
          <form class="create" @submit="checkForm" :action=`/api/find-parking/${fylke}/creator` method="post">

            <div v-if="errors.length">
              <b>Please correct the following error(s):</b>
              <ul>
                <li v-for="error in errors">{{ error }}</li>
              </ul>
            </div>

            <p class="infotittel">Tittel:</p>
            <p class="miniinfo">Anonnsens tittel</p>
            <input type="text" class="textbox" name="textbox" v-model="tittel">

            <p class="infotittel">Fylke:</p>
            <p class="miniinfo">eks: Stedestad</p>
            <input type="text" class="textbox" name="textbox" v-model="fylke">

            <p class="infotittel">Adresse:</p>
            <p class="miniinfo">eks: stedsveien 69</p>
            <input type="text" class="textbox" name="textbox" v-model="adresse">

            <p class="infotittel">Sted:</p>
            <p class="miniinfo">eks: Halden</p>
            <input type="text" class="textbox" name="textbox" v-model="sted">

            <p class="infotittel">Pris (kr/dag):</p><p>
            <p class="miniinfo">kun tall. eks: 90</p>
            <input type="number" class="textbox" name="textbox" value="100" v-model="pris" min="0">

            <p class="infotittel">Bilde URL</p><p >
            <p class="miniinfo">link til bildet du ønsker i annonsen</p>
            <input type="url" class="textbox" name="textbox" value="https://archinect.imgix.net/uploads/3d/3ddb00ec0feb2ed25b6804cfbc16c7d1.jpg" v-model="pictureUrl">

            <p class="infotittel">Beskrivelse:</p>
            <p class="miniinfo">kort beskrivelse ang plass / omgivelse</p>
            <textarea name="message" rows="10" cols="30" class="beskrivelsebox" v-model="beskrivelse">safsdaf asdf asdf asdf asdfra, unde, vitae! Ad, tempora.</textarea>
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
    fylke: "Oslo",
    adresse: "Haldenveien 123123",
    sted: "Halden",
    beskrivelse: "Beskrivelse",
    tittel: "tittel",
    pris: 10,
    pictureUrl: "https://www.canon.no/media/CINC_Sample_EOS_7D_Mark_II_MX054_-_35mm_F4.5_ISO1600_1_3985s_tcm85-1436734.jpg",
    errors: []
  }),
  created() {
    this.alle_annonser = this.$javalin.pathParams["alle-annonse-id"];
  },
  methods:{
    checkForm:function(e) {
      const urlRegex = "/^(?:(?:(?:https?|ftp):)?\\/\\/)(?:\\S+(?::\\S*)?@)?(?:(?!(?:10|127)(?:\\.\\d{1,3}){3})(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\\.(?:[a-z\u00a1-\uffff]{2,})))(?::\\d{2,5})?(?:[/?#]\\S*)?$/i";
      if(this.fylke && this.pris && this.pictureUrl) return true;
      this.errors = [];
      if (!this.fylke) this.errors.push("Fylke required");
      if (!this.pris) this.errors.push("pris required");
      if (!this.pictureUrl) this.errors.push("Bilde required");
      e.preventDefault();
    }
  }

});
</script>
