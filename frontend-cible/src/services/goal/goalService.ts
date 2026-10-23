import GoalApi from "../../api/goal/GoalApi";
import { GoalModel } from "../../models/GoalsModel";

export const GoalService = {
    fetchGoals: async (years: string): Promise<GoalModel[]> => {
        try {
            const data = await GoalApi.getAllGoalsBy(years);
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
    },


    getGoalById: async (id: number): Promise<GoalModel | null> => {
        try {
            const data = await GoalApi.getGoalById(id);
            return new GoalModel(data);
        } catch (error) {
            console.error("Error fetching goal by ID:", error);
            return null;
        }
    },

}