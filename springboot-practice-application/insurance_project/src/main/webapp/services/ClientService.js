import axios from "axios";

const BASE_URL = 'http://localhost:9988';

const ClientService = {
    getFirstMessage: async () => {
        try {
            const response = await axios.get(`${BASE_URL}/dummyMessage`);
            return response.data; // Return only the data part of the response
        } catch (error) {
            console.error("Error fetching the message:", error);
            throw error; // Re-throw the error to be handled in the component
        }
    }
};

export default ClientService;
