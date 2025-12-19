# Hướng Dẫn Chạy Project & Kiểm Thử API

## 1. Tạo Database

Tạo database theo yêu cầu dự án:

    CREATE TABLE demo;

---

## 2. Cấu Hình & Chạy Project

1. Mở project trong IntelliJ IDEA.
2. Chỉnh cấu hình kết nối database trong file:
   - application.properties  
3. Chạy project để hệ thống tự tạo entity/tables.

---

## 3. Tạo Tài Khoản

Dùng Postman:

### Tạo tài khoản Admin
    POST http://localhost:8080/public/dang-ky-admin

### Tạo tài khoản User
    POST http://localhost:8080/public/dang-ky-user

---

## 4. Kiểm Thử API Có Phân Quyền

### API dành cho Admin
    GET http://localhost:8080/admin/hello

Trong Postman:
- Tab Authorization
- Chọn Basic Auth
- Nhập username/password của admin

Ảnh minh họa:  
![Admin Auth](https://github.com/user-attachments/assets/f4b37d37-d297-40bc-a491-c1638061a476)

---

### API dành cho User
    GET http://localhost:8080/user/hello

Trong Postman:
- Authorization → Basic Auth
- Nhập username/password của user

Ảnh minh họa:  
![User Auth](https://github.com/user-attachments/assets/3862e0b3-89c5-4f11-becc-360029f07d2f)

---

## 5. Ghi Chú

- Lỗi 403 Forbidden → tài khoản không đủ quyền.
- Lỗi 401 Unauthorized → sai Basic Auth.
