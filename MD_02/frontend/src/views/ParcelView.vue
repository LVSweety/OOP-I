<template>
    <h1>PARCELS</h1>
    <h2>TODAY: {{ parcelsToday }}</h2>
    <ParcelTable />
</template>


<script>
import ParcelTable from "../components/parcel/ParcelTable.vue";
export default {
    name: 'ParcelView',
    components: {
        ParcelTable
    },
    data() {
        return {
            parcelsToday: 0
        }
    },
    mounted() {
        fetch('/api/parcel/show/today')
            .then(res => res.json())
            .then(data => this.parcelsToday = data)
            .catch(err => console.log(err.message));
    }
}
</script>
<style></style>