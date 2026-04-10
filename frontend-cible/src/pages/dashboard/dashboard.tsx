import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { TaskGroupDTO } from "../../components/types/Types";
import ListYears from "../../components/commons/ListYears";
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
      <ListYears
        title="Dashboard"
        subtitle="Select a timeframe to view nested objectives."
        options={listOfYears}
        addLabel="Add Year"
        onSelect={handleYearSelect}
        onAddClick={() => console.log("Click works")}
      />
    </div>
  );
}

    // Selector: ComponentType<{ onSelect: (time: K) => void }>;








  /* For docker database :

  [For connecting the database docker in the console git bash]
docker exec -it pg-dev psql -U admin -d CibleDB


[1. Copy past --->]


INSERT INTO users (
    username, email, password_hash, role,
    is_active, email_verified, account_locked,
    failed_login_attempts, created_at, updated_at
) VALUES (
    'mathieu', 'mathieu@test.com', '$2a$10$abcdefghijklmnopqrstuuABCDEFGHIJKLMNOPQRSTUVWXYZ012345',
    'USER', true, true, false, 0, NOW(), NOW()
);


[2. Copy past --->]


INSERT INTO task_groups (name, user_id) VALUES ('Mon premier groupe', 1);


[3. Copy past --->]

INSERT INTO tasks (
    title, description, due_date,
    user_id, status_id, priority_id, group_id,
    created_at, updated_at, task_order
) VALUES (
    'Ma première tâche', 'Description de test', '2026-03-15 10:00:00',
    1, NULL, NULL, 1,
    NOW(), NOW(), 1
);

  */

