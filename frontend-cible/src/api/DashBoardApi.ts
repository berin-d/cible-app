

const BASE_URL = "http://localhost:8081/api";

const DashBoardApi = {
  getAllYears: async () => {
    const token = localStorage.getItem('token');
    const response = await fetch(`${BASE_URL}/years`, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });

    if (!response.ok) {
      throw new Error(`Erreur ${response.status}: ${response.statusText}`);
    }

    return response.json();
  },

  addYear: async (year: string) => {
    const token = localStorage.getItem('token');
    const response = await fetch(`${BASE_URL}/years/add`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
      body: JSON.stringify({ year }),
    });

    if (!response.ok) {
      throw new Error(`Erreur ${response.status}: ${response.statusText}`);
    }

    return response.json();
  },
};

export default DashBoardApi;