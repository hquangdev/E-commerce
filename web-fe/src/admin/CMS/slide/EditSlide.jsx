import { useParams, useNavigate } from "react-router-dom";
import React, { useState, useEffect } from "react";
import { api } from "../../test/axiosInstance"; // Import API đã tối ưu

const BASE_IMAGE_URL = "http://localhost:8080/api/v1/uploads/";

const EditSlide = () => {
    const { id } = useParams(); 
    const navigate = useNavigate();
    const [title, setTitle] = useState("");
    const [content, setContent] = useState("");
    const [image, setImage] = useState(null);
    const [preview, setPreview] = useState("");

    useEffect(() => {
        const fetchSlide = async () => {
            try {
                const response = await api.get(`/slide/${id}`);
                const slideData = response.data.data;
                setTitle(slideData.title || ""); 
                setContent(slideData.content || "");
                if (slideData.image) {
                    setPreview(BASE_IMAGE_URL + slideData.image);
                }
            } catch (error) {
                alert("Không thể tải dữ liệu slide. Vui lòng thử lại sau!");
            }
        };

        if (id) fetchSlide();
    }, [id]);

    const handleImageChange = (e) => {
        const file = e.target.files[0];
        if (file) {
            setImage(file);
            setPreview(URL.createObjectURL(file));
        }
    };

    const handleUpdate = async (e) => {
        e.preventDefault();

        const formData = new FormData();
        formData.append("title", title);
        formData.append("content", content);
        if (image) formData.append("image", image);

        try {
            const response = await api.put(`/slide/${id}`, formData, {
                headers: { "Content-Type": "multipart/form-data" },
            });

            if (response.data.code === 2008) {
                alert(response.data.message);
                navigate("/admin/slide");
            } else if (response.data.code === 2009) {
                alert(response.data.message);
            }
        } catch (error) {
            alert("Cập nhật thất bại. Vui lòng thử lại!");
        }
    };

    return (
        <div className="container-fluid">
            <h1 className="h3 mb-2 text-gray-800">Chỉnh sửa Slide</h1>
            <div className="card shadow mb-4">
                <div className="card-header py-3">
                    <h6 className="m-0 font-weight-bold text-primary text-center">Chỉnh sửa Slide</h6>
                </div>
                <div className="card-body">
                    <form onSubmit={handleUpdate} encType="multipart/form-data">
                        <div className="form-group">
                            <label>ID Slide:</label>
                            <input type="text" className="form-control" value={id} disabled />
                        </div>
                        <div className="form-group">
                            <label>Tiêu đề:</label>
                            <input
                                type="text"
                                className="form-control"
                                value={title}
                                onChange={(e) => setTitle(e.target.value)}
                                required
                            />
                        </div>
                        <div className="form-group">
                            <label>Nội dung:</label>
                            <textarea
                                className="form-control"
                                value={content}
                                onChange={(e) => setContent(e.target.value)}
                                required
                            />
                        </div>
                        <div className="form-group">
                            <label>Hình ảnh:</label>
                            <input type="file" className="form-control" onChange={handleImageChange} />
                            {preview && (
                                <div className="mt-2">
                                    <img src={preview} alt="Preview" width="150" />
                                </div>
                            )}
                        </div>
                        <div className="form-group text-center mt-4">
                            <button type="submit" className="btn btn-primary mr-2">Lưu</button>
                            <button type="button" className="btn btn-secondary" onClick={() => navigate("/slides")}>Hủy</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default EditSlide;


//     return (
//         <div>
//             <h2>Chỉnh sửa Slide</h2>
//             <form onSubmit={handleUpdate}>
//                 <input
//                     type="text"
//                     value={title}
//                     onChange={(e) => setTitle(e.target.value)}
//                     placeholder="Tiêu đề"
//                 />
//                 <textarea
//                     value={content}
//                     onChange={(e) => setContent(e.target.value)}
//                     placeholder="Nội dung"
//                 />
//                 <input type="file" onChange={handleImageChange} />
//                 {preview && <img src={preview} alt="Preview" width="100" />}
//                 <button type="submit">Cập nhật</button>
//             </form>
//         </div>
//     );
// };

// export default EditSlide;
