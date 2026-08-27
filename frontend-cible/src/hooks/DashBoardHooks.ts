import DashBoardApi from "../api/DashBoardApi";
import YearModel from "../models/YearsModel";

const DashBoardHooks = {
  loadYears: async (): Promise<YearModel[]> => {
    try {
      const currentYear = new Date().getFullYear();
      let data = await DashBoardApi.getAllYears();
      
      const existingYears = new Set(
        data.map((year: { year: string }) => Number(year.year)),
      );
      const yearsToCreate = [currentYear, currentYear + 1].filter(
        (year) => !existingYears.has(year),
      );

      for (const year of yearsToCreate) {
        await DashBoardApi.addYear(String(year));
      }

      if (yearsToCreate.length > 0) {
        data = await DashBoardApi.getAllYears();
      }

      return data.map((year: { id: number; year: string }) => new YearModel(year));
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