import React from "react"; 
import logo from "../../client/assets/images/demos/demo-31/logo-web.jpg"; 

const Header = () => {
    return( 
      <header className ="header header-31">
        <div className ="header-middle sticky-header">
            <div className ="container">
                <div className ="header-left">
                    <nav className ="main-nav">
                        <ul className ="menu sf-arrows">
                            <li className ="megamenu-container active">
                                <a href="index.html" className ="sf-with-ul"><i className="fas fa-home"></i> Home</a>
                            </li>

                            <li>
                                <a href="category.html" className ="sf-with-ul">Shop</a>

                                <div className ="megamenu megamenu-md">
                                    <div className ="row no-gutters">
                                        <div className ="col-md-8">
                                            <div className ="menu-col">
                                                <div className ="row">
                                                    <div className ="col-md-6">
                                                        <div className ="menu-title">Shop with sidebar</div>
                                                        <ul>
                                                            <li><a href="category-list.html">Shop List</a></li>                                                        
                                                            <li><a href="category-market.html"><span>Shop Market<span className ="tip tip-new">New</span></span></a></li>
                                                        </ul>

                                                        <div className ="menu-title">Shop no sidebar</div>
                                                       
                                                    </div>

                                                    <div className ="col-md-6">
                                                        <div className ="menu-title">Product Category</div>
                                                        <ul>
                                                            <li><a href="product-category-boxed.html">Product Category Boxed</a></li>
                                                            <li><a href="product-category-fullwidth.html"><span>Product Category Fullwidth<span className ="tip tip-new">New</span></span></a></li>
                                                        </ul>
                                                        <div className ="menu-title">Shop Pages</div>
                                                        <ul>
                                                            <li><a href="cart.html">Cart</a></li>
                                                            <li><a href="checkout.html">Checkout</a></li>
                                                          
                                                            <li><a href="#">Lookbook</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                              </li>

                            <li>
                                <a href="elements-list.html" className ="sf-with-ul">Elements</a>

                                <ul>
                                    <li><a href="elements-products.html">Products</a></li>
                                    <li><a href="elements-typography.html">Typography</a></li>
                                  
                                </ul>
                            </li>
                        </ul>
                    </nav>
                </div>

                <figure className ="header-center">
                    <a href="index.html" className ="logo">
                        <img src ={logo} alt="Molla Logo" width="101" height="95" style={{ borderRadius: "50%", objectFit: "cover" }}/>
                    </a>                      
                </figure>

                <div className ="header-right">
                    <div className ="header-search header-search-visible">
                        <a href="#" className ="search-toggle" role="button"><i className ="icon-search"></i></a>
                        <form action="#" method="get">
                            <div className ="header-search-wrapper">
                                <label htmlFor="q" className ="sr-only">Search</label>
                                <input type="search" className ="form-control" name="q" id="q" placeholder="Tìm kiếm sản phẩm..." required/>
                                <button className ="btn" type="submit"><i className ="icon-search"></i></button>
                            </div>
                        </form>
                    </div>
                    
                    <a href="wishlist.html" className ="wishlist-link">
                        <i className ="fab fa-heart"></i>
                        <span className ="wishlist-count">3</span>
                    </a>

                    <div className ="dropdown cart-dropdown">
                        <a href="#" className ="dropdown-toggle" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" data-display="static">
                            <i className ="icon-shopping-cart"></i>
                            <span className ="cart-count">2</span>
                            <span className ="cart-text font-weight-normal">$ 164,00</span>
                        </a>

                        <div className ="dropdown-menu dropdown-menu-right">
                            <div className ="dropdown-cart-products">
                                <div className ="product">
                                    <div className ="product-cart-details">
                                        <h4 className ="product-title">
                                            <a href="product.html">Giày chạy bộ co giãn đan màu be</a>
                                        </h4>

                                        <span className ="cart-product-info">
                                            <span className ="cart-product-qty">1</span>
                                            x $84.00
                                        </span>
                                    </div>

                                    <figure className ="product-image-container">
                                        <a href="product.html" className ="product-image">
                                            <img src="assets/images/products/cart/product-1.jpg" alt="product" width="60" height="60"/>
                                        </a>
                                    </figure>
                                    <a href="#" className ="btn-remove" title="Remove Product"><i className ="icon-close"></i></a>
                                </div>
                            </div>

                            <div className ="dropdown-cart-total">
                                <span>Tổng</span>

                                <span className ="cart-total-price">$160.00</span>
                            </div>

                            <div className ="dropdown-cart-action">
                                <a href="cart.html" className ="btn btn-primary">Giỏ Hàng</a>
                                <a href="checkout.html" className ="btn btn-outline-primary-2"><span>Thanh Toán</span><i className ="icon-long-arrow-right"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
      </header>
    );
}

export default Header;