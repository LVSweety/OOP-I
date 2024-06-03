<template>
    <div class = 'customerparcels'>
        <h2>PARCELS</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>CUSTOMER CODE</th>
                <th>ORDER CREATED</th>
                <th>ORDER COMPLEATE</th>
                <th>SIZE</th>
                <th>PRICE</th>
                <th>FRAGILE</th>
                <th>EDIT</th>
            </tr>
            <tr v-for="parcel in parcels" :key="parcel.idPA">
                <td>{{ parcel.idPA }}</td>
                <td v-if="parcel.privateCustomer">{{ parcel.privateCustomer.customerCode }}</td>
                <td v-else-if="parcel.companyCustomer">{{ parcel.companyCustomer.customerCode }}</td>
                <td>{{ parcel.orderCreated }}</td>
                <td>{{ parcel.plannedDelivery }}</td>
                <td>{{ parcel.size }}</td>
                <td>{{ parcel.price }}</td>
                <td v-if="parcel.fragile"><img src="/CHECK.png"></td>
                <td v-else><img src="/CROSS.png"></td>
                <td>
                    <router-link :to="{ name: 'ParcelEdit', params: { id: parcel.idPA } }">
                        <button>EDIT</button>
                    </router-link>
                </td>
            </tr>
        </table>
        <h2>TOTAL: {{ total }}</h2>
    </div>
</template>

<script setup>
import { watch } from 'vue'
import { useRoute } from 'vue-router'
</script>

<script>
export default {
    name: 'CustomerParcels',
    data() {
        return {
            parcels: [],
            total: 0.0
        }
    },
    mounted() {
        const route = useRoute()
        this.id = route.params.id
        this.type = route.params.type
        fetch('/api/parcel/show/customer?type=' + this.type  + '&id=' + this.id)
            .then(res => res.json())
            .then(data => {
                this.$data.parcels = data
            })
            .catch(err => {
                console.log(err.message)
                this.$router.push({ name: 'PageNotFound', params: { catchAll: " " } })
            });
        fetch('/api/parcel/show/income?type=' + this.type  + '&id=' + this.id)
            .then(res => res.json())
            .then(data => this.total = data)
            .catch(err => console.log(err.message));
    }
}
</script>

<style>
.customerparcels tr:nth-child(even) {
    background-color: #3d3d3d;
}

.customerparcels table,
th,
td {
    border: 1px solid;
    border-collapse: collapse;
}

.customerparcels img {
    display: block;
    height: 50%;
    width: 50%;
    margin-left: auto;
    margin-right: auto;
}
</style>