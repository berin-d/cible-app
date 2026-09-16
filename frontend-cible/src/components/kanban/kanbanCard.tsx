
import { useEffect, useRef, useState } from 'react';
import { useDraggable } from '@dnd-kit/react';

export type KanbanTask = {
    id: string;
    title: string;
    description?: string;
    priority: 'low' | 'medium' | 'high';
};

type KanbanCardProps = {
    task: KanbanTask;
};

const priorityStyles = {
    low: 'bg-sky-400/10 text-sky-300',
    medium: 'bg-amber-400/10 text-amber-300',
    high: 'bg-rose-400/10 text-rose-300',
};


export default function KanbanCard({ task }: KanbanCardProps) {
    const { ref, isDragging } = useDraggable({ id: task.id });
    const [rotation, setRotation] = useState(0);
    const lastX = useRef<number | null>(null);

    useEffect(() => {
        if (!isDragging) {
            setRotation(0);
            lastX.current = null;
            return;
        }

        const handleMouseMove = (event: MouseEvent) => {
            if (lastX.current !== null) {
                const delta = event.clientX - lastX.current;

                // Calcul de l'angle progressif basé sur la vitesse du geste
                // Clampé entre -8deg et +8deg pour garder un rendu naturel
                const targetRotation = Math.max(-10, Math.min(10, delta * 0.8));
                setRotation(targetRotation);
            }

            lastX.current = event.clientX;
        };

        window.addEventListener('mousemove', handleMouseMove);

        return () => {
            window.removeEventListener('mousemove', handleMouseMove);
        };


    }, [isDragging]);

    return (
        <article
            ref={ref}
            style={{
                rotate: `${rotation}deg`,

            }}
            className={`cursor-grab rounded-xl border border-white/10 bg-zinc-900 p-4 shadow-lg shadow-black/10 transition-transform duration-200 ease-out hover:border-emerald-400/50 active:cursor-grabbing ${isDragging ? 'opacity-40' : ''
                }`}
        >
            <div className="mb-3 flex items-start justify-between gap-3">
                <h3 className="font-semibold text-white">{task.title}</h3>
                <span className={`shrink-0 rounded-full px-2 py-1 text-[10px] font-bold uppercase tracking-wider ${priorityStyles[task.priority]}`}>
                    {task.priority}
                </span>
            </div>
            {task.description && <p className="text-sm leading-5 text-zinc-400">{task.description}</p>}
        </article>
    );
}