import { getAuthToken } from "../../services/auth/authTokenStorage";

const BASE_URL = "http://localhost:8081/api";

const GoalApi = {
  getAllGoalsBy: async (year: string) => {
    const token = getAuthToken();
    const response = await fetch(`${BASE_URL}/goals/year/${year}`, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });
    return response.json();
  },

  addGoal: async (payload: {}) => {
    console.log(payload)
    const token = getAuthToken();
    await fetch(`${BASE_URL}/goals/add`, {
      method: "POST",
      headers: {
        Authorization: `Bearer ${token}`,
        "Content-Type": "application/json"
      },
      body: JSON.stringify(payload),
    });
  },

  deleteGoal: async (id: number) => {
    const token = getAuthToken();
    const res = await fetch(`${BASE_URL}/goals/${id}`, {
      method: "DELETE",
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });
    if (!res.ok) {
      throw new Error(`Erreur lors de la suppression du goal ${id}`);
    }
  },

  getGoalById: async (id: number) => {
    const token = getAuthToken();
    const response = await fetch(`${BASE_URL}/goals/${id}`, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });
    return response.json();
  }
};

export default GoalApi;