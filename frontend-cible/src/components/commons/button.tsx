import { Icon } from "./icon";

interface ButtonProps {
    text: string;
    label: string;
    color?: 'primary' | 'secondary' | 'danger';
    disabled?: boolean;
    iconName?: string;
}


export default function Button(
    // Props
    { text, label, color, disabled, iconName }: ButtonProps)

// Core
{
    return (
        <div className="flex flex-col justify-center items-center p-5">
            <p>{label}</p>
            <button className={`button ${color ? `button--${color}` : ''} 
            flex gap-2
            transition-all duration-300 ease-out 
            bg-[#50C878] border-0 rounded-md p-1 pl-5 pr-5 
            hover:scale-105
            hover:-translate-y-0.5
            hover:bg-[#2c7544] 
            items-center justify-between 
                `} disabled={disabled}>
                <div>
                    <Icon icon={iconName} />
                </div>

                <div>
                    {text}
                </div>

            </button>
        </div>
    )
}