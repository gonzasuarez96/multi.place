"use client";
import React, { useState } from "react";
import styles from "./navFilter.module.css";
import axios from "axios";
import urlProdu from "@/app/dataHardcodeada/url";

export default function NavFilter({ setPropiedades }) {
  const [filters, setFilters] = useState({
    property_type: "",
    bedrooms: "",
    bathrooms: "",
  });

  const handleSearch = () => {
    const { property_type, bedrooms, bathrooms } = filters;

    const queryParams = new URLSearchParams();

    if (property_type) {
      queryParams.append("type", property_type);
    }
    if (bedrooms) {
      queryParams.append("bedrooms", bedrooms);
    }
    if (bathrooms) {
      queryParams.append("bathrooms", bathrooms);
    }

    const queryString = queryParams.toString();
    console.log('url:', queryString)

    axios.get(`${urlProdu}/property/filter?${queryString}`)
      .then((response) => {
        console.log('DataFilter:', response.data);
        const properties = response.data.content;
        setPropiedades(properties);
        // Aquí puedes hacer lo que necesites con la respuesta
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  };
  return (
    <div className={styles.navbar}>
      <div className={styles.filter}>
        <select
          id="property_type"
          name="property_type"
          className="form-select"
          aria-label="Default select example"
          onChange={(e) =>
            setFilters({ ...filters, property_type: e.target.value })
          }
        >
          <option value="property_type" defaultValue>
            Tipo de propiedad
          </option>
          <option value="casa">Casa</option>
          <option value="departamento">Departamento</option>
          <option value="terreno">Terreno</option>
        </select>
      </div>
      <div className={styles.filter}>
        <select
          id="bedrooms"
          name="bedrooms"
          className="form-select"
          aria-label="Default select example"
          onChange={(e) => setFilters({ ...filters, bedrooms: e.target.value })}
        >
          <option value="bedrooms" defaultValue>
            Habitaciones
          </option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
        </select>
      </div>
      <div className={styles.filter}>
        <select
          id="bathrooms"
          name="bathrooms"
          className="form-select"
          aria-label="Default select example"
          onChange={(e) => setFilters({ ...filters, bathrooms: e.target.value })}
        >
          <option value="bathrooms" defaultValue>
            Baños
          </option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
        </select>
      </div>
      <div className={styles.filter}>
        <button onClick={handleSearch} className="btn btn-primary">
          Buscar
        </button>
      </div>
    </div>
  );
}
