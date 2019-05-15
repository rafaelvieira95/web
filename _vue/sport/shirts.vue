<template>

    <div class="container-fluid bg-transparent">

        <form method="post" action="#">

            <div class="row p-2 form-group bg-light">

                <div class="col-sm-auto">
                    <label class="badge badge-dark p-2" >Título:</label>
                    <input type="text" v-model="shirt.title">
                </div>

            </div>

            <div class="row p-2">

                <div class="jumbotron-fluid col-sm-auto">
                    <h4 style=color:darkorange>Preencha a ficha técnica</h4>
                    <p>Você pode encontrar estes dados na caixa do produto, etiqueta, embalagem ou nas especificações do fabricante.</p>
                </div>
            </div>

            <div class="row p-2 form-group bg-light">

                <div class="col-md-12">

                    <label class="badge badge-dark p-2">Marca:</label>
                    <input type="text" v-model="shirt.brand" class="col-md-3">

                    <label class="badge badge-dark p-2" >Versão da camisa:</label>
                    <input type="text" v-model="shirt.version" class="col-md-3">

                </div>

            </div>


            <div class="row p-2 form-group bg-light">

                <div class="col-md-12">

                    <label class="badge badge-dark p-2">Time:</label>

                    <select v-model="shirt.club" class="custom-select col-md-3">

                        <option v-for="team in teams">{{team.name}}</option>
                    </select>

                    <label class="badge badge-dark p-2">Temporada:</label>
                    <input type="text" v-model="shirt.season" class="col-md-3">

                </div>

            </div>

            <div class="row p-2  bg-light ">

                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 p-1">

                    <label class="badge badge-dark p-2">Tipo Ocasião:</label>

                    <select v-model="shirt.occasion" class="custom-select col-md-3">
                        <option v-for="i in mood">{{i.game}}</option>
                    </select>

                    <label class="badge badge-dark p-2">Preço (R$):</label>
                    <input type= "number" v-model="shirt.price" class="col-md-2">

                    <label class="badge badge-dark p-2">Camisa de Goleiro:</label>
                    <input type="checkbox" v-model="shirt.gk" class="custom-checkbox col-md-1">

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
            <button type="submit" @click.prevent="submit" class="btn btn-primary p-2" > Cadastrar </button>


        </form>

    </div>

</template>

<script>

 module.exports = {

    name:'shirts',

    data(){
        return{

            url:'http://127.0.0.1:8080/sport/api/shirts',

            log:'',
            pic0: null,
            pic1: null,
            pic2: null,
            pic3: null,

            shirt: {
                id: '',
                idUser: '',
                title: '',
                brand: '',
                version: '',
                club: '',
                season: '',
                occasion: '',
                price: '',
                gk: false
            },

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
            {game:"Casual"},
            {game:"Partida"},
            {game:"Treinamento"}

        ]
        }
    },
    methods: {

        validateForm: function() {
            return !this.shirt.title || !this.shirt.price || !this.shirt.brand || !this.shirt.version || !this.shirt.season;
        },

        submit: function(event) {

            let validateForm = this.validateForm();
            if(validateForm) {
                this.log = 'Volte e preencha todos os campos!';
                event.preventDefault();
            }else {




                 let formData = new FormData();

                  this.idUser = 3;

                  formData.append('pic0',this.pic0);
                  formData.append('pic1',this.pic1);
                  formData.append('pic2',this.pic2);
                  formData.append('pic3',this.pic3);
                  formData.append('shirt.idUser',this.shirt.idUser);
                  formData.append('shirt.title',this.shirt.title);
                  formData.append('shirt.brand',this.shirt.brand);
                  formData.append('shirt.version',this.shirt.version);
                  formData.append('shirt.club',this.shirt.club);
                  formData.append('shirt.season',this.shirt.season);
                  formData.append('shirt.price',this.shirt.price);
                  formData.append('shirt.occasion',this.shirt.occasion);
                  formData.append('shirt.gk',this.shirt.gk);


               axios.post(this.url,formData, {

                   headers:{'Content-Type': 'multipart/form-data'}

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
