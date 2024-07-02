import React from "react";

function Footer() {
  return (
    <div className="">
      <section className="mt-5 mb-3">
        <div className="row text-center d-flex justify-content-between align-items-center">
        <hr class="my-3 pb-3" />
          <div className="col-md-2">
            <h6 className="text-uppercase font-weight-bold">
              <a href="#!" className="text-black text-decoration-none">
                Ayuda
              </a>
            </h6>
          </div>
          <div className="col-md-2">
            <h6 className="text-uppercase font-weight-bold">
              <a href="#!" className="text-black text-decoration-none">
                Nosotros
              </a>
            </h6>
          </div>
          <div className="col-md-2 d-flex flex-wrap justify-content-center">
            <div
              className="rounded-circle overflow-hidden mx-1"
              style={{ width: "25px", height: "25px" }}
            >
              <img
                src={
                  "https://previews.123rf.com/images/glopphy/glopphy1509/glopphy150900071/45542269-grupo-inmobiliario-de-dise%C3%B1o-de-negocios-logotipo-de-casas.jpg"
                }
                alt="Your Logo"
                className="w-100 h-100"
              />
            </div>
            <h6 className="text-uppercase font-weight-bold">
              <a href="#!" className="text-black text-decoration-none">
                MultiPlace
              </a>
            </h6>
          </div>
          <div className="col-md-2">
            <h6 className="text-uppercase font-weight-bold">
              <a href="#!" className="text-black text-decoration-none">
                Términos
              </a>
            </h6>
          </div>

          <div className="col-md-2">
            <h6 className="text-uppercase font-weight-bold">
              <a href="#!" className="text-black text-decoration-none">
                Mapa de sitio
              </a>
            </h6>
          </div>
        </div>
      </section>
      <div className="container d-flex justify-content-center p-1">
        <p>
          <b>seguinos!</b>
        </p>
      </div>
      <div className="container d-flex justify-content-center py-2">
        <button
          type="button"
          className="rounded-circle mx-3 overflow-hidden"
          style={{ width: "50px", height: "50px" }}
        >
          <i class="bi bi-facebook"></i>
        </button>
        <button
          type="button"
          className="rounded-circle mx-3 overflow-hidden "
          style={{ width: "50px", height: "50px" }}
        >
          <a href="https://api.whatsapp.com/send?phone=5493624" class='text-black'>
          <i class="bi bi-whatsapp"></i>
          </a>
        </button>
        <button
          type="button"
          className="rounded-circle mx-3 overflow-hidden"
          style={{ width: "50px", height: "50px" }}
        >
          <i class="bi bi-instagram"></i>
        </button>
        <button
          type="button"
          className="rounded-circle mx-3 overflow-hidden"
          style={{ width: "50px", height: "50px" }}
        >
          <i class="bi bi-twitter-x"></i>
        </button>
      </div>
      <div className="text-center text-black p-3">© MultiPlace 2023</div>
    </div>
  );
}

export default Footer;
