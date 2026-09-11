import { useEffect, useState } from "react";
import DashBoardHooks from "../../hooks/DashBoardHooks";

import YearModel from "../../models/YearsModel";
import YearTimeline from "../../components/year/YearTimeline";

export default function DashboardPage() {
  const [listOfYears, setListOfYears] = useState<YearModel[]>([]);

  const onLoad = async () => {
    const data = await DashBoardHooks.loadYears();
    setListOfYears(data);
  };


  useEffect(() => {
    onLoad();
  }, []);

  return (
    <div>
      <YearTimeline years={listOfYears} />
    </div>
  );
}