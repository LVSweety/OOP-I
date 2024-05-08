<template>
    <div>
        <table>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>SURNAME</th>
                <th>PERSON CODE</th>
                <th>LICENSE NO</th>
                <th>EXPERIENCE</th>
                <th>EDIT</th>
            </tr>
            <tr v-for="driver in drivers" :key="driver.idD">
                <td>{{ driver.idD }}</td>
                <td>{{ driver.person.name }}</td>
                <td>{{ driver.person.surname }}</td>
                <td>{{ driver.person.personCode }}</td>
                <td>{{ driver.licenseNo }}</td>
                <td>{{ driver.experienceInYears }}</td>
                <td><router-link :to="{ name: 'DriverEdit', params: { id: driver.idD } }">
                        <button>EDIT</button>
                    </router-link>
                </td>
            </tr>
        </table>
    </div>
</template>

<script>

export default {
    name: 'DriverTable',
    data() {
        return {
            drivers: []
        }
    },
    mounted() {
        fetch('/api/driver/show/all')
            .then(res => res.json())
            .then(data => this.drivers = data)
            .catch(err => console.log(err.message));
    }
}
</script>

<style>
.driver tr:nth-child(even) {
    background-color: #3d3d3d;
}

.driver table,
th,
td {
    border: 1px solid;
    border-collapse: collapse;
}
</style>