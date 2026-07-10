const BASE_URL = "http://localhost:8081/api";

const TaskDetailApi = {
    getTasksByGroupId: async (groupId: string) => {
        const response = await fetch(`${BASE_URL}/tasks/group/${groupId}`);
        return response.json();
    },

    setTaskCompleted: async (id: number) => {
        await fetch(`${BASE_URL}/tasks/${id}/completed`, {
            method: "PUT"
        });
    }
};

export default TaskDetailApi;