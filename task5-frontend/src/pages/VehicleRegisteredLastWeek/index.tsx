import { useEffect, useState } from "react";
import { Header } from "../../components/Header";
import { api } from "../../services/api";
import { format } from 'date-fns'
import { toast } from "react-toastify";

interface VehicleData {
  id: number | string;
  brand: string;
  description: string;
  sold: boolean;
  vehicleName: string;
  year: number | string;
  createdAt: number;
}

export function VehicleRegisteredLastWeek() {

  const [vehicle, setVehicle] = useState<VehicleData[]>()

  useEffect(() => {
    api.get('veiculos/find/weekly-register')
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
                      <th>Data Registro</th>
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
                            <td>{format(vehicle.createdAt, 'dd/MM/yyyy')}</td>
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