import { create } from 'zustand';
import { GoalModel } from '../../models/GoalsModel';
import { GoalService } from '../../services/goal/goalService';

interface GoalStore {
    currentYear: string | null;
    isLoading: boolean;
    error: unknown;
    goals: GoalModel[];
    goal: GoalModel | null;

    // crud
    fetchGoals: (years: string) => Promise<void>
    addGoal: (title: string) => Promise<void>
    deleteGoal: (id: number) => Promise<void>
    getGoalById: (id: number) => Promise<GoalModel | null>;
}
export const useGoalStore = create<GoalStore>((set, get) => ({
    goals: [],
    goal: null,
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

    getGoalById: async (id: number) => {
        try {
            const response = await GoalService.getGoalById(id);
            set({ goal: response });
            return response;
        } catch (error) {
            console.error('Error fetching goal by ID:', error);
            return null;
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