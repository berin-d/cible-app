import { apiClient } from "../apiClient";
import { UserRegisterDto, UserLoginDto, User } from "../../models/Users/User";

export const authApi = {
    register: async function (data: UserRegisterDto): Promise<User> {
        return apiClient.post('users/', { json: data }).json<User>();
    },

    login: async function (data: UserLoginDto): Promise<User> {
        return apiClient.post('users/login', { json: data }).json<User>();
    }
};