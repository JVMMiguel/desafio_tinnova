import { FormEvent, useState } from "react";
import { Header } from "../../components/Header";
import { useNavigate } from 'react-router-dom'
import { api } from "../../services/api";
import { toast } from "react-toastify";

const options = [
  { label: "Alfa Romeo", value: "ALFA_ROMEO" }, { label: "Aston Martin", value: "ASTON_MARTIN" },
  { label: "Audi", value: "AUDI" }, { label: "Bmw", value: "BMW" }, { label: "Chevrolet", value: "CHEVROLET" },
  { label: "Citroen", value: "CITROEN" }, { label: "Fiat", value: "FIAT" }, { label: "Ford", value: "FORD" },
  { label: "Honda", value: "HONDA" }, { label: "Hyundai", value: "HYUNDAI" }, { label: "Jeep", value: "JEEP" }, 
  { label: "Kia", value: "KIA" }, { label: "Land Rover", value: "LAND_ROVER" }, { label: "Mercedes-benz", value: "MERCEDES_BENZ" },
  { label: "Nissan", value: "NISSAN" }, { label: "Peugeot", value: "PEUGEOT" }, { label: "Renault", value: "RENAULT" }, 
  { label: "Suzuki", value: "SUZUKI" }, { label: "Toyota", value: "TOYOTA" }, { label: "Volkswagen", value: "VOLKSWAGEN" }, 
  { label: "Volvo", value: "VOLVO" }, { label: "Yamaha", value: "YAMAHA" }, { label: "Outro", value: "OUTRO" }
]

export function RegisterVehicle() {
  const [brand, setBrand] = useState("");
  const [vehicleName, setVehicleName] = useState("");
  const [description, setDescription] = useState("");
  const [year, setYear] = useState("");

  const navigate = useNavigate()

  function handleSubmit(event: FormEvent) {
    event.preventDefault();
    api.post('/veiculos', {
      brand,
      vehicleName,
      description,
      year,
      sold: false
    }).then(() => {
      toast.success('Veículo cadastrado com sucesso! ')
      navigate('/');
    }).catch(() => toast.error('Houve um erro ao cadastrar o veículo!'));
  }

  return (
    <>
      <Header />
      <main>
        <section id="vehicles">
          <div className="vehicle-container">
            <div className="vehicle-card">
              <h2 className="vehicle-title">Registrar veículos</h2>
              <form onSubmit={handleSubmit}>
                <div className="form_group">
                  <label htmlFor="brand">Marca do veículo</label>
                  <select onChange={(event) => setBrand(event.target.value)}>
                    <option value="" disabled selected>Selecione uma marca</option>
                    {options.map((option) => (
                      <option value={option.value}>{option.label}</option>
                    ))}
                  </select>
                </div>
                <div className="form_group">
                  <label htmlFor="name">Nome do Veículo</label>
                  <input
                    id="name"
                    name="name"
                    type="text"
                    placeholder="Nome do Veículo"
                    onChange={(event) => setVehicleName(event.target.value)}
                    required
                  />
                </div>
                <div className="form_group">
                  <label htmlFor="description">Descrição do veículo</label>
                  <input
                    id="description"
                    name="description"
                    type="text"
                    placeholder="Descrição do veículo"
                    onChange={(event) => setDescription(event.target.value)}
                    required
                  />
                </div>
                <div className="form_group">
                  <label htmlFor="year">Ano do veículo</label>
                  <input
                    id="year"
                    name="year"
                    type="number"
                    placeholder="Ano do veículo"
                    onChange={(event) => setYear(event.target.value)}
                    required
                  />
                </div>
                <div className="form_group">
                  <button type="submit">Salvar</button>
                </div>
              </form>
            </div>
          </div>
        </section>
      </main>
    </>
  )
}