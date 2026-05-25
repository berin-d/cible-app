import { useParams, useNavigate } from "react-router-dom";
import { TaskGroupDTO } from "../types/Types";
import Card from "../commons/cards";

interface Props {
  datas: TaskGroupDTO[];
};


export default function ListTaskGroup({ datas }: Props) {
  const { year } = useParams();
  const navigate = useNavigate();

  return (
    <div className="flex flex-row flex-wrap items-stretch gap-4 p-4 py-10">
      {datas.map((taskGroup) => (
        <Card
          key={taskGroup.id}
          title={taskGroup.name}
          navigateTo={() => navigate(`/dashboard/taskGroup/${year}/${taskGroup.id}`)}
        />
      ))}

      <Card
        addCard={true}
      />
    </div>

  );
}