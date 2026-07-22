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
}

export default function Input({
    placeholder,
    label,
    value,
    disabled,
    type = 'text',
    required,
    onChange,
    iconName
}: InputProps) {


    return (
        <div className="w-full">
            <label className="block uppercase pb-2 text-xs font-semibold text-zinc-500 tracking-wider px-1">
                {label}
            </label>

            <div className="relative flex items-center">
                {iconName && (
                    <div className="absolute left-3 pointer-events-none text-zinc-500">
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
                        w-full bg-white/[0.03] border border-white/5 rounded-lg
                        py-2.5 text-sm text-white placeholder:text-zinc-700
                        transition-all
                        focus:border-emerald-500/50 focus:outline-none
                        disabled:opacity-50 disabled:cursor-not-allowed
                        ${iconName ? 'pl-10 pr-4' : 'px-4'}
                    `}
                />
            </div>
        </div>
    );
}