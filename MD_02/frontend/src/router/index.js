import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import PageNotFound from '../views/PageNotFound.vue'

import DriverView from '../views/DriverView.vue'
import DriverEditView from '../views/DriverEditView.vue'
import DriverAddView from '../views/DriverAddView.vue'

import ParcelView from '../views/ParcelView.vue'
import ParcelEditView from '../views/ParcelEditView.vue'
import ParcelAddView from '../views/ParcelAddView.vue'

import CustomerView from '../views/CustomerView.vue'
import CustomerEditView from '../views/CustomerEditView.vue'
const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomeView
  },
  {
    path: '/:catchAll(.*)',
    name: 'PageNotFound',
    component: PageNotFound
  },
  {
    path: '/driver',
    name: 'Driver',
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
  },
  {
    path: '/customer/:type/:id',
    name: 'CustomerEdit',
    component: CustomerEditView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
