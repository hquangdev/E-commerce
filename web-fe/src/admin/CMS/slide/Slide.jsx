import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import React from "react";
import { useNavigate } from "react-router-dom";

const BASE_IMAGE_URL = "http://localhost:8080/api/v1/uploads/";

const fetchSlides = async () => {

    const { data } = await axios.get("http://localhost:8080/api/v1/slide");

    if (data.code === 2007) return data.data;
    throw new Error("Dữ liệu không hợp lệ");
};

const Slide = () => {

     const nav = useNavigate();

    const { data: slides = [], isError } = useQuery({
        queryKey: ["slides"],
        queryFn: fetchSlides,
    });

    if (isError) return <p>Lỗi khi tải dữ liệu</p>;

    return (
        <div className="container-fluid">
            <h1 className="h3 mb-2 text-gray-800">Quản lí Slide</h1>
            <p className="mb-4">
                Xin chào quý khách đã đến với <a target="_blank" href="https://datatables.net">Shop bánh kẹo HKQ</a>.
            </p>
            <div className="card shadow mb-4">
                <div className="card-header py-3">
                    <h6 className="m-0 font-weight-bold text-primary" style={{ textAlign: "center" }}>
                        Quản lí Slide
                    </h6>
                </div>
                <div className="card-body">
                    <div className="table-responsive">
                        <table className="table table-bordered" width="100%" cellSpacing="0">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Hình Ảnh</th>
                                    <th>Tiêu đề</th>
                                    <th>Nội dung</th>
                                    <th colSpan={2}>Hành động</th>
                                </tr>
                            </thead>
                            <tbody>
                                {slides.map((slide) => (
                                    <tr key={slide.id}>
                                        <td>{slide.id}</td>
                                        <td>
                                            <img src={`${BASE_IMAGE_URL}${slide.image}`} alt="slide" width="100" />
                                        </td>
                                        <td>{slide.title}</td>
                                        <td>{slide.content}</td>
                                        <td>
                                            <button className="btn btn-warning"  onClick={() => nav(`/admin/slide/edit/${slide.id}`)}>Sửa</button>
                                        </td>
                                        <td>
                                            <button className="btn btn-danger">Xóa</button>
                                        </td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Slide;
