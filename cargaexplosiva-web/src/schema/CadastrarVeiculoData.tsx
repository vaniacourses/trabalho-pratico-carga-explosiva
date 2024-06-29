import {z} from "zod";

export function convertToYYYYMMDD(dateString: string): string {
    const parts = dateString.split('/');
    if (parts.length === 3) {
        const day = parts[0];
        const month = parts[1];
        const year = parts[2];
        if (!isNaN(Number(day)) && !isNaN(Number(month)) && !isNaN(Number(year))) {
            return `${year}-${month.padStart(2, '0')}-${day.padStart(2, '0')}`;
        }
    }
    return "";
}
export const cadastrarVeiculoSchema = z.object({
    placa: z.string({message: "A placa é obrigatória."}).min(1, { message: "A placa é obrigatória." }).toUpperCase(),
    marca: z.string({message: "A marca é obrigatória."}).min(1, { message: "A marca é" +
            " obrigatória." }),
    modelo: z.string({message: "O modelo é obrigatório."}).min(1, { message: "O modelo é" +
            " obrigatório." }),
    anoFabricacao: z.number({message: "O ano de fabricação é obrigatório."}).min(1, { message: "O modelo é" +
            " obrigatório." })
        .int()
        .min(1900, { message: "O ano de fabricação deve ser maior ou igual a 1900." })
        .max(9999, { message: "O ano de fabricação deve ser menor ou igual a 9999." })
        .refine(value => value >= 1900 && value <= 9999, { message: "Ano de fabricação inválido." }),

    anoModelo: z.number({message: "O ano do modelo é obrigatório."}).min(1, { message: "O modelo é" +
            " obrigatório." })
        .int()
        .min(1900, { message: "O ano do modelo deve ser maior ou igual a 1900." })
        .max(9999, { message: "O ano do modelo deve ser menor ou igual a 9999." })
        .refine(value => value >= 1900 && value <= 9999, { message: "Ano do modelo inválido." }),
    tipo: z.string({message: "O tipo é obrigatório."}).min(1, { message: "O tipo é" +
            " obrigatório." }),
    numRenavan: z.number({message: "O numero do renavam é obrigatório."}).int({ message: "O Renavam é" +
            " obrigatório." }),
    capacidadeCarga: z.number({ message: "A capacidade de carga é" +
            " obrigatório." })
        .nonnegative({ message: "A capacidade de carga deve ser um número não" +
                " negativo." })
        .min(0, { message: "A capacidade de carga deve ser maior ou igual a" +
                " zero." })
        .refine(value => !isNaN(value), { message: "A capacidade de carga" +
                " deve ser um número." }),
    numChassi: z.string({message: "O número do chassi é obrigatório."}).min(1, { message: "O número do" +
            " chassi é" +
            " obrigatório." }),
    totalKM: z.number({ message: "O total do KM é obrigatório." })
        .nonnegative({ message: "O valor do KM deve ser um número não negativo." })
        .min(0, { message: "O valor do KM deve ser maior ou igual a zero." })
        .refine(value => !isNaN(value), { message: "O valor do KM deve ser um número." }),
    status: z.boolean(),
    dataCompra: z.string({message: "A data de compra é obrigatória."}).refine((value) => {
        const convertedDate = convertToYYYYMMDD(value);
        return convertedDate !== "";
    }, { message: 'A data de compra é inválida. Utilize o formato' +
            ' DD/MM/YYYY.' }),
    valor: z.number({message: "O valor é obrigatório."}).positive().min(0.01).max(9999999.99).refine(value => {
        const twoDecimalPlaces = /^\d+(\.\d{1,2})?$/;
        return twoDecimalPlaces.test(value.toFixed(2).toString());
    }, { message: 'O valor deve ter exatamente duas casas decimais.' }),
}).strict();

export type CadastrarVeiculoData = z.infer<typeof cadastrarVeiculoSchema>;