import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

import "../admin/assets/css/sb-admin-2.min.css";
import "../admin/assets/vendor/fontawesome-free/css/all.min.css";
import logo from "../client/assets/images/demos/demo-31/logo-web.jpg"; 

const Login = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault(); 

        try {
            const response = await axios.post("http://localhost:8080/api/v1/auth", {
                name: username,
                password: password
            });

            const { code, message, data } = response.data;

            if (code === 1007) {
                localStorage.setItem("token", data.token);
                localStorage.setItem("roxle", data.role);
              
                if (data.role.includes("ADMIN")) {
                    navigate("/admin");
                    setTimeout(() => alert(message), 500); 
                } else {
                    navigate("/");
                    setTimeout(() => alert(message), 500); 
                }
            }

        } catch (error) {
            alert(error.response?.data?.message || "có lỗi xảy ra");  
        }
    };

    return (
        <div className="container">
            <div className="row justify-content-center">
                <div className="col-xl-10 col-lg-12 col-md-9">
                    <div className="card o-hidden border-0 shadow-lg my-5">
                        <div className="card-body p-0">
                            <div className="row">
                                <div className="col-lg-6 d-none d-lg-flex align-items-center justify-content-center">
                                    <img src={logo} alt="Brand Logo" className="img-fluid" style={{ maxWidth: "80%", borderRadius: "50%" }} />
                                </div>
                                {/* Form đăng nhập */}
                                <div className="col-lg-6">
                                    <div className="p-5">
                                        <div className="text-center">
                                            <h1 className="h4 text-gray-900 mb-4">Xin Chào Quý Khách!</h1>
                                        </div>
                                        <form onSubmit={handleLogin} className="user">
                                            <div className="form-group">
                                                <input 
                                                    type="text" 
                                                    className="form-control form-control-user"
                                                    id="exampleInputEmail" 
                                                    aria-describedby="emailHelp" 
                                                    value={username} 
                                                    onChange={(e) => setUsername(e.target.value)}
                                                    placeholder="Xin mời nhập Email..." 
                                                    required 
                                                />
                                            </div>
                                            <div className="form-group">
                                                <input 
                                                    type="password" 
                                                    className="form-control form-control-user" 
                                                    id="exampleInputPassword" 
                                                    value={password} 
                                                    onChange={(e) => setPassword(e.target.value)}
                                                    placeholder="Mật khẩu" 
                                                    required 
                                                />
                                            </div>
                                            <div className="form-group">
                                                <div className="custom-control custom-checkbox small">
                                                    <input type="checkbox" className="custom-control-input" id="customCheck" />
                                                    <label className="custom-control-label" htmlFor="customCheck">Nhớ mật khẩu</label>
                                                </div>
                                            </div>

                                            <button type="submit" className="btn btn-primary btn-user btn-block">
                                                Đăng Nhập
                                            </button>
                                            <hr />
                                            {/* Login bằng Google và Facebook */}
                                            <a href="#" className="btn btn-google btn-user btn-block">
                                                <i className="fab fa-google fa-fw"></i> Login with Google
                                            </a>
                                            <a href="#" className="btn btn-facebook btn-user btn-block">
                                                <i className="fab fa-facebook-f fa-fw"></i> Login with Facebook
                                            </a>
                                        </form>
                                        <hr />
                                        {/* Quên mật khẩu & Đăng ký */}
                                        <div className="text-center">
                                            <a className="small" href="/forgot-password">Quên mật khẩu?</a>
                                        </div>
                                        <div className="text-center">
                                            <a className="small" href="/register">Tạo tài khoản mới!</a>
                                        </div>
                                    </div>
                                </div>
                                {/* Kết thúc Form */}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Login;
