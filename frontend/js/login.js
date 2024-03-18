import { getLs, validateToken } from "../util/Auth.js";
import { routes } from "../util/Routes.js";

const d = document;
const $ = (e) => d.querySelector(e);

export const login = async (e) => {
    if (getLs('token') && getLs('username')) {
        let validLogin = await validateToken(getLs('token'));
        if (validLogin && validLogin.isTokenValid) {
            location.href = routes.home;
        }
    }

    d.addEventListener("click", (e)=>{
        
    })

}