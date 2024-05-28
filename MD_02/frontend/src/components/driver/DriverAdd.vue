<template>
    <div class="driveradd">
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
        <button @click="addDriver()">SAVE</button>
    </div>
</template>

<script>
export default {
    name: 'DriverAdd',
    components: {
    },
    data() {
        return {
            driver: {
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
    methods: {
        addDriver() {
            this.formValidation.fault = false
            this.formValidation.nameFault = false
            this.formValidation.surnameFault = false
            this.formValidation.personCodeFault = false
            this.formValidation.licenseFault = false
            this.formValidation.experienceFault = false

            if (!/^[A-Z]{1}[a-z]+$/.test(this.driver.name)) {
                this.formValidation.nameFault = true
                this.formValidation.fault = true
            }
            if (!/^[A-Z]{1}[a-z]+$/.test(this.driver.surname)) {
                this.formValidation.surnameFault = true
                this.formValidation.fault = true
            }
            if (!/^[0-9]{6}-[0-9]{5}$/.test(this.driver.personCode)) {
                this.formValidation.personCodeFault = true
                this.formValidation.fault = true
            }
            if (!/^[A-Z]{2}[0-9]{6}$/.test(this.driver.licenseNo)) {
                this.formValidation.licenseFault = true
                this.formValidation.fault = true
            }
            if (this.driver.experienceInYears < 0.0) {
                this.formValidation.experienceFault = true
                this.formValidation.fault = true
            }

            const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json; charset=utf-8' },
                body: JSON.stringify(this.driver)
            };

            if (!this.formValidation.fault) {
                fetch('/api/driver/add', requestOptions)
                    .then(res => res.json())
                    .then(data => {
                        if (data.status != 0) {
                            this.formValidation.fault = true
                        }
                    })
                    .catch(err => console.log(err.message));
                this.$router.push({ name: 'driver' })
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