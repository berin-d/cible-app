
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { authService } from '../services/authService';
import { UserRegisterDto } from '../models/User';

export const useAuth = () => {
    const navigate = useNavigate();
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState<string | null>(null);

    const register = async (data: UserRegisterDto) => {
        setLoading(true);
        setError(null);

        const result = await authService.register(data);

        setLoading(false);

        if (result.success) {
            navigate('/dashboard', { replace: true });
            return true;
        } else {
            setError(result.error || 'Erreur lors de l\'enregistrement');
            return false;
        }
    };


    const clearError = () => setError(null);

    return {
        register,
        clearError,
        loading,
        error,
    };
};