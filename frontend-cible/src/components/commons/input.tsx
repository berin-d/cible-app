import user from "../../assets/user-regular-full.svg"

interface InputProps {
    placeholder?: string;
    label: string;
    type?: 'text' | 'password' | 'email';
    disabled?: boolean;
    //icon here

}

export default function Input(
    // Props
    { placeholder, label, disabled, type }: InputProps) {

    // Core
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
                    className="bg-[#3B3B3F] border-0 rounded-md p-2 pl-10 w-full"
                />
            </div>
        </div>
    )
}