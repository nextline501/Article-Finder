import { createRouter, createWebHistory } from 'vue-router'
import Main from './components/Main.vue'
import Summary from './components/Summary.vue'

const routes = [
    {
        name: "home",
        path: "/",
        component: "Main"
    },
    {
        name: 'summaries',
        path: '/summaries',
        component: 'Summary'
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router