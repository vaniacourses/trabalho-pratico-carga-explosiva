import {createContext, useState} from "react";
import {LoginData} from "../Data/LoginData.tsx";
import {APILogin} from "../axios/APILogin.tsx";
import {clearToken, setToken} from "../axios/TokenControl.tsx";

type AuthContextType = {
    user: string
    role: string
    login: (data: LoginData) => Promise<Error | null>
    logout: () => void
}

const AuthCreateContext = createContext<AuthContextType>(null!)

export const AuthContext = ({children}: {children: JSX.Element}) => {

    const [user, setUser] = useState<string>(null!);
    const [role, setRole] = useState<string>(null!);
    const apiLogin = APILogin()

    const login = async (data : LoginData) => {
        const response = await apiLogin.login(data)
        if(response.user && response.role && response.token){
            setRole(response.role)
            setToken(response.token)
            setUser(response.user)
            return null
        }
        return new Error("Algo deu errado, por favor tente novamente mais tarde.");
    }

    const logout = () => {
        setUser(null!)
        clearToken()
    }

    return (
        <AuthCreateContext.Provider value={{user, role, login, logout}}>
            {children}
        </AuthCreateContext.Provider>
    )

}