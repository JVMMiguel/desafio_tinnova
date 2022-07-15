import { useEffect, useState } from "react";
import { toast } from "react-toastify";
import { Header } from "../../components/Header";
import { api } from "../../services/api";

interface VehicleData {
  id: number | string;
  brand: string;
  quantity: number;
}

export function VehicleByBrand() {

  const [vehicle, setVehicle] = useState<VehicleData[]>()

  useEffect(() => {
    api.get('veiculos/find/brand')
      .then(response => setVehicle(response.data))
      .catch(() => toast.error('Não foi possível conectar à API!'))
  }, [])

  return (
    <>
      <Header />
      <main>
        <section id="vehicles">
          <div className="vehicle-container">
            <div className="vehicle-card">
              <h2 className="vehicle-title">Veículos por Fabricante</h2>
              <div>
                <table className="vehicle-table">
                  <thead>
                    <tr>
                      <th className="show576">Marca</th>
                      <th className="show576">Quantidade</th>
                    </tr>
                  </thead>
                  {
                    vehicle ?
                      vehicle?.map(vehicle => (
                        <tbody key={vehicle?.id}>
                          <tr>
                            <td className="576">{vehicle?.brand.replace("_", " ")}</td>
                            <td className="show576">{vehicle?.quantity}</td>
                          </tr>
                        </tbody>
                      ))
                      :
                      <div className="not-found">
                        Nenhum dado encontrado
                      </div>
                  }
                </table>
              </div>

            </div>
          </div>
        </section>
      </main>
    </>
  )
}