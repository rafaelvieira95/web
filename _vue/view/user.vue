
<template>

    <div id="app" class="container-fluid bg-white font-weight-light">
        <nav class="navbar navbar-expand-sm bg-white navbar-dark">

            <a class="navbar-brand" href="index.html"><img src="_vue/sport/pictures/logo_temp.png" width="220px" height="120px"></a>
            <h2 class="align-content-center" style=color:darkorange;> Cadastro  na empresa 1000Sport</h2>

        </nav>

        <div v-if="index === 1" class="row form-group">
            <div class="col-md-4"></div>

            <fieldset id="1" class="form-group col-md-3">
                <legend> Dados da Empresa </legend>

                <label class="badge badge-primary"> Nome Fantasia: </label>
                <input type="text" v-model="user.nameFantasy" class="form-control form-text"> <br>
                <label class="badge badge-primary"> Razão Social: </label>
                <input type="text" v-model="user.societyReason" class="form-control form-text">
                <label class="badge badge-primary"> CNPJ: </label>
                <input type="text" v-model="user.cnpj" class="form-control form-text"><br>


            </fieldset>

        </div>

        <div v-if="index === 2"  class="row form-group">
            <div class="col-md-4"></div>
            <fieldset id="2" class="form-group col-md-3">

                <legend> Dados do proprietário</legend>

                <label class="badge badge-primary"> Nome: </label>
                <input type="text" v-model="user.name" class="form-control form-text">
                <label class="badge badge-primary"> Sobrenome:</label>
                <input type="text" v-model="user.surname" class="form-control form-text" >
                <label class="badge badge-primary"> CPF: </label>
                <input type="text" v-model="user.cpf" class="form-control form-text">


            </fieldset>

        </div>

        <div v-if="index === 3"  class="row form-group">
            <div class="col-md-4"></div>
            <fieldset id="3" class="form-group col-md-3">

                <legend> Onde sua empresa está localizada?</legend>

                <label class="badge badge-primary"> Cidade: </label>
                <input type="text" v-model="user.city" class="form-control form-text">
                <label class="badge badge-primary"> Estado:</label>

                <select class="custom-select" v-model="user.state">
                    <option v-for="i in states">{{i.name}} </option>
                </select>

                <label class="badge badge-primary"> Rua: </label>
                <input type="text" v-model="user.street" class="form-control form-text">
                <label class="badge badge-primary"> Bairro: </label>
                <input type="text" v-model="user.neighborhood" class="form-control form-text">
                <label class="badge badge-primary"> Cep:</label>
                <input type="text" v-model="user.cep" class="form-control form-text">

                <label class="badge badge-primary"> Número: </label>
                <input type="number" v-model="user.number" class="form-control form-text">

            </fieldset>
        </div>

        <div v-if="index === 4"  class="row form-group">
            <div class="col-md-4"></div>
            <fieldset id="4" class="form-group col-md-3">

                <legend> Dados de Acesso</legend>

                <label class="badge badge-primary"> Nome de usuário: </label>
                <input type="text" v-model="user.nameUser" class="form-control form-text">
                <label class="badge badge-primary"> Email: </label>
                <input type="email" v-model="user.email" class="form-control form-text">
                <label class="badge badge-primary"> Senha:</label>
                <input type="password" v-model="user.password" class="form-control form-text"><br>


                <div class="row">
                    <div class="col-md-1 col-1"></div>
                    <button type="submit" class="form-control btn btn-success col-sm-5 col-5" @click="submit" v-show="checkFields()">Cadastrar</button>
                    <button type="submit" class="form-control btn btn-success col-sm-5 col-5" disabled v-show="!(checkFields()!==false)">Cadastrar</button>
                    &nbsp;
                    <button type="reset" class="form-control  btn btn-danger col-sm-5 col-5" v-show="checkClear()">Limpar</button>
                    <button type="reset" class="form-control  btn btn-danger disabled col-sm-5 col-5" disabled v-show="checkClear() === false">Limpar</button>
                    &nbsp;   &nbsp
                    <p style=color:red;>{{msgCnpj}}</p>
                    <p style=color:red;>{{msgCpf}}</p>
                    <p style=color:red;>{{msgCep}}</p>
                </div>
            </fieldset>
        </div>
        <div class="row">
            <ul class="pagination col-md-10">

                <div class="col-md-5"></div>
                <p class="col-md-1"><strong style=color:orange;> {{index}} / 4</strong></p>
                <li class="page-item"><a class="page-link" @click="previousItem" :href=previous>previous</a></li>
                <li class="page-item"><a class="page-link" @click="nextItem" :href=next>next</a></li>

            </ul>
        </div>

    </div>

</template>

<script>

   module.exports = {
        name: 'user',

        data(){
            return{

                url: 'http://milsport.herokuapp.com/api/users',
                arrayUsers:[],
                user:{

                    id: null,
                    nameFantasy: null,
                    societyReason: null,
                    cnpj: null,
                    name: null,
                    surname: null,
                    cpf: null,
                    city: null,
                    state: null,
                    street: null,
                    neighborhood: null,
                    cep:null,
                    number:null,
                    nameUser:null,
                    email: null,
                    password: null},

                index: 1,
                next: '#1',
                previous: '#1',
                msgCep: '', //msg de erro para cep,cnpj e cpf
                msgCnpj: '',
                msgCpf:'',

                states:[
                    {name:'Acre'},{name: 'Alagoas'},{name:'Amapá'},{name:'Amazonas'},{name:'Bahia'},{name:'Ceará'},{name:'Distrito Federal'},
                    {name:'Espírito Santo'},{name:'Goiás'},{name:'Maranhão'},{name: 'Mato Grosso'},{name: 'Mato Grosso do Sul'},
                    {name: 'Minas Gerais'},{name: 'Pará'},{name: 'Paraíba'},{name: 'Paraná'},{name: 'Pernambuco'},{name: 'Piauí'},
                    {name: 'Rio de Janeiro'}, {name:'Rio Grande do Norte'},{name:'Rio Grande do Sul'},{name: 'Rondônia'},{name: 'Roraima'},
                    {name: 'Santa Catarina'}, {name: 'São Paulo'},{name: 'Sergipe' },{name: 'Tocantins'}
                ]
            }
        },

        methods:{

            checkClear(){

                return !!(this.user.nameFantasy || this.user.societyReason || this.user.cnpj || this.user.name || this.user.surname ||
                    this.user.cpf || this.user.city || this.user.street || this.user.neighborhood || this.user.cep || this.user.number ||
                    this.user.nameUser || this.user.email || this.user.password);

            },

            checkFields(){

                return !!(this.user.nameFantasy && this.user.societyReason && this.user.cnpj && this.user.name &&
                    this.user.surname && this.user.cpf && this.user.city && this.user.street && this.user.neighborhood &&
                    this.user.cep && this.user.number && this.user.nameUser && this.user.email && this.user.password);

            },

            cpfValidator: function(cpf){

                let regex = new RegExp("[0-9][0-9][0-9].[0-9][0-9][0-9].[0-9][0-9][0-9]-[0-9][0-9]");

                if(!regex.exec(cpf))
                    this.msgCpf = 'O Cpf passado é inválido!';
                else this.msgCpf = '';

                return regex.exec(cpf);

            },

            cnpjValidator: function(cnpj){

                let regex = new RegExp("[0-9][0-9].[0-9][0-9][0-9].[0-9][0-9][0-9]/[0-9][0-9][0-9][0-9]-[0-9][0-9]");

                if(!regex.exec(cnpj))
                    this.msgCnpj = 'O Cnpj passado é inválido!';
                else this.msgCnpj = '';

                return regex.exec(cnpj);

            },

            cepValidador: function(cep){

                let regex = new RegExp("[0-9][0-9][0-9][0-9][0-9]-[0-9][0-9][0-9]");

                if(!regex.exec(cep))
                    this.msgCep = 'O Cep informado é inválido!';
                else this.msgCep = '';

                return regex.exec(cep);

            },

            submit: function () {

                let cpf =  this.cpfValidator(this.user.cpf);
                let cnpj = this.cnpjValidator(this.user.cnpj);
                let cep =  this.cepValidador(this.user.cep);

                if (cpf && cnpj && cep){

                    axios.post(this.url,{

                            auth: {
                                username: 'admin',
                                password: 'password'
                            }
                        }, {
               
                    nameFantasy: this.user.nameFantasy,
                    societyReason: this.user.societyReason,
                    cnpj :this.user.cnpj, 
                    name :this.user.name,
                    surname : this.user.surname,
                    cpf : this.user.cpf,
                    city: this.user.city,
                    state: this.user.state,
                    street: this.user.street,
                    neighborhood: this.user.neighborhood,
                    cep :this.user.cep,
                    number: this.user.number,
                    nameUser: this.user.nameUser,
                    email: this.user.email,
                    password: this.user.password
      

                    }).then(function (r) {

                        console.log(r);
                        window.location.replace("/");

                    }).catch(function (erro) {
                        console.log(erro);
                    });
                }
            },
            nextItem:function () {

                if(this.index < 4){
                    this.index++;
                    this.next = '#'+this.index;

                }
            },
            previousItem:function () {
                if(this.index > 1){
                    this.index--;
                    this.previous = '#'+this.index;
                }
            },

            select: function (i) {

                switch (i) {

                    case 1: {
                        this.index = 1;
                        return '#1';
                    }
                    case 2: {
                        this.index = 2;
                        return '#2';
                    }
                    case 3: {
                        this.index = 3;
                        return '#3';
                    }
                    case 4: {
                        this.index = 4;
                        return '#4';
                    }
                    default:
                }
            }
        }

    };

</script>

<style scoped>

</style>
