export default function Select<T extends string = string>({
    label,
    placeholder = "Choose…",
    options,
    value,
    onChange
}: {
    label: string;
    placeholder?: string;
    options: T[];
    value?: T;
    onChange: (value: T | undefined) => void;
}) {
    return (
        <div className="flex flex-col space-y-2 w-full">
            <label className="text-slate-400 text-sm">{label}</label>
            <select
                className="w-full bg-zinc-900 border border-dashed border-slate-700 rounded-lg px-3 py-2 text-white placeholder:text-slate-500 focus:outline-none focus:border-slate-500 transition-colors"
                value={value ?? ""}
                onChange={(e) => onChange((e.target.value || undefined) as T | undefined)}
            >
                <option value="" disabled>{placeholder}</option>
                {options.map((opt) => (
                    <option key={opt} value={opt}>
                        {opt}
                    </option>
                ))}
            </select>
        </div>
    );
}