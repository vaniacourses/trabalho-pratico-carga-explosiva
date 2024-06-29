import {createContext} from "react";
import {FuncionarioData} from "../../schema/FuncionarioData.tsx";
import {LoginData} from "../../schema/LoginData.tsx";

export type AuthContextType = {
    funcionario: FuncionarioData | null;
    login: (data: LoginData) => Promise<boolean | string>;
    logout: () => void
}

export const AuthContext = createContext<AuthContextType>(null!);