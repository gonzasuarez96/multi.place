'use client'
import React, { useState, useEffect } from "react";
import axios from "axios";
import PropCard from "../props/components/propCard";
import NavFilter from "./components/navFilter";
import { getSessionStorageLocation } from "../func/sessionStorage";

export default function PropsFilterPage() {
  // const dt = JSON.parse(sessionStorage.getItem('location'));
  // const data = dt.ubic
  // console.log('dataPage:',data)
  // console.log(dt.cityDescription)
  // console.log(dt.provinceDescription)
  // const [propiedades, setPropiedades] = useState(data);

  return (
    <div>
      {/* <NavFilter  setPropiedades={setPropiedades} data={ data } province={ dt.provinceDescription } city={ dt.cityDescription }/>
      {propiedades?.map((propiedad, index) => (  
        <PropCard key={index} data={propiedad} />
      ))} */}
    </div>
  );
}
