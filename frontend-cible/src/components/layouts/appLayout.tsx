
import { Outlet } from "react-router-dom";
import Main from "../main/Main";
import SideBar from "../sideBar/Sidebar";





const AppLayout = () => {
  return (
      <div className="min-h-screen flex">
        <SideBar />
        <Main>
          <Outlet />
        </Main>
      </div>
  );
};

export default AppLayout;

