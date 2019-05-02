<template>

    <div id="app">


            <h4 class="jumbotron-fluid"><strong> Clique em um dos Produtos e o cadastro será gerado! </strong></h4>

        <select v-model="itemSelected" @click="selectProduct(itemSelected)" class="custom-select">
            <option v-for="i in products"> {{i.name}}</option>
        </select>

        <shirt v-show="itemSelected === 'Camisa' && ativo === true"></shirt>
        <!--control v-show="ativo && itemSelected === 'Nenhum'"></control-->

    </div>

</template>

<script>

    var Shirt = httpVueLoader('../_vue/shirts.vue');

      module.exports = {
        name:'app',
        components:{Shirt},

          data(){
            return{

                products:[{name:'Nenhum'}
                    ,{name:'Camisa'},
                    {name:'Chuteira'},
                    {name:'Bola'},
                    {name: 'Shorts'}],

                ativo: false,
                itemSelected: 'Nenhum Item'

            }
          },

          methods:{

            selectProduct(p){

                  if(p === 'Camisa') {

                       this.itemSelected = p;
                       this.ativo = true;
                  }

                  if(p === 'Nenhum'){
                      //this.itemSelected = p;
                      this.ativo = false;
                  }


                       //  alert(this.ativo + 'Camisa');
                        //this.itemSelected = p;
                        //this.ativo = true;


                        //alert(this.ativo + 'Chuteira');
                       // this.itemSelected = p;
                        //this.ativo = true;


                }


            }

    };

</script>

<style>


</style>