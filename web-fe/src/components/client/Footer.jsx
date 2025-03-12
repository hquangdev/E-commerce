import React from "react"; 
const Footer = () => {
    return (
      <footer className ="footer">
            <div className ="footer-top" style={{backgroundImage: "url(assets/images/demos/demo-31/footer-bg.jpg)"}}>
                <div className ="container">
                    <div className ="newsletter justify-content-center pt-7 pb-7">                                               
                        <div className ="newsletter-heading text-center">
                            <h3 className ="newsletter-title text-white">Get The Latest Deals</h3>{/* End .cta-title */}
                            <p className ="newsletter-desc font-weight-normal">Sign up & receive 10% off your first order</p>{/* End .cta-desc */}
                        </div>{/* End .text-center */}
                    
                        <form action="#">
                            <div className ="input-group">
                                <input type="email" className ="form-control" placeholder="Enter your Email Address" aria-label="Email Adress" required/>
                                <div className ="input-group-append">
                                    <button className ="btn btn-white" type="submit" title="Sing up">SUBSCRIBE</button>
                                </div>{/* .End .input-group-append */}
                            </div>{/* .End .input-group */}
                        </form>                          
                    </div>{/* End .cta */}   
                </div>{/*End .container*/}     
            </div>{/*End .footer-top*/}

            <div className ="container">
                <div className ="footer-middle pt-5">
                    <div className ="row">
	            		<div className ="col-sm-6 col-lg-3">
	            			<div className ="widget widget-about">
	            				<h3 className ="widget-title text-white font-weight-normal">About Molla</h3>
	            				<p className ="font-weight-normal">Praesent dapibus, neque id cursus ucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. </p>

	            				<div className ="social-icons">
	            					<a href="#" className ="social-icon" title="Facebook" target="_blank"><i className ="fab fa-facebook-f"></i></a>
	            					<a href="#" className ="social-icon" title="Twitter" target="_blank"><i className ="fab fa-twitter"></i></a>
	            					<a href="#" className ="social-icon" title="Instagram" target="_blank"><i className ="fab fa-instagram"></i></a>
	            					<a href="#" className ="social-icon" title="Youtube" target="_blank"><i className ="fab fa-youtube"></i></a>
	            				</div>{/* End .soial-icons */}
	            			</div>{/* End .widget about-widget */}
	            		</div>{/* End .col-sm-6 col-lg-3 */}

	            		<div className ="col-sm-6 col-lg-3">
	            			<div className ="widget">
	            				<h4 className ="widget-title text-white font-weight-normal">Useful Links</h4>{/* End .widget-title */}

	            				<ul className ="widget-list">
	            					<li><a href="about.html">About Molla</a></li>
	            					<li><a href="#">How to shop on Molla</a></li>
	            					<li><a href="#">FAQ</a></li>
	            					<li><a href="contact.html">Contact us</a></li>
	            					<li><a href="login.html">Log in</a></li>
	            				</ul>{/* End .widget-list */}
	            			</div>{/* End .widget */}
	            		</div>{/* End .col-sm-6 col-lg-3 */}

	            		<div className ="col-sm-6 col-lg-3">
	            			<div className ="widget">
	            				<h4 className ="widget-title text-white font-weight-normal">Customer Service</h4>{/* End .widget-title */}

	            				<ul className ="widget-list">
	            					<li><a href="#">Payment Methods</a></li>
	            					<li><a href="#">Money-back guarantee!</a></li>
	            					<li><a href="#">Returns</a></li>
	            					<li><a href="#">Shipping</a></li>
	            					<li><a href="#">Terms and conditions</a></li>
	            					<li><a href="#">Privacy Policy</a></li>
	            				</ul>{/* End .widget-list */}
	            			</div>{/* End .widget */}
	            		</div>{/* End .col-sm-6 col-lg-3 */}

	            		<div className ="col-sm-6 col-lg-3">
	            			<div className ="widget">
	            				<h4 className ="widget-title text-white font-weight-normal">My Account</h4>{/* End .widget-title */}

	            				<ul className ="widget-list">
	            					<li><a href="#">Sign In</a></li>
	            					<li><a href="cart.html">View Cart</a></li>
	            					<li><a href="#">My Wishlist</a></li>
	            					<li><a href="#">Track My Order</a></li>
	            					<li><a href="#">Help</a></li>
	            				</ul>{/* End .widget-list */}
	            			</div>{/* End .widget */}
	            		</div>{/* End .col-sm-6 col-lg-3 */}
	            	</div>{/* End .row */}
                </div>{/*End .footer-middle*/}

                <div className ="footer-bottom pb-3">
                    <figure className ="footer-payments mb-4">
                        <img src="assets/images/demos/demo-31/payments.png" alt="Footer payments" width="272" height="20" className ="footer-payments"/>
                    </figure>{/*End .footer-payments*/}  

                    <figure className ="footer-logo mb-4">
                        <img src="assets/images/demos/demo-31/footer-logo.png" alt="Footer logo" width="111" height="105" className ="footer-logo"/> 
                    </figure>

                    <p className ="footer-cotyright font-weight-normal">Copyright © 2020 Molla Store. All Rights Reserved.</p>                    
                </div>
            </div>
        </footer>
    );
  }
  

  export default Footer;
  