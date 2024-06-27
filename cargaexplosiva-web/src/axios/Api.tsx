import axios from "axios";
import {getToken} from "./TokenControl.tsx";

const Api = axios.create(
    {
        baseURL: "http://localhost:8080",
        withCredentials: true
    }
);

Api.interceptors.request.use(async config => {
    const token = getToken();
    if(token){
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
})

export default Api;