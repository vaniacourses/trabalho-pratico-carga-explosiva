import {z} from "zod";

export function formatarValorParaExibicao(valor: number): string {
    return valor.toFixed(2).replace('.', ',');
}

export const getVeiculoSchema = z.object({
    id_veiculo: z.string().uuid().trim(),
    placa: z.string(),
    marca: z.string(),
    modelo: z.string(),
    anoFabricacao: z.string().transform(value => {
        const year = parseInt(value, 10);
        if (isNaN(year)) {
            throw new Error("Formato Invalido");
        }
        return year;
    }),
    anoModelo: z.string().transform(value => {
        const year = parseInt(value, 10);
        if (isNaN(year)) {
            throw new Error("Formato Invalido");
        }
        return year;
    }),
    tipo: z.string(),
    numRenavan: z.number(),
    capacidadeCarga: z.number(),
    numChassi: z.string(),
    totalKM: z.number(),
    status: z.boolean(),
    dataCompra: z.string().transform(value => {
        const date = new Date(value);
        const day = String(date.getDate()).padStart(2, '0');
        const month = String(date.getMonth() + 1).padStart(2, '0'); // Months are zero-based
        const year = date.getFullYear();
        return `${day}/${month}/${year}`;
    }),
    valor: z.number().refine(value => {
        const twoDecimalPlaces = /^\d+(\.\d{1,2})?$/;
        return twoDecimalPlaces.test(value.toFixed(2).toString());
    }, { message: 'O valor deve ter exatamente duas casas decimais.' }),
    id_motorista: z.string().optional(),
    motorista: z.string().optional().transform(value => {
        if (typeof value === 'string') {
            return value.toLowerCase().replace(/\b\w/g, firstChar => firstChar.toUpperCase());
        }
        return value;
    })
})

export type GetVeiculoData = z.infer<typeof getVeiculoSchema>;