# SeleniumTest

Đây là project kiểm thử tự động bằng Selenium cho trang [Automation Exercise](https://automationexercise.com/). Project bao gồm các kịch bản kiểm thử (test cases) được viết bằng Java, bao phủ các luồng chức năng chính của website.

## Công nghệ sử dụng

- Java
- Maven
- Selenium WebDriver
- TestNG / JUnit

## Yêu cầu môi trường

- JDK 25 hoặc bản tương thích với cấu hình trong `pom.xml`
- Maven
- Google Chrome đã cài đặt

## Cấu trúc dự án

Tất cả các file test case được đặt trong thư mục `src/test/java`.

- `TestCase1.java`: Đăng ký tài khoản mới và xóa tài khoản sau khi tạo.
- `TestCase2.java`: Đăng nhập đúng tài khoản rồi xóa tài khoản.
- `TestCase3.java`: Đăng nhập sai và kiểm tra thông báo lỗi.
- `TestCase4.java`: Đăng nhập đúng rồi logout.
- `TestCase5.java`: Kiểm tra email đã tồn tại khi đăng ký.
- `TestCase6.java`: Gửi form liên hệ và upload file.
- `TestCase7.java`: Mở trang Test Cases.
- `TestCase8.java`: Xem danh sách sản phẩm và chi tiết sản phẩm.
- `TestCase9.java`: Tìm kiếm sản phẩm theo từ khóa.
- `TestCase10.java`: Cuộn xuống footer và kiểm tra subscription.
- `TestCase11.java`: Mở giỏ hàng và kiểm tra subscription ở cuối trang.
- `TestCase12.java`: Thêm 2 sản phẩm vào giỏ hàng và kiểm tra thông tin cart.
- `TestCase13.java`: Kiểm tra số lượng sản phẩm trong giỏ hàng.

## Cấu hình Maven

File `pom.xml` đã được cấu hình với các dependency cần thiết cho Selenium, JUnit và TestNG.

## Cách chạy

### Chạy bằng Maven

Mở terminal hoặc command prompt ở thư mục gốc của dự án và chạy lệnh:
```sh
mvn test
```
Maven sẽ tự động tìm và thực thi tất cả các test case trong thư mục `src/test/java`.

### Chạy từ IDE (IntelliJ, Eclipse, ...)

1. Mở project dưới dạng một project Maven.
2. Mở file test case bạn muốn chạy (ví dụ `TestCase8.java`).
3. Nhấn vào biểu tượng ▶ bên cạnh tên class hoặc tên phương thức `@Test` và chọn "Run".

## Ghi chú

- Tất cả testcase đều thao tác trên `https://automationexercise.com/`.
- Các test case sử dụng `Assert` để xác thực kết quả. Khi một assertion thất bại, test sẽ dừng và được báo cáo là FAILED.
