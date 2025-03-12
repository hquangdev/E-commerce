import React from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter } from "react-router-dom"; // ✅ Import BrowserRouter
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import App from "./App";

// import './assets/css/bootstrap.min.css';
// import './assets/css/plugins/owl-carousel/owl.carousel.css';
// import './assets/css/plugins/magnific-popup/magnific-popup.css';
// import './assets/css/style.css';
// import './assets/css/web/demo-31.css';
// import './assets/vendor/font-awesome/css/all.min.css';
// import './assets/css/css-custom/style.css';

// import $ from "jquery"; 
// window.jQuery = $;
// window.$ = $;
// console.log("jQuery version:", $.fn.jquery);

// import "./assets/js/jquery.min.js"; 
// import "./assets/js/bootstrap.bundle.min.js";
// import "./assets/js/jquery.hoverIntent.min.js";
// import "./assets/js/jquery.waypoints.min.js";
// import "./assets/js/superfish.min.js";
// import "./assets/js/owl.carousel.min.js"; 
// import "./assets/js/jquery.plugin.min.js";
// import "./assets/js/jquery.magnific-popup.min.js";
// import "./assets/js/jquery.countdown.min.js";
// import "./assets/js/imagesloaded.pkgd.min.js";
// import "./assets/js/isotope.pkgd.min.js";
// import "./assets/js/main.js";
// import "./assets/js/web/demo-31.js";

const queryClient = new QueryClient();

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <BrowserRouter> {/* ✅ Thêm BrowserRouter ở đây */}
      <QueryClientProvider client={queryClient}>
        <App />
      </QueryClientProvider>
    </BrowserRouter>
    <button id="scroll-top" title="Back to Top"><i className="icon-arrow-up"></i></button>
  </React.StrictMode>
);
