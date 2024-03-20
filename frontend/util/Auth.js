import config from "../api/config.js"

export const validateToken = async (token) => {
    if (token) {
        try {
            const response = await fetch(`${config.uri}/validateToken?token=${token}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                }
            });
            const data = await response.json();
            return data;
        } catch (error) {
            console.error('Error:', error.message);
            throw error;
        }
    }
}

export const registerUser = async (username, password) => {
    if (username && password) {
        try {
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
                throw new Error('Cannot Created : Verifying user data');
            }
            const data = await response.json();
            return data;
        } catch (error) {
            console.error('Error:', error.message);
            return { error }
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
                throw new Error('Cannot Access: Incorrect data');
            }
            const data = await response.json();
            saveLs('token', data.token);
            saveLs('username', data.username);
            return data;
        } catch (error) {
            console.error('Error:', error.message);
            return { error }
        }
    }
}

export const getRequest = async ({ path, config, needParams, params }, host, mainRoute, token) => {
    try {
        let queryParams;
        config.headers = { 'Authorization': token };
        path = `${host}${mainRoute}${path}`;
        if (needParams) {
            config.headers = { ...config.headers, "Content-Type": "application/x-www-form-urlencoded" }
            queryParams = new URLSearchParams({ ...params }).toString();
            path = `${path}${queryParams ? `?${queryParams}` : ""}`;
        }
        const response = await fetch(path, config);
        if (response.status === 200) {
            return await response.json();
        } else {
            let { message } = await response.json();
            return { status: response.status, message }
        }
    } catch (error) {
        return { status: 404, error };
    }
}

export const deleteLs = (key) => {
    localStorage.removeItem(key);
}

export const getLs = (key) => {
    return localStorage.getItem(key);
}

const saveLs = (key, value) => {
    if (key && value) {
        localStorage.setItem(key, value);
    }
}