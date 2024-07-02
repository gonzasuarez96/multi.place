'use client'
import React, { useState, useEffect } from "react";
import axios from "axios";
import PropCard from "./components/propCard";
import NavFilter from "./components/navFilter";
import urlProdu from "../dataHardcodeada/url";

export default function PropsPage() {
  const desarrolloApp = "http://localhost:9090";
  const [propiedades, setPropiedades] = useState([]);
  console.log('propNew:',propiedades);

  useEffect(() => {
    axios
      .get(`${urlProdu}/property/all`)
      .then((response) => {
        console.log(response.data);
        setPropiedades(response.data);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  }, []);

  return (
    <div>
      <NavFilter setPropiedades={setPropiedades}/>
      {propiedades?.map((propiedad, index) => (
        <PropCard key={index} data={propiedad} />
      ))}
    </div>
  );
}
