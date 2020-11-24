<template id="annonse">
    <section  v-if="annonse" class="single-annonse-container" >
        <section id="postHeader">
            <h2>BRUKER NAVN</h2>

        </section>
        <section id="bildeBlock">
            <img   class="list-image" src="https://i.imgur.com/BpXaB1z.png">
            <img   v-else class="list-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">
        </section>
        <section id="rightBlock">
            <p class="infotittel">Navn:</p>
            <p id="navn">navn navnesen</p>
            <p class="infotittel">Tilbakemeldinger:</p>
            <p id="score">score<span> / 5</span></p>
            <p class="infotittel">Antall annonser</p>
            <p id="antallannonser"> <p> antall </p>
            <p class="infotittel">Beskrivelse:</p><p> Lorem ipsum dolor sit amet, consectetur adipisicing elit. A consectetur dolores eum, natus officia possimus quas quisquam reprehenderit, sit soluta velit veritatis voluptas. Aspernatur excepturi, expedita ipsa quo rerum tempore? Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias aperiam beatae cum ducimus eligendi enim est illo ipsam libero maiores, minus nemo nesciunt, nostrum obcaecati officia quibusdam recusandae suscipit vel!</p>
        </section>
        <section id="buttonBlock">
            <button class="btn" type="button" id="buyBtn">BESTILL</button>
            <button class="btn" type="button" id="buyBtn">MINE ANNONSER</button>
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


