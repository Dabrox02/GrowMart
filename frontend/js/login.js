import { getLs, validateToken } from "../util/Auth.js";

export const login = async (e) => {
    if (getLs('token') && getLs('username')) {
        let validLogin = await validateToken(getLs('token'));
        if (validLogin && validLogin.isTokenValid) {
            location.href = 'http://localhost:5500/frontend/pages/home.html';
        }
    }
}