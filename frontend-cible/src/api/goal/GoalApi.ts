const BASE_URL = "http://localhost:8081/api";

const GoalApi = {
  fetchTaskByYears: async (year: string) => {
    const response = await fetch(`${BASE_URL}/goals/year/${year}`);
    return response.json();
  },

  addGoal: async (payload: {}) => {
    console.log(payload)
    await fetch(`${BASE_URL}/goals/add`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(payload),
    });
  }
};

export default GoalApi;