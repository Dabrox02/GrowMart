import config from "../api/config.js"

export const registerUser = async (username, password) => {
    if (username && password) {
        try {
            const body = {
                "username": username,
                "password": password
            }
            const response = await fetch(`${config.uri}/register`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: new URLSearchParams({
                    'username': username,
                    'password': password
                })
            });
            if (!response.ok) {
                throw new Error('Error verifying register user');
            }
            const data = await response.json();
            return data;
        } catch (error) {
            console.error('Error:', error.message);
            throw error;
        }
    }
}

export async function loginUser(username, password) {
    if (username && password) {
        try {
            const response = await fetch(`${config.uri}/login`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: new URLSearchParams({
                    'username': username,
                    'password': password
                })
            });
            if (!response.ok) {
                throw new Error('Error incorrect data');
            }
            const data = await response.json();
            console.log(data);
            saveLs('token', data.token);
            saveLs('username', data.username);
            return data;
        } catch (error) {
            console.error('Error:', error.message);
            throw error;
        }
    }
}

const saveLs = (key, value) => {
    if (key && value) {
        localStorage.setItem(key, value);
    }
}

const deleteLs = (key) => {
    localStorage.removeItem(key);
}

export const getLs = (key) => {
    return localStorage.getItem(key);
}

const deleteBearer = (token) => {
    return token.startsWith('Bearer ') ? token.slice(7) : token;
}


// export async function obtenerEmpleadosConJefe() {
//     const url = 'http://localhost:8080/order/ordersPerState';
//     try {
//         console.log(getToken());
//         const response = await fetch(url, {
//             method: 'GET',
//             headers: {
//                 'Authorization': getToken() // Incluir el token en el encabezado Authorization
//             }
//         });

//         if (!response.ok) {
//             throw new Error('Error al obtener los empleados');
//         }

//         const data = await response.json();
//         console.log(data);
//     } catch (error) {
//         console.error('Error:', error.message);
//         throw error;
//     }
// }