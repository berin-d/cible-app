import TaskDetailApi from "../../api/task/TaskApi";
import TaskModel, { type TaskDto } from "../../models/TasksModel";

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
        const tasks = await TaskDetailApi.getAllTaskByYear(year);

        return tasks.map((task: TaskDto) => TaskModel.fromApi(task));
    },

    addTask: async (task: TaskModel): Promise<void> => {
        const payload = TaskModel.toApi(task);
        console.log("Adding task with payload:", payload); // Log the payload before sending
        await TaskDetailApi.addTask(payload);
    },

    taskCompletedChange: async (id: number): Promise<void> => {
        try {
            await TaskDetailApi.setTaskCompleted(id);
        } catch (error) {
            console.error("Error completed tasks:", error);
        }
    },

    deleteTask: async (id: number): Promise<void> => {
        try {
            await TaskDetailApi.deleteTask(id);
        } catch (error) {
            console.error("Error deleting task:", error);
        }
    },

    updateTaskStatus: async (id: number, status: 'TODO' | 'IN_PROGRESS' | 'DONE'): Promise<TaskModel> => {
        try {
            const data = await TaskDetailApi.updateTaskStatus(id, status);
            return TaskModel.fromApi(data);
        } catch (error) {
            console.error("Error updating task status:", error);
            throw error;
        }
    },
};
