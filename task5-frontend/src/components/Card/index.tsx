import { Button } from '@material-ui/core';
import DeleteIcon from '@material-ui/icons/Delete'
import { format } from 'date-fns';
import ptBR from 'date-fns/esm/locale/pt-BR/index.js';
import { useEffect, useMemo, useState } from 'react';
import { toast } from 'react-toastify';
import { api } from '../../services/api';
import './styles.css'

interface VehicleData {
  id: number | string;
  brand: string;
  description: string;
  sold: boolean;
  vehicleName: string;
  year: number | string;
}

export function Card() {

  const [vehicle, setVehicle] = useState<VehicleData[]>()

  useEffect(() => {
    api.get('veiculos/')
      .then(response => setVehicle(response.data))
      .catch(() => toast.error('Não foi possível conectar à API!'))
  }, [])

  async function handleDelete(vehicleId: string | number) {
    try {
      await api.delete(`veiculos/${vehicleId}`)
      setVehicle(old => old?.filter(item => item.id !== vehicleId))
      toast.success('Veículo deletado!')
    } catch {
      toast.error('Houve um erro ao deletar o veículo!')
    }
  }
  
  return (
    <div className="vehicle-card">
      <h2 className="vehicle-title">Veículos</h2>
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
              <th>Excluir?</th>
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
                    <td >{vehicle?.year}</td>
                    <td><Button onClick={() => handleDelete(vehicle.id)} variant="contained" startIcon={<DeleteIcon />} /></td>
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
  )
}