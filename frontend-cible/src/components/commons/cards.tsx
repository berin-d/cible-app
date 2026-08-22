// Card.tsx
import { useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCirclePlus, faPen, faTrash } from "@fortawesome/free-solid-svg-icons";

import ProgressBar from "./progressBar";
import Button from "./button";
import Input from "./input";
import Select from "./select";

/* ----------  PROPS ----------
   We split them into two shapes so each branch only gets what it needs.
-------------------------------- */
export interface CardViewProps {
    title?: string;
    subtitle?: string;
    currentProgress?: number;
    maxProgress?: number;
    navigateTo?: () => void;
    onDeleteClick?: () => void;
}

export interface CardFormProps {
    openForm: boolean;
    addLabel?: string;
    showGoalForm?: boolean;
    showYearForm?: boolean;
    yearsSelection?: string[];
    onAddClick?: () => void;
    onSubmit?: (title: string) => void;
}

/* ----------  UNION TYPE ---------- --------- */
export type CardProps = { cardForm: false } & CardViewProps |
    { cardForm: true } & CardFormProps;

export function Card({ cardForm, ...rest }: CardProps) {
    return cardForm ? <CardForm {...(rest as CardFormProps)} /> : <CardView {...(rest as CardViewProps)} />;
}

/* ----------  VIEW ----------------------------------------------------- */
function CardView({
    title,
    subtitle,
    currentProgress = 0,
    maxProgress = 1,
    navigateTo,
    onDeleteClick
}: CardViewProps) {
    return (
        <div
            className="group relative flex flex-col bg-zinc-900 shadow-sm border border-slate-700 rounded-lg w-80 h-48 cursor-pointer hover:border-slate-500 transition-colors"
            onClick={navigateTo}
        >
            <div className="p-6">
                <div className="flex justify-between items-start mb-8">
                    <h5 className="text-white text-2xl font-semibold">{title}</h5>

                    {/* Edit / Delete icons – visible only on hover */}
                    <div className="flex gap-3 opacity-0 -translate-y-2 group-hover:opacity-100 group-hover:translate-y-0 transition-all duration-500 ease-out">
                        <FontAwesomeIcon
                            icon={faPen}
                            color="white"
                            className="border p-2 rounded-xl cursor-pointer"
                            onClick={(e) => e.stopPropagation()} // placeholder – add edit handler if needed
                        />
                        <FontAwesomeIcon
                            icon={faTrash}
                            color="white"
                            className="border p-2 rounded-xl cursor-pointer"
                            onClick={(e) => {
                                e.stopPropagation();
                                onDeleteClick?.();
                            }}
                        />
                    </div>
                </div>

                {currentProgress && (
                    <ProgressBar currentProgress={currentProgress} maxProgress={maxProgress} label="Progress" />
                )}

            </div>
        </div>
    );
}

/* ----------  FORM ---------- ----- */
function CardForm({
    openForm,
    addLabel = "Add",
    showGoalForm,
    showYearForm,
    yearsSelection = ["2026", "2027"],
    onAddClick,
    onSubmit
}: CardFormProps) {
    const [title, setTitle] = useState("");
    const [year, setYear] = useState<string | undefined>();

    function handleSubmit(e: React.FormEvent) {
        e.preventDefault();
        if (showGoalForm) onSubmit?.(title);
        if (showYearForm) onSubmit?.(year ?? "");
    }

    return (
        <div className="relative flex flex-col items-center justify-center bg-zinc-900 border border-dashed border-slate-700 rounded-lg w-80 h-48 cursor-pointer hover:border-slate-500 transition-colors group">
            {!openForm ? (
                <div
                    onClick={onAddClick}
                    className="flex flex-col w-full h-full justify-center items-center"
                >
                    <FontAwesomeIcon icon={faCirclePlus} className="text-3xl mb-3 text-slate-700 group-hover:text-slate-500" />
                    <div className="text-slate-700 font-medium group-hover:text-slate-500">{addLabel}</div>
                </div>
            ) : (
                <>
                    {showGoalForm && (
                        <form className="space-y-4 w-full px-6 py-4" onSubmit={handleSubmit}>
                            <Input
                                label="Title"
                                placeholder="English B1"
                                required
                                value={title}
                                onChange={setTitle}
                            />
                            <Button text="Confirm" type="submit" />
                        </form>
                    )}

                    {showYearForm && (
                        <form className="space-y-4 w-full px-6 py-4" onSubmit={handleSubmit}>
                            <Select
                                label="Year"
                                placeholder="Select a year"
                                options={yearsSelection}
                                value={year ?? ""}
                                onChange={setYear}
                            />
                            <Button text="Confirm" type="submit" />
                        </form>
                    )}
                </>
            )}
        </div>
    );
}



