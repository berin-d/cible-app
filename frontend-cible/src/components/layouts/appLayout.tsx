import { Outlet } from "react-router-dom";

import { Icon } from "../commons/icon";
const AppLayout = () => {
    return (
        <div className="min-h-screen flex">
            <aside className="flex flex-col space-y-4 bg-[#242429] p-4">
                <div>
                   <Icon icon="circle-user" color="#63E6BE" size="xl"/>
                </div>


                <div>
                    <ul>
                        <li>Dashboard</li>
                        <li>Tasks</li>
                    </ul>
                </div>

                  <div>
                    <ul>
                        <li>Dashboard</li>
                        <li>Tasks</li>
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