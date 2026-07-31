import { useParams, useNavigate } from "react-router-dom";
import Card from "../commons/cards";
import { GoalModel } from "../../models/goalModel/GoalsModel";
import { useState } from "react";

interface Props {
  goals: GoalModel[];
  addCard: (title: string) => void;
  deleteGoal: (id: number) => void;
};


export default function ListTaskGroup({ goals, addCard, deleteGoal }: Props) {
  const { year } = useParams();
  const navigate = useNavigate();

  const [isOpen, setIsOpen] = useState(false);


  return (
    <div className="flex flex-row flex-wrap items-stretch gap-4 p-4 py-10">
      {goals.map((goal) => (
        <Card
          key={goal.id}
          title={goal.name}
          currentProgress={goal.taskCompleted}
          maxProgress={goal.tasks.length}
          navigateTo={() => navigate(`/dashboard/taskGroup/${year}/${goal.id}`)}
          onDeleteClick={() => deleteGoal(goal.id)}
        />
      ))}

      <Card
        addCard={true}
        onAddClick={() => setIsOpen(true)}
        openForm={isOpen}
        onSubmit={addCard}
      />
    </div>

  );
}