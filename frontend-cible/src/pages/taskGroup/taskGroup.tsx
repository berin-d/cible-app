import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import TaskGroupHooks from "../../hooks/TaskGroupHooks";
import { TaskGroupDTO } from "../../components/types/Types";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faArrowLeft, faCirclePlus } from "@fortawesome/free-solid-svg-icons";
import TaskGroupList from "../../components/lists/ListTasksGroup";
import Card from "../../components/commons/cards";
import ListTaskGroup from "../../components/lists/ListTasksGroup";


export default function TaskGroupPage() {
    const { year } = useParams();
    const navigate = useNavigate();
    const [taskGroups, setTaskGroups] = useState<TaskGroupDTO[]>([]);

    const onLoad = async () => {
        if (!year) return;
        const data = await TaskGroupHooks.loadTaskGroupsByYear(year);
        setTaskGroups(data);
    };

    useEffect(() => {
        onLoad();
    }, [year]);

    return (
        <div>
            <div className="flex items-center gap-4">
                <button
                    onClick={() => navigate("/dashboard")}
                    className="text-slate-400 hover:text-white transition-colors hover:cursor-pointer"
                >
                    <FontAwesomeIcon icon={faArrowLeft} />
                </button>
                <div className="text-3xl font-bold tracking-tight md:text-4xl text-white">
                    {year}
                </div>

                <div className="text-3xl text-[#71717a]">
                    TasksGroup
                </div>
            </div>


            <ListTaskGroup datas={taskGroups} />

        </div>

    );
}