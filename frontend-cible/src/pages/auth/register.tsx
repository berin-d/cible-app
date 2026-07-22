import { NavLink } from "react-router-dom";
import RegisterForm from '../../components/form/auth/registerForm';

export default function RegisterPage() {
    return (
        <div className="flex flex-col items-center justify-center w-screen h-screen gap-2 p-5">
            <RegisterForm />
            <div>
                <span className="text-gray-400">You have an account ? </span>
                <NavLink
                    className="text-primary-400 hover:text-primary-600 mt-2 hover:text-primary-400 transition-colors"
                    to="/login"
                >
                    Login
                </NavLink>
            </div>

        </div>
    );
}