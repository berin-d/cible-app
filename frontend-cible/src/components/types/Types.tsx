export type TaskDTO = {
  id: number;
  title: string;
  description: string;
  dueDate: string;
  userId: number;
  username: string;
  statusId: number | null;
  statusName: string | null;
  priorityId: number | null;
  priorityName: string | null;
  taskGroupId: number;
  taskGroupName: string;
  createdAt: string;
  updatedAt: string;
  completedAt: string | null;
  taskOrder: number;
};

export type TaskGroupDTO = {
  id: number;
  name: string;
  tasks: TaskDTO[];
};