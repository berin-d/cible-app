import { create } from 'zustand';
import { GoalModel } from '../../models/goalModel/GoalsModel';
import { GoalService } from '../../services/goal/goalService';

interface GoalStore {
    currentYear: string | null;
    isLoading: boolean;
    error: unknown;
    goals: GoalModel[];

    // crud
    fetchGoals: (years: string) => Promise<void>
    addGoal: (title: string) => Promise<void>
    deleteGoal: (id: number) => Promise<void>
}
export const useGoalStore = create<GoalStore>((set, get) => ({
    goals: [],
    isLoading: false,
    error: null,
    currentYear: null,

    fetchGoals: async (years: string) => {
        set({ isLoading: true, error: null, currentYear: years });
        try {
            const reponse = await GoalService.fetchGoals(years);
            set({ goals: reponse, isLoading: false })
        } catch (error) {
            console.error('Error fetching goals:', error);
            set({ error, isLoading: false });
        }
    },

    addGoal: async (name: string) => {
        const { currentYear, fetchGoals } = get();
        if (!currentYear) {
            console.error('Cannot add goal: no current year set');
            return;
        }
        console.info("add goal")
        set({ isLoading: true, error: null });
        try {
            const payload = GoalModel.toApi(name, currentYear);
            await GoalService.addGoal(payload);
            await fetchGoals(currentYear);
        } catch (error) {
            console.error('Error adding goal:', error);
            set({ error, isLoading: false });
        }
    },

    deleteGoal: async (id: number) => {
        const { currentYear, fetchGoals } = get();
        if (!currentYear) {
            console.error('Cannot add goal: no current year set');
            return;
        }
        try {
            await GoalService.deleteGoal(id)
            await fetchGoals(currentYear);
        } catch (error) {
            console.error('Error delete goal:', error);
            set({ error, isLoading: false });
        }
    }





})
)