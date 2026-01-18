import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import { isTauri, isAuthenticated } from './utils/platforms';

// Pages
import LoginPage from './pages/auth/login';
import WelcomePage from './pages/web/Welcome';
import DashboardPage from './pages/dashboard/dashboard';


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

                {/* Welcome page - seulement pour web */}
                <Route path="/" element={<WelcomeRedirect />} />

                {/* Authentication */}
                <Route path="/login" element={<LoginPage />} />

                {/* Application protégée */}
                <Route
                    path="/dashboard"
                    element={
                        <ProtectedRoute>
                            <DashboardPage />
                        </ProtectedRoute>
                    }
                />

                {/* Route par défaut */}
                <Route path="*" element={<Navigate to="/" replace />} />
            </Routes>
        </BrowserRouter>
    );
}