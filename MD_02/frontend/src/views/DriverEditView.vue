<template>
    <h1>DRIVER EDIT</h1>
    <DriverEdit />
    <DriverParcels />
</template>

<script setup>
import { watch } from 'vue'
import { useRoute } from 'vue-router'
</script>

<script>
import DriverEdit from "../components/driver/DriverEdit.vue";
import DriverParcels from "../components/driver/DriverParcels.vue";
export default {
    name: 'DriverEditView',
    components: {
        DriverEdit,
        DriverParcels
    }
}
</script>

<style></style>