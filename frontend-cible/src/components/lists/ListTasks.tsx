import TaskModel from "../../models/taskModel/TasksModel";
import { useTaskStore } from "../../store/task/taskStore";
import Checkbox from "../commons/checkbox";
import DataTable, { type DataTableColumn } from "../commons/dataTable";


interface Props {
  datas: TaskModel[];
}

//mport { WebviewWindow } from '@tauri-apps/api/webviewWindow';
//
//function pinToSide() {
//  const pinned = new WebviewWindow('taches-epinglees', {
//    url: 'pinned.html',      // idéalement une page dédiée, plus légère
//    width: 280,
//    height: 600,
//    x: 1600,                 // à calculer selon la largeur de l'écran (currentMonitor())
//    y: 0,
//    alwaysOnTop: true,
//    decorations: false,
//    skipTaskbar: true,
//    resizable: false,
//  });
//
//  pinned.once('tauri://created', () => console.log('fenêtre épinglée créée'));
//  pinned.once('tauri://error', (e) => console.error(e));

//}

export default function ListTasks({ datas }: Props) {
  const completedTask = useTaskStore((state) => state.completedTask);

  function handleCompletedChange(taskId: number) {
    if (taskId == null) return;
    completedTask(taskId);
  }

  const columns: DataTableColumn<TaskModel>[] = [
    {
      key: "isCompleted",
      header: "Action",
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
    },

  ];

  return (
    <div className="flex flex-col gap-4 p-4 py-10 text-white">
      <DataTable columns={columns} data={datas} emptyMessage="Aucune tâche pour le moment." />
    </div>
  );
}