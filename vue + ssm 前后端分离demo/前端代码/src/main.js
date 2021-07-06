import Vue from 'vue'
import App from './App.vue'
import router from './router';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import qs from 'qs';
import axios from "axios";
// import request from "@/network/request";


// 阻止显示生产模式的消息
Vue.config.productionTip = false;
//配全局属性配置，在任意组件内可以使用this.$qs获取qs对象
Vue.prototype.qs = qs


// 引用axios，并设置基础URL为后端服务api地址

// axios.defaults.baseURL = "http://127.0.0.1:8080"

// axios.defaults.baseURL = '/api'

// Vue函数添加一个原型属性$axios 指向Axios,这样做的好处是在vue实例或组件中不用再去重复引用Axios 直接用this.$axios就能执行axios 方法了
Vue.prototype.axios = axios;
Vue.use(ElementUI);

axios.get('/api/user/findAll').
then(res => {
    console.log(222222)
    console.log(res.data)
}).catch(res =>{
    console.log(res.error)
    console.log(111111)
})





new Vue({
    router,
    render: h => h(App),
}).$mount('#app')




//https://www.cnblogs.com/supwang-learn-enjoy-success/p/11304006.html

// request({
//     url: '/api/user/findALl',
//     method: 'post'
// }).then(res => {
//         console.log(111)
//         console.log(res.data)
//     }
// ).catch(res =>{
//     console.log(222)
//     console.log(res.data)
// })









