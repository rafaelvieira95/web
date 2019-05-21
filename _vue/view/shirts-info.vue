<template>

    <div class="container-fluid">


         <div id="table" class="row">

             <table class="table table-hover">

                 <thead>
                 <th>#</th>
                 <th>Título</th>
                 <th>Marca</th>
                 <th>Versão</th>
                 <th>Clube</th>
                 <th>Temporada</th>
                 <th>Ocasião</th>
                 <th>Preço (R$)</th>
                 <th>Goleiro</th>
                 <th>Atualizar</th>
                 <th>Remover</th>
                 </thead>

                 <tbody>

                 <tr v-for="s in shirts">
                     <td>{{s.id}}</td>
                     <td>{{s.title}}</td>
                     <td>{{s.brand}}</td>
                     <td>{{s.version}}</td>
                     <td>{{s.club}}</td>
                     <td>{{s.season}}</td>
                     <td>{{s.occasion}}</td>
                     <td>{{s.price}}</td>
                     <td>{{s.gk}}</td>
                     <td><button @click="showId(s.id)" class="btn btn-warning">Atualizar</button></td>
                     <td><button @click="askBeforeDelete(s.id)" class="btn btn-danger">Remover</button></td>

                 </tr>

                 </tbody>


             </table>

         </div>


    </div>

</template>

<script>

    module.exports = {

        name: 'shirts',

        data(){

            return{

                url: 'http://127.0.0.1:8080/sport/api/shirts/all/',
                urlDelete: 'http://127.0.0.1:8080/sport/api/shirts/',
                shirts:[],
                T:[]
            }
        },

        created: function(){

            vm = this;
            let id = vm.$session.get("id");

            axios.get(vm.url + id).then(function (r) {

                   if (r.data.shirt.length > 1) {

                       vm.shirts = r.data.shirt;

                   }else{

                       vm.shirts = r.data;
                   }

                  console.log(r);

            }).catch(function (erro) {

                console.log(erro);

            });


        },

        methods:{

          askBeforeDelete: function (id) {

              if(confirm('Deseja realmente deletar?')){

                  axios.delete(this.urlDelete + id).then(function (r) {

                      console.log(r);

                  }).catch(function (erro) {

                      console.log(erro);
                  });
              }

          },

            showId: function (id) {
                alert('seu id é : '+ id);
            }

        }
    };
</script>

<style scoped>

    div#table{
        margin-top: 10px;
    }

</style>