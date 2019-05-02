<template>


</template>

<script>


   module.exports = {

        name:'control',
        data(){
            return{
                flag:false
            }
        },
        methods:{
            ativar: function () {

                this.flag = this.flag !== true;

            }
        }
    };

</script>

<style>

</style>