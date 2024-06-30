import {AuthContext} from "./AuthContext.tsx";
import {useState} from "react";
import {
    FuncionarioData,
    funcionarioSchema
} from "../../schema/FuncionarioData.tsx";
import {LoginData} from "../../schema/LoginData.tsx";
import {
    clearToken,
    setToken
} from "../../middleware/TokenControl.tsx";
import {useAPI} from "../../hooks/useApi.tsx";
import {JSX} from "react";

export const AuthProvider = ({children}: {children: JSX.Element}) => {

    const [funcionario, setFuncionario] = useState<FuncionarioData | null>(null!)
    const api = useAPI()

    const login = async (data: LoginData)=> {
        try {
            const response = await api.login(data);
            if(response.error){
                return response.error
            }
            const validatedResponse = funcionarioSchema.safeParse(response.funcionario)
            if(!validatedResponse.success){
                return "Erro de validação dos dados do funcionario."
            }
            setFuncionario(validatedResponse.data)
            setToken(response.token)
            return true
        }catch (e){
            return "Erro ao realizar o login. Por favor, tente novamente" +
                " mais tarde."
        }
    }

    function logout(){
        setFuncionario(null)
        clearToken()
    }

    return(
        <AuthContext.Provider value={{funcionario, login, logout}}>
            {children}
        </AuthContext.Provider>
    )
}