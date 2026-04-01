import { Outlet } from "react-router-dom";
import { NavLink } from "react-router-dom";
import { Icon } from "../commons/icon";
import { createContext, useContext, useState } from "react";

type GroupContextType = {
  selectedGroup: TaskGroupDTO | null;
  setSelectedGroup: (group: TaskGroupDTO | null) => void;
  taskGroups: TaskGroupDTO[];
  setTaskGroups: (groups: TaskGroupDTO[]) => void;
};

const GroupContext = createContext<GroupContextType | null>(null);

export const useGroupContext = () => {
  const ctx = useContext(GroupContext);
  if (!ctx) throw new Error("useGroupContext must be used within AppLayout");
  return ctx;
};

const AppLayout = () => {
  const [selectedGroup, setSelectedGroup] = useState<TaskGroupDTO | null>(null);
  const [taskGroups, setTaskGroups] = useState<TaskGroupDTO[]>([]);

  return (
    <GroupContext.Provider value={{ selectedGroup, setSelectedGroup, taskGroups, setTaskGroups }}>
      <div className="min-h-screen flex">
          <aside className="flex flex-col bg-[#242429] p-4 w-60 text-white overflow-y-auto shrink-0 h-screen sticky top-0">

        {/* User */}
        <div className="flex gap-2 items-center mb-4">
          <Icon icon="circle-user" color="#50C878" size="xl" />
          <p className="text-base font-medium">Drustin</p>
        </div>

        {/* Nav links */}
        <ul className="flex flex-col gap-1">
          <li>
            <NavLink to="/dashboard" className={({ isActive }) =>
              `flex items-center gap-2 p-2 rounded-xl cursor-pointer text-sm transition-all duration-300
              hover:text-primary-400 hover:bg-gray-100/5
              ${isActive ? 'text-primary-500 bg-gray-100/10' : 'text-zinc-300'}`
            }>
              <Icon icon="grip" size="lg" />
              <p>Dashboard</p>
            </NavLink>
          </li>
    
        </ul>

        {/* Groupes et tâches */}
        {taskGroups.length > 0 && (
          <div className="flex flex-col gap-1 mt-4 pt-4 border-t border-white/10">
            {taskGroups.map((tg) => (
              <div key={tg.id}>
                <button
                  onClick={() => setSelectedGroup(tg)}
                  className={`w-full text-left px-2 py-1.5 rounded-lg text-sm font-semibold transition-all
                    ${selectedGroup?.id === tg.id ? 'bg-[#10B981]/20 text-[#10B981]' : 'text-zinc-300 hover:bg-white/5 hover:text-white'}`}
                >
                  {tg.name}
                </button>
                <div className="flex flex-col gap-0.5 ml-3">
                  {tg.tasks.map((task) => (
                    <button
                      key={task.id}
                      onClick={() => setSelectedGroup(tg)}
                      className={`text-left px-2 py-1 rounded text-xs transition-all
                        ${selectedGroup?.id === tg.id ? 'text-zinc-300' : 'text-zinc-500 hover:text-zinc-300'}`}
                    >
                      • {task.title}
                    </button>
                  ))}
                </div>
              </div>
            ))}
          </div>
        )}

        {/* Logout */}
        <div className="mt-auto pt-4">
          <NavLink to="/welcome" className="flex items-center gap-2 p-2 rounded-xl cursor-pointer text-sm text-zinc-500 hover:text-zinc-300 transition-colors">
            <Icon icon="arrow-right-from-bracket" size="lg" />
            <p>Logout</p>
          </NavLink>
        </div>

        </aside>

        <main className="bg-[#1A1A1E] w-screen">
          <div className="p-2">
            <Outlet />
          </div>
        </main>
      </div>
    </GroupContext.Provider>
  );
};

export default AppLayout;