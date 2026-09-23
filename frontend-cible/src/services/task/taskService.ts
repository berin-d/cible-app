import TaskDetailApi from "../../api/task/TaskApi";
import GoalApi from "../../api/goal/GoalApi";
import TaskModel, { type TaskDto } from "../../models/taskModel/TasksModel";

export const TaskService = {
    loadTasksByGroupId: async (groupId: number): Promise<TaskModel[]> => {
        try {
            const data = await TaskDetailApi.getTasksByGroupId(groupId);
            return data.map((task: TaskDto) => TaskModel.fromApi(task));
        } catch (error) {
            console.error("Error fetching tasks:", error);
            return [];
        }
    },

    loadAllTasksByYear: async (year: string): Promise<TaskModel[]> => {
        const goals = await GoalApi.fetchTaskByYears(year);

        return goals.flatMap((goal: { tasks?: TaskDto[] }) =>
            (goal.tasks ?? []).map((task) => TaskModel.fromApi(task))
        );
    },

    addTask: async (task: TaskModel): Promise<void> => {
        const payload = TaskModel.toApi(task);
        await TaskDetailApi.addTask(payload);
    },

    taskCompletedChange: async (id: number): Promise<void> => {
        try {
            await TaskDetailApi.setTaskCompleted(id);
        } catch (error) {
            console.error("Error completed tasks:", error);
        }
    }
};
