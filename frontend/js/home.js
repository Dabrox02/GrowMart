import { getLs, deleteLs, validateToken } from "../util/Auth.js";
import { routes } from "../util/Routes.js";

const d = document;
const $ = (e) => d.querySelector(e);
const $a = (e) => d.querySelectorAll(e);

const swalSucces = () => {
    let timerInterval;
    Swal.fire({
        title: "See you!",
        icon: "info",
        timer: 1000,
        timerProgressBar: true,
        didOpen: () => {
            Swal.showLoading();
        },
        willClose: () => {
            clearInterval(timerInterval);
        }
    }).then((result) => {
        if (result.dismiss === Swal.DismissReason.timer) {
            location.href = routes.home;
        }
    });
}

export const home = async (e) => {
    if (getLs('token') && getLs('username')) {
        let validLogin = await validateToken(getLs('token'));
        if (validLogin && validLogin.isTokenValid) {
            let username = getLs("username");
            let token = getLs("token");
            $("#main-sidebar").setAttribute("username", username);


            d.addEventListener("click", (e) => {
                if (e.target.matches('[data-widget="logout"]') || e.target.closest('[data-widget="logout"]')) {
                    swalSucces();
                    deleteLs("token");
                    deleteLs("username");
                }
            })
        } else {
            location.href = routes.login;
        }
    } else {
        location.href = routes.login;
    }
}