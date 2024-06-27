import ReactDOM from 'react-dom/client'
import Router from "./router/Router.tsx";

import './css/body.css'
import "./css/root.css"

import {AuthContext} from "./context/AuthContext.tsx";

ReactDOM.createRoot(document.getElementById('root')!).render(
  <AuthContext>
      <Router />
  </AuthContext>,
)
