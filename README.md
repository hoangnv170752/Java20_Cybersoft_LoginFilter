# Java20_Cybersoft_LoginFilter
Viết chức năng đăng nhập
- Form đăng nhập gồm có email và mật khẩu.
- Truy vấn database để kiểm tra đăng nhập.
- Sử dụng Session để lưu trữ thông tin.

Tạo filter có tên AuthFilter
- Cấu hình bằng Annotation
- Viết chức năng kiểm tra đăng nhập
| Nếu chưa đăng nhập cho chuyển về trang đăng nhập.
| Nếu đã đăng nhập chuyển qua trang thông tin người dùng.
