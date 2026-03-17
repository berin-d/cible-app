import Button from "../../components/commons/button"



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
        <Button text="&larr; NEW OBJECTIF" label="" iconName="arrow-left"></Button> {/*I think we have to do a better reusable button with the size of button and clickable function */}
        </h2>
      </div>
        {group.tasks.length === 0 ? (
          <p className="text-gray-400">Aucune tâche dans ce groupe.</p>
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
  
        <button onClick={onBack} className="mt-4 px-4 py-2 bg-[#10B981] text-white rounded-lg">
          Back
        </button>
      </div>
    );
  }