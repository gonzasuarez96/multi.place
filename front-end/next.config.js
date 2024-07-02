/** @type {import('next').NextConfig} */
const nextConfig = {
    images: {
      domains: ['mir-s3-cdn-cf.behance.net', 'imgar.zonapropcdn.com', 'bucket-aws1-dif.s3.amazonaws.com'], // Agrega el hostname aquí
      },
}

module.exports = nextConfig
