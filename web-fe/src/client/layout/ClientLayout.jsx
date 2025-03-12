import React from "react"; Header
import Header from "../../components/client/Header";
import Footer from "../../components/client/Footer";
import { Outlet } from "react-router-dom";

import '../assets/css/bootstrap.min.css';
import '../assets/css/plugins/owl-carousel/owl.carousel.css';
import '../assets/css/plugins/magnific-popup/magnific-popup.css';
import '../assets/css/style.css';
import '../assets/css/web/demo-31.css';
import '../assets/vendor/font-awesome/css/all.min.css';
import '../assets/css/css-custom/style.css';

import $ from "jquery"; 
window.jQuery = $;
window.$ = $;
console.log("jQuery version:", $.fn.jquery);

import "../assets/js/jquery.min.js"; 
import "../assets/js/bootstrap.bundle.min.js";
import "../assets/js/jquery.hoverIntent.min.js";
import "../assets/js/jquery.waypoints.min.js";
import "../assets/js/superfish.min.js";
import "../assets/js/owl.carousel.min.js"; 
import "../assets/js/jquery.plugin.min.js";
import "../assets/js/jquery.magnific-popup.min.js";
import "../assets/js/jquery.countdown.min.js";
import "../assets/js/imagesloaded.pkgd.min.js";
import "../assets/js/isotope.pkgd.min.js";
import "../assets/js/main.js";
import "../assets/js/web/demo-31.js";

const MainLayout = () => {
  return (
    <div className="flex">
      <div className="flex-1">
        <Header />
        <main className="main">
          <Outlet />  
        </main>
        <Footer />
      </div>
    </div>
  );
};

export default MainLayout;
