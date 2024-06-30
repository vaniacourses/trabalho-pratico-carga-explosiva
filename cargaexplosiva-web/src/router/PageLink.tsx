export const pageVeiculos = '/veiculos'
export const pageLogin = '/login'
export const pageFuncionarios = '/funcionarios'
export const pageOficina = '/oficina'
export const pageMinhaPagina = '/mypage'
export const pageHome = '/'
export const pageCadastraVeiculo = '/veiculos/cadastrar'
export const pageOficinaEstoque = '/oficina/estoque'
export const pageCadastraItemEstoque = '/oficina/cadastrar/item-estoque'
export const pageOneVeiculo = '/veiculos/:id'
export const setIDOneVeiculo = (id: string) => `/veiculos/${id}`
export const pageIDDesignarMotorista = '/veiculos/desginar-motorista/:id'
export const setIDDesignarMotorista = (id: string) => {
    if(id){
        return `/veiculos/desginar-motorista/${id}`
    }return "/*"}