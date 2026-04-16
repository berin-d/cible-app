import { useParams, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCirclePlus, faArrowLeft } from "@fortawesome/free-solid-svg-icons";
import { TaskDTO } from "../types/Types";
import TaskDetailHooks from "../../hooks/TaskDetailHooks";

export default function TaskDetail() {
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
          className="text-slate-400 hover:text-white transition-colors"
        >
          <FontAwesomeIcon icon={faArrowLeft} />
        </button>
        <div className="text-3xl font-bold tracking-tight md:text-4xl text-white">
          Group {groupId}
        </div>
      </div>
      <div className="text-3xl text-[#71717a] mt-4">
        Select a task to view details.
      </div>

      <div className="flex flex-row flex-wrap items-stretch gap-4 p-4 py-10">
        {tasks.map((task) => (
          <div
            key={task.id}
            className="relative flex flex-col bg-zinc-900 shadow-sm border border-slate-700 rounded-lg w-80 cursor-pointer hover:border-slate-500 transition-colors"
          >
            <div className="p-6">
              <div className="flex justify-between items-start mb-8">
                <h5 className="text-white text-2xl font-semibold">{task.title}</h5>
                <span className="text-slate-400 text-sm">↗</span>
              </div>
              <p className="text-slate-400 text-sm">
              {task.dueDate
                ? `Due: ${new Date(task.dueDate).toLocaleDateString("fr-FR")}`
                : "No due date"}
              </p>
            </div>
          </div>
        ))}
        <div
          onClick={() => console.log("Add task")}
          className="relative flex flex-col items-center justify-center bg-zinc-900 border border-dashed border-slate-700 rounded-lg w-80 cursor-pointer hover:border-slate-500 transition-colors group"
        >
          <FontAwesomeIcon icon={faCirclePlus} className="text-3xl mb-3 text-slate-700 group-hover:text-slate-500" />
          <div className="text-slate-700 font-medium group-hover:text-slate-500">Add Task</div>
        </div>
      </div>
    </div>
  );
}