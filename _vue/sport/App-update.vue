<template>

   <div id="app" class="container-fluid">

   <shirt></shirt>

   </div>

</template>

<script>


    let shirt = httpVueLoader('_vue/sport/shirts-update.vue');

      module.exports = {

          name: 'app-update',
          components: {shirt},

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

        },

        methods:{

              clickOnMe: function () {
                  alert(this.isSelected +' '+this.id);
              }

        }
    }
</script>

<style scoped>

</style>