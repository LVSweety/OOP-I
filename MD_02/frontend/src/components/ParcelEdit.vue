<template>
    <div class="parceledit">
        <form>
            <table>
                <tr>
                    <td>CREATED</td>
                    <td><input type="datetime-local" required v-model='parcel.orderCreated'></td>
                </tr>
                <tr>
                    <td>DELIVERY</td>
                    <td><input type="datetime-local" required v-model='parcel.plannedDelivery'></td>
                    <p v-if="formValidation.orderCreatedFault">Invalid name</p>
                </tr>
                <tr>
                    <td>SIZE</td>
                    <td>
                        <select v-model='parcel.size'>
                            <option value="S">S</option>
                            <option value="M">M</option>
                            <option value="L">L</option>
                            <option value="XL">XL</option>
                            <option value="X">X</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>PRICE</td>
                    <td><input type="number" required v-model='parcel.price'></td>
                    <p v-if="formValidation.orderCreatedFault">Invalid name</p>
                </tr>
                <tr>
                    <td>FRAGILE</td>
                    <td><input type="checkbox" required v-model='parcel.fragile'></td>
                </tr>
                <tr>
                    <td>CUSTOMER</td>
                    <td>
                        <select v-model='parcel.customerCode'>
                            <option v-for="customer in customers" :key="customer.customerCode"
                                :value=customer.customerCode>{{ customer.customerCode }}</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>DRIVER</td>
                    <td>
                        <select v-model='parcel.idD'>
                            <option v-for="driver in drivers" :key="driver.id"
                                :value=driver.id>{{ driver.licenseNo }}</option>
                        </select>
                    </td>

                </tr>
            </table>
        </form>
        <p>{{ parcel }}</p>
        <router-link to="/parcel">
            <button>CANCEL</button>
        </router-link>
        <!-- <button @click="updateDriver()">SAVE</button> -->
        <button @click="removeParcel(parcel.idPA)">REMOVE</button>
    </div>
</template>

<script setup>
import { watch } from 'vue'
import { useRoute } from 'vue-router'
</script>

<script>
export default {
    name: 'ParcelEdit',
    components: {
    },
    data() {
        return {
            parcel: {
                idPA: 0,
                orderCreated: "2000-01-01T00:00",
                plannedDelivery: "2000-01-01T00:00",
                price: 0,
                size: "S",
                fragile: false,
                customerCode: "",
                idD: 0

            },
            customers: [],
            drivers: [],
            formValidation: {
                fault: false,
            }
        }
    },
    mounted() {
        const route = useRoute()
        this.parcel.idPA = route.params.id
        fetch('/api/parcel/show?id=' + this.parcel.idPA)
            .then(res => res.json())
            .then(data => {
                if (data[0] == null) {
                    this.$router.push({ name: 'PageNotFound', params: { catchAll: " " } })
                    return;
                }
                this.$data.parcel.orderCreated = data[0].orderCreated.slice(0, 16);
                this.$data.parcel.plannedDelivery = data[0].plannedDelivery.slice(0, 16);
                this.$data.parcel.price = data[0].price
                this.$data.parcel.size = data[0].size
                this.$data.parcel.fragile = data[0].fragile
                this.$data.parcel.idD = data[0].driver.idD;
                if (data[0].privateCustomer == null) {
                    this.$data.parcel.customerCode = data[0].companyCustomer.customerCode;
                } else {
                    this.$data.parcel.customerCode = data[0].privateCustomer.customerCode;
                }
            })
            .catch(err => console.log(err.message));
        fetch('/api/customer/show/all')
            .then(res => res.json())
            .then(data => {
                this.$data.customers = data;
            })
            .catch(err => console.log(err.message));
        fetch('/api/driver/show/short')
            .then(res => res.json())
            .then(data => {
                this.$data.drivers = data;
            })
            .catch(err => console.log(err.message));
    },
    methods: {
        removeParcel(id) {
            fetch('/api/parcel/remove?id=' + id)
                .catch(err => console.log(err.message));
            this.$router.push({ name: 'parcel' })
        },
    }
}
</script>

<style>
.driveredit p {
    margin: 0px;
}
</style>