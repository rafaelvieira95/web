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

        <div class="row p-2 bg-light">
            <div class="col-md-12">
                <label class="badge badge-dark p-2">Marca:</label>
                <input type="text" v-model="brand" class="col-md-2">

                <label class="badge badge-dark p-2">Modelo da chuteira:</label>
                <input type="text" v-model="model" class="col-md-2">

                <label class="badge badge-dark p-2">Versão:</label>
                <input type="text" v-model="version" class="col-md-2">
            </div>
        </div>

        <div class="row p-2 bg-light">
            <div class="col-md-12">
                <label class="badge badge-dark p-2">Gênero:</label>
                <select v-model="bootsGender" class="custom-select col-md-2">
                    <option v-for="g in gender">{{g.option}}</option>
                </select>
                <label class="badge badge-dark p-2">Tamanho:</label>
                <select v-model="bootSize" class="custom-select col-md-1">
                    <option v-for="s in size">{{s.number}}</option>
                </select>

                <label class="badge badge-dark p-2">Preço (R$):</label>
                <input type="number" v-model="price" class="col-md-1">

                <label class="">Campo:</label>
                <input type="checkbox" v-model="field" class="custom-checkbox col-md-1">
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

        name: 'boots',
        data(){
            return{
                url:'http://127.0.0.1:8080/api/boots/',
                log:'',
                pic0: null,
                pic1: null,
                pic2: null,
                pic3: null,

                pathPic0: null,
                pathPic1: null,
                pathPic2: null,
                pathPic3: null,

                idProduct: null,
                idUser: null,
                title: null,
                brand: null,
                model: null,
                bootsGender: null,
                bootSize: null,
                version: null,
                price: null,
                field: false,

                gender: [
                    {option: "Unissex"},
                    {option: "Masculina"},
                    {option: "Feminina"}
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

        created: function () {

            vm = this;

            let currentUrl = window.location.href;

            let newUrl = new URL(currentUrl);

            vm.idProduct = newUrl.searchParams.get("id");
            vm.idUser = vm.$session.get("id");
            vm.loadImages();

            axios.get(vm.url + vm.idProduct).then(function (r) {

                    vm.title = r.data.title;
                    vm.brand = r.data.brand;
                    vm.model = r.data.model;
                    vm.bootsGender = r.data.bootsGender;
                    vm.bootSize = r.data.bootSize;
                    vm.version = r.data.version;
                    vm.price = r.data.price;
                    vm.field = r.data.field;


            }).catch(function (erro) {

                console.log(erro);
            });


        },

        methods: {

            validateForm: function () {

                return !this.title || !this.brand || !this.model || !this.version ||
                    !this.bootsGender || !this.bootSize;
            },

            submit: function () {


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
                    formData.append('model', this.model);
                    formData.append('bootsGender', this.bootsGender);
                    formData.append('version', this.version);
                    formData.append('price', this.price);
                    formData.append('bootSize', this.bootSize);
                    formData.append('field', this.field);

                    axios.put(this.url + vm.idProduct, formData, {

                        auth: {
                            username: 'admin',
                            password: 'password'
                        },

                        headers: {'Content-Type': 'multipart/form-data'}

                    }).then(function (r) {
                        console.log(r.data);
                        window.location.replace("/sport/register.html");

                    }).catch(function (erro) {
                        console.log(erro);

                    });
                }
            },

            loadImages: function () {

                vm = this;
                let img = new Image();

                img.src = '_img/' + vm.idProduct + '_' + vm.idUser + '-pic0';

                vm.pathPic0 = img.src;

                img.onerror = function () {

                    vm.pathPic0 = '_img/no-pic_standard.png';

                };

                img = new Image();

                img.src = '_img/' + vm.idProduct + '_' + vm.idUser + '-pic1';

                vm.pathPic1 = img.src;

                vm.onerror = function () {

                    vm.pathPic1 = '_img/no-pic_standard.png';

                };

                img = new Image();

                img.src = '_img/' + vm.idProduct + '_' + vm.idUser + '-pic2';
                vm.pathPic2 = img.src;

                img.onerror = function () {

                    vm.pathPic2 = '_img/no-pic_standard.png';
                };

                img = new Image();

                img.src = '_img/' + vm.idProduct + '_' + vm.idUser + '-pic3';
                vm.pathPic3 = img.src;

                img.onerror = function () {

                    vm.pathPic3 = '_img/no-pic_standard.png';

                };

            }
        }
    };

</script>

<style scoped>

</style>