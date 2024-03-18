import { getLs, validateToken } from "../util/Auth.js";
import { routes } from "../util/Routes.js";

export const home = async (e) => {
    if (getLs('token') && getLs('username')) {
        let validLogin = await validateToken(getLs('token'));
        if (validLogin && validLogin.isTokenValid) {
            console.log("hola home");
        } 
    } 
    location.href = routes.login;
}