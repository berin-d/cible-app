const BASE_URL = "http://localhost:8081/api";

const GoalApi = {
  fetchTaskByYears: async (year: string) => {
    const token = localStorage.getItem('token');
    const response = await fetch(`${BASE_URL}/goals/year/${year}`, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });
    return response.json();
  },

  addGoal: async (payload: {}) => {
    const token = localStorage.getItem('token');
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
    const token = localStorage.getItem('token');
    const res = await fetch(`${BASE_URL}/goals/${id}`, {
      method: "DELETE",
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });
    if (!res.ok) {
      throw new Error(`Erreur lors de la suppression du goal ${id}`);
    }
  }
};

export default GoalApi;