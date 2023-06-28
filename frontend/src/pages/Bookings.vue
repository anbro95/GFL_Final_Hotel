<template>
  <div>
    <h1>Bookings</h1>
  </div>

  <input type="text" placeholder="Guest Id" v-model="guestId">
  <input type="text" placeholder="Room Id" v-model="roomId">
   Day from:
  <input type="date" v-model="this.booking.dayFrom">
   Day to:
  <input type="date" v-model="this.booking.dayTo">
  <button @click="saveBooking()">Save</button>
  <div v-for="booking in bookings" :key="booking.id" class="roomBox">
    <h3>Id: {{booking.id}}</h3>
    <h3>Guest: {{booking.guest.firstName}} {{booking.guest.lastName}}</h3>
    <h3>Room: {{booking.room.id}}</h3>
    <h3>Date from: {{booking.dayFrom}}</h3>
    <h3>Date to: {{booking.dayTo}}</h3>
    <h3>Sum: {{booking.sum}}</h3>
    <h3>Change date: </h3>
    <input type="date" v-model="this.newDate">
    <button @click="changeDate(booking.id)">Change</button>
  </div>
  <router-view></router-view>

</template>

<script>

import axios from "axios";

export default {
  data() {
    return {
      bookings: [],
      booking: {},
      guestId: 0,
      roomId: 0,
      newDate: "",
    }
  },

  methods: {
    fetchBookings() {
      axios.get(`http://localhost:8082/api/v1/bookings`)
          .then(response => this.bookings = response.data)

    },

    saveBooking() {
      axios.post(`http://localhost:8082/api/v1/bookings`,  this.booking, {
       params: {
         guestId: this.guestId,
         roomId: this.roomId
       }
      })
          .then(response => window.open('F:\\Java\\GFL_Final_Hotel\\receipt.pdf'))
          .catch(reason => {
            if (reason.response.status === 403) {
              alert("Failed to create booking. Check the data")
            }
          })
    },

    changeDate(id) {
      axios.put(`http://localhost:8082/api/v1/bookings/booking/${id}/changeDate`, {}, {
        params: {
          date: this.newDate,
        }
      })
    }

  },

  mounted() {
    this.fetchBookings()
  }
}
</script>

<style scoped>

.roomBox {
  border: dodgerblue 1px solid;
}

</style>