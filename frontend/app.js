import { home } from "./js/home.js";
import { login } from "./js/login.js";
import { register } from "./js/register.js";
import { getLs, validateToken } from "./util/Auth.js";
import { routes } from "./util/Routes.js";

const d = document;
const $ = (e) => d.querySelector(e);
const $a = (e) => d.querySelectorAll(e);

export const app = async () => {
    let path = window.location.href;

    if (routes.root.includes(path)) {
        if (getLs('token') && getLs('username')) {
            if (validateToken(getLs('token'))) {
                location.href = routes.home;
            }
        }
        location.href = routes.login;
    }

    if (path === routes.login) {
        await login();
    }

    if (path === routes.register) {
        await register();
    }

    if (path === routes.home) {
        await home();
    }
}  