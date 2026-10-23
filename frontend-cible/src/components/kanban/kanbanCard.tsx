import { useEffect, useRef, useState } from 'react';
import { useDraggable } from '@dnd-kit/react';

export type TaskStatus = 'TODO' | 'IN_PROGRESS' | 'DONE';

export type KanbanTask = {
    id: number | string;
    title: string;
    description?: string;
    status?: TaskStatus;
};

type KanbanCardProps = {
    task: KanbanTask;
};

export default function KanbanCard({ task }: KanbanCardProps) {
    const { ref, isDragging } = useDraggable({ id: String(task.id) });
    const [rotation, setRotation] = useState<number>(0);
    const lastX = useRef<number | null>(null);

    useEffect(() => {
        if (!isDragging) {
            setRotation(0);
            lastX.current = null;
            return;
        }

        const handleMouseMove = (event: MouseEvent) => {
            if (lastX.current !== null) {
                const deltaX = event.clientX - lastX.current;
                // Limite la rotation entre -10° et +10°
                const targetRotation = Math.max(-10, Math.min(10, deltaX * 0.8));
                setRotation(targetRotation);
            }
            lastX.current = event.clientX;
        };

        window.addEventListener('mousemove', handleMouseMove);
        return () => window.removeEventListener('mousemove', handleMouseMove);
    }, [isDragging]);

    return (
        <article
            ref={ref}
            style={{ transform: `rotate(${rotation}deg)` }}
            className={`cursor-grab select-none rounded-xl border border-white/10 bg-zinc-900 p-4 shadow-lg shadow-black/10 transition-transform duration-200 ease-out hover:border-emerald-400/50 active:cursor-grabbing ${
                isDragging ? 'opacity-40' : ''
            }`}
        >
            <div className="mb-2 flex items-start justify-between gap-3">
                <h3 className="font-semibold text-white">{task.title}</h3>
            </div>
            {task.description && (
                <p className="text-sm leading-5 text-zinc-400">{task.description}</p>
            )}
        </article>
    );
}