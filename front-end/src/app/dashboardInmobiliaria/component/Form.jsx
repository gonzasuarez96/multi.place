"use client";
import React, { useState, useEffect } from "react";
import axios from "axios";
import urlProdu from "@/app/dataHardcodeada/url";
import { ToastContainer } from "react-toastify";
import {
  displaySuccessMessage,
  displayFailedMessage,
} from "@/app/components/Toastify";
import axiosInstance from "@/app/func/Func";
import { getSessionStorageToken } from "@/app/func/sessionStorage";

const Form = () => {
  const [token, setToken] = useState("");
  const [selectedProvince, setSelectedProvince] = useState("");
  const [selectedCity, setSelectedCity] = useState("");
  const [cities, setCities] = useState([]);
  const [provinces, setProvinces] = useState([]);
  const [data, setData] = useState({
    name: "",
    province: "",
    city: "",
    price: "",
    square_meter: "",
    bedrooms: "",
    bathrooms: "",
    contract_type: "",
    description: "",
    noted: false,
    street: "",
    number: "",
    complement: "",
    propertyType: "",
  });
  const propertyType = [
    { id: 1, description: "Casa" },
    { id: 2, description: "Departamento" },
    { id: 3, description: "Terreno" },
  ];

  const [images, setImages] = useState([]);

  useEffect(() => {
    const tokenStorage = getSessionStorageToken();
    setToken(tokenStorage);
    console.log("tokenForm:", tokenStorage);

    axios
      .get(`${urlProdu}/province`)
      .then((response) => {
        console.log(response.data);
        setProvinces(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);
  console.log("token:", token);

  const handleProvinceChange = (e) => {
    const { name, value } = e.target;
    setData({
      ...data,
      [name]: value,
    });
    const selectedValue = provinces.find(
      (province) => province.id === parseInt(e.target.value, 10)
    );
    setSelectedProvince(value); // Aquí cambia para almacenar solo el id
    console.log("Provincia select:", value);

    // Hacer la solicitud para obtener las ciudades
    axios
      .get(`${urlProdu}/city/${selectedValue.id}`)
      .then((response) => {
        setCities(response.data);
        console.log("cities:", response.data);
      })
      .catch((error) => {
        console.error("Error fetching cities:", error);
      });
  };

  const handleCityChange = (e) => {
    const { value } = e.target;
    setData({
      ...data,
      city: value,
    });
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setData({
      ...data,
      [name]: value,
    });
  };

  const handleCheckboxChange = (e) => {
    const { name, checked } = e.target;
    setData({
      ...data,
      [name]: checked,
    });
  };

  const handleFileChange = (e) => {

    /*const file = e.target.files[0];
    setData({
      ...data,
      image: file, // Guarda el archivo en el estado data
    });
    */

    const selectedImages = e.target.files;
    setImages(selectedImages);
  };


  const handleSubmit = async (e) => {
    e.preventDefault();
    const propertyRequest = {
      property_type_id: data.propertyType,
      address: {
        street: data.street,
        number: data.number,
        complement: data.complement,
        location_lat: "1",
        location_len: "1",
      },
      province_id: data.province,
      city_id: data.city,
      price: data.price,
      square_meter: data.square_meter,
      bedrooms: data.bedrooms,
      bathrooms: data.bathrooms,
      contract_type: data.contract_type,
      name: data.name,
      description: data.description,
      noted: data.noted,
      user_id: sessionStorage.getItem("userId"),
      registration_date: "2023-10-07",
      registration_time: "12:48",
      state: true,
    };

    const formData = new FormData();

    console.log("el user id es ", sessionStorage.getItem("userId"),)

    formData.append("propertyRequest", new Blob([JSON.stringify(propertyRequest)], {type:"application/json"}) );
    //agregarmo imagenes al fromData
    for (let i = 0; i < images.length; i++) {
      formData.append("img", images[i]);
    }

    //imprimimos todos los elementos del formData
    for (const pair of formData.entries()) {
      console.log("todos los elementos del formData");
      console.log(pair[0], pair[1]);
    }


    const headers = {
      'Content-Type': 'multipart/form-data',
    };


    try {
      const response = await axiosInstance.post(`${urlProdu}/property/add`, formData, { headers });
      console.log("Response:", response.data);
      displaySuccessMessage('Publicacion Creada')
      setTimeout(() => {
        window.location.href = '/';
      }, 2000);
    } catch (error) {
      console.error("Error:", error);
      console.log("formsdata:", formData);
      displayFailedMessage('No se ha podido publicar')
    }
  };

  return (
    <form onSubmit={handleSubmit} style={{ width: "70%", margin: "0 auto", border: "1px solid #ccc", padding: "20px", borderRadius: "8px" }}>
      <div className="row g-3">
        <div className="col-md-6">
          <div className="mb-3">
            <label htmlFor="name" className="form-label">
              Nombre
            </label>
            <input
              type="text"
              className="form-control"
              id="name"
              name="name"
              value={data.name}
              onChange={handleInputChange}
            />
          </div>
        </div>
        <div className="col-md-6">
          <div className="mb-3">
            <label htmlFor="propertyType" className="form-label">
              Tipo de Propiedad
            </label>
            <select
              className="form-select"
              id="propertyType"
              name="propertyType"
              value={data.propertyType}
              onChange={handleInputChange}
            >
              <option value="">Selecciona un tipo de propiedad</option>
              {propertyType.map((type) => (
                <option key={type.id} value={type.id}>
                  {type.description}
                </option>
              ))}
            </select>
          </div>
        </div>
      </div>
      <div className="row g-3">
        <div className="col-md-6">
          <div className="mb-3">
            <label htmlFor="province" className="form-label">
              Provincia
            </label>
            <select
              className="form-select"
              value={data.province}
              onChange={handleProvinceChange}
              name="province"
            >
              <option value="">Selecciona una provincia</option>
              {provinces?.map((province) => (
                <option key={province.id} value={province.id}>
                  {province.description}
                </option>
              ))}
            </select>
          </div>
        </div>
        <div className="col-md-6">
          <div className="mb-3">
            <label htmlFor="city" className="form-label">
              Ciudad
            </label>
            <select
              className="form-select"
              value={data.city}
              name="city"
              onChange={handleCityChange}
            >
              <option value="">Selecciona una ciudad</option>
              {cities?.map((city) => (
                <option key={city.id} value={city.id}>
                  {city.description}
                </option>
              ))}
            </select>
          </div>
        </div>
      </div>
      <div className="row g-3">
        <div className="col-md-6">
          <div className="mb-3">
            <label htmlFor="price" className="form-label">
              Precio
            </label>
            <input
              type="text"
              className="form-control"
              id="price"
              name="price"
              value={data.price}
              onChange={handleInputChange}
            />
          </div>
        </div>
        <div className="col-md-6">
          <div className="mb-3">
            <label htmlFor="square_meter" className="form-label">
              Metros Cuadrados
            </label>
            <input
              type="text"
              className="form-control"
              id="square_meter"
              name="square_meter"
              value={data.square_meter}
              onChange={handleInputChange}
            />
          </div>
        </div>
      </div>
      <div className="row g-3">
        <div className="col-md-6">
          <div className="mb-3">
            <label htmlFor="bedrooms" className="form-label">
              Habitaciones
            </label>
            <input
              type="text"
              className="form-control"
              id="bedrooms"
              name="bedrooms"
              value={data.bedrooms}
              onChange={handleInputChange}
            />
          </div>
        </div>
        <div className="col-md-6">
          <div className="mb-3">
            <label htmlFor="bathrooms" className="form-label">
              Baños
            </label>
            <input
              type="text"
              className="form-control"
              id="bathrooms"
              name="bathrooms"
              value={data.bathrooms}
              onChange={handleInputChange}
            />
          </div>
        </div>
      </div>
      <div className="row g-3">
        <div className="col-md-6">
          <div className="mb-3">
            <label htmlFor="contract_type" className="form-label">
              Tipo de Contrato
            </label>
            <select
              className="form-select"
              id="contract_type"
              name="contract_type"
              value={data.contract_type}
              onChange={handleInputChange}
            >
              <option value="">Selecciona un tipo de contrato</option>
              <option value="alquiler">Alquiler</option>
              <option value="venta">Venta</option>
            </select>
          </div>
        </div>
        <div className="col-md-6">
          <div className="mb-3">
            <label htmlFor="description" className="form-label">
              Descripción
            </label>
            <textarea
              className="form-control"
              id="description"
              name="description"
              value={data.description}
              onChange={handleInputChange}
            />
          </div>
        </div>
      </div>
      <div className="row g-3">
        <div className="col-md-6">
          <div className="mb-3">
            <label htmlFor="street" className="form-label">
              Calle
            </label>
            <input
              type="text"
              className="form-control"
              id="street"
              name="street"
              value={data.street}
              onChange={handleInputChange}
            />
          </div>
        </div>
        <div className="col-md-6">
          <div className="mb-3">
            <label htmlFor="number" className="form-label">
              Número
            </label>
            <input
              type="text"
              className="form-control"
              id="number"
              name="number"
              value={data.number}
              onChange={handleInputChange}
            />
          </div>
        </div>
      </div>
      <div className="mb-3">
        <label htmlFor="image" className="form-label">
          Subir Imágenes
        </label>
        <input
          type="file"
          className="form-control"
          id="image"
          name="img"
          accept="image/*"
          multiple
          onChange={handleFileChange}
        />
      </div>
      <div className="mb-3 form-check">
        <input
          type="checkbox"
          className="form-check-input"
          id="noted"
          name="noted"
          checked={data.noted}
          onChange={handleCheckboxChange}
        />
        <label className="form-check-label" htmlFor="noted">
          Publicación destacada
        </label>
      </div>
      <button type="submit" className="btn btn-primary">
        Enviar
      </button>
      <ToastContainer style={{ marginTop: "100px" }} />
    </form>
  );
};

export default Form;
