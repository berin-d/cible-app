import { FormEvent, useState } from "react";
import { useAuth } from "../../../hooks/auth/useAuth";
// Component
import Button from "../../commons/button";
import Input from "../../commons/input";

export default function LoginForm() {

    const { login, loading, error: apiError, clearError } = useAuth();

    const [formData, setFormData] = useState({
        email: '',
        password: '',
    });

    const [validationErrors, setValidationErrors] = useState({
        email: '',
    });


    const validateEmail = (email: string) => {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!email) {
            return "Email is required.";
        } else if (!emailRegex.test(email)) {
            return "Invalid email format.";
        }
        return "";
    };

    const handleChange = (field: string, value: string) => {

        if (apiError) clearError();
        
        setFormData(prev => ({ ...prev, [field]: value }));

        if (field === 'email') {
            setValidationErrors(prev => ({
                ...prev,
                email: validateEmail(value)
            }));
        }
    };

    const handleSubmit = async (e: FormEvent) => {
        e.preventDefault();
        

        const emailError = validateEmail(formData.email);
        if (emailError) {
            setValidationErrors(prev => ({ ...prev, email: emailError }));
            return; 
        }

        await login(formData);
    };

    return (
        <div>
            {apiError && (
                <div className="mb-4 p-3 rounded bg-red-500/10 border border-red-500/50 text-red-400 text-sm">
                    {apiError.toString()} 
                </div>
            )}

            <form className="space-y-4" onSubmit={handleSubmit}>
                <Input 
                    iconName="envelope" 
                    label="Email address" 
                    type="email" 
                    value={formData.email} 
                    onChange={(value) => handleChange('email', value)} 
                    placeholder="name@example.com" 
                    error={validationErrors.email}
                    required 
                />
                
                <Input 
                    iconName="lock" 
                    label="Password" 
                    type="password" 
                    value={formData.password} 
                    onChange={(value) => handleChange('password', value)} 
                    placeholder="••••••••" 
                    required 
                />
                
                {/* On peut aussi désactiver le bouton si le format email est invalide */}
                <Button 
                    text="Sign in" 
                    type="submit" 
                    disabled={loading || !!validationErrors.email} 
                />
            </form>
            <div className="mt-8 pt-6 border-t border-white/5 text-center"></div>
        </div>
    )
}