import React from "react"; 
import productImage from "../assets/images/demos/demo-31/products/9-1.jpg";
import Slider from "../../components/client/Slider";


<img src={productImage} alt="Product image" width="264" height="396" className="product-image" />

const Home = () => {
    return (
        <div>
      <div className ="intro-slider-container">
            <Slider />
            </div>

            <div className ="container">
                <div className ="owl-carousel owl-theme icon-box cols-1 cols-lg-4 mt-2 mb-2" data-toggle="owl" data-owl-options='{
                    "dots": false,
                    "nav": false, 
                    "margin": 20,
                    "responsive": {
                        "0": {
                            "items": 1
                        },
                        "576": {
                            "items": 2
                        },
                        "768": {
                            "items": 3
                        },
                        "992": {
                            "items": 4
                        }
                    }
                }'>               
                    <div className ="icon-box-side side-cs">
                        <span className ="icon-box-icon text-dark">
                            <i className ="icon-truck"></i>
                        </span>

                        <div className ="icon-box-content">
                            <h3 className ="icon-box-title">Payment &amp; Delivery</h3>
                            <p>Free shipping for orders over $50</p>
                        </div>
                    </div>

                    <div className="icon-box-side side-cs">
                        <figure className="icon-box-icon">
                            <img src="assets/images/demos/demo-29/icons/icon-1.jpg" alt="Icon" width="28" height="28"/>
                        </figure>

                        <div className="icon-box-content">
                            <h3 className="icon-box-title">Return &amp; Refund</h3>
                            <p>Free 100% money back guarantee</p>
                        </div>
                    </div>                                       
                    <div className="icon-box-side side-cs">
                        <figure className="icon-box-icon">
                            <img src="assets/images/demos/demo-29/icons/icon-2.jpg" alt="Icon" width="28" height="28"/>
                        </figure>

                        <div className="icon-box-content">
                            <h3 className="icon-box-title">Quality Support</h3>
                            <p>Alway online feedback 24/7</p>
                        </div>
                    </div>
                                        
                    <div className="icon-box-side side-cs">
                        <figure className="icon-box-icon">
                                <img src="assets/images/demos/demo-29/icons/icon-3.jpg" alt="Icon" width="28" height="28"/>
                        </figure>

                        <div className="icon-box-content">
                            <h3 className="icon-box-title">Join Our Newsletter</h3>
                            <p>10% off by subscribing to our newsletter</p>
                        </div>
                    </div>                                       
                                          
                </div>

                <div className ="heading text-center mt-6 mb-4">
                    <h3 className ="text-secondary">Sản Phẩm Mới</h3>
                    <h6>Mẫu mã đẹp - Chất lượng tốt</h6>
                </div>

                <div className ="owl-carousel owl-simple owl-products" data-toggle="owl" 
                    data-owl-options='{
                        "nav": true, 
                        "dots": false,
                        "margin": 20,
                        "loop": false,
                        "responsive": {
                            "0": {
                                "items":2,
                                "nav": false
                            },
                            "576": {
                                "items":2
                            },
                            "768": {
                                "items":3
                            },
                            "992": {
                                "items":4
                            }
                        }
                    }'>
                    <div className ="product product-7 text-center">
                        <figure className ="product-media">
                            <a href="product.html">
                                <img src="assets/images/demos/demo-31/products/1-1.jpg" alt="Product image" width="335" height="480" className ="product-image"/>
                                <img src="assets/images/demos/demo-31/products/1-2.jpg" alt="Product image" width="335" height="480" className ="product-image-hover"/>
                            </a>

                            <div className ="product-action-vertical">
                                <a href="#" className ="btn-product-icon btn-wishlist btn-expandable"><span>add to wishlist</span></a>
                            </div>{/* End .product-action-vertical*/}

                            <div className ="product-action">
                                <a href="#" className ="btn-product btn-cart"><span>add to cart</span></a>
                            </div>{/* End .product-action*/}
                        </figure>{/* End .product-media*/}

                        <div className ="product-body">
                            <h6 className ="product-subtitle">Clothes</h6>
                            <h3 className ="product-title"><a href="product.html">Long-sleeved blouse</a></h3>{/* End .product-title*/}
                            <div className ="product-price">
                                $12.00
                            </div>{/* End .product-price*/}
                        </div>{/* End .product-body*/}
                    </div>{/* End .product*/}
                
                </div>{/* End .owl-carousel*/}

                <hr className ="mt-4 mb-6"/>

                <div className ="heading heading-testimonial text-center mt-4">
                    <h3 className ="text-secondary">Testimonials</h3>
                    <h6>What Members Are Saying</h6>
                </div>{/*End .heading*/}

                <div className ="row testimonials mb-7">
                    <div className ="col-sm-9 col-md-10 col-lg-10">
                        <div className ="owl-carousel owl-simple owl-testimonial" data-toggle="owl" 
                            data-owl-options='{
                            "nav": false, 
                            "dots": true,
                            "responsive": {
                                "992": {
                                    "nav": true
                                }
                            }
                        }'>
                            <div className ="testimonial">
                                <figure className ="avatar">
                                    <img src="assets/images/demos/demo-31/testimonials/1.png" alt="Avatar" width="150" height="151"/>
                                </figure>{/*End .avatar*/}

                                <div className ="comment">
                                    <p>“ Morbi interdum mollis sapien. Sedac risus phasellus lacinia, magna a ullamcorper laoreet, 
                                            lectusarcu pulvinar risus, vitae facilisis libero dolor a purus. Sed vel lacus mauris nibh felis, 
                                            adipiscing varius, adipiscing in, lacinia vel, tellus. ”
                                    </p>
                                </div>{/*End .comment*/}

                                <div className ="commenter">Sakina Stout</div>
                            </div>{/*End .testimonial*/}
        
                            <div className ="testimonial">
                                <figure className ="avatar">
                                    <img src="assets/images/demos/demo-31/testimonials/2.png" alt="Avatar" width="150" height="151"/>
                                </figure>{/*End .avatar*/}

                                <div className ="comment">
                                    <p>“ Sedac risus phasellus lacinia, magna a ullamcorper laoreet, lectusarcu pulvinar risus, vitae facilisis libero dolor 
                                        a purus. Sed vel lacus mauris nibh felis, adipiscing varius, adipiscing in, lacinia vel, tellus. ”
                                    </p>
                                </div>{/*End .comment*/}

                                <div className ="commenter">John Doe</div>
                            </div>
                        </div>
                    </div>
                </div>              
            </div>
        

            <div className ="container">
                <div className ="banner-group banner-group-2 mt-2">
                    <div className ="row">
                        <div className ="col-md-6">
                            <figure className ="banner banner-overlay banner-1" style={{backgroundColor: "#006699"}}>
                                <a href="#">
                                    <img src="assets/images/demos/demo-31/banners/6.jpg" alt="Banner" width="690" height="340"/>
                                </a>
        
                                <div className ="banner-content">
                                    <h5 className ="banner-subtitle">Find Your Yoga Mat</h5>
                                    <h3 className ="banner-title">Yoga Accessories</h3>
                                    <a href="#" className ="btn">SHOP NOW</a>
                                </div>{/*End .banner-content*/}
                            </figure>{/*End .banner*/}
                        </div>
                        
                        <div className ="col-md-6">
                            <figure className ="banner banner-overlay banner-2" style={{backgroundColor: "#3e5c59"}}>
                                <a href="#">
                                    <img src="assets/images/demos/demo-31/banners/7.jpg" alt="Banner" width="690" height="340"/>
                                </a>
        
                                <div className ="banner-content">
                                    <h5 className ="banner-subtitle">Harmony In Your Body</h5>
                                    <h3 className ="banner-title">Ayurvedic Massage</h3>
                                    <a href="#" className ="btn">SHOP NOW</a>
                                </div>{/*End .banner-content*/}
                            </figure>{/*End .banner*/}
                        </div>
                    </div>{/*End .row*/}
                </div>{/*End .banner-group*/}

                <div className ="heading heading-featured text-center mt-4 mb-4">
                    <h3 className ="text-secondary">Featured Products</h3>
                    <h6>Find Something New To Love</h6>
                </div>

                <div className ="owl-carousel owl-simple owl-products" data-toggle="owl" 
                    data-owl-options='{
                        "nav": true, 
                        "dots": false,
                        "margin": 20,
                        "loop": false,
                        "responsive": {
                            "0": {
                                "items":2
                            },
                            "576": {
                                "items":2
                            },
                            "768": {
                                "items":3
                            },
                            "992": {
                                "items":4
                            },
                            "1200": {
                                "items":5
                            }
                        }
                    }'>

                    <div className ="product product-7 text-center">
                        <span className ="product-label label-sale">SALE</span>
                        <figure className ="product-media">
                            <a href="product.html">
                                <img src={productImage} alt="Product image" width="264" height="396" className ="product-image"/>
                                <img src="../assets/images/demos/demo-31/products/9-2.jpg" alt="Product image" width="264" height="396" className ="product-image-hover"/>
                            </a>

                            <div className ="product-action-vertical">
                                <a href="#" className ="btn-product-icon btn-wishlist btn-expandable"><span>add to wishlist</span></a>
                            </div>

                            <div className ="product-action">
                                <a href="#" className ="btn-product btn-cart"><span>add to cart</span></a>
                            </div>
                        </figure>

                        <div className ="product-body">
                            <h6 className ="product-subtitle">Mats</h6>
                            <h3 className ="product-title"><a href="product.html">Essential Studio Yoga Mat</a></h3>{/* End .product-title*/}
                            <div className ="product-price">
                                <span className ="new-price">$25.99</span>
                                <span className ="old-price">Was $45.99</span>
                            </div>{/* End .product-price*/}
                        </div>{/* End .product-body*/}
                    </div>{/* End .product*/}

                </div>

                <hr className ="mt-6"/>

                <div className ="heading heading-instagram text-center mt-5 mb-5">
                    <h3 className ="text-secondary">Shop by Instagram</h3>
                    <h6>@molla Instagram</h6>
                </div>
    
                <div className ="owl-carousel owl-simple owl-instagram" data-toggle="owl" 
                    data-owl-options='{
                        "nav": false, 
                        "dots": false,
                        "margin": 20,
                        "loop": false,
                        "responsive": {
                            "0": {
                                "items":2
                            },
                            "576": {
                                "items":2
                            },
                            "768": {
                                "items":3
                            },
                            "992": {
                                "items":4
                            },
                            "1200": {
                                "items":5
                            }
                        }
                    }'>
                    <figure className ="instagram-feed">
                        <img src="assets/images/demos/demo-31/instagram/1.jpg" alt="img" width="264" height="264"/>

                        <div className ="instagram-feed-content">
                            <a href="#"><i className ="icon-instagram"></i></a>
                        </div>{/* End .instagram-feed-content*/}
                    </figure>{/* End .instagram-feed*/}

                    <figure className ="instagram-feed">
                        <img src="assets/images/demos/demo-31/instagram/4.jpg" alt="img" width="264" height="264"/>

                        <div className ="instagram-feed-content">
                            <a href="#"><i className ="icon-instagram"></i></a>
                        </div>{/* End .instagram-feed-content*/}
                    </figure>{/* End .instagram-feed*/}

                    <figure className ="instagram-feed">
                        <img src="assets/images/demos/demo-31/instagram/5.jpg" alt="img" width="264" height="264"/>

                        <div className ="instagram-feed-content">
                            <a href="#"><i className ="icon-instagram"></i></a>
                        </div>{/* End .instagram-feed-content*/}
                    </figure>
                </div>
            </div>

            </div>
    );
  }
  
  export default Home;