
let Admin = httpVueLoader('_vue/view/view-app/admin-view.vue');

const app = new Vue({
   el:'#app',
    render: h => h(Admin)
});