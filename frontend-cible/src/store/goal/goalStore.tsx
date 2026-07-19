import { create } from 'zustand';
import { GoalModel } from '../../models/goalModel/GoalsModel';
import { GoalService } from '../../services/goal/goalService';

interface GoalStore {
    currentYear: string | null;
    isLoading: boolean;
    error: unknown;
    goals: GoalModel[];


    fetchGoals: (years: string) => Promise<void>
    addGoal: (title: string) => Promise<void>
}
export const useGoalStore = create<GoalStore>((set) => ({
    goals: [],
    isLoading: false,
    error: null,
    currentYear: null,

    fetchGoals: async (years: string) => {
        set({ isLoading: true, error: null, currentYear: years });
        try {
            const reponse = await GoalService.fetchGoals(years);
            console.log(reponse)
            set({ goals: reponse, isLoading: false })
        } catch (error) {
            console.error('Error fetching goals:', error);
            set({ error, isLoading: false });
        }
    },

    addGoal: async (title: string) => {

    }





})
)