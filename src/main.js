import Vue from 'vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue'
import router from './router'
import './assets/global.css'
Vue.config.productionTip = false
Vue.use(ElementUI,{size:"mini"});

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
