import TaskDetailApi from "../../api/task/TaskApi";
import TaskModel from "../../models/taskModel/TasksModel";

export const TaskService = {


    loadTasksByGroupId: async (groupId: string): Promise<TaskModel[]> => {
        try {
            const data = await TaskDetailApi.getTasksByGroupId(groupId);
            return data.map((task: any) => new TaskModel(task));
        } catch (error) {
            console.error("Error fetching tasks:", error);
            return [];
        }
    },





    taskCompletedChange: async (id: number) => {
        try {
            await TaskDetailApi.setTaskCompleted(id);
        } catch (error) {
            console.error("Error completed tasks:", error);
            return [];
        }

    }
};
