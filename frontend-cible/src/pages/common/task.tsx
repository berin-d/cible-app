
import { useCallback, useEffect, useState } from "react";
import { NavLink, useNavigate, useParams } from "react-router-dom";
import { ArrowLeft } from "lucide-react";
import { faAdd } from "@fortawesome/free-solid-svg-icons";
import ListTasks from "../../components/lists/ListTasks";
import { useTaskStore } from "../../store/task/taskStore";
import Button from "../../components/commons/button";
import Modal from "../../components/commons/modal";
import TaskModel from "../../models/TasksModel";
import { ToastContainer, toast } from 'react-toastify';
import { useGoalStore } from "../../store/goal/goalStore";

export default function TaskPage() {
    // route & data
    const { goalId } = useParams();
    const navigate = useNavigate();


    // form
    const [isOpen, setIsOpen] = useState(false);
    const [title, setTitle] = useState("");

    // store
    const tasks = useTaskStore((state) => state.tasks);
    const fetchTasks = useTaskStore((state) => state.fetchTasks);
    const addTask = useTaskStore((state) => state.addTask);
    const goal = useGoalStore((state) => state.goal);
    const getGoalById = useGoalStore((state) => state.getGoalById);

    // toast
    const notify = () => toast("Task created !");


    const onLoad = useCallback(async () => {
        if (!goalId) return;
        await fetchTasks(Number(goalId));
    }, [goalId, fetchTasks]);

    useEffect(() => {
        onLoad();
    }, [onLoad]);

    useEffect(() => {
        if (!goalId) return;
        void getGoalById(Number(goalId));
    }, [goalId, getGoalById]);

    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        if (!goalId) return;
        const newTask = new TaskModel({
            id: null,
            title: title,
            goalId: Number(goalId),
            dueDate: null,
            completedAt: null,
            isCompleted: false,
        });
        notify()
        await addTask(newTask);
        setTitle("");
        setIsOpen(false);
    };

    return (
        <div>
            <div className="flex justify-between items-center mb-6 pl-4">
                <div className="flex items-center gap-4">
                    <button className="text-white hover:text-emerald-500 hover:cursor-pointer transition hover:-translate-x-1 " type="button" aria-label="Retour" onClick={() => navigate(-1)}>
                        <ArrowLeft size={20} />
                    </button>
                    <h1 className="text-2xl font-bold text-white">
                        {goal?.id === Number(goalId) ? goal.name : ""}
                    </h1>
                </div>
                <div>
                    <Button
                        iconName={faAdd}
                        text="add task"
                        onClick={() => setIsOpen(true)}
                    />
                </div>
            </div>

            <ListTasks datas={tasks} />

            <Modal isOpen={isOpen} onClose={() => setIsOpen(false)} title="Ajouter une tâche">
                <form onSubmit={handleSubmit} className="space-y-4">
                    <input
                        type="text"
                        value={title}
                        onChange={(event) => setTitle(event.target.value)}
                        placeholder="Nom de la tâche"
                        className="w-full rounded-lg border border-zinc-700 bg-zinc-900 px-3 py-2 text-white outline-none focus:border-emerald-500"
                    />

                    <div className="flex justify-end gap-2">
                        <Button text="Annuler" variant="secondary" onClick={() => setIsOpen(false)} />
                        <Button text="Ajouter" type="submit" />
                    </div>
                </form>
            </Modal>


            <div>
                <ToastContainer position="bottom-left" />
            </div>
        </div>
    );
}