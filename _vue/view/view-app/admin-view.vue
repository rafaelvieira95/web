<template>

    <div id="app" class="container-fluid">

        <div class="row">

            <div class="col-md-1 bg-dark"></div>

            <nav class="navbar col-md-10 col-sm-5 col-5 navbar-nav navbar-expand-sm bg-white navbar-dark">
                <ul class="nav col-md-10 col-sm-5 col-5 navbar-nav font-weight-bold">
                    <a  href="index.html"><img class="navbar-brand figure-img" width="200px" height="100px" src="_vue/sport/pictures/logo_temp.png"></a>
                    <li class="col-md-2 text-md-right"><a class="alert-link" @click="logout"  href="index.html" style=color:red;>Sair</a></li>
                </ul>

            </nav>

            <div class="col-md-1 bg-dark"></div>

        </div>

        <div id="menu" class="row">

                <select v-model="menu" class="col-md-2 custom-select">
                    <option v-for="op in options" @click="chooseOption(op.name)">{{op.name}}</option>
                </select>
        </div>

        <client v-if="menu === 'Meus dados'"></client>
        <shirts v-if="menu === 'Camisas'"></shirts>
        <balls  v-if="menu === 'Bolas'"></balls>
        <shorts v-if="menu === 'Shorts'"></shorts>
        <boots  v-if="menu === 'Chuteiras'"></boots>

    </div>



</template>

<script>

    let client = httpVueLoader('_vue/view/client-info.vue');
    let shirts = httpVueLoader('_vue/view/shirts-info.vue');
    let balls = httpVueLoader('_vue/view/balls-info.vue');
    let shorts = httpVueLoader('_vue/view/shorts-info.vue');
    let boots = httpVueLoader('_vue/view/boots-info.vue');

    module.exports = {

        name: 'admin',
        components:{client,shirts,balls,shorts,boots},

        data(){

            return{

              menu: 'Meus dados',
              options:[
                  {name:'Meus dados'},
                  {name:'Camisas'},
                  {name:'Shorts'},
                  {name:'Chuteiras'},
                  {name:'Bolas'}
              ]
            }
        },
        methods:{

            logout:function () {

                if(this.$session.exists()) {
                    this.$session.destroy();
                }
            },

            chooseOption: function(op){
                this.menu = op;
            }

        }

    };


</script>

<style scoped>

    div#menu{
        margin-top: 20px;
        margin-left: 6px;
    }

    nav ul a{
        margin-left: 20px;
        margin-top: 0px;
    }

    nav li{
        margin-left: 700px;
    }

</style>