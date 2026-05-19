
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCirclePlus } from "@fortawesome/free-solid-svg-icons";
import ProgressBar from "./progressBar";

interface CardProps {
    title: string;
    subtitle?: string;
    onAddClick?: () => void;
    addLabel?: string;
}

export default function Card({ title, subtitle, onAddClick, addLabel }: CardProps) {
    return (
        <div
            className="relative flex flex-col bg-zinc-900 shadow-sm border border-slate-700 rounded-lg w-80 h-48 cursor-pointer hover:border-slate-500 transition-colors"
        >
            <div className="p-6">
                <div className="flex justify-between items-start mb-8">
                    <h5 className="text-white text-2xl font-semibold">{title}</h5>
                    <span className="text-slate-400 text-sm">↗</span>
                </div>

                <ProgressBar currentProgress={70} maxProgress={100} label="Progress" />
            </div>


            <p className="text-slate-400 text-sm">
                12 Active Groups + 142 Tasks
            </p>
        </div>




    )
}