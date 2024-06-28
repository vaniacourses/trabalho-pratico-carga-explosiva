import ReactDOM from 'react-dom/client'
import Router from "./router/Router.tsx";

import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.bundle.min.js'

import 'bootstrap-icons/font/bootstrap-icons.min.css'

import './css/root.css'
import './css/body.css'

ReactDOM.createRoot(document.getElementById('root')!).render(
  <Router />,
)
