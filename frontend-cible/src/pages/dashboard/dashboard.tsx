import { useEffect, useState } from "react";
import ExpandableList from "../../components/commons/ExpandableList";


type TaskDTO = {
    id: number;
    title: string;
    description: string;
    dueDate: string;
    userId: number;
    username: string;
    statusId: number | null;
    statusName: string | null;
    priorityId: number | null;
    priorityName: string | null;
    taskGroupId: number;
    taskGroupName: string;
    createdAt: string;
    updatedAt: string;
    completedAt: string | null;
    taskOrder: number;
  };


  type TaskGroupDTO = {
    id: number;
    name: string;
    tasks: TaskDTO[];
  }
  


    


export default function DashboardPage() {

    const [taskGroups, setTaskGroup] = useState<TaskGroupDTO[]>([]);

    useEffect(() => {
      fetch("http://localhost:8081/api/task-groups/all")
        .then((response) => response.json())
        .then((data) => {
          setTaskGroup(data);
        })
        .catch((error) => console.error(error));
    }, []);
    
  
    return (
      <div>
        <p>test</p>
        <ExpandableList data={taskGroups} />
      </div>
    );
  }





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

