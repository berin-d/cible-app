import TaskDetailApi from "../api/TaskDetailApi";
import { TaskDTO } from "../components/types/Types";

const TaskDetailHooks = {
    loadTasksByGroupId: async (groupId: string): Promise<TaskDTO[]> => {
        try {
            const data = await TaskDetailApi.getTasksByGroupId(groupId);
            return data;
        } catch (error) {
            console.error("Error fetching tasks:", error);
            return [];
        }
    },
};

export default TaskDetailHooks;