"use client";
import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import Form from "@/app/props/components/form";
import Text from "@/app/props/components/text";
import Image from "@/app/props/components/image";
import urlProdu from "@/app/dataHardcodeada/url";

const detailId = async(id) => {
    return fetch(`${urlProdu}/property/findById/${id}`)
    .then(response => response.json())
}

export default async function page({params}) {
    const {id} = params;
    const detail= await detailId(id);
    console.log('detail:', detail)
    const user = detail.user_registration;
    console.log(user)
  return (
    <div className="container">
      <div className="row">
          <Image data={detail.property_image}/>
        <div className="col-md-6">
          <Text data={detail}/>
        </div>
        <div className="col-md-6">
          <Form user={user}/>
        </div>
      </div>
    </div>
  );
}


