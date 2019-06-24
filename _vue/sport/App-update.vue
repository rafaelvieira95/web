<template>

   <div id="app" class="container-fluid">

      <shirt v-if="isSelected === 'shirt'"></shirt>
      <balls v-if="isSelected === 'ball'"></balls>
      <boots v-if="isSelected === 'boot'"></boots>
      <shorts v-if="isSelected === 'short'"></shorts>

   </div>

</template>

<script>


    let shirt = httpVueLoader('_vue/sport/shirts-update.vue');
    let balls = httpVueLoader('_vue/sport/balls-update.vue');
    let boots = httpVueLoader('_vue/sport/boots-update.vue');
    let shorts = httpVueLoader('_vue/sport/shorts-update.vue');

      module.exports = {

          name: 'app-update',
          components: {shirt,balls,boots,shorts},

        data(){
            return{

                isSelected: null,
                id: null

            }
        },

        created: function(){

            vm = this;

           let urlCurrent = window.location.href;

           let newUrl = new URL(urlCurrent);
           let id = newUrl.searchParams.get("id");
           let param = newUrl.searchParams.get("param");

           vm.id = id;
           vm.isSelected = param;

        }
    }
</script>

<style scoped>

</style>