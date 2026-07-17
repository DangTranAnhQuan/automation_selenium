# SeleniumTest

Dự án này chứa các testcase Selenium cho trang [Automation Exercise](https://automationexercise.com/). Nhóm testcase hiện tại tập trung vào các bài từ **TestCase9 đến TestCase12** với các luồng kiểm thử tìm kiếm sản phẩm, đăng ký nhận email, cuộn trang và thêm sản phẩm vào giỏ hàng.

## Công nghệ sử dụng

- Java
- Maven
- Selenium WebDriver
- ChromeDriver / Google Chrome

## Yêu cầu môi trường

- JDK 25 hoặc tương thích với cấu hình trong `pom.xml`
- Maven
- Google Chrome đã cài đặt
- ChromeDriver tương thích với phiên bản Chrome đang dùng

## Cấu trúc chính

- `src/main/java/TestCase9.java`: tìm kiếm sản phẩm theo từ khóa `top`
- `src/main/java/TestCase10.java`: kiểm tra phần Subscription ở cuối trang và gửi email đăng ký
- `src/main/java/TestCase11.java`: mở giỏ hàng, cuộn xuống footer và đăng ký Subscription
- `src/main/java/TestCase12.java`: thêm 2 sản phẩm vào giỏ hàng và kiểm tra thông tin trong cart

## Cách chạy

Các class hiện tại đang được viết theo kiểu chạy trực tiếp trong IDE.

1. Mở project bằng IntelliJ IDEA hoặc VS Code.
2. Đảm bảo ChromeDriver đã sẵn sàng trên máy.
3. Chạy từng class tương ứng: `TestCase9`, `TestCase10`, `TestCase11`, `TestCase12`.

## Ghi chú

- Các testcase đều mở trang `https://automationexercise.com/`.
- Một số bước phụ thuộc vào nội dung và trạng thái thực tế của website tại thời điểm chạy.
- Nếu muốn chạy bằng dòng lệnh Maven, cần bổ sung cấu hình chạy phù hợp cho `main` class.