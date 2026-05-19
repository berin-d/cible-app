import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import TaskGroupHooks from "../../hooks/TaskGroupHooks";
import { TaskGroupDTO } from "../../components/types/Types";


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

            {/* LE TITLE */}

            
            {/* COMPOSANTS CARDS */}

            {/* COMPOPOSABTS CARDS MODALS ? */}

        </div>
    );
}