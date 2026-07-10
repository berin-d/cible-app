import TaskGroupApi from "../api/goal/GoalApi";
import { TaskGroupDTO } from "../components/types/Types";

const TaskGroupHooks = {
  loadTaskGroupsByYear: async (year: string): Promise<TaskGroupDTO[]> => {
    try {
      const data = await TaskGroupApi.getTaskGroupsByYear(year);
      return data;
    } catch (error) {
      console.error("Error fetching taskgroups:", error);
      return [];
    }
  },
};

export default TaskGroupHooks;