// src/components/commons/Breadcrumb.tsx
import { Fragment } from "react";
import { useParams } from "react-router-dom";
import useBreadcrumbs from "use-react-router-breadcrumbs";
import routes from "../../routes/breadcrumbs";
import { Link } from "react-router-dom";
import { useGoalStore } from "../../store/goal/goalStore";

export default function Breadcrumb() {
    const { goalId } = useParams();
    const goals = useGoalStore((state) => state.goals);
    const breadcrumbs = useBreadcrumbs(routes, {
        excludePaths: ["/"],
    });

    const goalName = goals.find((goal) => String(goal.id) === goalId)?.name;

    return (
        <nav className="flex items-center gap-2 text-sm text-slate-400">
            {breadcrumbs.map(({ match, breadcrumb }, index) => (
                <Fragment key={match.pathname}>
                    {index > 0 && <span className="text-slate-600">&gt;</span>}
                    <Link
                        to={match.pathname}
                        className={
                            index === breadcrumbs.length - 1
                                ? "text-white font-medium"
                                : "hover:text-white transition-colors hover:cursor-pointer"
                        }
                    >
                        {match.params.goalId && goalName ? goalName : breadcrumb}
                    </Link>
                </Fragment>
            ))}
        </nav>
    );
}