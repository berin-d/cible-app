import GoalApi from "../../api/goal/GoalApi";
import { GoalModel } from "../../models/goalModel/GoalsModel";

export const GoalService = {
    fetchGoals: async (years: string): Promise<GoalModel[]> => {
        try {
            const data = await GoalApi.fetchTaskByYears(years);
            return data.map((goal: any) => new GoalModel(goal));
        } catch (error) {
            console.error("Error fetching tasks:", error);
            return [];
        }
    },

    addGoal: async (payload: {}) => {
        await GoalApi.addGoal(payload);
    },

    deleteGoal: async (id: number) => {
        await GoalApi.deleteGoal(id);
    }

}