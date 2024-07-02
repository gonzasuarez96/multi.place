import './globals.css'
import { Inter } from 'next/font/google'
import "bootstrap/dist/css/bootstrap.min.css";
import 'bootstrap-icons/font/bootstrap-icons.css';
import Header from './components/header/Header'
import Footer from './components/footer/Footer'

const inter = Inter({ subsets: ['latin'] })

export const metadata = {
  title: 'MultiPlace',
  description: 'WebApp de busqueda de Inmuebles',
}

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body className={inter.className}>
        <Header />
        <main>
        {children}
        </main>
        <Footer />
      </body>
    </html>
  )
}
