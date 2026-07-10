import TaskModel from "../../models/taskModel/TasksModel";
import { motion, AnimatePresence } from "framer-motion";
import { useTaskStore } from "../../store/task/taskStore";
import Checkbox from "../commons/checkbox";
import { useMemo } from "react";


interface Props {
  datas: TaskModel[];
}

export default function ListTasks({ datas }: Props) {
  const completedTask = useTaskStore((state) => state.completedTask);

  const { todoTasks, doneTasks } = useMemo(() => {
    return {
      todoTasks: datas.filter((task) => !task.isCompleted),
      doneTasks: datas.filter((task) => task.isCompleted),
    };
  }, [datas]);

  function handleCompletedChange(taskId: number) {
    if (taskId == null) return;
    completedTask(taskId);
  }

  function renderTask(task: TaskModel) {
    return (
      <motion.div
        key={task.id}
        layout
        initial={{ opacity: 0, scale: 0.95 }}
        animate={{ opacity: 1, scale: 1 }}
        exit={{ opacity: 0, scale: 0.95 }}
        transition={{ type: "spring", stiffness: 400, damping: 30 }}
        className="flex flex-row items-center gap-4 p-2 border border-gray-700 rounded-lg bg-[#181818]"
      >
        <Checkbox
          onClick={() => handleCompletedChange(task.id)}
          isChecked={task.isCompleted}
        />
        <p>{task.title}</p>
      </motion.div>
    );
  }

  return (
    <div className="flex flex-col text-white flex-wrap items-stretch gap-4 p-4 py-10">
      <p>À faire</p>
      <AnimatePresence mode="popLayout">
        {todoTasks.map(renderTask)}
      </AnimatePresence>

      <p>Terminé</p>
      <AnimatePresence mode="popLayout">
        {doneTasks.map(renderTask)}
      </AnimatePresence>
    </div>
  );
}