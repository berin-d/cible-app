interface ButtonProps {
    text: string;
    label: string;
    color?: 'primary' | 'secondary' | 'danger';
    disabled?: boolean;
    // icon
}


export default function Button(
    // Props
    {text, label, color, disabled }: ButtonProps)

    // Core
    {
        return (
            <div className="flex flex-col justify-center items-center p-5">
                <p>{label}</p>
                <button className={`button ${color ? `button--${color}` : ''} bg-[#50C878] border-0 rounded-md p-1 pl-5 pr-5 hover:bg-[#2c7544]`} disabled={disabled}>
                    {text}
                </button>
            </div>
        )
    }