<template>

    <div class="container-fluid">


        <div id="table" class="row">

            <table class="table table-hover">

                <thead>
                <th>#</th>
                <th>Título</th>
                <th>Marca</th>
                <th>Modelo</th>
                <th>Gênero</th>
                <th>Tamanho</th>
                <th>Preço (R$)</th>
                <th>Atualizar</th>
                <th>Remover</th>
                </thead>

                <tbody>

                <tr v-for="s in shorts">
                    <td>{{s.id}}</td>
                    <td>{{s.title}}</td>
                    <td>{{s.brand}}</td>
                    <td>{{s.model}}</td>
                    <td>{{s.chooseSize}}</td>
                    <td>{{s.chooseGender}}</td>
                    <td>{{s.price}}</td>
                    <td><button class="btn btn-warning">Atualizar</button></td>
                    <td><button @click="askBeforeDelete(s)" class="btn btn-danger">Remover</button></td>

                </tr>

                </tbody>

            </table>

        </div>

    </div>

</template>

<script>

    module.exports = {

        name: 'shorts',

        data(){

            return{

                url: 'http://milsport.herokuapp.com/api/shorts/all/',
                urlDelete: 'http://milsport.herokuapp.com/api/shorts/',
                shorts:[]
            }
        },

        created: function(){

           vm = this;
           vm.get();

        },

        methods: {

            askBeforeDelete: function (s) {

                if (confirm('Deseja realmente deletar?')) {

                    this.deleteItem(s);

                    axios.delete(this.urlDelete + s.id,{

                        auth: {
                            username: 'admin',
                            password: 'password'
                        }

                    }).then(function (r) {
                        console.log(r);
                    }).catch(function (erro) {
                        console.log(erro);
                    });
                }

            },

            deleteItem: function(el){

                if(el != null){

                    let index = this.shorts.indexOf(el);

                    if(index !== -1) {
                        this.shorts.splice(index, 1);
                    }
                }

            },

            get: function () {

                vm = this;
                let id = vm.$session.get("id");

                axios.get(vm.url + id,{
                    auth: {
                        username: 'user',
                        password: 'password'
                    }
                }).then(function (r) {

                    if (r.data.length >= 1) {
                        vm.shorts = r.data;
                    }

                    console.log(r);

                }).catch(function (erro) {

                    console.log(erro);

                });

            },
            update: function (id) {

                return 'update.html?id='+id+'&param=short';


            }
        }

    };
</script>

<style scoped>

</style>
