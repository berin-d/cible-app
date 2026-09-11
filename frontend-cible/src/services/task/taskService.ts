import TaskDetailApi from "../../api/task/TaskApi";
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
