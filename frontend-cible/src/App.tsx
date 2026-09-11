import { BrowserRouter, Routes, Route, Navigate, Outlet } from 'react-router-dom';
import { isTauri } from './utils/platforms';

// Pages
import LoginPage from './pages/auth/login';
import WelcomePage from './pages/web/Welcome';
import DashboardPage from './pages/common/dashboard';

// Layouts
import AuthLayout from './components/layouts/authLayout';
import AppLayout from './components/layouts/appLayout';
import RegisterPage from './pages/auth/register';
import TaskPage from './pages/common/task';
import GoalPage from './pages/common/goals';


function ProtectedRoute() {
    const token = localStorage.getItem("token");

    if (!token) {
        return <Navigate to="/" replace />;
    }

    return <Outlet />;
}

const WelcomeRedirect = () => {
    if (isTauri()) {
        return <Navigate to="/login" replace />;
    }
    return <WelcomePage />;
};

export default function App() {
    return (
        <BrowserRouter>
            <Routes>
                {/* Routes */}
                <Route path="/" element={<WelcomeRedirect />} />

                <Route element={<AuthLayout />}>
                    <Route path="/login" element={<LoginPage />} />
                    <Route path="/register" element={<RegisterPage />} />

                </Route>

                {/* Portected Routes */}

                <Route element={<ProtectedRoute />}>
                    <Route element={<AppLayout />}>
                        <Route path="/dashboard" element={<DashboardPage />} /> {/* child page */}
                        <Route path="/dashboard/:year" element={<GoalPage />} />
                        <Route path="/dashboard/:year/:goalId" element={<TaskPage />} />

                        <Route path="/dashboard/:year/kanban"></Route>
                    </Route>
                </Route>

                {/* Default Routes */}
                <Route path="*" element={<Navigate to="/" replace />} />
            </Routes>
        </BrowserRouter>
    );
}