let User = httpVueLoader('_vue/view/user-update.vue');

const app = new Vue({
   el:"#app",
    render: h => h(User)
});