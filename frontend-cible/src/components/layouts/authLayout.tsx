import { Outlet } from "react-router-dom";

const AuthLayout = () => {
    return (
        <div className="min-h-screen bg-[#1A1A1E]">
            <main>
                <Outlet />
            </main>
        </div>
    );
};

export default AuthLayout