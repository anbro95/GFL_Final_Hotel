<template>
  <router-link :to="{name: 'guests'}">Guests</router-link>
  <br>
  <router-link :to="{name: 'bookings'}">Bookings</router-link>
  <br>
  <router-link :to="{name: 'rooms'}">Rooms</router-link>
  <router-view></router-view>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {

    }
  }
}
</script>

<style lang="scss" scoped>

</style>