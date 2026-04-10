const BASE_URL = "http://localhost:8081/api";

const TaskDetailApi = {
    getTasksByGroupId: async (groupId: string) => {
        const response = await fetch(`${BASE_URL}/tasks/group/${groupId}`);
        return response.json();
    },
};

export default TaskDetailApi;