const BASE_URL = "http://localhost:8081/api";

const TaskGroupApi = {
  getTaskGroupsByYear: async (year: string) => {
    const response = await fetch(`${BASE_URL}/task-groups/year/${year}`);
    return response.json();
  },
};

export default TaskGroupApi;