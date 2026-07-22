const BASE_URL = "http://localhost:8081/api";

const DashBoardApi = {
  getAllYears: async (): Promise<number[]> => {
    const response = await fetch(`${BASE_URL}/goals/years`);
    return response.json();
  },
};

export default DashBoardApi;