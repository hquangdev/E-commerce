import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import logo from "../client/assets/images/demos/demo-31/logo-web.jpg"; 

const Register = () =>{

    const [form, setForm] = useState({ name: "", pass: "", address: "", email: "", phone: "" });

    const handleChange = (e) => {
        setForm({ ...form, [e.target.name]: e.target.value });
    };

    const nav = useNavigate();

    const handleRegister = async (e) => {
        e.preventDefault();

        try {
            const response = await axios.post("http://localhost:8080/api/v1/user", {
                name: form.name,
                password: form.pass,
                address: form.address,
                email: form.email,
                phone: form.phone
            });
           
            const { code, message } = response.data;

            if (code === 2003) {
                nav("/login"); 
                setTimeout(() => alert(message), 500); 
            } else {
                alert(message); 
            }
        } catch (error) {
            alert(error.response?.data?.message || "Có lỗi xảy ra, vui lòng thử lại!");
        }
    }
    

    return(
        
        <div className="container">

        <div className="card o-hidden border-0 shadow-lg my-5">
            <div className="card-body p-0">
                <div className="row">
                    <div className="col-lg-5 d-none d-lg-flex align-items-center justify-content-center">
                      <a href="/"> <img src= {logo} alt="Brand Logo" href="/" className="img-fluid" style={{ maxWidth: "80%", borderRadius:"50%" }} /></a> 
                    </div>

                    <div className="col-lg-7">
                        <div className="p-5">
                            <div className="text-center">
                                <h1 className="h4 text-gray-900 mb-4">Tạo tài khoản mới !</h1>
                            </div>
                          
                            <form className="user" onSubmit={handleRegister}>
                                <div className="form-group row">
                                    <div className="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" className="form-control form-control-user" id="exampleFirstName" required
                                            placeholder="Họ và tên" name="name" value={form.name} onChange={handleChange}/>
                                    </div>
                                    <div className="col-sm-6">
                                        <input type="password" className="form-control form-control-user" id="exampleInputPassword" required
                                            placeholder="Mật khẩu" name="pass" value={form.pass} onChange={handleChange}/>
                                    </div>
                                </div>
                                <div className="form-group">
                                    <input type="text" className="form-control form-control-user" id="exampleInputAndress" required
                                        placeholder="Địa chỉ" name="address" value={form.address} onChange={handleChange}/>
                                </div>
                                <div className="form-group row">
                                    <div className="col-sm-6 mb-3 mb-sm-0">
                                        <input type="email" className="form-control form-control-user" required
                                            id="exampleInputEmail" name="email" placeholder="Email" value={form.email} onChange={handleChange}/> 
                                    </div>
                                    <div className="col-sm-6">
                                        <input type="text" className="form-control form-control-user" required
                                            id="exampleRepeatPhone" name="phone" placeholder="Số điện thoại" value={form.phone} onChange={handleChange}/>
                                    </div>
                                </div>
                            
                                <button type="submit" className="btn btn-primary btn-user btn-block">
                                    Đăng kí
                                </button>

                                <hr/>
                                <a href="index.html" className="btn btn-google btn-user btn-block">
                                    <i className="fab fa-google fa-fw"></i> Register with Google
                                </a>
                                <a href="index.html" className="btn btn-facebook btn-user btn-block">
                                    <i className="fab fa-facebook-f fa-fw"></i> Register with Facebook
                                </a>
                            </form>
                            <hr/>
                            <div className="text-center">
                                <a className="small" href="forgot-password.html">Forgot Password?</a>
                            </div>
                            <div className="text-center">
                                <a className="small" href="/login">Bạn đã có tài khoản ! Đăng nhập</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    );
}

export default Register;