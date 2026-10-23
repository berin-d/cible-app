import { useCallback, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { DragDropProvider, type DragEndEvent } from '@dnd-kit/react';

import KanbanColumn from '../../components/kanban/kanbanColumn';
import type { KanbanTask, TaskStatus } from '../../components/kanban/kanbanCard';
import { useTaskStore } from '../../store/task/taskStore';

type BoardState = Record<TaskStatus, KanbanTask[]>;

const INITIAL_BOARD_STATE: BoardState = {
    TODO: [],
    IN_PROGRESS: [],
    DONE: [],
};

const KANBAN_COLUMNS: { id: TaskStatus; title: string; accentColorClass: string }[] = [
    { id: 'TODO', title: 'À faire', accentColorClass: 'bg-zinc-400' },
    { id: 'IN_PROGRESS', title: 'En cours', accentColorClass: 'bg-amber-400' },
    { id: 'DONE', title: 'Terminé', accentColorClass: 'bg-emerald-400' },
];

export default function KanbanPage() {
    const [boardTasks, setBoardTasks] = useState<BoardState>(INITIAL_BOARD_STATE);

    const { year } = useParams<{ year: string }>();
    const tasks = useTaskStore((state) => state.tasks);
    const fetchAllTaskByYear = useTaskStore((state) => state.fetchAllTaskByYear);
    const updateTaskStatus = useTaskStore((state) => state.updateTaskStatus);

    const loadTasks = useCallback(async () => {
        if (year) {
            await fetchAllTaskByYear(year);
        }
    }, [year, fetchAllTaskByYear]);

    useEffect(() => {
        loadTasks();
    }, [loadTasks]);

    // Synchronisation de l'état local du Kanban dès que les données du store changent
    useEffect(() => {
        if (!tasks) return;

        const nextBoard: BoardState = {
            TODO: [],
            IN_PROGRESS: [],
            DONE: [],
        };

        tasks.forEach((task) => {
            const status = (task.status || 'TODO') as TaskStatus;
            if (nextBoard[status]) {
                nextBoard[status].push({
                    id: task.id!,
                    title: task.title,
                    status: status,
                });
            }
        });

        setBoardTasks(nextBoard);
    }, [tasks]);

    const handleDragEnd = async (event: DragEndEvent) => {
        if (event.canceled) return;

        const sourceTaskId = event.operation.source?.id;
        const destinationColumnId = event.operation.target?.id as TaskStatus | undefined;

        if (!sourceTaskId || !destinationColumnId || !(destinationColumnId in boardTasks)) return;

        
        const sourceEntry = Object.entries(boardTasks).find(([, columnTasks]) =>
            columnTasks.some((task) => String(task.id) === String(sourceTaskId))
        );

        if (!sourceEntry || sourceEntry[0] === destinationColumnId) return;

        const [sourceColumnId, sourceTasks] = sourceEntry as [TaskStatus, KanbanTask[]];
        const movedTask = sourceTasks.find((task) => String(task.id) === String(sourceTaskId));
        if (!movedTask) return;

      
        setBoardTasks((currentBoard) => ({
            ...currentBoard,
            [sourceColumnId]: sourceTasks.filter((task) => String(task.id) !== String(sourceTaskId)),
            [destinationColumnId]: [...currentBoard[destinationColumnId], { ...movedTask, status: destinationColumnId }],
        }));

        
        try {
            await updateTaskStatus(Number(sourceTaskId), destinationColumnId);
        } catch (error) {
            loadTasks();
        }
    };

    return (
        <DragDropProvider onDragEnd={handleDragEnd}>
            <main className="min-h-screen bg-[#11131a] px-4 py-8 text-white sm:px-6 lg:px-10">
                <div className="mx-auto max-w-7xl">
                    <header className="mb-8 flex flex-wrap items-end justify-between gap-4">
                        <div>
                            <p className="mb-2 text-xs font-bold uppercase tracking-[0.22em] text-emerald-400">
                                Espace de travail
                            </p>
                            <h1 className="text-3xl font-bold tracking-tight sm:text-4xl">
                                Tableau Kanban {year ? `- ${year}` : ''}
                            </h1>
                            <p className="mt-2 text-zinc-400">
                                Suivez l'avancement de vos tâches en temps réel.
                            </p>
                        </div>
                        <p className="text-sm font-medium text-zinc-500">
                            {tasks?.length || 0} tâche(s) au total
                        </p>
                    </header>

                    <div className="grid gap-4 lg:grid-cols-3">
                        {KANBAN_COLUMNS.map((column) => (
                            <KanbanColumn
                                key={column.id}
                                id={column.id}
                                title={column.title}
                                accentColorClass={column.accentColorClass}
                                tasks={boardTasks[column.id] || []}
                            />
                        ))}
                    </div>
                </div>
            </main>
        </DragDropProvider>
    );
}