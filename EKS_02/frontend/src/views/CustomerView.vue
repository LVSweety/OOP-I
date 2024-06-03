<template>
    <h1>CUSTOMERS</h1>
    <CustomerTable />
</template>

<script>
import CustomerTable from "../components/customer/CustomerTable.vue";
export default {
    name: 'CustomerView',
    components: {
        CustomerTable
    }
}
</script>