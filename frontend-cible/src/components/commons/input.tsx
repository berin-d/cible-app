import { Icon } from "./icon";
import { IconProp } from '@fortawesome/fontawesome-svg-core';

interface InputProps {
    placeholder?: string;
    label: string;
    value?: string;
    type?: 'text' | 'password' | 'email' | 'number' | 'checkbox';
    disabled?: boolean;
    required?: boolean;
    onChange?: (value: string) => void;
    iconName?: IconProp;
    error?: string;
}

export default function Input({
    placeholder,
    label,
    value,
    disabled,
    type = 'text',
    required,
    onChange,
    iconName,
    error 
}: InputProps) {

    return (
        <div className="w-full">
            <label className={`block uppercase pb-2 text-xs font-semibold tracking-wider px-1 ${error ? 'text-red-400' : 'text-zinc-500'}`}>
                {label}
            </label>

            <div className="relative flex items-center">
                {iconName && (
                    <div className={`absolute left-3 pointer-events-none ${error ? 'text-red-400' : 'text-zinc-500'}`}>
                        <Icon icon={iconName} />
                    </div>
                )}

                <input
                    type={type}
                    placeholder={placeholder}
                    disabled={disabled}
                    value={value}
                    required={required}
                    onChange={(e) => onChange?.(e.target.value)}
                    className={`
                        w-full bg-white/[0.03] border rounded-lg
                        py-2.5 text-sm text-white placeholder:text-zinc-700
                        transition-all focus:outline-none
                        disabled:opacity-50 disabled:cursor-not-allowed
                        ${iconName ? 'pl-10 pr-4' : 'px-4'}
                        ${error 
                            ? 'border-red-500 focus:border-red-400 focus:ring-1 focus:ring-red-400/50' 
                            : 'border-white/5 focus:border-emerald-500/50'
                        }
                    `}
                />
            </div>
            
            {/* Affichage du message d'erreur */}
            {error && (
                <p className="text-red-400 text-xs mt-1.5 px-1 font-medium">
                    {error}
                </p>
            )}
        </div>
    );
}