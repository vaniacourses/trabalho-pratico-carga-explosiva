import {createBrowserRouter} from "react-router-dom";
import App from "../App.tsx";
import Login from "../page/Login.tsx";
import ListaItensEstoque from "../page/ListaItensEstoque.tsx";
import ItensEstoque from "../components/ItensEstoque.tsx";

export const Routers = createBrowserRouter([
    {
        element: <App />,
        children: [
            {
                path: '/',
                element: <Login />
            },
            {
                path: '/estoque',
                element: <ListaItensEstoque />
            },
            {
                path: '/add-item',
                element: <ItensEstoque />
            }
        ]
    }
])