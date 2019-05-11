
var App = httpVueLoader('../_vue/App.vue');

var app = new Vue({

    el:"#app",
     render: h => h(App)
});