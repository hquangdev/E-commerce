import React from "react";
import { Routes, Route } from "react-router-dom";
import MainLayout from "./layout/ClientLayout"; // Layout Client
import Home from "./pages/Home"; // Trang chủ

const AppClient = () => {
  return (
    <Routes>
      <Route path="/" element={<MainLayout />}>
        <Route index element={<Home />} />
      </Route>
    </Routes>
  );
};

export default AppClient;
