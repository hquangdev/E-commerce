import React from "react"; 
import Navba from "../../components/cms/Navba";
import Topbar from "../../components/cms/Topbar";
import Footer from "../../components/cms/Footer";
import { Outlet } from "react-router-dom";

import "../assets/vendor/fontawesome-free/css/all.min.css";
import "../assets/css/sb-admin-2.min.css";
import "../assets/css/style.css";
import "../assets/vendor/datatables/dataTables.bootstrap4.min.css";

import $ from "jquery";
window.jQuery = $;
window.$ = $;

import "../assets/vendor/jquery/jquery.min.js";
import "../assets/vendor/chart.js/Chart.min.js";
import "../assets/js/sb-admin-2.js";
// import "../assets/js/demo/chart-area-demo.js";
// import "../assets/js/demo/chart-pie-demo.js";
import "../assets/vendor/jquery-easing/jquery.easing.min.js";
import "../assets/vendor/bootstrap/js/bootstrap.bundle.min.js";
// import "../assets/js/demo/datatables-demo.js";
// import "../assets/vendor/datatables/jquery.dataTables.min.js";
// import "../assets/vendor/datatables/dataTables.bootstrap4.min.js";

const LayoutsAdmin = () => {
  return (
      <div id="wrapper">
            <Navba />

            <div id="content-wrapper" className="d-flex flex-column">
              <div id="content">
                  <Topbar />
                  
                  <Outlet />

              </div>

              <Footer />
          </div>

      </div>
  );
};

export default LayoutsAdmin;
