import { useState } from "react";
import TaskDetail from "./TaskDetail";
import TaskGroupList from "./TaskGroupList";
import YearSelector from "./YearSelector";
import { useGroupContext } from "../layouts/appLayout";

type Props = {
  data: TaskGroupDTO[];
};

export default function ExpandableList({ data }: Props) {
  const [selectedYear, setSelectedYear] = useState<string | null>(null);
  const { selectedGroup, setSelectedGroup } = useGroupContext();

  if (selectedGroup)
    return (
      <TaskDetail
        group={selectedGroup}
        onBack={() => setSelectedGroup(null)}
      />
    );

  if (selectedYear)
    return (
      <TaskGroupList
        data={data}
        year={selectedYear}
        onSelect={setSelectedGroup} 
        onBack={() => setSelectedYear(null)}  
      />
    );

  return <YearSelector onSelect={setSelectedYear} />;
}