import TaskModel from "../../models/taskModel/TasksModel";
import { useTaskStore } from "../../store/task/taskStore";
import Checkbox from "../commons/checkbox";
import DataTable, { type DataTableColumn } from "../commons/dataTable";

interface Props {
  datas: TaskModel[];
}

export default function ListTasks({ datas }: Props) {
  const completedTask = useTaskStore((state) => state.completedTask);

  function handleCompletedChange(taskId: number) {
    if (taskId == null) return;
    completedTask(taskId);
  }

  const columns: DataTableColumn<TaskModel>[] = [
    {
      key: "isCompleted",
      header: "",
      className: "w-12 px-3",
      render: (_, task) => (
        <Checkbox
          onClick={() => task.id !== null && handleCompletedChange(task.id)}
          isChecked={task.isCompleted}
        />
      ),
    },
    {
      key: "title",
      header: "Tâche",
      className: "font-medium text-white",
      render: (_, task) => (
        <span className={task.isCompleted ? "text-slate-500 line-through" : ""}>
          {task.title}
        </span>
      ),
    },
  ];

  return (
    <div className="flex flex-col p-4 py-6 text-white">
      <DataTable
        columns={columns}
        data={datas}
        emptyMessage="Aucune tâche pour le moment."
        rowClassName="h-14"
      />
  
    </div>
  );
}