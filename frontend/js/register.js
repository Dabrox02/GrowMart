import { getLs, registerUser, validateToken } from "../util/Auth.js";
import { routes } from "../util/Routes.js";

const d = document;
const $ = (e) => d.querySelector(e);

const validLenghtField = (valor, longitudMinima) => valor.trim() !== "" && valor.length >= longitudMinima;

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
        title: "User Created!",
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
            location.href = routes.login;
        }
    });
}

export const register = async (e) => {
    if (getLs('token') && getLs('username')) {
        let validLogin = await validateToken(getLs('token'));
        if (validLogin && validLogin.isTokenValid) {
            location.href = routes.home;
        }
    }

    d.addEventListener("click", async (e) => {
        if (e.target.matches("#btn-register-user")) {
            let data = Object.fromEntries(new FormData($("#frm-register-user")))

            const conditions = [
                validLenghtField(data.username, 4),
                /^(?=.*[a-zA-Z])[a-zA-Z0-9]{4,}$/.test(data.username),
                validLenghtField(data.password, 4),
                validLenghtField(data.retypePassword, 4),
                data.password === data.retypePassword
            ];

            if (conditions.every(condicion => condicion)) {
                let res = await registerUser(data.username, data.password);
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
