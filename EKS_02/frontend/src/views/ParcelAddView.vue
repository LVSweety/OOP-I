<template>
    <h1>PARCEL ADD</h1>
    <ParcelAdd/>
</template>

<script setup>
import { watch } from 'vue'
import { useRoute } from 'vue-router'
</script>

<script>
import ParcelAdd from "../components/parcel/ParcelAdd.vue";
export default {
    name: 'ParcelAddView',
    components: {
        ParcelAdd
    }
}
</script>

<style></style>