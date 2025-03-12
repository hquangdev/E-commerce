import axios from "axios";

// Lấy token từ localStorage
export const getAuthToken = () => {
    return localStorage.getItem("token");
};

export const api = axios.create({
    baseURL: "http://localhost:8080/api/v1",
});

api.interceptors.request.use((config) => {
    const token = getAuthToken();
    if (token) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
}, (error) => {
    return Promise.reject(error);
});
