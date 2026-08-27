import TaskModel from "../taskModel/TasksModel";
import { User } from "../users/User";
import YearModel from "../YearsModel";

export class GoalModel {
    public id: number;
    public name: string;
    public user: User;
    public year: String;
    public tasks: TaskModel[];

    // Data calculated
    public taskCompleted: number;


    constructor(dto: GoalModel) {
        this.id = dto.id
        this.name = dto.name
        this.user = dto.user
        this.tasks = dto.tasks
        this.year = dto.year
        //
        this.taskCompleted = this.taskDone()
    }

    taskDone(): number {
        return this.tasks.reduce((count, task) => task.isCompleted ? count + 1 : count, 0);
    }

    static toApi(title: string, currentYear: string | null) {
        return {
            name: title,
            year: currentYear
        };
    }
}
