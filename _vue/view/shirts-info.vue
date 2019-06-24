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
                     <td><a :href=update(s.id)  class="btn btn-warning">Atualizar</a></td>
                     <td><button @click="askBeforeDelete(s)" class="btn btn-danger">Remover</button></td>

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

                url: 'http://127.0.0.1:8080/api/shirts/all/',
                urlDelete: 'http://127.0.0.1:8080/api/shirts/',
                shirts:[]    
            }
        },

        created: function(){
          vm = this;
          vm.get();
         
        },

        methods:{

          askBeforeDelete: function (s) {

              if(confirm('Deseja realmente deletar?')){

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

                  let index = this.shirts.indexOf(el);

                  if(index !== -1) {
                      this.shirts.splice(index, 1);
                  }
              }

          } ,

          get: function(){

              vm = this;
            let id = vm.$session.get("id");

            axios.get(vm.url + id,{
                auth: {
                    username: 'user',
                    password: 'password'
                }
            }).then(function (r) {

                vm.shirts = r.data;
                console.log(r);

            }).catch(function (erro) {

                console.log(erro);

            });


           },

            update: function (id) {

              return 'update.html?id='+id+'&param=shirt';


            }
        }
    };
</script>

<style scoped>

    div#table{
        margin-top: 10px;
    }

</style>
