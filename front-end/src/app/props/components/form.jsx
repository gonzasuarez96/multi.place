"use client";
import React, { useState } from "react";
import axios from "axios";
import { ToastContainer } from "react-toastify";
import {
  displayFailedMessage,
  displaySuccessMessage,
} from "@/app/components/Toastify";
import urlProdu from "@/app/dataHardcodeada/url";

const Form = ({ user }) => {
  const [formData, setFormData] = useState({
    name: "",
    last_name: "",
    email: "",
    phone: "",
    message: "",
    property_name: "",
    property: [{}],
    user,
  });
  const [error, setError] = useState("");

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    
    if (!formData.name || !formData.email) {
      setError("Complete todos los campos por favor");
      return;
    } else {
      setError("");
    }
    try {
      const res = await axios.post(
        `${urlProdu}/correo/enviar`,
        formData
      );
      console.log("datos enviados:", res); // Puedes quitar esto, es solo para verificar que los datos se actualizan correctamente
      displaySuccessMessage("Consulta enviada");
    } catch (error) {
      console.log("errorData:", error);
    }
  };
  return (
    <div className="row align-items-stretch justify-content-stretch">
      <div className="col-md-10">
        <div className="form h-100 contact-wrap p-3">
          <h3 className="text">Contacto</h3>
          <form className="mb-5" onSubmit={handleSubmit}>
            <div className="row">
              <div className="col-md-6 form-group mb-3">
                <input
                  type="text"
                  className="form-control"
                  placeholder="Nombre"
                  name="name"
                  value={formData.name}
                  onChange={handleChange}
                />
              </div>
              <div className="col-md-6 form-group mb-3">
                <input
                  type="text"
                  className="form-control"
                  placeholder="Apellido"
                  name="last_name"
                  value={formData.last_name}
                  onChange={handleChange}
                />
              </div>
              <div className="col-md-12 form-group mb-3">
                <input
                  type="email"
                  className="form-control"
                  placeholder="Mail"
                  name="email"
                  value={formData.email}
                  onChange={handleChange}
                />
              </div>
              <div className="col-md-12 form-group mb-3">
                <input
                  type="number"
                  className="form-control"
                  placeholder="Teléfono"
                  name="phone"
                  value={formData.phone}
                  onChange={handleChange}
                />
              </div>
            </div>
            <div className="row mb-2">
              <div className="col-md-12 form-group mb-3">
                <textarea
                  className="form-control"
                  id="message"
                  cols="30"
                  rows="6"
                  name="message"
                  placeholder="Mensaje"
                  value={formData.message}
                  onChange={handleChange}
                ></textarea>
              </div>
            </div>
            <div className="row mb-2"></div>
            <div className="row justify-content-center">
              <div className="col-md-5 form-group text-center">
                <input
                  type="submit"
                  value="Enviar"
                  className="btn btn-block btn-primary rounded-0 py-2 px-4"
                />
              </div>
              {error && (
                <div className="flex justify-center text-danger mt-2 mb-2">
                  {error}
                </div>
              )}
            </div>
          </form>
        </div>
      </div>
      <ToastContainer style={{ marginTop: "100px" }} />
    </div>
  );
};

export default Form;
