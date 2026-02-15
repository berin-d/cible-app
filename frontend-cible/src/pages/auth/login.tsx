import Input from "../../components/commons/input";
import logo from "../../assets/app-icon.png"
import { NavLink } from "react-router-dom";
import Button from "../../components/commons/button";

export default function LoginPage() {
    return (
        <div className="flex flex-col items-center justify-center w-screen h-screen l bg-[#1A1A1E] gap-2 p-5">
            <div className="pb-5">
                <img src={logo} className="size-48"></img>
            </div>
            <div>
                <Input label="Username" placeholder="Your username..." />
                <Input label="Password" placeholder="Your password.." />
                <div className="flex flex-col justify-center items-center p-5">
                    <NavLink className="bg-[#50C878] p-1 pl-5 pr-5 rounded-md" to="/dashboard">Login</NavLink>
                </div>
            </div>
        </div>
    );
}



