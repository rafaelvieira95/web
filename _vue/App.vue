<template>

    <div id="app">

        <h4 class="jumbotron-fluid"><strong> Clique em um dos Produtos e o cadastro será gerado! </strong></h4>

        <label class="row">
            <select @click="selectProduct(itemSelected)" class="col-md-3 col-sm-3 custom-select" v-model="itemSelected">
                <option v-for="i in products"> {{i.name}}</option>
            </select>
        </label>


        <shirts v-show="itemSelected === 'Camisa' && activated === true"></shirts>
        <boots  v-show="itemSelected  === 'Chuteira' && activated === true"></boots>
        <shorts v-show="itemSelected === 'Shorts' && activated === true"></shorts>
        <balls  v-show="itemSelected  === 'Bola' && activated === true"></balls>

    </div>

</template>

<script>

     let shirts = httpVueLoader('../_vue/shirts.vue');
     let shorts = httpVueLoader('../_vue/shorts.vue');
     let balls =  httpVueLoader('../_vue/balls.vue');
     let boots =  httpVueLoader("../_vue/boots.vue");

      module.exports = {
          name:'app',
        components:{shorts,balls,shirts,boots},

          data(){
            return{

                products:[{name:'Nenhum'}
                    ,{name:'Camisa'},
                    {name:'Chuteira'},
                    {name:'Bola'},
                    {name: 'Shorts'}],

                activated: false,
                itemSelected: ""

            }
          },

          methods: {

              selectProduct(p) {

                  if (p === 'Nenhum') {
                      this.itemSelected ="";
                      this.activated = false;
                  }else

                  if (p === 'Camisa') {
                      this.itemSelected = p;
                      this.activated = true;
                  }else

                  if(p === 'Chuteira'){
                      this.itemSelected = p;
                      this.activated = true;
                  }else

                  if (p === 'Bola') {
                      this.itemSelected = p;
                      this.activated = true;

                  }else

                  if(p === 'Shorts'){
                      this.itemSelected = p;
                      this.activated = true;
                  }
              }
          }
    };

</script>



<style>

</style>
