"use client";

import axios from "axios";
import { useState } from "react";
import urlProdu from "@/app/dataHardcodeada/url";
import { ToastContainer } from "react-toastify";
import {
  displayFailedMessage,
  displaySuccessMessage,
} from "@/app/components/Toastify";
import { useRouter } from "next/navigation";

function Login() {
  const router = useRouter();
  const [error, setError] = useState("");
  const [credentials, setCredentials] = useState({
    email: "",
    password: "",
  });

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log(credentials);
    if (!credentials.email || !credentials.password) {
      setError("Complete los campos");
      return;
    } else {
      try {
        const res = await axios.post(`${urlProdu}/user/login`, credentials);
        console.log(res);
        const token = res.data.token;
        const idUsuario = res.data.idUsuario;
        // Guardar el token en el sessionStorage
        sessionStorage.setItem("token", token);
        sessionStorage.setItem("userId", idUsuario);

        console.log("el id de usuario despues del login es ", idUsuario)

        displaySuccessMessage("Sesion Iniciada");
        setTimeout(() => {
          window.location.href = '/';
        }, 2000);
      } catch (error) {
        console.log(error);
        displayFailedMessage("No se pudo iniciar sesion");
      }
    }
  };

  return (
    <div>
      <div
        className="container d-flex text-center justify-content-center align-items-center"
        style={{ height: "80vh" }}
      >
        <form
          className="p-3 p-3 shadow-lg p-3 mb-5 bg-body rounded"
          style={{ width: "50%", height: "50vh" }}
          onSubmit={handleSubmit}
        >
          <h2 className="text-center">Bienvenido</h2>
          <div className="form-group row justify-content-center">
            <div className="form-group justify-content-center col-sm-8 mb-3">
              <input
                type="email"
                className="form-control "
                id="email"
                placeholder="Correo"
                onChange={(e) =>
                  setCredentials({
                    ...credentials,
                    email: e.target.value,
                  })
                }
              />
            </div>
            <div className="form-group col-sm-8 mb-3">
              <input
                type="password"
                className="form-control "
                id="password"
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
          <div className="form-group ">
            <button type="submit" className="btn btn-primary btn-block ">
              Ingresar
            </button>
          </div>
          {error && (
            <div className="flex justify-center text-danger mt-2 mb-2">
              {error}
            </div>
          )}
      <label className="m-4">Esto es solo para empleados de MultiPlace</label>
        </form>
      </div>
      <ToastContainer style={{ marginTop: "100px" }} />
    </div>
  );
}

export default Login;
