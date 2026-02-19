import { useState, FormEvent } from 'react';
import { NavLink } from "react-router-dom";
import Input from "../../components/commons/input";
import { useAuth } from '../../hooks/useAuth';

export default function RegisterPage() {
    const { register, loading, error, clearError } = useAuth();

    const [formData, setFormData] = useState({
        username: '',
        email: '',
        password: '',
    });

    const handleChange = (field: string, value: string) => {
        // Effacer l'erreur quand l'utilisateur tape
        if (error) clearError();
        setFormData(prev => ({ ...prev, [field]: value }));
    };



    const handleSubmit = async (e: FormEvent) => {
        e.preventDefault();

        // Validation basique côté client
        if (formData.password.length < 6) {
            // Vous pouvez utiliser votre propre système d'erreur ici
            alert('Le mot de passe doit contenir au moins 6 caractères');
            return;
        }

        await register(formData);
    };

    return (
        <form
            onSubmit={handleSubmit}
            className="flex flex-col items-center justify-center w-screen h-screen bg-[#1A1A1E] gap-2 p-5"
        >
            <div className="pb-5">
                <img src="/src/assets/app-icon.png" className="size-48" alt="App icon" />
            </div>

            <div className="w-full max-w-md">
                {error && (
                    <div className="bg-red-500/20 border border-red-500 text-red-500 p-3 rounded-md mb-4 text-center">
                        {error}
                    </div>
                )}
                <Input
                    label="Username"
                    placeholder="Your username..."
                    value={formData.username}
                    onChange={(value) => handleChange('username', value)}
                    required
                />
                <Input
                    label="Email"
                    type="email"
                    placeholder="Your email..."
                    value={formData.email}
                    onChange={(value) => handleChange('email', value)}
                    required
                />
                <Input
                    label="Password"
                    type="password"
                    placeholder="Your password..."
                    value={formData.password}
                    onChange={(value) => handleChange('password', value)}
                    required
                />
                <div className="flex flex-col justify-center items-center p-5">
                    <button
                        type="submit"
                        disabled={loading}
                        className="bg-[#50C878] p-2 px-8 rounded-md hover:bg-[#45b368] disabled:opacity-50 disabled:cursor-not-allowed transition-colors"
                    >
                        {loading ? 'Chargement...' : 'Register'}
                    </button>
                    <NavLink
                        className="text-gray-400 mt-2 hover:text-primary-hover transition-colors"
                        to="/login"
                    >
                        Already have an account? Login
                    </NavLink>
                </div>
            </div>
        </form >
    );
}