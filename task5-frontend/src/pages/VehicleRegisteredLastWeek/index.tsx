import { useEffect, useState } from "react";
import { Header } from "../../components/Header";
import { api } from "../../services/api";
import { format } from 'date-fns'

interface vehicleData {
  id: number | string;
  brand: string;
  description: string;
  sold: boolean;
  vehicleName: string;
  year: number | string;
}

export function VehicleRegisteredLastWeek() {

  const [vehicle, setVehicle] = useState<vehicleData[]>()

  async function handleVehicle() {
    const { data } = await api.get('veiculos/find/weekly-register');
    setVehicle(data)
  }

  useEffect(() => {
    handleVehicle()
  }, [])

  return (
    <>
      <Header />
      <main>
        <section id="vehicles">
          <div className="vehicle-container">
            <div className="vehicle-card">
              <h2 className="vehicle-title">Veículos registrados últimos 7 dias</h2>
                <div>
                  <table className="vehicle-table">
                    <thead>
                      <tr>
                        <th className="show992">ID</th>
                        <th>Marca</th>
                        <th className="show576">Descrição</th>
                        <th className="show992">Vendido</th>
                        <th className="show992">Nome do Veículo</th>
                        <th>Ano</th>
                      </tr>
                    </thead>
                    {
                      vehicle ?
                        vehicle?.map(vehicle => (
                          <tbody key={vehicle?.id}>
                            <tr>
                              <td className="show992">{vehicle?.id}</td>
                              <td>{vehicle?.brand.replace("_", " ")}</td>
                              <td className="show576">{vehicle?.description}</td>
                              <td className="show992">{vehicle?.sold === true ? "Sim" : "Não"}</td>
                              <td className="show992">{vehicle?.vehicleName}</td>
                              <td>{vehicle?.year}</td>
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