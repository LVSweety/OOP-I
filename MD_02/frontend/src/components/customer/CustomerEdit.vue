<template>
    <div class='customeredit'>
        <div v-if="type === 'P'">
            <form>
                <table>
                    <tr>
                        <td>CUSTOMER CODE</td>
                        <td>
                            <p>{{ privateCustomer.customerCode }}</p>
                        </td>
                        <!-- <p v-if="formValidation.nameFault">Invalid name</p> -->
                    </tr>
                    <tr>
                        <td>PHONE NO</td>
                        <td><input type="text" required v-model='privateCustomer.phoneNo'></td>
                        <!-- <p v-if="formValidation.nameFault">Invalid name</p> -->
                    </tr>
                    <tr>
                        <td>NAME</td>
                        <td><input type="text" required v-model='privateCustomer.name'></td>
                        <!-- <p v-if="formValidation.nameFault">Invalid name</p> -->
                    </tr>
                    <tr>
                        <td>SURNAME</td>
                        <td><input type="text" required v-model='privateCustomer.surname'></td>
                        <!-- <p v-if="formValidation.nameFault">Invalid name</p> -->
                    </tr>
                    <tr>
                        <td>PERSON CODE</td>
                        <td><input type="text" required v-model='privateCustomer.personCode'></td>
                        <!-- <p v-if="formValidation.nameFault">Invalid name</p> -->
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
                        <td><input type="text" required v-model='privateCustomer.streetOrHouseTitle'></td>
                        <!-- <p v-if="formValidation.nameFault">Invalid name</p> -->
                    </tr>
                    <tr>
                        <td>HOUSE NO</td>
                        <td><input type="number" required v-model='privateCustomer.houseNo'></td>
                        <!-- <p v-if="formValidation.nameFault">Invalid name</p> -->
                    </tr>
                </table>
            </form>
            <p>{{ privateCustomer }}</p>
        </div>
        <div v-if="type === 'C'">
            <form>
                <table>
                    <tr>
                        <td>CUSTOMER CODE</td>
                        <td>
                            <p>{{ companyCustomer.customerCode }}</p>
                        </td>
                        <!-- <p v-if="formValidation.nameFault">Invalid name</p> -->
                    </tr>
                    <tr>
                        <td>PHONE NO</td>
                        <td><input type="text" required v-model='companyCustomer.phoneNo'></td>
                        <!-- <p v-if="formValidation.nameFault">Invalid name</p> -->
                    </tr>
                    <tr>
                        <td>REG NO</td>
                        <td><input type="text" required v-model='companyCustomer.regNo'></td>
                        <!-- <p v-if="formValidation.nameFault">Invalid name</p> -->
                    </tr>
                    <tr>
                        <td>TITLE</td>
                        <td><input type="text" required v-model='companyCustomer.title'></td>
                        <!-- <p v-if="formValidation.nameFault">Invalid name</p> -->
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
                        <td><input type="text" required v-model='companyCustomer.streetOrHouseTitle'></td>
                        <!-- <p v-if="formValidation.nameFault">Invalid name</p> -->
                    </tr>
                    <tr>
                        <td>HOUSE NO</td>
                        <td><input type="number" required v-model='companyCustomer.houseNo'></td>
                        <!-- <p v-if="formValidation.nameFault">Invalid name</p> -->
                    </tr>
                </table>
            </form>
            <p>{{ companyCustomer }}</p>
        </div>

        <router-link to="/customer">
            <button>CANCEL</button>
        </router-link>
        <button @click="updateCustomer()">SAVE</button>
        <!-- <button @click="removeDriver(driver.idD)">REMOVE</button> -->
    </div>
</template>

<script setup>
import { watch } from 'vue'
import { useRoute } from 'vue-router'
</script>

<script>
export default {
    name: 'CustomerEdit',
    data() {
        return {
            privateCustomer: {
                id: 0,
                customerCode: "",
                phoneNo: "",
                name: "",
                surname: "",
                personCode: "",
                city: "",
                streetOrHouseTitle: "",
                houseNo: 0
            },
            companyCustomer: {
                id: 0,
                customerCode: "",
                phoneNo: "",
                regNo: "",
                title: "",
                city: "",
                streetOrHouseTitle: "",
                houseNo: 0
            },
            type: "P",
            id: 0,
            formValidation: {
                fault: false,
            }

        }
    },
    mounted() {
        const route = useRoute()
        this.$data.id = route.params.id
        this.$data.type = route.params.type
        fetch('/api/customer/show?type=' + this.$data.type + '&id=' + this.$data.id)
            .then(res => res.json())
            .then(data => {
                if (data.customerCode == null) {
                    this.$router.push({ name: 'PageNotFound', params: { catchAll: " " } })
                    return;
                }
                this.$data.retunrData = data
                if (this.type === "P") {
                    this.$data.privateCustomer.id = data.idPC
                    this.$data.privateCustomer.customerCode = data.customerCode
                    this.$data.privateCustomer.phoneNo = data.phoneNo
                    this.$data.privateCustomer.name = data.person.name
                    this.$data.privateCustomer.surname = data.person.surname
                    this.$data.privateCustomer.personCode = data.person.personCode
                    this.$data.privateCustomer.city = data.address.city
                    this.$data.privateCustomer.streetOrHouseTitle = data.address.streetOrHouseTitle
                    this.$data.privateCustomer.houseNo = data.address.houseNo
                }
                if (this.type === "C") {
                    this.$data.companyCustomer.id = data.idCC
                    this.$data.companyCustomer.customerCode = data.customerCode
                    this.$data.companyCustomer.phoneNo = data.phoneNo
                    this.$data.companyCustomer.regNo = data.regNo
                    this.$data.companyCustomer.title = data.title
                    this.$data.companyCustomer.city = data.address.city
                    this.$data.companyCustomer.streetOrHouseTitle = data.address.streetOrHouseTitle
                    this.$data.companyCustomer.houseNo = data.address.houseNo
                }
            })
            .catch(err => {
                console.log(err.message)
                //this.$router.push({ name: 'PageNotFound', params: { catchAll: " " } })
            });
    },
    methods: {
        // removeDriver(id) {
        //     fetch('/api/driver/remove?id=' + id)
        //         .catch(err => console.log(err.message));
        //     this.$router.push({ name: 'Driver' })
        // },
        updateCustomer() {
            if (this.$data.type == "P") {
                const requestOptions = {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json; charset=utf-8' },
                    body: JSON.stringify(this.$data.privateCustomer)
                };

                if (!this.$data.formValidation.fault) {
                    console.log("updating")
                    fetch('/api/customer/update/p', requestOptions)
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
                    fetch('/api/customer/update/c', requestOptions)
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