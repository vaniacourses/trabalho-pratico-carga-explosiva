import axios from "axios";
import {LoginData} from "../schema/LoginData.tsx";
import {getToken} from "../middleware/TokenControl.tsx";

const api = axios.create({
    baseURL: "http://localhost:8080"
})

api.interceptors.request.use(async config => {
    const token = getToken();
    if(token){
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
})

export const useAPI = () => ({
    login: async (data: LoginData) => {
        try {
            const response = await api.post("/authentication", data)
            return response.data
        }catch (e){
            if(axios.isAxiosError(e) && e.response && e.response.data){
                return {error: e.response.data}
            }
            return {error: "Erro ao executar o login. Verifique os dados e" +
                    " tento novamente."}
        }
    }
})