<template>
    <div class='customeradd'>
        <div v-if="privateType">
            <form>
                <table>
                    <tr>
                        <td>PHONE NO</td>
                        <td><input type="text" required v-model='privateCustomer.phoneNo'></td>
                    </tr>
                    <tr>
                        <td>NAME</td>
                        <td><input type="text" required v-model='privateCustomer.name'></td>
                    </tr>
                    <tr>
                        <td>SURNAME</td>
                        <td><input type="text" required v-model='privateCustomer.surname'></td>
                    </tr>
                    <tr>
                        <td>PERSON CODE</td>
                        <td><input type="text" required v-model='privateCustomer.personCode'></td>
                    </tr>
                    <tr>
                        <td>CITY</td>
                        <td>
                            <select v-model='privateCustomer.city'>
                                <option value="VENTSPILS">VENTSPILS</option>
                                <option value="RIGA">RIGA</option>
                                <option value="LIEPAJA">LIEPAJA</option>
                                <option value="JELGAVA">JELGAVA</option>
                                <option value="DAUGAVPILS">DAUGAVPILS</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>STREET / TITILE</td>
                        <td><input type="text" required v-model='privateCustomer.streetHouseTitle'></td>
                    </tr>
                    <tr>
                        <td>HOUSE NO</td>
                        <td><input type="number" required v-model='privateCustomer.houseNo'></td>
                    </tr>
                </table>
            </form>
        </div>
        <div v-if="!privateType">
            <form>
                <table>
                    <tr>
                        <td>PHONE NO</td>
                        <td><input type="text" required v-model='companyCustomer.phoneNo'></td>
                    </tr>
                    <tr>
                        <td>REG NO</td>
                        <td><input type="text" required v-model='companyCustomer.regNo'></td>
                    </tr>
                    <tr>
                        <td>TITLE</td>
                        <td><input type="text" required v-model='companyCustomer.title'></td>
                    </tr>
                    <tr>
                        <td>CITY</td>
                        <td>
                            <select v-model='companyCustomer.city'>
                                <option value="VENTSPILS">VENTSPILS</option>
                                <option value="RIGA">RIGA</option>
                                <option value="LIEPAJA">LIEPAJA</option>
                                <option value="JELGAVA">JELGAVA</option>
                                <option value="DAUGAVPILS">DAUGAVPILS</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>STREET / TITILE</td>
                        <td><input type="text" required v-model='companyCustomer.streetHouseTitle'></td>
                    </tr>
                    <tr>
                        <td>HOUSE NO</td>
                        <td><input type="number" required v-model='companyCustomer.houseNo'></td>
                    </tr>
                </table>
            </form>
        </div>

        <router-link to="/customer">
            <button>CANCEL</button>
        </router-link>
        <button @click="chandeMode()">MODE</button>
        <button @click="addCustomer()">SAVE</button>
    </div>
</template>

<script>

export default {
    name: 'CustomerAdd',
    data() {
        return {
            privateCustomer: {
                phoneNo: "00000000",
                name: "Janis",
                surname: "Berzins",
                personCode: "000000-00000",
                city: "VENTSPILS",
                streetHouseTitle: "Liepas",
                houseNo: 0
            },
            companyCustomer: {
                phoneNo: "00000000",
                regNo: "LV00000000000",
                title: "SIA XYZ",
                city: "VENTSPILS",
                streetHouseTitle: "Liepas",
                houseNo: 0
            },
            privateType: true,
            id: 0,
            formValidation: {
                fault: false,
            }
        }
    },
    mounted() {
    },
    methods: {
        chandeMode() {
            this.$data.privateType = !this.$data.privateType
        },
        addCustomer() {
            this.$data.formValidation.fault = false

            if (this.$data.privateType) {
                const requestOptions = {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json; charset=utf-8' },
                    body: JSON.stringify(this.$data.privateCustomer)
                };

                if (!this.$data.formValidation.fault) {
                    console.log("updating")
                    fetch('/api/customer/add/p', requestOptions)
                        .then(res => res.json())
                        .then(data => {
                            if (data[0].status == 0) {
                                this.$router.push({ name: 'Customer' })
                            } else {
                                this.$data.formValidation.fault = true
                            }
                        })
                        .catch(err => {
                            this.$data.formValidation.fault = true
                            console.log(err.message)
                        });
                }
            } else {
                const requestOptions = {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json; charset=utf-8' },
                    body: JSON.stringify(this.$data.companyCustomer)
                };

                if (!this.$data.formValidation.fault) {
                    console.log("updating")
                    fetch('/api/customer/add/c', requestOptions)
                        .then(res => res.json())
                        .then(data => {
                            if (data[0].status == 0) {
                                this.$router.push({ name: 'Customer' })
                            } else {
                                this.$data.formValidation.fault = true
                            }
                        })
                        .catch(err => {
                            this.$data.formValidation.fault = true
                            console.log(err.message)
                        });
                }
            }
        }
    }
}
</script>

<style></style>