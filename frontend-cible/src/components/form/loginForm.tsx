import { NavLink } from "react-router-dom";
import Button from "../commons/button";
import Input from "../commons/input";
import { FormEvent, useState } from "react";
import { useAuth } from "../../hooks/auth/useAuth";



export default function LoginForm() {
    const { login, loading, error, clearError } = useAuth();

    const [formData, setFormData] = useState({
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
        await login(formData);
    };



    return (
        <div>
            <form className="space-y-4" onSubmit={handleSubmit}>
                <Input iconName="user" label="Email address" type="email" value={formData.email} onChange={(value) => handleChange('email', value)} placeholder="name@example.com" required />
                <Input iconName="lock" label="Password" type="password" value={formData.password} onChange={(value) => handleChange('password', value)} placeholder="••••••••" required />
                <Button text="Sign in" type="submit" disabled={loading} />
            </form>
            <div className="mt-8 pt-6 border-t border-white/5 text-center"></div>
            <div className="text-center p-2">
                <span className="text-gray-400">Don't have an account ? </span>
                <NavLink className="text-primary-400 hover:text-primary-300" to="/register"> Sign up</NavLink>
            </div>
        </div>
    )
}