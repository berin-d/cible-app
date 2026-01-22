import { Icon } from "./icon";
import { IconProp } from '@fortawesome/fontawesome-svg-core';

interface ButtonProps {
    text: string;
    label?: string;
    color?: 'primary' | 'secondary' | 'danger';
    disabled?: boolean;
    iconName?: IconProp;
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
            bg-[#50C878] border-0 rounded-md p-1 pl-5 pr-5 
            hover:bg-[#2c7544] 
            items-center justify-between 
                `} disabled={disabled}>
                <div>
                    {iconName && <Icon icon={iconName} />}
                </div>

                <div>
                    {text}
                </div>

            </button>
        </div>
    )
}