import { useNavigate, useParams } from "react-router-dom";
import Button from "../../components/commons/button";
import Modal from "../../components/commons/modal";

import { useEffect, useState } from "react";
import { TaskDTO } from "../../components/types/Types";
import TaskDetailHooks from "../../hooks/TaskDetailHooks";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faArrowLeft, faCirclePlus } from "@fortawesome/free-solid-svg-icons";
import ListTasks from "../../components/lists/ListTasks";

export default function TaskPage() {
    const [modalOpen, setModalOpen] = useState(false);

    const { year, groupId } = useParams();
    const navigate = useNavigate();
    const [tasks, setTasks] = useState<TaskDTO[]>([]);

    const onLoad = async () => {
        if (!groupId) return;
        const data = await TaskDetailHooks.loadTasksByGroupId(groupId);
        setTasks(data);
    };

    useEffect(() => {
        onLoad();
    }, [groupId]);

    return (
        <div>
            <div className="flex items-center gap-4">
                <button
                    onClick={() => navigate(`/dashboard/taskGroup/${year}`)}
                    className="text-slate-400 hover:text-white transition-colors hover:cursor-pointer"
                >
                    <FontAwesomeIcon icon={faArrowLeft} />
                </button>
                <div className="text-3xl font-bold tracking-tight md:text-4xl text-white">
                    {year}
                </div>

                <div className="text-3xl text-[#71717a]">
                    Tasks
                </div>
            </div>

            <ListTasks datas={tasks} />
        </div>

    );
}