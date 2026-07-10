const BASE_URL = "http://localhost:8081/api";

const GoalApi = {
  fetchTaskByYears: async (year: string) => {
    const response = await fetch(`${BASE_URL}/task-groups/year/${year}`);
    return response.json();
  },
};

export default GoalApi;