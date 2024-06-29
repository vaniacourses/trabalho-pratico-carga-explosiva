import {JSX, useContext} from "react";
import {AuthContext} from "./AuthContext.tsx";
import Login from "../../page/Login.tsx";

export const RequireAuth = ({children}: {children: JSX.Element}) => {
    const  auth = useContext(AuthContext)
    if(!auth.funcionario){
        return <Login />
    }
    return children;

}