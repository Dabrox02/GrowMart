import { getLs, validateToken } from "../util/Auth.js";

export const home = async (e) => {
    if (getLs('token') && getLs('username')) {
        let validLogin = await validateToken(getLs('token'));
        if (validLogin && validLogin.isTokenValid) {
            console.log("hola home");
        } else {
            location.href = "http://localhost:5500/frontend/pages/login.html"
        }
    }
}