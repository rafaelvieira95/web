<template>

    <div class="container-fluid">


        <div id="table" class="row">

            <table class="table table-hover">

                <thead>
                <th>#</th>
                <th>Título</th>
                <th>Marca</th>
                <th>Modelo</th>
                <th>Versão</th>
                <th>Gênero</th>
                <th>Tamanho</th>
                <th>Preço (R$)</th>
                <th>Campo</th>
                <th>Atualizar</th>
                <th>Remover</th>
                </thead>

                <tbody>

                <tr v-for="s in boots">

                    <td>{{s.id}}</td>
                    <td>{{s.title}}</td>
                    <td>{{s.brand}}</td>
                    <td>{{s.model}}</td>
                    <td>{{s.version}}</td>
                    <td>{{s.bootsGender}}</td>
                    <td>{{s.bootSize}}</td>
                    <td>{{s.price}}</td>
                    <td>{{s.field}}</td>
                    <td><a :href="update(s.id)" class="btn btn-warning">Atualizar</a></td>
                    <td><button @click="askBeforeDelete(s)" class="btn btn-danger">Remover</button></td>

                </tr>

                </tbody>

            </table>

        </div>

    </div>

</template>

<script>

    module.exports = {
        name: 'boots',

        data(){

            return{

                url: 'http://127.0.0.1:8080/api/boots/all/',
                urlDelete: 'http://127.0.0.1:8080/api/boots/',
                boots:[]
            }
        },

        created: function(){

            vm = this;
            vm.get();

        },

        methods: {

            askBeforeDelete: function (b) {

                if (confirm('Deseja realmente deletar?')) {

                    this.deleteItem(b);

                    axios.delete(this.urlDelete + b.id).then(function (r) {
                        console.log(r);
                    }).catch(function (erro) {
                        console.log(erro);
                    });
                }

            },

            deleteItem: function(el){

                if(el != null){

                    let index = this.boots.indexOf(el);

                    if(index !== -1) {
                        this.boots.splice(index, 1);
                    }
                }

            },

            get: function () {

                vm = this;
                let id = vm.$session.get("id");

                axios.get(vm.url + id).then(function (r) {

                    if (r.data.length >= 1) {
                        vm.boots = r.data;
                    }

                    console.log(r);

                }).catch(function (erro) {

                    console.log(erro);

                });

            },
            update: function (id) {

                return 'update.html?id='+id+'&param=boot';


            }
        }

    };
</script>

<style scoped>

</style>