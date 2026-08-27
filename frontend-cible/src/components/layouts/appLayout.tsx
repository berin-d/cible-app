
import { Outlet } from "react-router-dom";
import Main from "../main/Main";
import SideBar from "../sideBar/Sidebar";
import Breadcrumb from "../commons/breadcrumb";





const AppLayout = () => {
  return (
    <div className="min-h-screen flex">
      <SideBar />
      <Main>
        <Breadcrumb />
        <Outlet />
      </Main>
    </div>
  );
};

export default AppLayout;

