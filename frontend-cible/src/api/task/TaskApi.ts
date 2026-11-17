import { type TaskDto } from "../../models/TasksModel";
import { getAuthToken } from "../../services/auth/authTokenStorage";

const BASE_URL = "http://localhost:8081/api/tasks";

const TaskDetailApi = {
    getTasksByGroupId: async (goalId: number) => {
        const token = getAuthToken();
        const response = await fetch(`${BASE_URL}/group/${goalId}`, {
            headers: {
                Authorization: `Bearer ${token}`,
            }
        });
        return response.json();
    },

    getAllTaskByYear: async (year: string) => {
        const token = getAuthToken();
        const response = await fetch(`${BASE_URL}/year/${year}`, {
            headers: {
                Authorization: `Bearer ${token}`,
            }
        });
        return response.json();
    },

    addTask: async (payload: TaskDto) => {
        const token = getAuthToken();
        await fetch(`${BASE_URL}/add`, {
            method: "POST",
            headers: {
                Authorization: `Bearer ${token}`,
                "Content-Type": "application/json"
            },
            body: JSON.stringify(payload),
        });
    },

    setTaskCompleted: async (id: number) => {
        const token = getAuthToken();
        await fetch(`${BASE_URL}/${id}/completed`, {
            method: "PUT",
            headers: {
                Authorization: `Bearer ${token}`,
            }
        });
    },

    deleteTask: async (id: number) => {
        const token = getAuthToken();
        await fetch(`${BASE_URL}/${id}`, {
            method: "DELETE",
            headers: {
                Authorization: `Bearer ${token}`,
            }
        });
    },

    updateTaskStatus: async (id: number, status: 'TODO' | 'IN_PROGRESS' | 'DONE') => {
        const token = getAuthToken();
        const response = await fetch(`${BASE_URL}/${id}/status?status=${status}`, {
            method: "PATCH",
            headers: {
                Authorization: `Bearer ${token}`,
            }
        });
        
        if (!response.ok) {
            throw new Error("Erreur lors de la mise à jour du statut");
        }
        
        return response.json();
    },
};

export default TaskDetailApi;