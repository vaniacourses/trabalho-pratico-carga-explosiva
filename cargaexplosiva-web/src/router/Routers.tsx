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

export const Routers = createBrowserRouter([
    {
        element: <App />,
        children: [
            {
                path: pageHome,
                element: <Home />
            },
            {
                path: pageLogin,
                element: <Login />
            },
            {
                path: pageOficina,
                element: <Oficina />
            },
            {
                path: pageFuncionarios,
                element: <Funcionarios />
            },
            {
                path: pageMinhaPagina,
                element: <MinhaPagina />
            },
            {
                path: pageVeiculos,
                element: <Veiculos />
            },
        ]
    }
])