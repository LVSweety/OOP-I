<template>
    <div class = 'customer'>
        <table>
            <tr>
                <th>ID</th>
                <th>TYPE</th>
                <th>CUSTOMER CODE</th>
                <th>EDIT</th>
            </tr>
            <tr v-for="customer in customers" :key="customers.id">
                <td>{{ customer.id }}</td>
                <td v-if="customer.type === 'P'">PERSON</td>
                <td v-if="customer.type === 'C'">COMPANY</td>
                <td>{{ customer.customerCode }}</td>
                <td><router-link :to="{ name: 'CustomerEdit', params: { type: customer.type, id: customer.id } }">
                        <button>EDIT</button>
                    </router-link>
                </td>
            </tr>
        </table>
        <router-link to="/customer/add">
            <button>ADD</button>
        </router-link>
    </div>
</template>

<script>

export default {
    name: 'CustomerTable',
    data() {
        return {
            customers: []
        }
    },
    mounted() {
        fetch('/api/customer/show/all')
            .then(res => res.json())
            .then(data => this.customers = data)
            .catch(err => console.log(err.message));
    }
}
</script>

<style>
.customer tr:nth-child(even) {
    background-color: #3d3d3d;
}

.customer table,
th,
td {
    border: 1px solid;
    border-collapse: collapse;
}
</style>