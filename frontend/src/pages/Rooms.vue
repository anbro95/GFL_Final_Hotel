<template>
  <div>
    <h1>Guests</h1>
  </div>

  <input type="text" placeholder="Id" v-model="this.room.id">
  <select v-model="this.room.type">
    <option value="STANDARD">Standard</option>
    <option value="SUIT">Suit</option>
    <option value="DELUXE">Deluxe</option>
  </select>
  <select v-model="this.room.capacity">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="3">4</option>
    <option value="3">5</option>
  </select>
  <button @click="saveRoom()">Save</button>
  <div v-for="room in rooms" :key="room.id" class="roomBox">
    <h3>Id: {{room.id}}</h3>
    <h3>Capacity: {{room.capacity}}</h3>
    <h3>Type: {{room.type}}</h3>
    <h3>Is Available: {{room.isAvailable}}</h3>
  </div>
  <router-view></router-view>

</template>

<script>

import axios from "axios";

export default {
  data() {
    return {
      rooms: [],
      room: {},
    }
  },

  methods: {
    fetchRooms() {
      const response = axios.get(`http://localhost:8082/api/v1/rooms`).then(response => this.rooms = response.data)

    },

    saveRoom() {
      axios.post(`http://localhost:8082/api/v1/rooms`, this.room)
    }

  },

  mounted() {
    this.fetchRooms()
  }
}
</script>

<style scoped>

.roomBox {
  border: dodgerblue 1px solid;
}

</style>