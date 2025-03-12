import React from "react";
import { useLocation } from "react-router-dom"; 
import AppAdmin from "./admin/AppAdmin";
import AppClient from "./client/AppClient";
import { Routes, Route } from "react-router-dom";

import Login from "./components/login";
import Register from "./components/Register";

const App = () => {
  const location = useLocation();

  if (location.pathname === "/login" || location.pathname === "/register") {
    return (
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
      </Routes>
    );
  }

  return location.pathname.startsWith("/admin") ? <AppAdmin /> : <AppClient />;
};

export default App;


