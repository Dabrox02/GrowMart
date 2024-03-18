import { app } from "./app.js";
import { getLs, loginUser, registerUser } from "./util/Auth.js";

addEventListener("DOMContentLoaded", async (e) => {
    if (getLs('token') && getLs('username')) {
        location.href = 'http://localhost:5500/frontend/pages/home.html';
    } else {
        location.href = 'http://localhost:5500/frontend/pages/login.html';
    }
})