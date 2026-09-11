import { NavLink, useNavigate, useParams } from "react-router-dom";
import { Icon } from "../commons/icon";

export default function SideBar({ }) {
    const navigate = useNavigate();
    const { year } = useParams();

    function logout(): void {
        localStorage.removeItem('token');
        navigate("/welcome");
    }

    return (
        <aside className="flex flex-col h-screen bg-surface  text-white transition-all duration-300 md:w-60 w-20">
            <div className="flex flex-col space-y-6 p-4">
                <div className="flex items-center justify-center md:justify-start gap-3 md:px-2">
                    <Icon icon="circle-user" color="#50C878" size="xl" />

                    <p className="hidden md:block font-bold text-lg truncate">Drustin</p>
                </div>

                {/* Lien Dashboard */}
                <ul className="flex flex-col">
                    <li>
                        <NavLink
                            to="/dashboard"
                            className={({ isActive }) =>
                                `flex items-center justify-center md:justify-start gap-3 p-2 md:px-4 rounded-xl cursor-pointer text-sm md:text-base
                                transform transition-all duration-300 ease-in-out
                                hover:text-primary-400 hover:scale-[1.02]
                                ${isActive && !year ? 'text-primary-500 bg-gray-100/10 text-primary-400 scale-[1.03] md:translate-x-1' : 'scale-100'}`
                            }
                        >
                            <Icon icon="grip" size="lg" />
                            <p className="hidden md:block">Dashboard</p>
                        </NavLink>
                    </li>
                </ul>
            </div>
            <hr className="my-6 w-full border-t border-zinc-700/50" />
            <div className="flex flex-col flex-grow justify-between p-4">

                {/* Sous-menu année (Kanban) */}
                <ul className="flex flex-col space-y-2">
                    {year && (
                        <div className="flex flex-col space-y-2 md:pl-4 md:border-l-2 border-primary-500/50">
                            <li className="hidden md:block text-primary-400 text-xs font-semibold py-1 uppercase tracking-wider">
                                Workspace {year}
                            </li>
                            <li>
                                <NavLink
                                    to={`/dashboard/${year}`}
                                    className={({ isActive }) =>
                                        `flex items-center justify-center md:justify-start gap-3 p-2 md:px-4 rounded-xl cursor-pointer text-sm md:text-base
                                        transform transition-all duration-300 ease-in-out
                                        hover:text-primary-400 hover:bg-gray-100/5 hover:scale-[1.03] md:hover:translate-x-1
                                        ${isActive ? 'text-primary-500 bg-gray-100/10 text-primary-400 scale-[1.03] md:translate-x-1' : 'scale-100'}`
                                    }
                                >
                                    <Icon icon="list" size="lg" />
                                    <p className="hidden md:block">Kanban</p>
                                </NavLink>
                            </li>
                        </div>
                    )}
                </ul>

                {/* Déconnexion (poussé vers le bas via le flex-grow du parent si h-screen est utilisé) */}
                <div
                    onClick={logout}
                    className="flex items-center justify-center md:justify-start gap-3 p-2 md:px-4 rounded-xl cursor-pointer mt-10 text-sm md:text-base text-zinc-500 hover:text-zinc-300 hover:bg-gray-100/5 transition-all"
                >
                    <Icon icon="arrow-right-from-bracket" size="lg" />
                    <p className="hidden md:block">Logout</p>
                </div>

            </div>
        </aside>
    );
}