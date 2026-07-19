

export default class TaskModel {
    public id: number;
    public title: string;
    public dueDate: string | null;
    public completedAt: string | null;
    public isCompleted: boolean | undefined;

    constructor(dto: TaskModel) {
        this.id = dto.id;
        this.title = dto.title;
        this.dueDate = dto.dueDate;
        this.completedAt = dto.completedAt;
        this.isCompleted = dto.isCompleted ?? false;
    }









}

