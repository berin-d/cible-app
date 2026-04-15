import { useEffect, useState } from "react";
import ExpandableList from "../../components/commons/ExpandableList";


type TaskDTO = {
  id: number;
  title: string;
  description: string;
  dueDate: string;
  userId: number;
  username: string;
  statusId: number | null;
  statusName: string | null;
  priorityId: number | null;
  priorityName: string | null;
  taskGroupId: number;
  taskGroupName: string;
  createdAt: string;
  updatedAt: string;
  completedAt: string | null;
  taskOrder: number;
};


type TaskGroupDTO = {
  id: number;
  name: string;
  tasks: TaskDTO[];
}






export default function DashboardPage() {

  // Quel fonction ce lance quand la page est charger / composant est charger ?

  // [ListOfYears, dzhqdhuqz] = useState([])
  // Fonction qui ce lance quand la page est charger / composant est charger
  /*

 function onLoad() {
 
  setListofYears(DashboardHooks.load(idUser));

 }
  
 // 
 useEffect(() => {
 
  onLoad();

}, []);




  */


  return (

    /*
    <ListYears listOfYears={ListOfYears} />
    */
    );
}







/*


======= DashboardhHooks =====

load(idUser: number) {

  Dashboard.getAllTaskGroupByUser(idUser).then((response) => {

  return response.data;

}).catch((error) => {

  console.error("Error fetching task groups:", error);

});
}


*/