import axios from "axios";
import {LoginData} from "../schema/LoginData.tsx";
import {getToken} from "../middleware/TokenControl.tsx";
import {CadastrarVeiculoData} from "../schema/CadastrarVeiculoData.tsx";

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
    },
    cadastrarVeiculo: async (data: CadastrarVeiculoData) => {
        try {
            const response = await api.post("/veiculo", data)
            return response.data
        }catch (e){
            if(axios.isAxiosError(e) && e.response && e.response.data){
                return {error: e.response.data}
            }
            return {error: "Erro ao cadastrar o veiculo. Verifique os dados" +
                    " ou entre em contado com o setor de TI."}
        }
    },
    getOneVeiculo: async (data: string) => {
        try {
            const response = await api.get(`/veiculo/${data}`)
            return response.data
        }catch (e){
            if(axios.isAxiosError(e) && e.response && e.response.data){
                return {error: e.response.data}
            }
            return {error: "Erro ao localizar o veiculo."}
        }
    },
    getAllVeiculo: async () => {
        try {
            const response = await api.get("/veiculo")
            return response.data
        }catch(e){
            return {error: "Erro ao solicitar os veiculos."}
        }
    },
    exluirVeiculo: async (id: string) => {
        try {
            const response = await api.delete(`/veiculo/${id}`)
            return response.status
        }catch (e){
            return {error: "Erro ao solicitar a exclusão do veiculo."}
        }
    }
})