import {createBrowserRouter} from "react-router-dom";
import App from "../App.tsx";
import Login from "../page/Login.tsx";
import {
    pageFuncionarios,
    pageHome,
    pageLogin, pageMinhaPagina,
    pageOficina, pageVeiculos
} from "./PageLink.tsx";
import Oficina from "../page/Oficina.tsx";
import Funcionarios from "../page/Funcionarios.tsx";
import Home from "../page/Home.tsx";
import MinhaPagina from "../page/MinhaPagina.tsx";
import Veiculos from "../page/Veiculos.tsx";
import {RequireAuth} from "../contexts/auth/RequireAuth.tsx";

export const Routers = createBrowserRouter([
    {
        element: <App />,
        children: [
            {
                path: pageHome,
                element: <RequireAuth><Home /></RequireAuth>
            },
            {
                path: pageLogin,
                element: <RequireAuth><Login /></RequireAuth>
            },
            {
                path: pageOficina,
                element: <RequireAuth><Oficina /></RequireAuth>
            },
            {
                path: pageFuncionarios,
                element: <RequireAuth><Funcionarios /></RequireAuth>
            },
            {
                path: pageMinhaPagina,
                element: <RequireAuth><MinhaPagina /></RequireAuth>
            },
            {
                path: pageVeiculos,
                element: <RequireAuth><Veiculos /></RequireAuth>
            },
        ]
    }
])