<template id="annonse">
    <section  v-if="annonse" class="single-annonse-container" >
        <section id="postHeader">
            <h2>Anonnse kontrollpanel</h2>

        </section>
        <section id="input">

            <p class="infotittel">Tittel:</p>
            <p class="miniinfo">Anonnsens tittel</p>
            <input type="text" class="textbox" name="textbox">

            <p class="infotittel">Sted:</p>
            <p class="miniinfo">eks: Stedestad</p>
            <input type="text" class="textbox" name="textbox">

            <p class="infotittel">Adresse:</p>
            <p class="miniinfo">eks: stedsveien 69</p>
            <input type="text" class="textbox" name="textbox">

            <p class="infotittel">Pris (kr/time):</p><p id="price">
            <p class="miniinfo">kunn tall. eks: 90</p>
            <input type="number" class="textbox" name="textbox" value="100">

            <p class="infotittel">Beskrivelse:</p>
            <p class="miniinfo">kort beskrivelse ang plass / omgivelse</p>
            <textarea name="message" rows="10" cols="30" class="beskrivelsebox">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam commodi dolore eius est eveniet explicabo illo illum inventore neque nobis placeat qui quo soluta sunt tempora, unde, vitae! Ad, tempora.</textarea>
            <br>
            <button class="btn3" type="button">Slett</button>
            <button class="btn3" type="button">Publiser</button>
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
            // .catch(() => alert("Error while fetching annonse"));
        }
    });
</script>