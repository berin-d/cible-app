// src/routes/breadcrumbs.tsx
import { Link } from "react-router-dom";
import type { BreadcrumbsRoute } from "use-react-router-breadcrumbs";

const routes: BreadcrumbsRoute[] = [
    { path: "/dashboard", breadcrumb: "Dashboard" },
    {
        path: "/dashboard/taskGroup/:year",
        breadcrumb: ({ match }) => (
            <Link to={match.pathname}>{match.params.year}</Link>
        ),
    },
    {
        path: "/dashboard/taskGroup/:year/:groupId",
        breadcrumb: ({ match }) => (
            <Link to={match.pathname}>Groupe {match.params.groupId}</Link>
        ),
    },
];

export default routes;