import {JSX, useContext} from "react";
import {AuthContext} from "./AuthContext.tsx";
import UnauthorizedPage from "../../page/UnathorizedPage.tsx";

export const RequireRoleGerenteFrota = ({children}: {children: JSX.Element}) => {
    const  auth = useContext(AuthContext)
    if (auth.funcionario?.role == "Gerente Frota" || auth.funcionario?.role == "Administrador") {
        return children;
    } else {
        return <UnauthorizedPage />
    }

}