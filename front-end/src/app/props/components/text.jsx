import React from "react";


function Text({ data }) {
  return (
    <div className="container">
      <div className="row">
        <div className="col-12">
          <h3>{data?.name}</h3>
          <small className="p-2">Baños: {data?.bathrooms}</small>
          <small className="p-2">Habitaciones: {data?.bedrooms} </small>
          <small className="p-2">Metros Cuadrados: {data?.square_meter} m2 </small>
      
          <p className="m-2 py-1">
            {data.description}
          </p>
        </div>
      </div>
    </div>
  );
}

export default Text;

