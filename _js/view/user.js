
let User = httpVueLoader('_vue/view/view-app/user-view.vue');

const app = new Vue({

   el:'#app',
    render: h => h(User)

});
