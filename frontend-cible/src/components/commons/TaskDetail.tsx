import Button from "../../components/commons/button"
import { faPlus } from "@fortawesome/free-solid-svg-icons";

type Props = {
    group: TaskGroupDTO;
    onBack: () => void;
  };
  
  export default function TaskDetail({ group, onBack }: Props) {
    return (
      <div className="p-4">
      <div className="flex justify-between items-center">
      <h1 className="text-4xl font-bold mb-10 text-white">
        {group.name}
      </h1>

        <h2 className="text-4xl font-bold mb-10 text-white">
        <Button
          text="NEW OBJECTIF"
          iconName={faPlus}
          variant="primary"
          size="lg"
          animation="scale"
          // onClick={onBack}
        />  
</h2>
      </div>
        {group.tasks.length === 0 ? (
          <p className="text-gray-400">None tasks for this group </p>
        ) : (
          group.tasks.map((task) => (
            <div key={task.id} className="p-4 bg-white rounded-xl m-3 shadow-sm border border-gray-200 hover:shadow-md transition max-w-md">
              <p className="font-semibold text-gray-800 text-lg mb-2">{task.title}</p>
              <ul className="space-y-1 text-sm text-gray-600">
                <li>📅 Due date: {task.dueDate ?? "No date"}</li>
                <li>✅ Completed: {task.completedAt ?? "Not completed"}</li>
              </ul>
            </div>
          ))
        )}
  
        <Button
          text="Back"
          variant="primary"
          size="md"
          onClick={onBack}
      />

      </div>
    );
  }