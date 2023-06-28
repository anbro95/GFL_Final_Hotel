<template>
  <div>
    <h1>Rooms</h1>
  </div>

  <input type="text" placeholder="Id" v-model="this.room.id">
  <select v-model="this.room.type">
    <option value="STANDARD">Standard</option>
    <option value="SUIT">Suit</option>
    <option value="DELUXE">Deluxe</option>
  </select>
  <input type="text" placeholder="Capacity" v-model="this.room.capacity">
  <button @click="saveRoom()">Save</button>
  <div v-for="room in rooms" :key="room.id" class="roomBox">
    <h3>Id: {{room.id}}</h3>
    <h3>Capacity: {{room.capacity}}</h3>
    <h3>Type: {{room.type}}</h3>
    <h3>Is Available: {{room.isAvailable}}</h3>
    <button @click="vacateRoom(room.id)">Vacate</button>
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
    },

    vacateRoom(id) {
      axios.put(`http://localhost:8082/api/v1/rooms/vacate/${id}`)
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