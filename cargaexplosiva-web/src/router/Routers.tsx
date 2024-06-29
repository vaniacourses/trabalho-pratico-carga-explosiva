import {createBrowserRouter} from "react-router-dom";
import App from "../App.tsx";
import Login from "../page/Login.tsx";
import ListaItensEstoque from "../page/ListaItensEstoque.tsx";
import ItensEstoque from "../components/ItensEstoque.tsx";
import {
    pageCadastraVeiculo,
    pageFuncionarios,
    pageHome,
    pageLogin, pageMinhaPagina,
    pageOficina, pageOficinaEstoque, pageVeiculos
} from "./PageLink.tsx";
import Oficina from "../page/Oficina.tsx";
import Funcionarios from "../page/Funcionarios.tsx";
import Home from "../page/Home.tsx";
import MinhaPagina from "../page/MinhaPagina.tsx";
import Veiculos from "../page/Veiculos.tsx";
import {RequireAuth} from "../contexts/auth/RequireAuth.tsx";
import {
    RequireRoleGerenteFrota
} from "../contexts/auth/RequireRoleGerenteFrota.tsx";
import CadastrarVeiculo from "../page/CadastrarVeiculo.tsx";
import NotFoundPage from "../page/NotFoundPage.tsx";

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
            {
                path: pageOficinaEstoque,
                element: <RequireAuth><ListaItensEstoque /></RequireAuth>
            },
            {
                path: pageCadastraVeiculo,
                element: <RequireRoleGerenteFrota><CadastrarVeiculo /></RequireRoleGerenteFrota>
            },
            {
                path: "*",
                element: <NotFoundPage />
            }
        ]
    }
])