import {LoginData} from "../Data/LoginData.tsx";
import Api from "./Api.tsx";

export const APILogin = () => ({

    login: async (data: LoginData) => {
        try {
            const response = await  Api.post("/authentication", data)
            return response.data;
        }catch (e){
            return Error("Algo deu errado, por favor tente novamente mais" +
                " tarde.")
        }
    }
})