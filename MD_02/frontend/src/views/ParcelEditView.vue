<template>
    <h1>PARCEL EDIT</h1>
    <ParcelEdit />
</template>

<script setup>
</script>

<script>
import ParcelEdit from "../components/parcel/ParcelEdit.vue";
import DriverEdit from "../components/parcel/ParcelEdit.vue";
export default {
    name: 'ParcelEditView',
    components: {
        ParcelEdit
    }
}
</script>

<style></style>