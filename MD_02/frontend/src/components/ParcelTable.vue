<template>
    <div class="parcel">
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
        <router-link to="/parcel/add">
            <button>ADD</button>
        </router-link>
    </div>
</template>

<script>

export default {
    name: 'ParcelTable',
    data() {
        return {
            parcels: []
        }
    },
    mounted() {
        fetch('/api/parcel/show/all')
            .then(res => res.json())
            .then(data => this.parcels = data)
            .catch(err => console.log(err.message));
    }
}
</script>

<style>
.parcel tr:nth-child(even) {
    background-color: #3d3d3d;
}

.parcel table,
th,
td {
    border: 1px solid;
    border-collapse: collapse;
}

.parcel img {
    display: block;
    height: 50%;
    width: 50%;
    margin-left: auto;
    margin-right: auto;
}
</style>