import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import { isTauri } from './utils/platforms';

// Pages
import LoginPage from './pages/auth/login';
import WelcomePage from './pages/web/Welcome';
import DashboardPage from './pages/dashboard/dashboard';

// Layouts
import AuthLayout from './components/layouts/authLayout';
import AppLayout from './components/layouts/appLayout';
import RegisterPage from './pages/auth/register';
import TaskGroupList from './components/commons/TaskGroupList';
import TaskDetail from './components/commons/TaskDetail';

/*
const ProtectedRoute = ({ children }: { children: React.ReactNode }) => {
    if (!isAuthenticated()) {
        return <Navigate to="/login" replace />;
    }
    return <>{children}</>;
};
*/

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

                <Route element={<AppLayout />}>
                    <Route path="/dashboard" element={<DashboardPage />} /> {/* child page */}
                    <Route path="/dashboard/taskGroup/:year" element={<TaskGroupList />} />
                    <Route path="/dashboard/taskGroup/:year/:groupId" element={<TaskDetail />} />
                </Route>

                {/* Default Routes */}
                <Route path="*" element={<Navigate to="/" replace />} />
            </Routes>
        </BrowserRouter>
    );
}