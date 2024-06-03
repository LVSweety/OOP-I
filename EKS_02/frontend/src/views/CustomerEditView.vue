<template>
    <h1>CUSTOMER EDIT</h1>
    <CustomerEdit />
    <CustomerParcels />
</template>

<script>
import CustomerEdit from "../components/customer/CustomerEdit.vue";
import CustomerParcels from "../components/customer/CustomerParcels.vue";
export default {
    name: 'CustomerEditView',
    components: {
        CustomerEdit,
        CustomerParcels
    }
}
</script>