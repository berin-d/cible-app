import Input from "../../components/commons/input";
import logo from "../../assets/app-icon.png"
import { NavLink } from "react-router-dom";
import Button from "../../components/commons/button";
import { useAuth } from "../../hooks/useAuth";
import { useState, FormEvent } from 'react';

export default function LoginPage() {
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
        <div className="flex flex-col items-center justify-center w-screen h-screen l  gap-2 p-5">
            <div className="pb-5">
                <img src={logo} className="size-48"></img>
            </div>
            <div>
                <form onSubmit={handleSubmit}
                    className="flex flex-col items-center justify-center w-screen h-screen bg-[#1A1A1E] gap-2 p-5">
                    <Input label="Email" placeholder="Your email..." value={formData.email} onChange={(value) => handleChange('email', value)} required />
                    <Input label="Password" placeholder="Your password.." value={formData.password} onChange={(value) => handleChange('password', value)} required />
                    <div className="flex flex-col justify-center items-center p-5">
                        <Button text="Login" type="submit" disabled={loading} />
                        <NavLink className="text-gray-400 mt-2 text-primary hover:text-primary-hover" to="/register">Don't have an account ? Sign up</NavLink>
                    </div>
                </form>



            </div>
        </div>
    );
}



