import { createRouter, createWebHashHistory } from 'vue-router'
import Home from "@/pages/Home.vue";
import Guests from "@/pages/Guests.vue";
import Bookings from "@/pages/Bookings.vue";
import Rooms from "@/pages/Rooms.vue";

const routes = [
    {
        path: '/home',
        name: 'home',
        component: Home
    },
    {
        path: '/guests',
        name: 'guests',
        component: Guests
    },
    {
        path: '/bookings',
        name: 'bookings',
        component: Bookings
    },
    {
        path: '/rooms',
        name: 'rooms',
        component: Rooms
    },

]

const router = createRouter({
    history: createWebHashHistory(),
    routes})

export default router