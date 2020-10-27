<template id="observations-overview">
   <div>
       <h1>Planet systems</h1>
        <ul class="observations-overview-list">
            <li v-for="observation in observations">
                <a :href="`/observations/${observation.name.trim()}`" class="link-to-observation-details">
                    <div class="single-observation-container" >
                        <h1>{{observation.id}} - {{observation.name}}</h1>
                        <h1>{{observation.animal.name}}</h1>
                        <img v-if="observation.pictureUrl" class="observation-cover-image" v-bind:src="observation.pictureUrl">
                        <img v-else class="cover-image-frontpage" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">
                    </div>
                </a>
            </li>
        </ul>
   </div>
</template>
<script>
    Vue.component("observations-overview", {
        template: "#observations-overview",
        data: () => ({
            observations: [],
        }),
        created() {
            fetch("/api/observations")
                .then(res => res.json())
                .then(res => {
                   this.observations = res;
                })
                .catch(() => alert("Error while fetching observations"));
        }
    });
</script>

<style>
  @import '/stil/master.css';
</style>
