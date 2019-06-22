<template>

    <div class="container-fluid bg-transparent">

        <div class="row p-2 form-group bg-light">

            <div class="col-sm-auto">
                <label class="badge badge-dark p-2" >Título:</label>
                <input type="text" v-model="title">

            </div>

        </div>

        <div class="row p-2">

            <div class="jumbotron-fluid col-sm-auto">
                <h4 style=color:darkorange> Preencha a ficha técnica</h4>
                <p> Você pode encontrar estes dados na caixa do produto, etiqueta, embalagem ou nas especificações do fabricante.</p>
            </div>
        </div>

        <div class="row p-2 form-group bg-light">

            <div class="col-md-12">

                <label class="badge badge-dark p-2">Marca:</label>
                <select v-model="brand"  class="col-md-2 custom-select">
                    <option v-for="b in brands">{{b.name}}</option>
                </select>

                <label class="badge badge-dark p-2" >Versão da camisa:</label>
                <input type="text" v-model="version" class="col-md-3">

            </div>

        </div>


        <div class="row p-2 form-group bg-light">

            <div class="col-md-12">

                <label class="badge badge-dark p-2">Time:</label>

                <select v-model="club" class="custom-select col-md-3">

                    <option v-for="team in teams">{{team.name}}</option>
                </select>

                <label class="badge badge-dark p-2">Temporada:</label>
                <input type="text" v-model="season" class="col-md-3">

            </div>

        </div>

        <div class="row p-2  bg-light ">

            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 p-1">

                <label class="badge badge-dark p-2">Tipo Ocasião:</label>

                <select v-model="occasion" class="custom-select col-md-3">
                    <option v-for="i in mood">{{i.game}}</option>
                </select>

                <label class="badge badge-dark p-2">Preço (R$):</label>
                <input type= "number" v-model="price" class="col-md-2">

                <label class="badge badge-dark p-2">Camisa de Goleiro:</label>
                <input type="checkbox" v-model="gk" class="custom-checkbox col-md-1">

            </div>

        </div>


        <div class="row">

            <div class="col-md-1">
                <p class="badge badge-primary">Foto principal</p>
                <img :src=pathPic0 width="110px" height="100px"><br><br>
                <label v-if="pic0 === null" class="btn btn-primary">Selecione
                    <input type="file" id="pic0" ref="pic0" name="pic0" @change="handleFileUpload('0')" hidden>
                </label>
                <label v-if="pic0 !== null" class="btn btn-success">Selecione
                    <input type="file" id="pic00" ref="pic0" name="pic0" @change="handleFileUpload('0')" hidden>
                </label>
            </div>

            <div class="col-md-1">
                <p class="badge badge-secondary">Foto secundária</p>
                <img  :src=pathPic1 width="110px" height="100px"><br><br>
                <label v-if="pic1 === null" class="btn btn-primary">Selecione
                    <input type="file" id="pic1" ref="pic1" name="pic1" @change="handleFileUpload('1')" hidden>
                </label>

                <label v-if="pic1 !== null" class="btn btn-success">Selecione
                    <input type="file" id="pic11" ref="pic1" name="pic1" @change="handleFileUpload('1')" hidden>
                </label>

            </div>

            <div class="col-md-1">

                <p class="badge badge-info">opcional</p>
                <img :src=pathPic2 width="110px" height="100px"><br><br>
                <label v-if="pic2 === null" class="btn btn-primary">Selecione
                    <input type="file" id="pic2" ref="pic2" name="pic2" @change="handleFileUpload('2')" hidden>
                </label>

                <label v-if="pic2 !== null" class="btn btn-success">Selecione
                    <input type="file" id="pic22" ref="pic2" name="pic2" @change="handleFileUpload('2')" hidden>
                </label>

            </div>

            <div class="col-md-1">
                <p class="badge badge-info">opcional</p>
                <img :src=pathPic3 width="110px" height="100px"><br><br>

                <label v-if="pic3 === null" class="btn btn-primary">Selecione
                    <input type="file" id="pic3" ref="pic3" name="pic3" @change="handleFileUpload('3')" hidden>
                </label>

                <label v-if="pic3 !== null" class="btn btn-success">Selecione
                    <input type="file" id="pic33" ref="pic3" name="pic3" @change="handleFileUpload('3')" hidden>
                </label>

            </div>
        </div>

        <p style=color:darkred;>{{log}} </p>
        <button type="submit" @click="submit" class="btn btn-primary p-2" > Atualizar </button>



    </div>


</template>

<script>

    module.exports = {

        name: 'shirt',

        data(){

            return{

                url: 'http://127.0.0.1:8080/api/shirts/',
                idProduct: null,
                idUser: null,
                log: null,
                pic0: null,
                pic1: null,
                pic2: null,
                pic3: null,
                pathPic0: null,
                pathPic1: null,
                pathPic2: null,
                pathPic3: null,

                title: null,
                brand: null,
                version: null,
                club: null,
                season: null,
                occasion: null,
                price: null,
                gk: false,

                teams: [
                    {name: "Athletico Paranaense"},{name: "Atlético Mineiro"},{name: "Avaí"},
                    {name: "Bahia"},{name: "Ceará"},{name: "Chapecoense"},{name: "Corinthians"},
                    {name: "Cruzeiro"},{name: "CSA"},{name: "Flamengo"},{name: "Fluminense"},
                    {name: "Fortaleza"},{name: "Goiás"},{name: "Grêmio"},{name: "Internacional"},
                    {name: "Palmeiras"},{name: "Santos"}, {name: "São Paulo"}, {name: "Vasco"}
                ],

                mood:[
                    {game:"Casual"},
                    {game:"Partida"},
                    {game:"Treinamento"}

                ],

                brands:[
                    {name:'Adidas'},
                    {name:'Diadora'},
                    {name:'Nike'},
                    {name:'Lotto'},
                    {name:'Rebook'},
                    {name:'Puma'},
                    {name:'Under Armour'},
                    {name:'Umbro'}
                ]
            }
        },

        created: function(){

            vm = this;

            let currentUrl = window.location.href;
            vm.idProduct = new URL(currentUrl).searchParams.get("id");
            vm.idUser =  vm.$session.get("id");
            vm.loadImages();

                axios.get(vm.url + vm.idProduct).then(function (r) {

                            vm.title = r.data.title;
                            vm.brand = r.data.brand;
                            vm.version = r.data.version;
                            vm.club = r.data.club;
                            vm.season = r.data.season;
                            vm.occasion = r.data.occasion;
                            vm.price = r.data.price;
                            vm.gk = r.data.gk;

                }).catch(function (erro) {

                    console.log(erro);
                });

        },

        methods: {

            validateForm: function() {
                return !this.title || !this.price || !this.brand || !this.version || !this.season;
            },

            submit: function() {

                let validateForm = this.validateForm();

                if (validateForm) {
                    this.log = 'Volte e preencha todos os campos!' +
                        '\nlembrando que as duas primeiras fotos são obrigatórias!';
                } else {

                    let formData = new FormData();

                    formData.append('pic0', this.pic0);
                    formData.append('pic1', this.pic1);
                    formData.append('pic2', this.pic2);
                    formData.append('pic3', this.pic3);

                    formData.append('idUser', this.idUser);
                    formData.append('title', this.title);
                    formData.append('brand', this.brand);
                    formData.append('version', this.version);
                    formData.append('club', this.club);
                    formData.append('season', this.season);
                    formData.append('price', this.price);
                    formData.append('occasion', this.occasion);
                    formData.append('gk', this.gk);


                    axios.put(this.url + this.idProduct, formData, {

                        headers: {'Content-Type': 'multipart/form-data'}

                    }).then(function (r) {

                        console.log(r.data);
                        window.location.replace("/sport/admin.html");

                    }).catch(function (erro) {

                        console.log(erro);

                    });

                }
            },

            loadImages: function () {

                vm = this;

                let img = new Image();

                img.src = '_img/'+vm.idProduct + '_' + vm.idUser + '-pic0';

                vm.pathPic0 = img.src;

                img.onerror = function () {

                    vm.pathPic0 = '_img/no-pic_standard.png';

                };

                img = new Image();

                img.src = '_img/'+vm.idProduct + '_' + vm.idUser + '-pic1';

                vm.pathPic1 = img.src;

                img.onerror = function () {
                    vm.pathPic1 = '_img/no-pic_standard.png';

                };

                 img = new Image();

                img.src = '_img/'+vm.idProduct+ '_' + vm.idUser + '-pic2';
                vm.pathPic2 = img.src;

                img.onerror = function () {

                    vm.pathPic2 = '_img/no-pic_standard.png';

                };

                 img = new Image();


                img.src = '_img/'+vm.idProduct + '_' + vm.idUser + '-pic3';
                vm.pathPic3 = img.src;


                img.onerror = function () {

                    vm.pathPic3 = '_img/no-pic_standard.png';


                };

            },

            handleFileUpload(idx) {

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
    };

</script>

<style scoped>

</style>