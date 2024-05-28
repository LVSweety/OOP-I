<template>
    <h1>DRIVER ADD</h1>
    <DriverAdd/>
</template>

<script setup>
import { watch } from 'vue'
import { useRoute } from 'vue-router'
</script>

<script>
import DriverAdd from "../components/driver/DriverAdd.vue";
export default {
    name: 'DriverAddView',
    components: {
        DriverAdd
    }
}
</script>

<style></style>