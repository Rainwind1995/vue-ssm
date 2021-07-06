import Vue from 'vue';
import Router from 'vue-router';
import HelloWorld from '@/components/HelloWorld'
import UserHome from '@/components/userHome'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/HelloWorld',
            name: 'HelloWorld',
            component: HelloWorld
        },
        {
            path: '/',
            name: 'userHome',
            component: UserHome
        }
    ]
})
// https://blog.csdn.net/jianyuwuyi/article/details/107924066
// https://www.jb51.net/article/190355.htm
// https://www.jb51.net/article/190355.htm
