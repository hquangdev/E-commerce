import React from "react";
import { Routes, Route, Navigate, Outlet, Router } from "react-router-dom";
import LayoutAdmin from "./layout/AdminLayout"; 
import Dashboard from "./CMS/Dasboard"; 
import Slide from "./CMS/slide/Slide";
import EditSlide from "./CMS/slide/EditSlide";

const isAuthenticated = () => {
  return localStorage.getItem("token") !== null; 
};

// Component bảo vệ route admin
const PrivateRoute = () => {
  return isAuthenticated() ? <Outlet /> : <Navigate to="/login" replace />;
};

const AppAdmin = () => {
  return (
    <Routes>
      <Route path="/admin" element={<PrivateRoute />}>
        <Route element={<LayoutAdmin />}>
          <Route index element={<Dashboard />} />
          <Route path="slide" element={<Slide />} />
          <Route path="slide/edit/:id" element={<EditSlide />} />

        </Route>
      </Route>
    </Routes>
  );
};

export default AppAdmin;
