import { useEffect, useState } from "react";

import DashBoardHooks from "../../hooks/DashBoardHooks";
import YearTimeline from "../../components/year/YearTimeline";
import Button from "../../components/commons/button";
import Modal from "../../components/commons/modal";
import Select from "../../components/commons/select";
import YearModel from "../../models/YearsModel";

export default function DashboardPage() {
  const [listOfYears, setListOfYears] = useState<YearModel[]>([]);
  const [isOpen, setIsOpen] = useState(false);
  const [year, setYear] = useState<string>();

  const onLoad = async () => {
    const data = await DashBoardHooks.loadYears();
    setListOfYears(data);
  };

  const handleAddYear = async () => {
    await DashBoardHooks.addYear(year)
  }


  useEffect(() => {
    onLoad();
  }, []);

  return (
    <div>
      <div className="flex items-center gap-4 justify-between">
        <div className="text-3xl text-[#71717a]">Dashboard</div>
        <Button text="+ New Years" type="button" onClick={() => setIsOpen(true)} />
      </div>
      <YearTimeline years={listOfYears}></YearTimeline>

      <Modal isOpen={isOpen} onClose={() => setIsOpen(false)}>
        <div>
          <form className="space-y-4 w-full px-6 py-4" onSubmit={handleAddYear} >
            <Select
              label="Year"
              placeholder="Select a year"
              options={["2023", "2024", "2025", "2026", "2027", "2028"]}
              value={year ?? ""}
              onChange={setYear}

            />
            <Button text="Confirm" type="submit" />
          </form>
        </div>
      </Modal>
    </div>
  );
}