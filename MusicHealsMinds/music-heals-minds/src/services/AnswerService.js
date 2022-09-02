import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:8080/"
});

export default {
    getAll(){
        return http.get('answers'); // adding to the baseURL
    }
}