import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { TaskGroupDTO } from "../../components/types/Types";
import ListYears from "../../components/lists/ListYears";
import DashBoardHooks from "../../hooks/DashBoardHooks"


export default function DashboardPage() {
  const navigate = useNavigate();
  const [listOfYears, setListOfYears] = useState<string[]>([]);
  const [selectedYear, setSelectedYear] = useState<string | null>(null);
  const [selectedGroup, setSelectedGroup] = useState<TaskGroupDTO | null>(null);

  const onLoad = async () => {
    const data = await DashBoardHooks.loadYears();
    setListOfYears(data);
  };

  useEffect(() => {
    onLoad();
  }, []);

  const handleYearSelect = (year: string) => {
    setSelectedYear(year);
    navigate(`/dashboard/taskGroup/${year}`);
  };

  return (

    <div className="text-white">

      <div>
        <header>Dashboard</header>
      </div>

      <ListYears
        options={listOfYears} // list of all data
        addLabel="Add Year"
        onSelect={handleYearSelect}
        onAddClick={() => console.log("Click works")}
      />
    </div>
  );
}


