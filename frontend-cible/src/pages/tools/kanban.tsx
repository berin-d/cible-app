import { useState } from 'react';

import { DragDropProvider } from '@dnd-kit/react';
import KanbanColumn, { type KanbanColumnId } from '../../components/kanban/kanbanColumn';
import type { KanbanTask } from '../../components/kanban/kanbanCard';

type BoardState = Record<KanbanColumnId, KanbanTask[]>;

const initialBoard: BoardState = {
    backlog: [
        { id: 'task-1', title: 'Define product goals', description: 'Align the next milestone with the team.', priority: 'high' },
        { id: 'task-2', title: 'Create wireframes', description: 'Sketch the main dashboard flow.', priority: 'medium' },
    ],
    'in-progress': [
        { id: 'task-3', title: 'Build the task list', description: 'Connect the list to the task service.', priority: 'high' },
        { id: 'task-4', title: 'Review visual system', priority: 'low' },
    ],
    done: [
        { id: 'task-5', title: 'Set up authentication', description: 'Login and registration are ready.', priority: 'medium' },
    ],
};

const columns: { id: KanbanColumnId; title: string; accentClass: string }[] = [
    { id: 'backlog', title: 'Backlog', accentClass: 'bg-zinc-400' },
    { id: 'in-progress', title: 'In progress', accentClass: 'bg-amber-400' },
    { id: 'done', title: 'Done', accentClass: 'bg-emerald-400' },
];

export default function KanbanPage() {
    const [board, setBoard] = useState<BoardState>(initialBoard);

    return (
        <DragDropProvider
            onDragEnd={(event) => {
                if (event.canceled) return;

                const sourceId = event.operation.source?.id;
                const targetId = event.operation.target?.id;
                if (!sourceId || !targetId || !(targetId in board)) return;

                const destination = targetId as KanbanColumnId;
                setBoard((currentBoard) => {
                    const source = Object.entries(currentBoard).find(([, tasks]) => tasks.some((task) => task.id === sourceId));
                    if (!source || source[0] === destination) return currentBoard;

                    const [sourceColumn, sourceTasks] = source;
                    const task = sourceTasks.find((item) => item.id === sourceId);
                    if (!task) return currentBoard;

                    return {
                        ...currentBoard,
                        [sourceColumn]: sourceTasks.filter((item) => item.id !== sourceId),
                        [destination]: [...currentBoard[destination], task],
                    } as BoardState;
                });
            }}
        >
            <main className="min-h-screen bg-[#11131a] px-4 py-8 text-white sm:px-6 lg:px-10">
                <div className="mx-auto max-w-7xl">
                    <header className="mb-8 flex flex-wrap items-end justify-between gap-4">
                        <div>
                            <p className="mb-2 text-xs font-bold uppercase tracking-[0.22em] text-emerald-400">Workspace</p>
                            <h1 className="text-3xl font-bold tracking-tight sm:text-4xl">Project board</h1>
                            <p className="mt-2 text-zinc-400">Move your work forward, one card at a time.</p>
                        </div>
                        <p className="text-sm text-zinc-500">{Object.values(board).flat().length} tasks</p>
                    </header>

                    <div className="grid gap-4 lg:grid-cols-3">
                        {columns.map((column) => (
                            <KanbanColumn
                                key={column.id}
                                id={column.id}
                                title={column.title}
                                accentClass={column.accentClass}
                                tasks={board[column.id]}
                            />
                        ))}
                    </div>
                </div>
            </main>
        </DragDropProvider>
    );
}