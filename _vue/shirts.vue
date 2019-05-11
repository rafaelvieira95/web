<template>

    <div class="container-fluid bg-transparent">

        <form @submit="validaCadastro" action="#">

            <div class="row p-2 form-group bg-light">

                <div class="col-sm-auto">
                    <label class="badge badge-dark p-2" >Título:</label>
                    <input type="text" v-model="title">
                </div>

            </div>

            <div class="row p-2">

                <div class="jumbotron-fluid col-sm-auto">
                    <h4 style=color:orange;>Preencha a ficha técnica</h4>
                    <p>Você pode encontrar estes dados na caixa do produto, etiqueta, embalagem ou nas especificações do fabricante.</p>
                </div>
            </div>

            <div class="row p-2 form-group bg-light">

                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">

                    <label class="badge badge-dark p-2">Marca:</label>
                    <input type="text" v-model="brand" class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col-12">

                    <label class="badge badge-dark p-2" >Versão da camisa:</label>
                    <input type="text" v-model="version" class="col-xl-3 col-lg-3 col-md-3 col-sm-4 col-12">

                </div>

            </div>


            <div class="row p-2 form-group bg-light">

                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">

                    <label class="badge badge-dark p-2">Time:</label>

                    <select v-model="club" class="custom-select col-xl-3 col-lg-3 col-md-3 col-sm-3 col-12">

                        <option v-for="team in teams">{{team.name}}</option>
                    </select>

                    <label class="badge badge-dark p-2">Temporada:</label>
                    <input type="text" v-model="season" class="col-xl-3 col-lg-3 col-md-3 col-sm-4 col-12">

                </div>

            </div>

            <div class="row p-2 form-group bg-light ">

                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 p-1">

                    <label class="badge badge-dark p-2">Tipo Ocasião:</label>

                    <select v-model="occasion" class="custom-select ccol-xl-3 col-lg-3 col-md-3 col-sm-4 col-12">
                        <option v-for="i in mood">{{i.game}}</option>
                    </select>

                    <label class="badge badge-dark p-2">Camisa de Goleiro:</label>
                    <input type="checkbox" v-model="gk" class="custom-checkbox col-xl-1 col-lg-1 col-md-1 col-sm-1 col-1">

                </div>

            </div>

            <div class="row">
                <div class="col-sm-auto" style=margin-top:150px;>
                    <button type="submit" class="btn btn-primary p-2" > Continuar </button>
                    <p style=color:darkred;>{{log}} </p>
                </div>
            </div>

        </form>

    </div>

</template>

<script>

 module.exports = {

    name:'shirts',

    data(){
        return{
            log:'',

            id: 0,
            title: null,
            brand: null,
            version: null,
            club: null,
            season: null,
            occasion: null,
            gk: false,

            teams: [
                {name: "Corinthians"},
                {name: "Flamengo"},
                {name: "São Paulo"},
                {name: "Cruzeiro"},
                {name: "Fluminense"},
                {name: "Bahia"},
                {name: "Palmeiras"},
                {name: "Vasco"}
            ],

            mood:[
            {game:"Selecione"},
            {game:"Partida"},
            {game:"Treinamento"}

        ]

        }
    },
    methods: {

        validaCadastro: function(event) {

            if(this.title && this.brand && this.version && this.season) {
                this.log = 'Produto cadastrado!';
                return true;
            }

            if(!this.title || !this.brand || !this.version || !this.season)
            {
                this.log ='Volte e preencha todos os campos!';
                event.preventDefault()

            }



        }
    }
};

</script>

<style>


</style>