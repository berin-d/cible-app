import ky from "ky";

const API_BASE_URL = import.meta.env.VITE_API_URL || 'http://localhost:8080/api';

export const apiClient = ky.create({
    prefixUrl: API_BASE_URL,
    headers: {
        'Content-Type': 'application/json',
    },
    hooks: {
        afterResponse: [
            async (_request, _options, response) => {
                return response;
            },
        ],
    },
});