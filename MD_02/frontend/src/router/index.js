import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import DriverView from '../views/DriverView.vue'
import PageNotFound from '../views/PageNotFound.vue'
import DriverEditView from '../views/DriverEditView.vue'
import DriverAddView from '../views/DriverAddView.vue'
import ParcelView from '../views/ParcelView.vue'
import CustomerView from '../views/CustomerView.vue'
import ParcelEditView from '../views/ParcelEditView.vue'
import ParcelAddView from '../views/ParcelAddView.vue'
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
    name: 'parcel',
    component: ParcelView
  },
  {
    path: '/parcel/:id',
    name: 'ParcelEdit',
    component: ParcelEditView
  },
  {
    path: '/parcel/add',
    name: 'ParcelAdd',
    component: ParcelAddView
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
