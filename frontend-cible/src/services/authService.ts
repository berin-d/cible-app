import { authApi } from '../api/authApi';
import { UserRegisterDto, UserLoginDto, User } from '../models/User';

export const authService = {

    async register(data: UserRegisterDto): Promise<{ success: boolean; error?: string; user?: User }> {
        try {
            const user = await authApi.register(data);

            // Sauvegarde de l'utilisateur en localStorage (sans token)
            localStorage.setItem('user', JSON.stringify(user));
            localStorage.setItem('isAuthenticated', 'true');

            return { success: true, user };
        } catch (error: any) {
            console.error('Register error:', error);
            return {
                success: false,
                error: error.message || 'Erreur lors de l\'enregistrement',
            };
        }
    },


}