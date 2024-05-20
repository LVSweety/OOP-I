<template>
    <h1>DRIVER EDIT</h1>
    <DriverEdit />
</template>

<script setup>
import { watch } from 'vue'
import { useRoute } from 'vue-router'
</script>

<script>
import DriverEdit from "../components/DriverEdit.vue";
export default {
    name: 'DriverEditView',
    components: {
        DriverEdit
    }
}
</script>

<style></style>