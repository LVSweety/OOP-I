<template>
    <div class="driveredit">
        <form v-for="item in drivers" :key="item.idD">
            <table>
                <tr>
                    <td>NAME</td>
                    <td><input type="text" required v-model='item.person.name'></td>
                </tr>
                <tr>
                    <td>SURNAME</td>
                    <td><input type="text" required v-model='item.person.surname'></td>
                </tr>
                <tr>
                    <td>PERSON CODE</td>
                    <td><input type="text" required v-model='item.person.personCode'></td>
                </tr>
                <tr>
                    <td>LICENSE NO</td>
                    <td><input type="text" required v-model='item.licenseNo'></td>
                </tr>
                <tr>
                    <td>EXPERIENCE</td>
                    <td><input type="number" required v-model='item.experienceInYears'></td>
                </tr>
            </table>
            <button>SAVE</button>
            <button @click="removeDriver(item.idD)">REMOVE</button>
        </form>
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
            drivers: [],
            driverID: 0
        }
    },
    mounted() {
        const route = useRoute()
        this.driverID = route.params.id

        fetch('/api/driver/show?id=' + this.driverID)
            .then(res => res.json())
            .then(data => {
                this.$data.drivers = data
                console.log(this.$data.drivers[0].person.idP)
            })
            .catch(err => console.log(err.message));
        //console.log(dri.length);

    },
    methods: {
        removeDriver(id) {
            fetch('/api/driver/remove?id=' + id)
                .catch(err => console.log(err.message));
                this.$router.push({ name: 'driver'})
        }
    }

}
</script>