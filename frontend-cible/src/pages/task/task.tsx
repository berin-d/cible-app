
import { useCallback, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faArrowLeft } from "@fortawesome/free-solid-svg-icons";
import ListTasks from "../../components/lists/ListTasks";
import { useTaskStore } from "../../store/task/taskStore";

export default function TaskPage() {

    const { year, groupId } = useParams();
    const navigate = useNavigate();


    const tasks = useTaskStore((state) => state.tasks);
    const fetchTasks = useTaskStore((state) => state.fetchTasks);


    const onLoad = useCallback(async () => {
        if (!groupId) return;
        await fetchTasks(groupId);
    }, [groupId, fetchTasks]);

    useEffect(() => {
        onLoad();
    }, [onLoad]);

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