"use client";
import React, { useState } from "react";
import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css"; // Importa el CSS de Bootstrap
import data from "../dataHardcodeada/home"
import HomeComponent from "./components/HomeComponent";
import DestacadasPage from "./components/DestacadasPage";
import { getSessionStorageToken } from "../func/sessionStorage";

export default function HomePage() {
  const token = getSessionStorageToken();
  console.log(token);
  // Verificar si hay un token
  const isAuth = !!token;

  console.log('isAuth?:', isAuth);
  return (
    <div>
      <HomeComponent />
      <DestacadasPage />
    </div>
  );
}

