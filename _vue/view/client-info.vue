<template>

    <div v-if="sessionActivated" class="container-fluid">

        <fieldset>
            <legend class="text-justify"> Dados da Empresa</legend>
        <div class="row bg-light">


            <div class="col-md-2"></div>
            <label class="badge badge-pill col-md-3 col-sm-5">Nome Fantasia:
                <strong class="text-md-left text-uppercase" style=color:#007bff;>{{users.nameFantasy}}</strong>
            </label>

            <label class="badge badge-pill col-md-3 col-sm-4">Razão Social:
                <strong class="text-md-left text-uppercase" style=color:#007bff;> {{users.societyReason}} </strong>
            </label>
            <label class="badge badge-pill col-md-3 col-sm-3">Cnpj:
                <strong class="text-md-left text-uppercase" style=color:#007bff;> {{users.cnpj}} </strong>
            </label>


        </div>
        </fieldset>

        <fieldset> <legend class="text-justify"> Dados do Cliente</legend>
        <div class="row bg-light">
            <div class="col-md-2"></div>

            <label class="badge badge-pill col-md-2 col-sm-3">Nome:
                <strong class="text-md-left text-uppercase" style=color:#007bff;> {{users.name}} </strong>  </label>
            <label class="badge badge-pill col-md-2 col-sm-3">Sobrenome:
                <strong class="text-md-left text-uppercase" style=color:#007bff;>{{users.surname}} </strong> </label>
            <label class="badge badge-pill col-md-2 col-sm-3">Cpf:
                <strong class="text-md-left text-uppercase" style=color:#007bff;> {{users.cpf}}</strong> </label>
        </div>
        </fieldset>


        <fieldset><legend class="text-justify"> Endereço </legend>
        <div class="row bg-light">
            <div class="col-md-2"></div>

            <label class="badge badge-pill col-md-1 col-sm-2">Estado:
                <strong class="text-md-left text-uppercase" style=color:#007bff;> {{users.state}}</strong> </label>
            <label class="badge badge-pill col-md-2 col-sm-2">Cidade:
                <strong class="text-md-left text-uppercase" style=color:#007bff;>{{users.city}} </strong> </label>
            <label class="badge badge-pill col-md-2 col-sm-3">Rua:
                <strong class="text-md-left text-uppercase" style=color:#007bff;> {{users.street}}</strong> </label>
            <label class="badge badge-pill col-md-2 col-sm-3">Bairro:
                <strong class="text-md-left text-uppercase" style=color:#007bff;> {{users.neighborhood}}</strong> </label>
            <label class="badge badge-pill col-md-1 col-sm-2">Cep:
                <strong class="text-md-left text-uppercase" style=color:#007bff;>{{users.cep}} </strong> </label>
            <label class="badge badge-pill col-md-1 col-sm-1">Número:
                <strong class="text-md-left text-uppercase" style=color:#007bff;> {{users.number}}</strong> </label>
        </div>
        </fieldset>

        <fieldset> <legend class="text-justify">Dados de Acesso</legend>


        <div class="row bg-light">
            <div class="col-md-2 col-sm-1"></div>
            <label class="badge badge-pill col-md-2 col-sm-4">Nome de Usuário:
                <strong class="text-md-left text-uppercase" style=color:#007bff;>{{users.nameUser}} </strong> </label>
            <label class="badge badge-pill col-md-3 col-sm-4">email:
                <strong class="text-md-left text-uppercase" style=color:#007bff;> {{users.email}}</strong>  </label>
            <label class="badge badge-pill col-md-1 col-sm-2">senha:
                <strong class="text-md-left text-uppercase" style=color:#007bff;>{{users.password}} </strong> </label>
        </div>
        </fieldset>

        <div id="opt" class="row">
         <div class="col-md-4 col-sm-4"></div>
                <a class="btn btn-warning" href="../sport/user-update.html">Atualizar dados</a>
            <div class="col-md-1 col-sm-1"></div>
                <button class="btn btn-danger" @click="deleteUser(users.id)">Apagar conta </button>
            <div class="col-md-4 col-sm-4"></div>
        </div>

        <div id="footer" class="row">
        <footer class="col-md-12 col-sm-12 text-center text-muted"> Copyright &copy; 2019 - 1000Sport Ltda.</footer>
        </div>
    </div>

</template>

<script>

    module.exports = {
        name: 'client',
        data(){

            return{

                users:[],
                sessionActivated: null,
                url:'http://127.0.0.1:8080/api/users/'
            }
        },

        created: function () {

            vm = this;

            if(!vm.$session.exists()){

                vm.sessionActivated = false;

            }else{
                vm.sessionActivated = true;

                let id = vm.$session.get("id");

                axios.get(vm.url + id,{
                    auth: {
                        username: 'admin',
                        password: 'password'
                    }
                }).then(function (r) {
                    vm.users = r.data;


            }).catch(function (erro) {

                console.log(erro);
              });
            }
        },

        methods: {

            deleteUser: function () {

                let id = this.$session.get("id");

                if (confirm('Deseja realmente apagar sua conta? \ntodos os produtos e imagens serão removidos de nossos servidores.')) {

                    axios.delete(this.url + id, {
                        auth: {
                            username: 'admin',
                            password: 'password'
                        }

                    }).then(function (r) {

                        this.$session.destroy();

                        window.location.replace("/sport/");

                    }).catch(function (erro) {

                    });
                }
            }
        }
    };

</script>

<style scoped>

    div#opt{

        margin-top: 50px;
    }

    div#footer{
        margin-top: 150px;
    }

</style>
