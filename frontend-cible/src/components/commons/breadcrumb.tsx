// src/components/commons/Breadcrumb.tsx
import { Fragment } from "react";
import useBreadcrumbs from "use-react-router-breadcrumbs";
import routes from "../../routes/breadcrumbs";

export default function Breadcrumb() {
    const breadcrumbs = useBreadcrumbs(routes, {
        excludePaths: ["/"],
    });

    return (
        <nav className="flex items-center gap-2 text-sm text-slate-400">
            {breadcrumbs.map(({ match, breadcrumb }, index) => (
                <Fragment key={match.pathname}>
                    {index > 0 && <span className="text-slate-600">&gt;</span>}
                    <span
                        className={
                            index === breadcrumbs.length - 1
                                ? "text-white font-medium"
                                : "hover:text-white transition-colors hover:cursor-pointer"
                        }
                    >
                        {breadcrumb}
                    </span>
                </Fragment>
            ))}
        </nav>
    );
}