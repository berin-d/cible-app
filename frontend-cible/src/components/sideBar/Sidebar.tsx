import { NavLink } from "react-router-dom";


import { Icon } from "../commons/icon";

export default function SideBar({


}) {
    return (
        <>
            <aside className="flex flex-col space-y-4 bg-[#242429] p-4 md:text-xl text-xs md:w-60 w-20 text-white">
                <div className="flex gap-2">
                    <Icon icon="circle-user" color="#50C878" size="xl" />
                    <p>Drustin</p>
                </div>
                {/* TODO : Need to change be a generic list component */}
                <div>
                    <ul className="flex flex-col space-y-2 pt-5">
                        <li>
                            <NavLink
                                to="/dashboard"
                                className={({ isActive }) =>
                                    `flex items-center gap-2 p-2 rounded-xl cursor-pointer
                transform transition-all duration-300 ease-in-out
                hover:text-primary-400 hover:bg-gray-100/5 hover:scale-[1.03] hover:translate-x-1
                ${isActive ? 'text-primary-500 bg-gray-100/10 text-primary-400 scale-[1.03] translate-x-1' : 'scale-100'}`
                                }
                            >
                                <Icon icon="grip" size="lg" />
                                <p>Dashboard</p>
                            </NavLink>
                        </li>
                    </ul>
                </div>

                <div className="flex h-full justify-center items-end">
                    <NavLink to="/welcome" className="flex items-center gap-2 p-2 rounded-xl cursor-pointer mt-10 text-sm text-zinc-500 hover:text-zinc-300 transition-colors">
                        <Icon icon="arrow-right-from-bracket" size="lg" />
                        <p>Logout</p>
                    </NavLink>
                </div>
            </aside>


        </>
    );
}

