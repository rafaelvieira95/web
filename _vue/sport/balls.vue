<template>
    <div class="container-fluid bg-transparent">

            <div class="row p-2 bg-light">
                <div class="col-sm-auto">
                    <label class="badge badge-dark p-2">Título: </label>
                    <input type="text" v-model="title">
                </div>
            </div>

            <div class="row p-2">
                <div class="jumbotron-fluid col-sm-auto">
                    <h4 style=color:darkorange>Preencha a ficha técnica</h4>
                    <p>Você pode encontrar estes dados na caixa do produto, etiqueta, embalagem ou nas especificações do fabricante.</p>
                </div>
            </div>

            <div class="row p-2  bg-light">
                <div class="col-md-12">
                    <label class="badge badge-dark p-2">Marca:</label>
                    <input type="text" v-model="brand" class="col-md-3">

                    <label class="badge badge-dark p-2" >Modelo da bola:</label>
                    <input type="text" v-model="model" class="col-md-3">
                </div>
            </div>

            <div class="row p-2  bg-light">
                <div class="col-md-12">
                    <label class="badge badge-dark p-2">Ano:</label>
                    <select v-model="year" class="custom-select col-md-3">
                        <option v-for="year in years">{{year.number}}</option>
                    </select>

                    <label class="badge badge-dark p-2">Preço (R$): </label>
                    <input type="number" v-model="price" class="col-md-1">

                    <label class="badge badge-dark p-2">Campo: </label>
                    <input type="checkbox" v-model="field" class="custom-checkbox col-md-1">
                </div>
            </div>
            <div class="row">

                <div class="col-md-1">
                    <p class="badge badge-primary">Foto principal</p>
                    <img src="_vue/sport/pictures/icone_camera.png" width="110px" height="100px"><br><br>
                    <label v-if="pic0 === null" class="btn btn-primary">Selecione
                        <input type="file" id="pic0" ref="pic0" name="pic0" @change="handleFileUpload('0')" hidden>
                    </label>
                    <label v-if="pic0 !== null" class="btn btn-success">Selecione
                        <input type="file" id="pic00" ref="pic0" name="pic0" @change="handleFileUpload('0')" hidden>
                    </label>
                </div>

                <div class="col-md-1">
                    <p class="badge badge-secondary">Foto secundária</p>
                    <img  src="_vue/sport/pictures/icone_camera.png" width="110px" height="100px"><br><br>
                    <label v-if="pic1 === null" class="btn btn-primary">Selecione
                        <input type="file" id="pic1" ref="pic1" name="pic1" @change="handleFileUpload('1')" hidden>
                    </label>

                    <label v-if="pic1 !== null" class="btn btn-success">Selecione
                        <input type="file" id="pic11" ref="pic1" name="pic1" @change="handleFileUpload('1')" hidden>
                    </label>
                </div>

                <div class="col-md-1">

                    <p class="badge badge-info">opcional</p>
                    <img src="_vue/sport/pictures/icone_camera.png" width="110px" height="100px"><br><br>
                    <label v-if="pic2 === null" class="btn btn-primary">Selecione
                        <input type="file" id="pic2" ref="pic2" name="pic2" @change="handleFileUpload('2')" hidden>
                    </label>

                    <label v-if="pic2 !== null" class="btn btn-success">Selecione
                        <input type="file" id="pic22" ref="pic2" name="pic2" @change="handleFileUpload('2')" hidden>
                    </label>

                </div>

                <div class="col-md-1">
                    <p class="badge badge-info">opcional</p>
                    <img src="_vue/sport/pictures/icone_camera.png" width="110px" height="100px"><br><br>
                    <label v-if="pic3 === null" class="btn btn-primary">Selecione
                        <input type="file" id="pic3" ref="pic3" name="pic3" @change="handleFileUpload('3')" hidden>
                    </label>

                    <label v-if="pic3 !== null" class="btn btn-success">Selecione
                        <input type="file" id="pic33" ref="pic3" name="pic3" @change="handleFileUpload('3')" hidden>
                    </label>

                </div>

            </div>


            <p style=color:darkred;>{{log}} </p>
            <button type="submit" @click="submit" class="btn btn-primary p-2">Cadastrar </button>

    </div>
</template>

<script>
    
    module.exports = {

        name: 'balls',
        data(){
            return{
                url:'http://127.0.0.1:8080/api/balls',
                log:'',
                pic0: null,
                pic1: null,
                pic2: null,
                pic3: null,


                    id: null,
                    idUser: null,
                    title: null,
                    brand: null,
                    model: null,
                    year: null,
                    price: null,
                    field: false,


                years: [
                    {number: 2017},
                    {number: 2018},
                    {number: 2019}
                ]
            }
        },

        created:function(){

            if(this.$session.exists()){
                this.idUser = this.$session.get("id");
            }

        },

        methods: {

            validateForm: function () {

                return !this.title || !this.brand || !this.pic0 ||
                    !this.pic1 || !this.price || !this.model || !this.year;
            },

            submit:function () {

                let validateForm = this.validateForm();

                if (validateForm) {

                    this.log = 'Volte e preencha todos os campos!'+
                        '\nlembrando que as duas primeiras fotos são obrigatórias!';

                } else {

                    let formData = new FormData();

                    formData.append('pic0',this.pic0);
                    formData.append('pic1',this.pic1);
                    formData.append('pic2',this.pic2);
                    formData.append('pic3',this.pic3);


                    formData.append('idUser',this.idUser);
                    formData.append('title',this.title);
                    formData.append('brand',this.brand);
                    formData.append('model',this.model);
                    formData.append('year',this.year);
                    formData.append('price',this.price);
                    formData.append('field',this.field);

                axios.post(this.url, formData,{
                    headers:{'Content-Type':'multipart/form-data'}

                }).then(function (r) {

                    console.log(r.data);
                    window.location.replace("/sport/register.html");

                }).catch(function (erro) {
                    console.log(erro);
                });
             }

            },

            handleFileUpload(idx){

                switch (idx) {
                    case '0': {
                        this.pic0 = this.$refs.pic0.files[0];
                        break;
                    }
                    case '1': {
                        this.pic1 = this.$refs.pic1.files[0];
                        break;
                    }
                    case '2': {
                        this.pic2 = this.$refs.pic2.files[0];
                        break;
                    }
                    case '3': {
                        this.pic3 = this.$refs.pic3.files[0];
                        break;
                    }

                    default:
                }
            }
        }
    }
</script>

<style>

</style>
