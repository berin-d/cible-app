import { TaskDTO } from "../types/Types";
import Card from "../commons/cards";

interface Props {
  datas: TaskDTO[];
};
export default function ListTasks({ datas }: Props) {
  return (
    <div className="flex flex-row flex-wrap items-stretch gap-4 p-4 py-10">
      {datas.map((task) => (
        <Card
          key={task.id}
          title={task.title}
        />
      ))}
    </div>
  );
}