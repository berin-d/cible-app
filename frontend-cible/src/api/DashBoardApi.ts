const BASE_URL = "http://localhost:8081/api";

const DashBoardApi = {
  getAllYears: async (): Promise<number[]> => {
    const token = localStorage.getItem('token');
    const response = await fetch(`${BASE_URL}/goals/years`, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });

    if (!response.ok) {
      throw new Error(`Erreur ${response.status}: ${response.statusText}`);
    }

    return response.json();
  },
};

export default DashBoardApi;