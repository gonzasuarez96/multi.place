import Link from "next/link";

export default function PropCard({ data }) {
  const maxDescriptionLength = 100;

  let truncatedDescription = data
    ? data.description
    : "Some quick example text to build on the card title and make up the bulk of the cards content.";

  if (truncatedDescription.length > maxDescriptionLength) {
    truncatedDescription =
      truncatedDescription.substring(0, maxDescriptionLength) + "...";
  }

  return (
    <div className="card" style={{ width: "50rem", margin: "2rem" }}>
      <img
        src={
          data && data.property_image && data.property_image[0]
            ? data.property_image[0].route
            : "https://www.el-carabobeno.com/minianuncios/wp-content/uploads/2023/08/cartoon-house-and-the-sun-in-the-grass-field-vector.jpg"
        }
        className="card-img-top"
        alt="Inmueble"
      />
      <div className="card-body">
        <h5 className="card-title">{data ? data.name : "Nombre"}</h5>
        <p className="card-text">{truncatedDescription}</p>
        <Link href={`/props/${data.id}`} className="btn btn-primary">
          Detalles
        </Link>
      </div>
    </div>
  );
}
