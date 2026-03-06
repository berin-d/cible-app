import { NavLink } from "react-router-dom";
import LoginForm from "../../components/form/loginForm";

export default function LoginPage() {
    return (
        <div className="flex flex-col items-center justify-center w-screen h-screen gap-2 p-5">
            <LoginForm />
            <div>
                <span className="text-gray-400">Don't have an account ? </span>
                <NavLink
                    className="text-primary-400 hover:text-primary-600 mt-2 hover:text-primary-400 transition-colors"
                    to="/register"
                >
                    Register
                </NavLink>
            </div>

        </div>
    );
}



