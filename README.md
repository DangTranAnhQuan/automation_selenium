# SeleniumTest

Đây là project kiểm thử tự động bằng Selenium cho trang [Automation Exercise](https://automationexercise.com/). Project hiện có 12 testcase Java, bao phủ các luồng cơ bản như đăng ký tài khoản, đăng nhập, liên hệ, xem sản phẩm, tìm kiếm, giỏ hàng và subscription.

## Công nghệ sử dụng

- Java
- Maven
- Selenium WebDriver
- ChromeDriver / Google Chrome

## Yêu cầu môi trường

- JDK 25 hoặc bản tương thích với cấu hình trong `pom.xml`
- Maven
- Google Chrome đã cài đặt
- ChromeDriver tương thích với phiên bản Chrome đang dùng

## Cấu trúc dự án

- `src/main/java/TestCase1.java`: đăng ký tài khoản mới và xóa tài khoản sau khi tạo
- `src/main/java/TestCase2.java`: đăng nhập đúng tài khoản rồi xóa tài khoản
- `src/main/java/TestCase3.java`: đăng nhập sai và kiểm tra thông báo lỗi
- `src/main/java/TestCase4.java`: đăng nhập đúng rồi logout
- `src/main/java/TestCase5.java`: kiểm tra email đã tồn tại khi đăng ký
- `src/main/java/TestCase6.java`: gửi form liên hệ và upload file
- `src/main/java/TestCase7.java`: mở trang Test Cases
- `src/main/java/TestCase8.java`: xem danh sách sản phẩm và chi tiết sản phẩm
- `src/main/java/TestCase9.java`: tìm kiếm sản phẩm theo từ khóa
- `src/main/java/TestCase10.java`: cuộn xuống footer và kiểm tra subscription
- `src/main/java/TestCase11.java`: mở giỏ hàng và kiểm tra subscription ở cuối trang
- `src/main/java/TestCase12.java`: thêm 2 sản phẩm vào giỏ hàng và kiểm tra thông tin cart

## Cấu hình Maven

Project đang khai báo dependency Selenium trong [pom.xml](pom.xml).

## Cách chạy

Các class hiện tại được viết theo kiểu chạy trực tiếp trong IDE.

1. Mở project bằng IntelliJ IDEA hoặc VS Code.
2. Đảm bảo ChromeDriver đã sẵn sàng trên máy hoặc được cấu hình trong PATH.
3. Chạy class tương ứng với testcase bạn muốn kiểm tra.

## Ghi chú

- Tất cả testcase đều thao tác trên `https://automationexercise.com/`.
- Một số bước phụ thuộc vào trạng thái thực tế của website tại thời điểm chạy.
- Nếu muốn chạy hoàn toàn bằng dòng lệnh Maven, cần bổ sung thêm cấu hình plugin/entry point cho class `main`.
