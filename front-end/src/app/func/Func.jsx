import axios from 'axios';
import urlProdu from '../dataHardcodeada/url';

const axiosInstance = axios.create({
  baseURL: `${urlProdu}`,
  headers: {
    'Content-Type': 'application/json',
  },
});

axiosInstance.interceptors.request.use(
  (config) => {
    const token = sessionStorage.getItem('token'); // Obtener el token almacenado
    if (token) {
      config.headers.Authorization = `Bearer ${token}`; // Agregar el token al encabezado
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

export default axiosInstance;
