import { useState, FormEvent } from 'react';
import { useAuth } from '../../../hooks/auth/useAuth';
// Component
import Button from "../../commons/button";
import Input from "../../commons/input";

export default function RegisterForm() {
    const { register, loading } = useAuth();

    const [formData, setFormData] = useState({
        username: '',
        email: '',
        password: '',
    });

    const handleChange = (field: string, value: string) => {
        setFormData(prev => ({ ...prev, [field]: value }));
    };


    const handleSubmit = async (e: FormEvent) => {
        e.preventDefault();
        if (formData.password.length < 6) {
            alert('Le mot de passe doit contenir au moins 6 caractères');
            return;
        }
        await register(formData);
    };


    return (
        <div>
            <form className="space-y-4" onSubmit={handleSubmit}>
                <Input iconName="user" label="Username" placeholder="Your username..." value={formData.username} onChange={(value) => handleChange('username', value)} required />
                <Input iconName="envelope" label="Email address" type="email" value={formData.email} onChange={(value) => handleChange('email', value)} placeholder="name@example.com" required />
                <Input iconName="lock" label="Password" type="password" value={formData.password} onChange={(value) => handleChange('password', value)} placeholder="••••••••" required />
                <Button text="Register" type="submit" disabled={loading} />
            </form>
            <div className="mt-8 pt-6 border-t border-white/5 text-center"></div>

        </div>


    );


}