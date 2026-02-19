import user from "../../assets/user-regular-full.svg"

interface InputProps {
    placeholder?: string;
    label: string;
    value?: string;
    type?: 'text' | 'password' | 'email';
    disabled?: boolean;
    required?: boolean;
    onChange?: (value: string) => void;
    //icon here

}

export default function Input(
    // Props
    { placeholder, label, value, disabled, type, required, onChange }: InputProps) {

    // Content
    return (
        <div className="text-white">
            <p>{label}</p>
            <div className="relative flex items-center">
                <img
                    src={user}
                    alt="user"
                    className="absolute left-3 h-5 w-5 z-10"
                />
                <input
                    type={type}
                    placeholder={placeholder}
                    disabled={disabled}
                    value={value}
                    required={required}
                    onChange={(e) => onChange && onChange(e.target.value)}
                    className="bg-[#3B3B3F] border-0 rounded-md p-2 pl-10 w-full"

                />
            </div>
        </div>
    )
}