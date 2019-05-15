
let App = httpVueLoader('_vue/sport/App.vue');

const app = new Vue({

    el:"#app",
     render: h => h(App)
});