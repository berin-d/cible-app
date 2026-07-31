import { authApi } from '../../api/auth/authApi';
import { UserRegisterDto, UserLoginDto, User } from '../../models/users/User';

export const authService = {

    async register(data: UserRegisterDto): Promise<{ success: boolean; error?: string; user?: User }> {
        try {
            const user = await authApi.register(data);
            return { success: true, user };
        } catch (error: any) {
            console.error('Register error:', error);
            return {
                success: false,
                error: error.message || 'Erreur lors de l\'enregistrement',
            };
        }
    },

    async login(data: UserLoginDto): Promise<{ success: boolean; error?: string; token?: string }> {
        try {
            const token = await authApi.login(data);
            localStorage.setItem('token', token);
            return { success: true };
        } catch (error: any) {
            console.error('Login error:', error);
            return {
                success: false,
                error: error.message || 'Erreur lors de la connexion',
            };
        }
    },


}