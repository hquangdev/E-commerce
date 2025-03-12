package com.example.webbe.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum EnumCode {

    //thông báo thành công
    SUCCESSFULLY(888,"Bạn đã thực hiện thành công", HttpStatus.OK),
    DELETE_SUC(777, "Bạn đã xóa thành công", HttpStatus.OK),

    //USER
    UNCATEGORIZED_EXCEPTION(999,"Uncategoried error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1002,"Uncategorized error", HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED(1003,"Uncategorized", HttpStatus.UNAUTHORIZED),
    USER_NOT_EXITED(1004, "User not exited", HttpStatus.NOT_FOUND),
    NOT_USER(1006, "Tài khoản hoặc mật khẩu không đúng !", HttpStatus.BAD_REQUEST),
    LOGIN_SUCC(1007, "Bạn đã đăng nhập thành công !", HttpStatus.OK),

    //Đăng kí tài khoản
    USER_PASS_FAILED(2000, "Mật khẩu phải trên 8 kí tự và có chữ in hoa,thường và 1 kí tự", HttpStatus.BAD_REQUEST),
    USER_FAILED_NAME(2001, "Tên tài khoản đã tồn tại", HttpStatus.BAD_REQUEST),
    REGISTER_FAILED(2002, "Đăng kí thất bại ", HttpStatus.BAD_REQUEST),
    REGISTER_SUCC(2003, "Chúc mừng bạn đã đăng kí thành công", HttpStatus.OK),
    USER_NAME_FAILED(2004, "Tên phải trên 5 kí tự", HttpStatus.BAD_REQUEST),

    //slide
    ADD_SLIDE_SUCCESSFULLY(2005,"Bạn đã thêm slide thành công", HttpStatus.CREATED),
    ADD_SLIDE_FAILED(2006,"Đã có lỗi xảy ra", HttpStatus.BAD_REQUEST),
    GET_ALL_SLIDE_SUCCESSFULLY(2007,"Lấy danh sách thành công", HttpStatus.OK),
    EDIT_SLIDE_SUCCESSFULLY(2008,"Bạn đã sửa slide thành công", HttpStatus.OK),
    EDIT_SLIDE_FAILED(2009,"Sửa slide thất bại", HttpStatus.BAD_REQUEST),
    DELETE_SLIDE_SUCCESSFULLY(2010, "Bạn đã xóa thành công", HttpStatus.OK),
    GET_SLIDE_SUCCESSFULLY(2011,"Lấy thành công slide", HttpStatus.OK),

    //GIỏ hàng
    GET_CART_FAILED(2012, "Hiện thị giỏ hàng thất bại", HttpStatus.BAD_REQUEST),
    ADD_CART_FAILED(2013, "Thêm sản phẩm vào giỏ hàng thất bại", HttpStatus.BAD_REQUEST),
    EDIT_CART_FAILED(2014, "Sửa giỏ hàng thất bại", HttpStatus.BAD_REQUEST),

    //authentication
    AUTHENTICATED(1010, " có token", HttpStatus.NO_CONTENT),
    UNAUTHORIZED(1011, "Bạn không có quyền truy cập", HttpStatus.FORBIDDEN),

    //Danh mục
    ADD_CATEGORY_FAILED(2013,"Thêm danh mục thất bại", HttpStatus.BAD_REQUEST),
    EDIT_CATEGORY_FAILED(2015,"Sửa danh mục thất bại", HttpStatus.BAD_REQUEST),
    GET_CATEGORY_FAILED(1017,"Lấy danh mục thất baị", HttpStatus.BAD_REQUEST),

    //Sản phẩm
    ADD_PRODUCT_FAILED(3001,"Thêm sản phẩm thất bại !", HttpStatus.BAD_REQUEST),
    EDIT_PRODUCT_FAILED(3002, "Sửa sản phẩm thất bại !", HttpStatus.BAD_REQUEST),
    DELETE_PRODUCT_FAILED(3003, "Xóa sản phâmt thát bại", HttpStatus.BAD_REQUEST),
    GET_ALL_PRODUCT_FAILED(3004, "Lấy sản phẩm thất bại", HttpStatus.BAD_REQUEST),
    ;


    private final int code;
    private final String mess;
    private final HttpStatus statusCode;

    EnumCode(int code, String mess, HttpStatus statusCode) {
        this.code = code;
        this.mess = mess;
        this.statusCode= statusCode;
    }
}
