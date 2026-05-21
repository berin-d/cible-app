import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import ListYears from "../../components/lists/ListYears";
import DashBoardHooks from "../../hooks/DashBoardHooks"


export default function DashboardPage() {
  const navigate = useNavigate();
  const [listOfYears, setListOfYears] = useState<string[]>([]);

  const onLoad = async () => {
    const data = await DashBoardHooks.loadYears();
    setListOfYears(data);
  };

  useEffect(() => {
    onLoad();
  }, []);

  const handleYearSelect = (year: string) => {
    navigate(`/dashboard/taskGroup/${year}`);
  };

  return (
    <div>
      <div className="flex items-center gap-4">
        <div className="text-3xl text-[#71717a]">
          Dashboard
        </div>
      </div>
      <ListYears
        datas={listOfYears}
        navigateTo={handleYearSelect}
      />
    </div>
  );
}


