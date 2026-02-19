import { apiClient } from "./apiClient";
import { UserRegisterDto, UserLoginDto, User } from "../models/User";

export const authApi = {

    register: async (data: UserRegisterDto): Promise<User> => {
        return apiClient.post('users/', { json: data }).json<User>();
    }

};