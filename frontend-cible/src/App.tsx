import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import { isTauri, isAuthenticated } from './utils/platforms';

// Pages
import LoginPage from './pages/auth/login';
import WelcomePage from './pages/web/Welcome';
import DashboardPage from './pages/dashboard/dashboard';

// Layouts
import AuthLayout from './components/layouts/authLayout';


const ProtectedRoute = ({ children }: { children: React.ReactNode }) => {
    if (!isAuthenticated()) {
        return <Navigate to="/login" replace />;
    }
    return <>{children}</>;
};

const WelcomeRedirect = () => {
    if (isTauri()) {
        // En desktop, rediriger directement vers login ou dashboard
        return isAuthenticated() ? <Navigate to="/dashboard" replace /> : <Navigate to="/login" replace />;
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
                    <Route path="/register" element={<LoginPage />} />
                </Route>

                {/* Portected Routes */}

                <Route
                    path="/dashboard"
                    element={
                        <ProtectedRoute>
                            <DashboardPage />
                        </ProtectedRoute>
                    }
                />

                {/* Default Routes */}
                <Route path="*" element={<Navigate to="/" replace />} />
            </Routes>
        </BrowserRouter>
    );
}