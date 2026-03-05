import { Icon } from "./icon";
import { IconProp } from '@fortawesome/fontawesome-svg-core';

interface ButtonProps {
    text: string;
    label?: string;
    type?: 'button' | 'submit' | 'reset';
    variant?: 'primary' | 'secondary' | 'danger';
    disabled?: boolean;
    iconName?: IconProp;
    fullWidth?: boolean;

    onClick?: () => void;
}


export default function Button(
    // Props
    { text, label, type, variant = 'primary', disabled, iconName, onClick, fullWidth }: ButtonProps)



// Core
{

    // Styles selon le variant
    const variantStyles = {
        primary: 'bg-emerald-500 hover:bg-emerald-400 text-zinc-950',
        secondary: 'bg-transparent border border-zinc-700 text-zinc-100 hover:bg-zinc-800',
        danger: 'bg-red-600 hover:bg-red-500 text-white',
    };

    return (
        <div className="flex flex-col">
            <button
                type={type}
                onClick={onClick}
                disabled={disabled}
                className={`
                    ${variantStyles[variant]}
                    ${fullWidth ? 'w-full' : ''}
                    flex items-center justify-center gap-2
                    font-semibold text-sm py-2.5 px-5 rounded-lg
                    text-zinc-950 transition-all
                    hover:cursor-pointer 
                    disabled:opacity-50 disabled:cursor-not-allowed
                `}
            >
                {iconName && <Icon icon={iconName} />}
                {text}
            </button>
        </div>
    )
}