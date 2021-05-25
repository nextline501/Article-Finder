import { createApp } from 'vue'
import App from './App.vue'
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap";

import router from './router.js'
import store from './store.js'

const app = createApp(App)
app.use(router)
app.use(store)
app.mount('#app')

