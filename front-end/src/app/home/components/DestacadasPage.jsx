"use client";
import React, { useState, useEffect } from "react";
import PropCard from "./PropCard";
import Link from "next/link";
import axios from "axios";
import urlProdu from "@/app/dataHardcodeada/url";

export default function DestacadasPage() {
  const desarrolloApp = "http://localhost:9090";
  const [propiedades, setPropiedades] = useState([]);

  useEffect(() => {
    axios
      .get(`${urlProdu}/property/filter`, {
        params: {
          noted: true,
        },
      })
      .then((response) => {
        const primeraSeisPropiedades = response.data.content.slice(0, 6);
        setPropiedades(primeraSeisPropiedades);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  }, []);

  return (
    <div className="d-flex justify-content-center h-100 mt-5">
      <div className="ml-10">
        <h2 className="text-center mb-4">Publicaciones Destacadas</h2>
        <div className="row mb-3">
          {propiedades?.map((propiedad, index) => (
            <div
              key={index}
              className="col-md-4 d-flex justify-content-center align-items-center"
            >
              <PropCard data={propiedad} />
            </div>
          ))}
        </div>

        <div className="d-flex justify-content-center">
          <Link href={"/props"} className="btn btn-primary px-5 mt-4 mb-4">
            Ver Más
          </Link>
        </div>
      </div>
    </div>
  );
}
