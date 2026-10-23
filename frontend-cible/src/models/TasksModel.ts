export type TaskDto = {
    id: number | null;
    title: string;
    dueDate: string | null;
    goalId: number;
    completedAt: string | null;
    isCompleted?: boolean;
    status?: 'TODO' | 'IN_PROGRESS' | 'DONE';
};

export default class TaskModel {
    public id: number | null;
    public title: string;
    public dueDate: string | null;
    public goalId : number;
    public completedAt: string | null;
    public isCompleted: boolean;
    public status?: 'TODO' | 'IN_PROGRESS' | 'DONE';

    constructor(dto: TaskDto) {
        this.id = dto.id || null;
        this.goalId = dto.goalId;
        this.title = dto.title;
        this.dueDate = dto.dueDate;
        this.completedAt = dto.completedAt;
        this.status = dto.status ?? (dto.isCompleted ? 'DONE' : 'TODO');
        this.isCompleted = dto.status ? dto.status === 'DONE' : dto.isCompleted ?? false;
    }

    static fromApi(dto: TaskDto): TaskModel {
        return new TaskModel(dto);
    }

    static toApi(task: TaskModel): TaskDto {
        return {
            id: task.id || null,
            goalId: task.goalId,
            title: task.title,
            dueDate: task.dueDate,
            completedAt: task.completedAt,
            isCompleted: task.isCompleted,
            status: task.status ? task.status : 'TODO',
        };
    }
}