let Update = httpVueLoader('_vue/sport/App-update.vue');

const app = new Vue({

   el:'#app',
   render: h => h(Update)
});

