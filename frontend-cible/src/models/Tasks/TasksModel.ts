export type TaskDTO = {
    id: number;
    title: string;
    dueDate: string | null;
    completedAt: string | null;
};

export type TaskGroupDTO = {
    id: number;
    name: string;
    tasks: TaskDTO[];
};


export type TaskGroupListProps = {
    data: TaskGroupDTO[];
    year: string;
    onSelect: (group: TaskGroupDTO) => void;
    onBack: () => void;
};






export type TaskDetailProps = {
    group: TaskGroupDTO;
    onBack: () => void;
};

