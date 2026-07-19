
interface CheckboxProps {
    onClick: () => void;
    isChecked: boolean | undefined;
}



export default function Checkbox({ onClick, isChecked }: CheckboxProps) {
    return (
        <div onClick={onClick}>
            <input
                type="checkbox"
                className="appearance-none w-5 h-5 rounded-full border-2 border-gray-300 bg-white checked:bg-emerald-600 transition-colors relative cursor-pointer
                "
                checked={isChecked}

            />
        </div>
    );
}