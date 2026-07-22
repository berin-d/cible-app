import { create } from 'zustand';
import TaskModel from '../../models/taskModel/TasksModel';
import { TaskService } from '../../services/task/taskService';

interface TaskStore {
    tasks: TaskModel[];
    isLoading: boolean;
    error: unknown;
    currentGroupId: string | null;

    fetchTasks: (groupId: string) => Promise<void>;
    completedTask: (id: number) => Promise<void>;
}

/**
 * set : sert à modifier le state
 * get : sert à lire le state actuel (et les actions) depuis n'importe quelle fonction du store, même en dehors du scope où elles ont été définies au départ
 * action : est une fonction, on peut faire get().fetchTasks par exemple vu que c'est une fonction.
 */

export const useTaskStore = create<TaskStore>((set, get) => ({
    tasks: [],
    isLoading: false,
    error: null,
    currentGroupId: null,

    /**
     * Fetch all tasks for a grouptask
     */
    fetchTasks: async (groupId: string) => {
        set({ isLoading: true, error: null, currentGroupId: groupId });
        try {
            const response = await TaskService.loadTasksByGroupId(groupId);
            set({ tasks: response, isLoading: false });
        } catch (error) {
            console.error('Error fetching tasks:', error);
            set({ error, isLoading: false });
        }
    },

    /**
     * Update a task to set like completed
     */
    completedTask: async (id: number) => {
        try {
            await TaskService.taskCompletedChange(id);

            const { currentGroupId, fetchTasks } = get();
            if (currentGroupId) {

                await fetchTasks(currentGroupId);
            }
        } catch (error) {
            console.error('Error updating task completion:', error);
            set({ error });
        }
    },
}));