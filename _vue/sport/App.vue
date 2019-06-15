<template>

    <div v-if="sessionActivated" id="app" class="container-fluid">

        <div class="row">
            <div class="col-md-11 jumbotron-fluid text-center bg-primary">
                <h2 style=color:white;>Cadastro de Produtos esportivos</h2>
            </div>
            <a class="alert-link col-md-1 bg-primary text-md-center" href="index.html" style=color:white;> Voltar </a>
        </div>

        <h4 class="jumbotron-fluid"><strong> &nbsp&nbsp;Clique em um dos Produtos e o cadastro será gerado! </strong></h4>

        <label class="row">

            <select @click="selectProduct(itemSelected)" class="col-md-3 custom-select" v-model="itemSelected">
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

     let shirts = httpVueLoader('_vue/sport/shirts.vue');
     let shorts = httpVueLoader('_vue/sport/shorts.vue');
     let balls =  httpVueLoader('_vue/sport/balls.vue');
     let boots =  httpVueLoader('_vue/sport/boots.vue');

      module.exports = {
          name:'app',
          components:{shorts,balls,shirts,boots},

          data(){
            return{

                products:[{name:'Nenhum'},
                         {name:'Camisa'},
                         {name:'Chuteira'},
                         {name:'Bola'},
                         {name:'Shorts'}],
                activated: false,
                itemSelected: "",
                sessionActivated: false

            }
          },

          created: function () {
             vm = this;

              if(!vm.$session.exists()){

                  vm.sessionActivated = false;
                  window.location.replace("index.html");
              }else{

                  vm.sessionActivated = true;
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
