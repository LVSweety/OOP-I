<template>
    <div class="driveredit">
        <form>
            <table>
                <tr>
                    <td>NAME</td>
                    <td><input type="text" required v-model='driver.name'></td>
                    <p v-if="formValidation.nameFault">Invalid name</p>
                </tr>
                <tr>
                    <td>SURNAME</td>
                    <td><input type="text" required v-model='driver.surname'></td>
                    <p v-if="formValidation.surnameFault">Invalid surname</p>
                </tr>
                <tr>
                    <td>PERSON CODE</td>
                    <td><input type="text" required v-model='driver.personCode'></td>
                    <p v-if="formValidation.personCodeFault">Invalid person code</p>
                </tr>
                <tr>
                    <td>LICENSE NO</td>
                    <td><input type="text" required v-model='driver.licenseNo'></td>
                    <p v-if="formValidation.licenseFault">Invalid license number</p>
                </tr>
                <tr>
                    <td>EXPERIENCE</td>
                    <td><input type="number" required v-model='driver.experienceInYears'></td>
                    <p v-if="formValidation.experienceFault">Invalid number</p>
                </tr>
            </table>
        </form>
        <router-link to="/driver">
            <button>CANCEL</button>
        </router-link>
        <button @click="updateDriver()">SAVE</button>
        <button @click="removeDriver(driver.idD)">REMOVE</button>
    </div>
</template>

<script setup>
import { watch } from 'vue'
import { useRoute } from 'vue-router'
</script>

<script>
export default {
    name: 'DriverEdit',
    components: {
    },
    data() {
        return {
            driver: {
                idD: 0,
                experienceInYears: 0.0,
                licenseNo: "",
                name: "",
                surname: "",
                personCode: ""
            },
            formValidation: {
                fault: false,
                nameFault: false,
                surnameFault: false,
                personCodeFault: false,
                licenseFault: false,
                experienceFault: false
            }
        }
    },
    mounted() {
        const route = useRoute()
        this.driver.idD = route.params.id
        fetch('/api/driver/show?id=' + this.driver.idD)
            .then(res => res.json())
            .then(data => {
                if (data[0] == null) {
                    this.$router.push({ name: 'PageNotFound', params: { catchAll: " " } })
                    return;
                }
                this.$data.driver.name = data[0].person.name
                this.$data.driver.surname = data[0].person.surname
                this.$data.driver.personCode = data[0].person.personCode
                this.$data.driver.licenseNo = data[0].licenseNo
                this.$data.driver.experienceInYears = data[0].experienceInYears
            })
            .catch(err => console.log(err.message));
    },
    methods: {
        removeDriver(id) {
            fetch('/api/driver/remove?id=' + id)
                .catch(err => console.log(err.message));
            this.$router.push({ name: 'Driver' })
        },
        updateDriver() {
            this.$data.formValidation.fault = false
            this.$data.formValidation.nameFault = false
            this.$data.formValidation.surnameFault = false
            this.$data.formValidation.personCodeFault = false
            this.$data.formValidation.licenseFault = false
            this.$data.formValidation.experienceFault = false

            if (!/^[A-Z]{1}[a-z]+$/.test(this.driver.name)) {
                this.$data.formValidation.nameFault = true
                this.$data.formValidation.fault = true
            }
            if (!/^[A-Z]{1}[a-z]+$/.test(this.driver.surname)) {
                this.$data.formValidation.surnameFault = true
                this.$data.formValidation.fault = true
            }
            if (!/^[0-9]{6}-[0-9]{5}$/.test(this.driver.personCode)) {
                this.$data.formValidation.personCodeFault = true
                this.$data.formValidation.fault = true
            }
            if (!/^[A-Z]{2}[0-9]{6}$/.test(this.driver.licenseNo)) {
                this.$data.formValidation.licenseFault = true
                this.$data.formValidation.fault = true
            }
            if (this.$data.driver.experienceInYears < 0.0) {
                this.$data.formValidation.experienceFault = true
                this.$data.formValidation.fault = true
            }

            const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json; charset=utf-8' },
                body: JSON.stringify(this.driver)
            };

            if (!this.$data.formValidation.fault) {
                console.log("updating")
                fetch('/api/driver/update', requestOptions)
                    .then(res => res.json())
                    .then(data => {
                        if (data[0].status == 0) {
                            this.$router.push({ name: 'Driver' })
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
</script>

<style>
.driveredit p {
    margin: 0px;
}
</style>