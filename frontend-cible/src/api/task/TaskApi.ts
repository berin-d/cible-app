import { type TaskDto } from "../../models/taskModel/TasksModel";

const BASE_URL = "http://localhost:8081/api/tasks";

const TaskDetailApi = {
    getTasksByGroupId: async (goalId: number) => {
        const token = localStorage.getItem('token');
        const response = await fetch(`${BASE_URL}/group/${goalId}`, {
            headers: {
                Authorization: `Bearer ${token}`,
            }
        });
        return response.json();
    },

    getAllTaskByYear: async (year: string) => {
        const token = localStorage.getItem('token');
        const response = await fetch(`${BASE_URL}/year/${year}`, {
            headers: {
                Authorization: `Bearer ${token}`,
            }
        });
        return response.json();
    },

    addTask: async (payload: TaskDto) => {
        const token = localStorage.getItem('token');
        console.log(payload)
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
        const token = localStorage.getItem('token');
        await fetch(`${BASE_URL}/${id}/completed`, {
            method: "PUT",
            headers: {
                Authorization: `Bearer ${token}`,
            }
        });
    }
};

export default TaskDetailApi;