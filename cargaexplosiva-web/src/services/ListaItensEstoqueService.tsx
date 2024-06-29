import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/item-do-estoque';

export const listaItensEstoque = () => axios.get(REST_API_BASE_URL);

export const createItemEstoque = (item) => axios.post(REST_API_BASE_URL, item);