import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCirclePlus } from "@fortawesome/free-solid-svg-icons";
import ProgressBar from "./progressBar";
import Button from "./button";
import Input from "./input";
import { FormEvent, useState } from "react";

interface CardProps {
    title?: string;
    subtitle?: string;
    onAddClick?: () => void;
    navigateTo?: () => void;
    addLabel?: string;

    progressBar?: boolean;
    currentProgress?: number;
    maxProgress?: number;

    // addCard
    addCard?: boolean;
    openForm?: boolean;
    onSubmit?: (title: string) => void;
}

export default function Card({ title, subtitle, currentProgress, maxProgress, onAddClick, onSubmit, addLabel, addCard, navigateTo, openForm }: CardProps) {
    return (
        !addCard
            ? CardYear({ title, subtitle, currentProgress, maxProgress, navigateTo })
            : CardAdd({ onAddClick, onSubmit, openForm, addLabel })
    );
}

function CardYear({ title, currentProgress, maxProgress, navigateTo }: CardProps) {
    return (
        <div
            className="relative flex flex-col bg-zinc-900 shadow-sm border border-slate-700 rounded-lg w-80 h-48 cursor-pointer hover:border-slate-500 transition-colors"
            onClick={navigateTo}>
            <div className="p-6">
                <div className="flex justify-between items-start mb-8">
                    <h5 className="text-white text-2xl font-semibold">{title}</h5>
                    <span className="text-slate-400 text-sm">↗</span>
                </div>

                <ProgressBar currentProgress={currentProgress || 0} maxProgress={maxProgress || 1} label="Progress" />
            </div>
        </div >
    );

};

function CardAdd({ onAddClick, onSubmit, openForm }: CardProps) {
    const [title, setTitle] = useState("");

    function handleSubmit(e: FormEvent) {
        e.preventDefault();
        onSubmit?.(title);
    }
    return (
        <div className="relative flex flex-col items-center justify-center bg-zinc-900 border border-dashed border-slate-700 rounded-lg w-80 cursor-pointer hover:border-slate-500 transition-colors group">
            {!openForm ? (
                <div
                    onClick={onAddClick} className="flex flex-col border w-full h-full justify-center items-center"
                >
                    <FontAwesomeIcon icon={faCirclePlus} className="text-3xl mb-3 text-slate-700 group-hover:text-slate-500" />
                    <div className="text-slate-700 font-medium group-hover:text-slate-500">Add</div>

                </div>

            ) : (
                <div>
                    <form className="space-y-4" onSubmit={handleSubmit}>
                        <Input
                            label="Title"
                            placeholder="English B1"
                            required
                            value={title}
                            onChange={(title) => setTitle(title)}
                        />
                        <Button text="Confirm" type="submit" />
                    </form>
                </div>
            )
            }
        </div>
    )
}