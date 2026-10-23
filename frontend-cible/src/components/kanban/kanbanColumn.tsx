import { useDroppable } from '@dnd-kit/react';
import KanbanCard, { type KanbanTask, type TaskStatus } from './kanbanCard';

type KanbanColumnProps = {
    id: TaskStatus;
    title: string;
    tasks: KanbanTask[];
    accentColorClass: string;
};

export default function KanbanColumn({
    id,
    title,
    tasks,
    accentColorClass,
}: KanbanColumnProps) {
    const { ref, isDropTarget } = useDroppable({ id });

    return (
        <section
            ref={ref}
            className={`flex min-h-96 flex-col rounded-2xl border p-4 transition-colors ${
                isDropTarget
                    ? 'border-emerald-400 bg-emerald-400/10'
                    : 'border-white/10 bg-zinc-950/60'
            }`}
        >
            <header className="mb-4 flex items-center justify-between">
                <div className="flex items-center gap-2">
                    <span className={`h-2.5 w-2.5 rounded-full ${accentColorClass}`} />
                    <h2 className="font-semibold text-zinc-100">{title}</h2>
                </div>
                <span className="rounded-full bg-white/10 px-2.5 py-0.5 text-xs font-medium text-zinc-400">
                    {tasks.length}
                </span>
            </header>

            <div className="flex flex-1 flex-col gap-3">
                {tasks.length > 0 ? (
                    tasks.map((task) => <KanbanCard key={task.id} task={task} />)
                ) : (
                    <div className="flex flex-1 items-center justify-center rounded-xl border border-dashed border-white/10 p-6 text-center text-sm text-zinc-500">
                        Déposer une carte ici
                    </div>
                )}
            </div>
        </section>
    );
}