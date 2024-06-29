import {z} from "zod";

const capitalizeFirstLetter = (str: string) => {
    return str.replace(/_/g, ' ')
        .replace(/\b\w/g,
            (char) => char.toUpperCase());
};

const formatCPF = (str: string): string => {
    const cleaned = str.replace(/\D/g, '')
    return cleaned.replace(/^(\d{3})(\d{3})(\d{3})(\d{2})$/, '$1.$2.$3-$4');
};

const capitalizeWords = (str: string): string => {
    return str.toLowerCase().replace(/(?:^|\s)\S/g, (char) => char.toUpperCase());
};

const formatDate = (date: Date): string => {
    const day = date.getDate().toString().padStart(2, '0');
    const month = (date.getMonth() + 1).toString().padStart(2, '0');
    const year = date.getFullYear().toString();
    return `${day}/${month}/${year}`;
};

const parseDate = (str: string): Date => {
    const [year, month, day] = str.split('-').map(Number);
    return new Date(year, month - 1, day);
};

export const funcionarioSchema = z.object({
    numCPF: z.string().trim()
        .regex(/^\d+$/)
        .transform(formatCPF),
    nome: z.string().trim().transform(capitalizeWords),
    sobrenome: z.string().trim().transform(capitalizeWords),
    dataNascimento: z.string().transform((str) => formatDate(parseDate(str))),
    email: z.string().toLowerCase().trim(),
    role: z.string().toLowerCase().trim().transform(capitalizeFirstLetter)
})

export type FuncionarioData = z.infer<typeof funcionarioSchema>;