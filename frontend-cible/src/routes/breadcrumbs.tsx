// src/routes/breadcrumbs.tsx
import type { BreadcrumbsRoute } from "use-react-router-breadcrumbs";

const routes: BreadcrumbsRoute[] = [
    { path: "/dashboard", breadcrumb: "Dashboard" },
    {
        path: "/dashboard/:year",
        breadcrumb: ({ match }) => match.params.year,
    },

    {
        path: "/dashboard/:year/:goalId",
        breadcrumb: ({ match }) => match.params.goalId,
    },
];

export default routes;