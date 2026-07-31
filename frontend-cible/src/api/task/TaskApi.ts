const BASE_URL = "http://localhost:8081/api";

const TaskDetailApi = {
    getTasksByGroupId: async (groupId: string) => {
        const token = localStorage.getItem('token');
        const response = await fetch(`${BASE_URL}/tasks/group/${groupId}`, {
            headers: {
                Authorization: `Bearer ${token}`,
            }
        });
        return response.json();
    },

    setTaskCompleted: async (id: number) => {
        await fetch(`${BASE_URL}/tasks/${id}/completed`, {
            method: "PUT"
        });
    }
};

export default TaskDetailApi;