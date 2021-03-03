import Vue from 'vue'
import App from './App.vue'
require('@/assets/main.scss')

new Vue({
  render: h => h(App),
}).$mount('#app')
