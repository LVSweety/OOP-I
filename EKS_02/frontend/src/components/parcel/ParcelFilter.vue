<template>
    <div class='parcelfilter'>
        <div v-if="cityMode">
            <table>
                <tr>
                    <td>CITY</td>
                    <td>
                        <select v-model='city'>
                            <option value="VENTSPILS">VENTSPILS</option>
                            <option value="RIGA">RIGA</option>
                            <option value="LIEPAJA">LIEPAJA</option>
                            <option value="JELGAVA">JELGAVA</option>
                            <option value="DAUGAVPILS">DAUGAVPILS</option>
                        </select>
                    </td>
                </tr>
            </table>
        </div>
        <div v-if="!cityMode">
            <table>
                <tr>
                    <td>MIN</td>
                    <td><input type="number" required v-model='min'></td>
                </tr>
                <tr>
                    <td>MAX</td>
                    <td><input type="number" required v-model='max'></td>
                </tr>
            </table>
        </div>
        <button @click="searchMode()">MODE</button>
        <button @click="searchParcel()">SEARCH</button>
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
    </div>
</template>

<script>

export default {
    name: 'ParcelFilter',
    data() {
        return {
            cityMode: true,
            city: "VENTSPILS",
            min: 0,
            max: 100,
            parcels: []
        }
    },
    mounted() {
    },
    methods: {
        searchMode() {
            this.$data.cityMode = !this.$data.cityMode
        },
        searchParcel() {
            if (this.$data.cityMode) {
                fetch('/api/parcel/show/city?city=' + this.$data.city)
                    .then(res => res.json())
                    .then(data => this.parcels = data)
                    .catch(err => console.log(err.message));
            } else {
                fetch('/api/parcel/show/price?min= ' + this.$data.min + '&max=' + this.$data.max)
                    .then(res => res.json())
                    .then(data => this.parcels = data)
                    .catch(err => console.log(err.message));
            }
        }
    }
}
</script>

<style>
.parcelfilter tr:nth-child(even) {
    background-color: #3d3d3d;
}

.parcelfilter table,
th,
td {
    border: 1px solid;
    border-collapse: collapse;
}

.parcelfilter img {
    display: block;
    height: 50%;
    width: 50%;
    margin-left: auto;
    margin-right: auto;
}
</style>