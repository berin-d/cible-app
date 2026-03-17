
type TaskDTO = {
    id: number;
    title: string;
    dueDate: string | null;
    completedAt: string | null;
  };

type TaskGroupDTO = {
    id: number;
    name: string;
    tasks: TaskDTO[];
  };
  