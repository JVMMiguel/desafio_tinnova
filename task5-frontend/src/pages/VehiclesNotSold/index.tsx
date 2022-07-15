import { useEffect, useState } from "react";
import { Header } from "../../components/Header";
import { api } from "../../services/api";


export function VehiclesNotSold() {

  const [vehicle, setVehicle] = useState<[]>()

  useEffect(() => {
    api.get('veiculos/find/not-sold')
      .then(response => setVehicle(response.data))
      .catch(() => console.log('Não retornou nada'))
  }, [])

  return (
    <>
      <Header />
      <main>
        <section id="vehicles">
          <div className="vehicle-container">
            <div className="vehicle-card">
              <h2 className="vehicle-title">Quantidade de veículos não vendidos</h2>
              <div>
                <table className="vehicle-table">
                  <thead>
                    <tr>
                      <th className="show576">Quantidade</th>
                    </tr>
                  </thead>
                  {
                    vehicle ?
                      <tbody>
                        <tr>
                          <td className="show576">{vehicle}</td>
                        </tr>
                      </tbody>
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