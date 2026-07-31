import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCirclePlus, faPen, faTrash } from "@fortawesome/free-solid-svg-icons";
import ProgressBar from "./progressBar";
import Button from "./button";
import Input from "./input";
import { FormEvent, useState } from "react";

interface CardProps {
    // defaultCard
    title?: string;
    subtitle?: string;
    addLabel?: string;
    progressBar?: boolean;
    currentProgress?: number;
    maxProgress?: number;

    onAddClick?: () => void;
    onDeleteClick?: () => void;
    navigateTo?: () => void;





    // addCard
    addCard?: boolean;
    openForm?: boolean;
    onSubmit?: (title: string) => void;
}

export default function Card({ title, subtitle, currentProgress, maxProgress, onAddClick, onSubmit, addLabel, addCard, navigateTo, openForm, onDeleteClick }: CardProps) {
    return (
        !addCard
            ? CardYear({ title, subtitle, currentProgress, maxProgress, navigateTo, onDeleteClick })
            : CardAdd({ onAddClick, onSubmit, openForm, addLabel })
    );
}

function CardYear({ title, currentProgress, maxProgress, navigateTo, onDeleteClick }: CardProps) {
    return (
        <div
            className="group relative flex flex-col bg-zinc-900 shadow-sm border border-slate-700 rounded-lg w-80 h-48 cursor-pointer hover:border-slate-500 transition-colors"
            onClick={navigateTo}>
            <div className="p-6">
                <div className="flex justify-between items-start mb-8">
                    <h5 className="text-white text-2xl font-semibold">{title}</h5>

                    <div className="flex gap-3 opacity-0 -translate-y-2 group-hover:opacity-100 group-hover:translate-y-0 transition-all duration-500 ease-out">
                        <FontAwesomeIcon icon={faPen} color="white" className="border p-2 rounded-xl"
                            onClick={(e) => {
                                e.stopPropagation();

                            }} />
                        <FontAwesomeIcon icon={faTrash} color="white" className="border p-2 rounded-xl" onClick={(e) => {
                            e.stopPropagation();
                            onDeleteClick?.();
                        }} />
                    </div>
                </div>

                <ProgressBar currentProgress={currentProgress || 0} maxProgress={maxProgress || 1} label="Progress" />
            </div>
        </div>
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