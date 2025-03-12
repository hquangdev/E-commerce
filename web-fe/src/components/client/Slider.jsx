import React from "react";
import { Swiper, SwiperSlide } from "swiper/react";
import { Navigation, Autoplay } from "swiper/modules";
import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import "swiper/css";
import "swiper/css/navigation";

const BASE_IMAGE_URL = "http://localhost:8080/api/v1/uploads/"; 

const fetchSlides = async () => {
  const { data } = await axios.get("http://localhost:8080/api/v1/slide");
  if (data.code === 2007) {
    return data.data; 
  }
  throw new Error("Dữ liệu không hợp lệ");
};

const Slider = () => {
  const { data: slides, isLoading, isError } = useQuery({
    queryKey: ["slides"],
    queryFn: fetchSlides,
    staleTime: 99 * 60 * 1000, 
  });

  if (isLoading) return <p>Loading...</p>;
  if (isError) return <p>Lỗi khi tải dữ liệu</p>;

  return (
    <div className="intro-slider-container">
      <Swiper
        modules={[Navigation, Autoplay]}
        navigation={true}
        autoplay={{ delay: 5000 }}
        loop={true}
        className="intro-slider"
      >
        {slides.map((slide) => (
          <SwiperSlide key={slide.id}>
            <div
              className="intro-slide"
              style={{ 
                backgroundImage: `url(${ BASE_IMAGE_URL+slide.image})`, 
                backgroundColor: "#39c" 
              }}
            >
              <div className="intro-content text-center">
                <h1 className="intro-title text-white">{slide.title}</h1>
                <h3 className="intro-text text-white font-weight-normal">{slide.content}</h3>
              </div>
            </div>
          </SwiperSlide>
        ))}
      </Swiper>
    </div>
  );
};

export default Slider;
