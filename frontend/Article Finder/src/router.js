import { createRouter, createWebHistory } from 'vue-router'

// Pages
import Main from './components/Main.vue'
import Summary from './components/Summary.vue'
import Results from './components/Results.vue'
import ReadingTips from './components/ReadingTips.vue'

// Routing to components
const routes = [
    {
        path: '/',
        name: 'home',
        component: Main
    },
    {
        
        path: '/summary',
        name: 'Summary',
        component: Summary
    },
    {
        path: '/results',
        name: 'Results',
        component: Results
    },
    {
        path: '/summary',
        name: 'ReadingTips',
        component: ReadingTips
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router