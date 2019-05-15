
let User = httpVueLoader('_vue/view/sport.vue');

const app = new Vue({

   el:'#app',
    render: h => h(User)

});
