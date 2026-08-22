import { Check, Hourglass, Calendar } from "lucide-react";


interface CardYearProps {
    id: number;
    name: string;
    status: string;
    currentProgress?: number;
    maxProgress?: number;
    navigateTo?: () => void;
}

export default function YearCard({ status, navigateTo, name }: CardYearProps) {
    const active = name === "2026";

    return (
        <div className="relative z-10 flex flex-col items-center ">
            <div
                onClick={active ? navigateTo : undefined}
                className={`
                    w-64 rounded-3xl border p-6 transition-all duration-300
                    bg-zinc-800 shadow-sm border border-slate-700 
                    ${active ? "cursor-pointer hover:border-slate-500" : ""}
                `}
            >
                <div className="flex justify-between items-center">
                    <h2 className="text-lg font-semibold text-white">
                        {name}
                    </h2>

                    {status === "completed" && (
                        <Check className="text-emerald-400" size={20} />
                    )}

                    {status === "active" && (
                        <Calendar className="text-violet-400" size={20} />
                    )}

                    {status === "upcoming" && (
                        <Hourglass className="text-zinc-500" size={20} />
                    )}
                </div>

                <p className="mt-2 text-sm text-zinc-400">
                    {status === "completed" && "Terminée"}
                    {status === "active" && "En cours"}
                    {status === "upcoming" && "À venir"}
                </p>

                {active && (
                    <div className="mt-8 flex justify-center">
                        <span className="rounded-full bg-violet-500/20 px-4 py-1 text-sm text-violet-300">
                            Vous êtes ici
                        </span>
                    </div>
                )}
            </div>
        </div>
    );
}