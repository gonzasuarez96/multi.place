import Image from "next/image";
import Link from "next/link";

export default function PropCard({ data }) {
  console.log("data:", data);
  const imageUrl = data.property_image[0]?.route;
  console.log("imageUrl:", imageUrl)
    ? data.property_image[0]
    : "https://mir-s3-cdn-cf.behance.net/project_modules/2800_opt_1/e00f7988125171.5e4c6027139b9.png";

  return (
    <div className="d-flex align-items-center border px-4">
      <div>
        <Image
          src={imageUrl}
          width={500}
          height={300}
          alt="Foto del inmueble"
        />
      </div>
      <div className="p-4" style={{ maxWidth: "600px" }}>
        <p
          style={{
            wordWrap: "break-word",
            fontWeight: "bold",
            fontSize: "1.5rem",
          }}
        >
          {data.name ? data.name : "Titulo"}
        </p>

        <p style={{ wordWrap: "break-word", fontWeight: "bold" }}>
          {data.price ? `$ ${data.price}` : "Precio"}
        </p>
        <p>
          {data.address
            ? `${data.address.street} ${data.address.number}`
            : "Dirección"}
        </p>
        <p>{data.contract_type ? data.contract_type : "Tipo de unidad"}</p>
        <p style={{ wordWrap: "break-word" }}>
          {data.description
            ? data.description
            : "Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel egestas dolor, nec dignissim metus."}
        </p>
        <div className="d-flex justify-content-center">
          <Link
            href={`/props/${data.id}`}
            className="btn btn-primary mt-4 mb-4"
          >
            Detalles
          </Link>
        </div>
      </div>
    </div>
  );
}
