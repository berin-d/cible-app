import { useCallback, useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faArrowLeft } from "@fortawesome/free-solid-svg-icons";
import ListTaskGroup from "../../components/lists/ListTasksGroup";
import { useGoalStore } from "../../store/goal/goalStore";

export default function TaskGroupPage() {
    // Init
    const { year } = useParams();
    const navigate = useNavigate();

    const goals = useGoalStore((state) => state.goals)
    const fetchGoals = useGoalStore((state) => state.fetchGoals)
    const addGoal = useGoalStore((state) => state.addGoal);

    const onLoad = useCallback(async () => {
        if (!year) return;
        await fetchGoals(year)
    }, [fetchGoals]);

    const addCard = useCallback((name: string) => {
        addGoal(name);
    }, [addGoal]);

    useEffect(() => {
        onLoad();
    }, [onLoad]);

    // Functionnal


    return (
        <div>
            <div className="flex items-center gap-4">
                <button
                    onClick={() => navigate("/dashboard")}
                    className="text-slate-400 hover:text-white transition-colors hover:cursor-pointer"
                >
                    <FontAwesomeIcon icon={faArrowLeft} />
                </button>
                <div className="text-3xl font-bold tracking-tight md:text-4xl text-white">
                    {year}
                </div>

                <div className="text-3xl text-[#71717a]">
                    TasksGroup
                </div>
            </div>


            <ListTaskGroup goals={goals} addCard={addCard} />



        </div >

    );
}