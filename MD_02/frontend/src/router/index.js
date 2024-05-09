import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import DriverView from '../views/DriverView.vue'
import PageNotFound from '../views/PageNotFound.vue'
import DriverEditView from '../views/DriverEditView.vue'
import DriverAddView from '../views/DriverAddView.vue'
import ParcelView from '../views/ParcelView.vue'
import CustomerView from '../views/CustomerView.vue'
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/:catchAll(.*)',
    name: 'PageNotFound',
    component: PageNotFound
  },
  {
    path: '/driver',
    name: 'driver',
    component: DriverView
  },
  {
    path: '/driver/:id',
    name: 'DriverEdit',
    component: DriverEditView
  },
  {
    path: '/driver/add',
    name: 'DriverAdd',
    component: DriverAddView
  },
  {
    path: '/parcel',
    name: 'Parcel',
    component: ParcelView
  },
  {
    path: '/customer',
    name: 'Customer',
    component: CustomerView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
