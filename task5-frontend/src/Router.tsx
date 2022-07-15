import { Route, Routes } from "react-router-dom";

import { Main } from "./pages/Main";
import { RegisterVehicle } from "./pages/RegisterVehicle";
import { VehicleByBrand } from "./pages/VehicleByBrand";
import { VehicleRegisteredLastWeek } from "./pages/VehicleRegisteredLastWeek";
import { VehiclesNotSold } from "./pages/VehiclesNotSold";

export function Router() {
  return (
    <Routes>
      <Route path="/" element={<Main />}/>
      <Route path="/vehicle-by-brand" element={<VehicleByBrand/>} />
      <Route path="/weekly-register" element={<VehicleRegisteredLastWeek />} />
      <Route path="/not-sold" element={<VehiclesNotSold />} />
      <Route path="/register-vehicle" element={<RegisterVehicle />} />
    </Routes>
  )
}