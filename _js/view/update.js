let Update = httpVueLoader('_vue/sport/App-update.vue');

const App = new Vue({

   el:'#app',
   render: h => h(Update)
});

