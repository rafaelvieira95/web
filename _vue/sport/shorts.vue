<template>
    <div class="container-fluid bg-transparent">
        <form method="post" action="#">

            <div class="row p-2 bg-light">
                <div class="col-sm-auto">
                    <label class="badge badge-dark p-2">Título: </label>
                    <input type="text" v-model="short.title">
                </div>
            </div>

            <div class="row p-2">
                &nbsp; &nbsp;
                <div class="jumbotron-fluid col-sm-auto">
                    <h4 style=color:darkorange>Preencha a ficha técnica</h4>
                    <p>Você pode encontrar estes dados na caixa do produto, etiqueta, embalagem ou nas especificações do fabricante.</p>
                </div>
            </div>

            <div class="row p-2 bg-light">
                <div class="col-md-10">
                    <label class="badge badge-dark p-2">Marca:</label>
                    <input type="text" v-model="short.brand" class="col-md-3">
                    &nbsp; &nbsp;
                    <label class="badge badge-dark p-2" >Modelo do short:</label>
                    <input type="text" v-model="short.model" class="col-md-3">
                </div>
            </div>

            <div class="row p-2 bg-light">
                &nbsp; &nbsp;
                    <label class="badge badge-dark p-2">Gênero:</label>
                    <select v-model="short.chooseGender" class="custom-select col-md-2">
                        <option v-for="g in gender">{{g.option}}</option>
                    </select>
                   &nbsp; &nbsp;
                    <label class="badge badge-dark p-2">Preço (R$):</label>
                    <input type="number" v-model="short.price" class="col-md-2">
                   &nbsp; &nbsp;
                    <label class="badge badge-dark p-2">Tamanho:</label>
                    <select v-model="short.chooseSize" class="custom-select col-md-1">
                        <option v-for="s in size">{{s.letter}}</option>
                    </select>




            </div><br><br>

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

                    <label v-if="pic3 !== null" class="btn btn-primary">Selecione
                        <input type="file" id="pic33" ref="pic3" name="pic3" @change="handleFileUpload('3')" hidden>
                    </label>

                </div>

            </div>

            <p style=color:darkred;>{{log}} </p>
            <button type="submit" @click.prevent="submit" class="btn btn-primary p-2" > Cadastrar </button>

        </form>
    </div>


</template>

<script>

    module.exports = {
        name: 'shorts',
        data(){
            return{
                url:'http://127.0.0.1:8080/sport/api/shorts',
                log:'',
                pic0: null,
                pic1: null,
                pic2: null,
                pic3: null,

                short: {
                    id: null,
                    idUser: null,
                    title: null,
                    brand: null,
                    model: null,
                    price: null,
                    chooseSize: null,
                    chooseGender: null
                },

                gender: [
                    {option: "Unissex"},
                    {option: "Masculino"},
                    {option: "Feminino"}
                ],

                size: [
                    {letter: "P"},
                    {letter: "M"},
                    {letter: "G"},
                    {letter: "GG"}
                ]
            }
        },
        methods: {

            validateForm: function () {
                return !this.short.title || !this.short.brand || !this.short.model || !this.short.chooseGender || !this.short.chooseSize;
            },

            submit: function (event) {

                let validateForm = this.validateForm();

                if(validateForm){
                    this.log = 'Volte e preencha todos os campos!';
                    event.preventDefault();
                }else {

                    let formData = new FormData();

                    formData.append('pic0',this.pic0);
                    formData.append('pic1',this.pic1);
                    formData.append('pic2',this.pic2);
                    formData.append('pic3',this.pic3);

                    formData.append('short.title',this.short.title);
                    formData.append('short.brand',this.short.brand);
                    formData.append('short.model',this.short.model);
                    formData.append('short.chooseSize',this.short.chooseSize);
                    formData.append('short.price',this.short.price);
                    formData.append('short.chooseGender',this.short.chooseGender);

                    axios.post(this.url,formData, {

                     headers:{'Content-Type':'multipart/form-data'}

                    }).then(function (r) {

                        console.log(r.data);

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
    };
</script>

<style>

</style>
