<template>
    <div class="parceladd">
        <form>
            <table>
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
                            <option v-for="driver in drivers" :key="driver.id" :value=driver.id>{{ driver.licenseNo }}
                            </option>
                        </select>
                    </td>

                </tr>
            </table>
        </form>
        <p>{{ parcel }}</p>
        <router-link to="/parcel">
            <button>CANCEL</button>
        </router-link>
        <button @click="addParcel()">SAVE</button>
    </div>
</template>

<script>
export default {
    name: 'ParcelAdd',
    components: {
    },
    data() {
        return {
            parcel: {
                plannedDelivery: "2000-01-01T00:00",
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
        const now = new Date();
        this.$data.parcel.plannedDelivery = now.toJSON().slice(0, 16);
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
        addParcel() {
            const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json; charset=utf-8' },
                body: JSON.stringify(this.parcel)
            };

            if (!this.formValidation.fault) {
                fetch('/api/parcel/add', requestOptions)
                    .then(res => res.json())
                    .then(data => {
                        if (data.status != 0) {
                            this.formValidation.fault = true
                        }
                    })
                    .catch(err => console.log(err.message));
                this.$router.push({ name: 'parcel' })
            }
        }
    }

}
</script>

<style>
.driveradd p {
    margin: 0px;
}
</style>