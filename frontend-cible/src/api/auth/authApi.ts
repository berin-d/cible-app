
import { User, UserLoginDto, UserRegisterDto } from "../../models/UserModel";
import { apiClient } from "../apiClient";

export const authApi = {
    register: async function (data: UserRegisterDto): Promise<User> {
        return apiClient.post('register', { json: data }).json<User>();
    },

    login: async function (data: UserLoginDto, rememberMe: boolean): Promise<string> {
        return apiClient.post('login', {
            json: data,
            searchParams: { rememberMe: String(rememberMe) },
        }).text();
    }
};