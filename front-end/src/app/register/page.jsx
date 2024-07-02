"use client";

import axios from "axios";
import { useState } from "react";
import urlProdu from "@/app/dataHardcodeada/url";
import { ToastContainer } from "react-toastify";
import {
  displayFailedMessage,
  displaySuccessMessage,
} from "@/app/components/Toastify";

function Register() {
  const [error, setError] = useState("");
  const [credentials, setCredentials] = useState({
    name: "",
    last_name: "",
    email: "",
    password: "",
  });

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log("credentials:", credentials);
    if (!credentials.name || !credentials.last_name || !credentials.email || !credentials.password) {
      setError("Complete todos los campos");
      return;
    } else {
      try {
        const res = await axios.post(`${urlProdu}/user/save`, credentials);
        console.log("resServer:", res);
        displaySuccessMessage("Usuario registrado");
        setTimeout(() => {
          window.location.href = "/";
        }, 2000);
      } catch (error) {
        console.log(error);
        displayFailedMessage("No se puede registrar el usuario");
      }
    }
  };

  return (
    <div
      className={`container d-flex justify-content-center align-items-center text-center`}
      style={{ height: "80vh" }}
    >
      <form
        className="p-3 p-3 shadow-lg p-3 mb-5 bg-body rounded"
        style={{ width: "50%" }}
        onSubmit={handleSubmit}
      >
        <h2>Registrate!</h2>
        <div className="form-group row justify-content-center">
          <div className="col-sm-8 mb-3">
            <input
              type="text"
              className="form-control"
              placeholder="Nombre"
              onChange={(e) =>
                setCredentials({
                  ...credentials,
                  name: e.target.value,
                })
              }
            />
          </div>
          <div className="col-sm-8 mb-3">
            <input
              type="text"
              className="form-control"
              placeholder="Apellido"
              onChange={(e) =>
                setCredentials({
                  ...credentials,
                  last_name: e.target.value,
                })
              }
            />
          </div>
          <div className="col-sm-8 mb-3">
            <input
              type="email"
              className="form-control"
              placeholder="Email"
              onChange={(e) =>
                setCredentials({
                  ...credentials,
                  email: e.target.value,
                })
              }
            />
          </div>
          <div className="col-sm-8 mb-3">
            <input
              type="password"
              className="form-control"
              placeholder="Contraseña"
              onChange={(e) =>
                setCredentials({
                  ...credentials,
                  password: e.target.value,
                })
              }
            />
          </div>
        </div>
        <div className="row mb-2"></div>
        <div className="row justify-content-center">
          <div className="col-md-5 form-group text-center">
            <input
              type="submit"
              value="Registrarse"
              className="btn btn-primary btn-block"
            />
          </div>
          {error && (
            <div className="flex justify-center text-danger mt-2 mb-2">
              {error}
            </div>
          )}
        </div>
      </form>
      <ToastContainer style={{ marginTop: "100px" }} />
    </div>
  );
}

export default Register;
