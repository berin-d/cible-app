interface ProgressBarProps {
    currentProgress: number;
    maxProgress: number;
    label?: string;
}

export default function ProgressBar({ currentProgress, maxProgress, label }: ProgressBarProps) {

    const percentage = Math.min((currentProgress / maxProgress) * 100, 100);



    return (
        <div className="w-full">
            <div className="flex justify-between items-baseline mb-1.5">
                {label && (
                    <span className="text-sm text-gray-500">{label}</span>
                )}
                <span className="text-sm font-medium text-gray-900 ml-auto">
                    {currentProgress} / {maxProgress}
                </span>
            </div>
            <div className="w-full h-2 bg-gray-100 rounded-full overflow-hidden bg-slate-700">
                <div
                    className={`h-full rounded-full transition-all duration-500 ease-out bg-emerald-500`}
                    style={{ width: `${percentage}%` }}
                    role="progressbar"
                    aria-valuenow={currentProgress}
                    aria-valuemin={0}
                    aria-valuemax={maxProgress}
                />
            </div>
        </div>
    );
}