import {z} from "zod";

export const loginSchema = z.object({
    email: z.string()
        .nonempty("O email é obrigatório.")
        .toLowerCase()
        .trim(),
    password: z.string()
        .nonempty("A senha é obrigatório.")
})

export type LoginData = z.infer<typeof loginSchema>;