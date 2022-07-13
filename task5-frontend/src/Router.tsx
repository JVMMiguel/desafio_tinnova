import { Route, Routes } from "react-router-dom";

import { Main } from "./pages/Main";
import { VehicleByBrand } from "./pages/VehicleByBrand";
import { VehicleRegisteredLastWeek } from "./pages/VehicleRegisteredLastWeek";

export function Router() {
  return (
    <Routes>
      <Route path="/" element={<Main />}/>
      <Route path="/vehicle-by-brand" element={<VehicleByBrand/>} />
      <Route path="/weekly-register" element={<VehicleRegisteredLastWeek />} />
    </Routes>
  )
}