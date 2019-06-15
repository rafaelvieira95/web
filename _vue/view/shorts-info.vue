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
                    <td><button @click="askBeforeDelete(s.id)" class="btn btn-danger">Remover</button></td>

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

                url: 'http://127.0.0.1:8080/api/shorts/all/',
                urlDelete: 'http://127.0.0.1:8080/api/shorts/',
                shorts:[]
            }
        },

        created: function(){

        this.get();

        },

        methods: {

            askBeforeDelete: function (id) {

                if (confirm('Deseja realmente deletar?')) {

                    axios.delete(this.urlDelete + id).then(function (r) {

                        console.log(r);

                    }).catch(function (erro) {

                        console.log(erro);
                    });
                }

            },

            get: function () {

                vm = this;
                let id = vm.$session.get("id");

                axios.get(vm.url + id).then(function (r) {

                    if (r.data.length >= 1) {
                        vm.shorts = r.data;
                    }

                    console.log(r);

                }).catch(function (erro) {

                    console.log(erro);

                });

            }
        }

    };
</script>

<style scoped>

</style>
