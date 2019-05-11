<template>
    <div class="container-fluid bg-transparent">
        <form @submit="validaCadastro" action="#">

            <div class="row p-2 form-control bg-light">
                <div class="col-sm-auto">
                    <label class="badge badge-dark p-2">Título: </label>
                    <input type="text" v-model="title">
                </div>
            </div>

            <div class="row p-2">
                <div class="jumbotron-fluid col-sm-auto">
                    <h4 style=...>Preencha a ficha técnica</h4>
                    <p>Você pode encontrar estes dados na caixa do produto, etiqueta, embalagem ou nas especificações do fabricante.</p>
                </div>
            </div>

            <div class="row p-2 form-control bg-light">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <label class="badge badge-dark p-2">Marca:</label>
                    <input type="text" v-model="brand" class="col-xl-3 col-lg-3 col-md-3 col-sm-3 col-12">

                    <label class="badge badge-dark p-2">Modelo da chuteira:</label>
                    <input type="text" v-model="model" class="col-xl-3 col-lg-3 col-md-3 col-sm-4 col-12">

                    <label class="badge badge-dark p-2">Versão:</label>
                    <input type="text" v-model="version" class="col-xl-3 col-lg-3 col-md-3 col-sm-4 col-12">
                </div>
            </div>

            <div class="row p-2 form-control bg-light">
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <label class="badge badge-dark p-2">Gênero:</label>
                    <select v-model="gender" class="custom-select col-xl-3 col-lg-3 col-md-3 col-sm-3 col-12">
                        <option v-for="g in gender">{{g.option}}</option>
                    </select>
                    <label class="badge badge-dark p-2">Tamanho:</label>
                    <select v-model="size" class="custom-select col-xl-3 col-lg-3 col-md-3 col-sm-3 col-12">
                        <option v-for="s in size">{{s.number}}</option>
                    </select>
                    <label class="">Campo:</label>
                    <input type="checkbox" v-model="field" class="custom-checkbox col-xl-1 col-lg-1 col-md-1 col-sm-1 col-1">
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
        name: 'boots',
        data(){
            return{
                log:'',
                id: 0,
                title: null,
                brand: null,
                model: null,
                version: null,
                field: false,

                gender: [
                    {option: "unissex"},
                    {option: "masculina"},
                    {option: "feminina"}
                ],
                size: [
                    {number: 37},
                    {number: 38},
                    {number: 39},
                    {number: 40},
                    {number: 41},
                    {number: 42},
                    {number: 43},
                    {number: 44}
                ]
            }
        },
        methods: {
            validaCadastro: function (event) {
                if(this.title && this.brand && this.model && this.version){
                    this.log = 'Produto cadastrado!';
                    return true;
                }

                if(!this.title || !this.brand || !this.model || !this.version){
                    this.log = 'Volte e preencha todos os campos!';
                    event.preventDefault()
                }
            }
        }
    }
</script>

<style>

</style>