<template>
  <div>
    <h1>Guests</h1>
  </div>

  <input type="text" placeholder="Name" v-model="this.guest.firstName">
  <input type="text" placeholder="Surname" v-model="this.guest.lastName">
  <input type="text" placeholder="Passport" v-model="this.guest.passport">
  <input type="text" placeholder="Email" v-model="this.guest.email">
  <button @click="saveGuest()">Save</button>
  <div v-for="guest in guests" :key="guest.id" class="roomBox">
    <h3>Name: {{guest.firstName}}</h3>
    <h3>Surname: {{guest.lastName}}</h3>
    <h3>Id: {{guest.id}}</h3>
    <h3>Passport: {{guest.passport}}</h3>
    <h3>Email: {{guest.email}}</h3>
  </div>
  <router-view></router-view>

</template>

<script>

import axios from "axios";

export default {
  data() {
    return {
      guests: [],
      guest: {},
    }
  },

  methods: {
    fetchGuests() {
      const response = axios.get(`http://localhost:8082/api/v1/guests`).then(response => this.guests = response.data)

    },

    saveGuest() {
      axios.post(`http://localhost:8082/api/v1/guests`, this.guest)
    }

  },

  mounted() {
    this.fetchGuests()
  }
}
</script>

<style scoped>

.roomBox {
  border: dodgerblue 1px solid;
}

</style>