<template id="userData">
    <section  v-if="user" class="single-annonse-container" >

      {{console.log(user.navn)}}
        <section id="postHeader">
            <h2>{{user.navn}}</h2>

        </section>
        <section id="bildeBlock">
            <img   class="list-image" src="https://i.imgur.com/BpXaB1z.png">
            <img   v-else class="list-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">
        </section>
        <section id="rightBlock">
            <p class="infotittel">Navn:</p>
            <p id="navn">{{ user.navn }}</p>
            <p class="infotittel">Tilbakemeldinger:</p>
            <p id="score">score<span> / 5</span></p>
            <p class="infotittel">Antall annonser</p>
            <p id="antallannonser"> <p> {{user.annonser.length}} </p>
             <p class="infotittel">E-post:</p>
             <p id="epost">{{user.epost}}</p>
            <p class="infotittel">Beskrivelse:</p><p> Lorem ipsum dolor sit amet, consectetur adipisicing elit. A consectetur dolores eum, natus officia possimus quas quisquam reprehenderit, sit soluta velit veritatis voluptas. Aspernatur excepturi, expedita ipsa quo rerum tempore? Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias aperiam beatae cum ducimus eligendi enim est illo ipsam libero maiores, minus nemo nesciunt, nostrum obcaecati officia quibusdam recusandae suscipit vel!</p>
        </section>
        <section id="buttonBlock">
            <a class="btn" :href="`/find-parking/minSide/${user.navn}/annonser`">MINE ANNONSER </a>
        </section>

    </section>

</template>

<script>
    Vue.component("bruker", {
        template: "#userData",
        data: () => ({
            user: null,
        }),
        created() {
            const brukerId = this.$javalin.pathParams["bruker-id"];
            console.log("Bruker id: " + brukerId);
            fetch(`/api/find-parking/minSide/${brukerId}`)

                .then(res => res.json())
                .then(res => this.user = res)
            // .catch(() => alert("Error while fetching Bruker"));
        }
    });
</script>


