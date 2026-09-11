
import { useCallback, useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { faAdd } from "@fortawesome/free-solid-svg-icons";
import ListTasks from "../../components/lists/ListTasks";
import { useTaskStore } from "../../store/task/taskStore";
import Button from "../../components/commons/button";
import Modal from "../../components/commons/modal";
import TaskModel from "../../models/taskModel/TasksModel";
import { ToastContainer, toast } from 'react-toastify';

export default function TaskPage() {
    // route & data
    const { goalId } = useParams();

    // form
    const [isOpen, setIsOpen] = useState(false);
    const [title, setTitle] = useState("");

    // store
    const tasks = useTaskStore((state) => state.tasks);
    const fetchTasks = useTaskStore((state) => state.fetchTasks);
    const addTask = useTaskStore((state) => state.addTask);

    // toast
    const notify = () => toast("Task created !");


    const onLoad = useCallback(async () => {
        console.log(goalId)
        if (!goalId) return;
        await fetchTasks(Number(goalId));
    }, [goalId, fetchTasks]);

    useEffect(() => {
        onLoad();
    }, [onLoad]);

    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        console.log(goalId)
        if (!goalId) return;
        console.log("create taskmodel")
        const newTask = new TaskModel({
            id: null,
            title: title,
            goalId: Number(goalId),
            dueDate: null,
            completedAt: null,
            isCompleted: false,
        });

        console.log("addTask")
        notify()
        await addTask(newTask);
        setTitle("");
        setIsOpen(false);
    };

    return (
        <div>
            <div className="flex justify-between items-center mb-6">
                <div>
                    <h1 className="text-2xl font-bold">Tasks</h1>
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