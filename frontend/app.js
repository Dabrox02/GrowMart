import { home } from "./js/home.js";
import { login } from "./js/login.js";
import { getLs, validateToken } from "./util/Auth.js";

const d = document;
const $ = (e) => d.querySelector(e);
const $a = (e) => d.querySelectorAll(e);

export const app = async () => {
    let path = window.location.pathname.split(".")[0];
    console.log(path);

    if (path === "/frontend/pages/login") {
        await login();
    }

    if (path === "/frontend/pages/register") {
        console.log("hola register");
    }

    if (path === "/frontend/pages/home") {
        await home();
    }

    // if (getLs('token') && getLs('username')) {
    //     if (validateToken(getLs('token'))) {
    //         location.href = 'http://localhost:5500/frontend/pages/home.html';
    //     }
    // }
    // location.href = 'http://localhost:5500/frontend/pages/login.html';
}  