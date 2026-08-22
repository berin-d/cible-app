import DashBoardApi from "../api/DashBoardApi";
import YearModel from "../models/YearsModel";

const DashBoardHooks = {
  loadYears: async (): Promise<YearModel[]> => {
    try {
      const data = await DashBoardApi.getAllYears();
      console.log(data);
      return data.map((task: any) => new YearModel(task));
    } catch (error) {
      console.error("Error fetching years:", error);
      return [];
    }
  },

  addYear: async (year: string): Promise<boolean> => {
    try {
      await DashBoardApi.addYear(year);
      return true;
    } catch (error) {
      console.error("Error adding year:", error);
      return false;
    }
  },
};

export default DashBoardHooks;