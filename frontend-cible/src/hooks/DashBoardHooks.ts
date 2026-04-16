import DashBoardApi from "../api/DashBoardApi";

const DashBoardHooks = {
  loadYears: async (): Promise<string[]> => {
    try {
      const data: (number | null)[] = await DashBoardApi.getAllYears();
      return data
        .filter((year) => year !== null)
        .map((year) => year!.toString());
    } catch (error) {
      console.error("Error fetching years:", error);
      return [];
    }
  },
};

export default DashBoardHooks;