import { User, UserLoginDto, UserRegisterDto } from "../../models/users/User";
import { apiClient } from "../apiClient";

export const authApi = {
    register: async function (data: UserRegisterDto): Promise<User> {
        return apiClient.post('register', { json: data }).json<User>();
    },

    login: async function (data: UserLoginDto): Promise<string> {
        return apiClient.post('login', { json: data }).text();
    }
};