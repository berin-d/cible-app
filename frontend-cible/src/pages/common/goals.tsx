import { useCallback, useEffect, useState } from "react";
import { useNavigate, useParams, Link } from "react-router-dom";

import { useGoalStore } from "../../store/goal/goalStore";
import { Card } from "../../components/commons/cards";


export default function GoalPage() {
    // Init
    const { year } = useParams();
    const navigate = useNavigate();
    const [isOpen, setIsOpen] = useState(false);

    // Data & Store
    const goals = useGoalStore((state) => state.goals)
    const fetchGoals = useGoalStore((state) => state.fetchGoals)
    const addGoal = useGoalStore((state) => state.addGoal);
    const deleteGoal = useGoalStore((state) => state.deleteGoal)

    const onLoad = useCallback(async () => {
        if (!year) return;
        await fetchGoals(year)
    }, [fetchGoals]);

    useEffect(() => {
        onLoad();
    }, [onLoad]);



    // Functionnal
    return (
        <div>
            <div className="flex flex-row flex-wrap items-stretch gap-4 p-4 py-10">
                {goals.map((goal) => (
                    <Card
                        key={goal.id}
                        title={goal.name}
                        cardForm={false}
                        currentProgress={goal.taskCompleted}
                        maxProgress={goal.tasks.length}
                        navigateTo={() => navigate(`/dashboard/${year}/${goal.id}`)}
                        onDeleteClick={() => deleteGoal(goal.id)}
                    />
                ))}

                <Card
                    cardForm={true}
                    onAddClick={() => setIsOpen(true)}
                    openForm={isOpen}
                    showGoalForm={true}
                    onSubmit={addGoal}
                />
            </div>
        </div >

    );
}