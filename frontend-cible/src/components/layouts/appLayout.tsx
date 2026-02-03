import { Outlet } from "react-router-dom";

import { Icon } from "../commons/icon";
const AppLayout = () => {
    return (
        <div className="min-h-screen flex">
            <aside className="flex flex-col space-y-4 bg-[#242429] p-4 md:text-xl text-xs md:w-60 w-20 text-white">
                <div className="flex gap-2">
                    <Icon icon="circle-user" color="#63E6BE" size="xl" />
                    <p>Drustin</p>
                </div>
                {/* TODO : Need to change be a generic list component */}
                <div>
                    <ul className="flex flex-col space-y-2 pt-5">
                        <li className="flex hover:text-green-400 hover:cursor-pointer items-center gap-2">
                            <Icon icon="grip" size="lg" />
                            <p>Dashboard</p>
                        </li>
                        <li className="flex hover:text-green-400 hover:cursor-pointer items-center gap-2">
                            <Icon icon="chart-line" size="lg" />
                            <p>Tasks</p>
                        </li>
                    </ul>
                </div>


            </aside>

            <main className="bg-[#1A1A1E] w-screen">
                <div>
                    <p>header</p>
                </div>
                <div>
                    <Outlet />
                </div>
            </main>


        </div>
    );
};

export default AppLayout