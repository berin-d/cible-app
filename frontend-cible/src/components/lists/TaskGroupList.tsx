import { useParams, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import { TaskGroupDTO } from "../types/Types";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCirclePlus } from "@fortawesome/free-solid-svg-icons";
import { faArrowLeft } from "@fortawesome/free-solid-svg-icons";
import TaskGroupHooks from "../../hooks/TaskGroupHooks";

export default function TaskGroupList() {
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
          className="text-slate-400 hover:text-white transition-colors"
        >
          <FontAwesomeIcon icon={faArrowLeft} />
        </button>
        <div className="text-3xl font-bold tracking-tight md:text-4xl text-white">
          {year}
        </div>
      </div>
      <div className="text-3xl text-[#71717a] mt-4">
        Select a group to view tasks.
      </div>

      <div className="flex flex-row flex-wrap items-stretch gap-4 p-4 py-10">
        {taskGroups.map((tg) => (
          <div
            key={tg.id}
            onClick={() => navigate(`/dashboard/taskGroup/${year}/${tg.id}`)}
            className="relative flex flex-col bg-zinc-900 shadow-sm border border-slate-700 rounded-lg w-80 cursor-pointer hover:border-slate-500 transition-colors"
          >
            <div className="p-6">
              <div className="flex justify-between items-start mb-8">
                <h5 className="text-white text-2xl font-semibold">{tg.name}</h5>
                <span className="text-slate-400 text-sm">↗</span>
              </div>

              <p className="text-slate-400 text-sm">
                {tg.tasks?.length ?? 0} Tasks
              </p>
            </div>
          </div>
        ))}
        <div
          onClick={() => console.log("Add group")}
          className="relative flex flex-col items-center justify-center bg-zinc-900 border border-dashed border-slate-700 rounded-lg w-80 cursor-pointer hover:border-slate-500 transition-colors group"
        >
          <FontAwesomeIcon icon={faCirclePlus} className="text-3xl mb-3 text-slate-700 group-hover:text-slate-500" />
          <div className="text-slate-700 font-medium group-hover:text-slate-500">Add Group</div>
        </div>
      </div>
    </div>
  );
}