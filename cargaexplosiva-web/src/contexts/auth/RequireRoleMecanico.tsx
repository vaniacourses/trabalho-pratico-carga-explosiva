import {JSX, useContext} from "react";
import {AuthContext} from "./AuthContext.tsx";
import UnauthorizedPage from "../../page/UnathorizedPage.tsx";

export const RequireRoleMecanico = ({children}: {children: JSX.Element}) => {
    const  auth = useContext(AuthContext)
    if (auth.funcionario?.role == "Gerente Mecanico" || auth.funcionario?.role == "Administrador" || auth.funcionario?.role == "Mecanico") {
        return children;
    } else {
        return <UnauthorizedPage />
    }

}