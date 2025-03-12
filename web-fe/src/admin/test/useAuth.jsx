import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

const useAuth = (rolesAllowed, permissionsAllowed = []) => {
    const nav = useNavigate();

    // Lấy dữ liệu từ localStorage
    const storedRole = localStorage.getItem("role");

    let userRoles = [];
    let userPermissions = [];

    if (storedRole) {
        try {
            userRoles = JSON.parse(storedRole);
            if (!Array.isArray(userRoles)) {
                userRoles = [userRoles]; // Chuyển thành mảng nếu cần
            }
            userPermissions = userRoles.flatMap(role => role.permission.map(p => p.name)); // Lấy danh sách quyền
        } catch (error) {
            console.error("Lỗi phân tích JSON:", error);
        }
    }

    // Kiểm tra quyền truy cập
    useEffect(() => {
        const hasRolePermission = userRoles.some(role => rolesAllowed.includes(role.name));
        const hasSpecificPermission = permissionsAllowed.length === 0 || userPermissions.some(p => permissionsAllowed.includes(p));

        if (!hasRolePermission || !hasSpecificPermission) {
            alert("Bạn không có quyền truy cập!");
            nav("/login");
        }
    }, [userRoles, userPermissions, rolesAllowed, permissionsAllowed, nav]);
};

export default useAuth;
