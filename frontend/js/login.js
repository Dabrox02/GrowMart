import { getLs, loginUser, validateToken } from "../util/Auth.js";
import { routes } from "../util/Routes.js";

const d = document;
const $ = (e) => d.querySelector(e);

const swalError = () => {
    Swal.fire({
        icon: "error",
        title: "Oops...",
        text: "Something went wrong!",
    });
}

const swalSucces = () => {
    let timerInterval;
    Swal.fire({
        title: "Welcome!",
        icon: "success",
        html: "I will close in <b></b> milliseconds.",
        timer: 1000,
        timerProgressBar: true,
        didOpen: () => {
            Swal.showLoading();
            const timer = Swal.getPopup().querySelector("b");
            timerInterval = setInterval(() => {
                timer.textContent = `${Swal.getTimerLeft()}`;
            }, 100);
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

export const login = async (e) => {
    if (getLs('token') && getLs('username')) {
        let validLogin = await validateToken(getLs('token'));
        if (validLogin && validLogin.isTokenValid) {
            location.href = routes.home;
        }
    }

    d.addEventListener("click", async (e) => {
        if (e.target.matches("#btn-login-user")) {
            let data = Object.fromEntries(new FormData($("#frm-login-user")))

            const conditions = [
                data.username !== "",
                data.password !== ""
            ];

            if (conditions.every(condicion => condicion)) {
                let res = await loginUser(data.username, data.password);
                if (!res.error && res.username && res.token) {
                    swalSucces();
                } else {
                    swalError();
                }
            } else {
                swalError();
            }

        }
    })

}