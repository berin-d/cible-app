import { useParams, useNavigate } from "react-router-dom";
import Card from "../commons/cards";
import { GoalModel } from "../../models/goalModel/GoalsModel";

interface Props {
  goals: GoalModel[];
};


export default function ListTaskGroup({ goals }: Props) {
  const { year } = useParams();
  const navigate = useNavigate();

  return (
    <div className="flex flex-row flex-wrap items-stretch gap-4 p-4 py-10">
      {goals.map((goal) => (
        <Card
          key={goal.id}
          title={goal.name}
          currentProgress={goal.taskCompleted}
          maxProgress={goal.tasks.length}
          navigateTo={() => navigate(`/dashboard/taskGroup/${year}/${goal.id}`)}
        />
      ))}

      <Card
        addCard={true}
      />
    </div>

  );
}