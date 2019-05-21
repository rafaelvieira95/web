<template>

<div id="app">
    <user></user>
</div>

</template>

<script>

    let user = httpVueLoader('_vue/view/user.vue');

    module.exports = {
        name: 'app',
        components:{user}
    };

</script>

<style scoped>

</style>