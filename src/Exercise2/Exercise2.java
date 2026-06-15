package Exercise2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hoTen = "",email = "",soDienThoai = "",matKhau ="";
        StringBuilder sb = new StringBuilder();
        while (true) {
            System.out.println("""
                    ******************QUẢN LÝ NGƯỜI DÙNG****************
                    
                    1. Nhập thông tin người dùng
                    2. Chuẩn hóa họ tên
                    3. Kiểm tra email hợp lệ
                    4. Kiểm tra số điện thoại hợp lệ
                    5. Kiểm tra mật khẩu hợp lệ
                    6. Thoát
                    
                    """);

            System.out.print("Lựa chọn của bạn: ");

            // Kiểm tra dữ liệu đầu vào của menu để tránh lỗi crash chương trình
            if (!scanner.hasNextInt()) {
                System.out.println("Cảnh báo: Vui lòng chỉ nhập số từ 1 đến 6!");
                scanner.next(); // Đọc bỏ giá trị sai
                continue;
            }
             int luaChon = Integer.parseInt(scanner.nextLine());

            switch (luaChon) {
                case 1:
                    System.out.println("--- Nhập thông tin người dùng ---");
                    System.out.println("Nhập Họ và Tên : ");
                    hoTen = scanner.nextLine();
                    System.out.println("Nhập email : ");
                    email = scanner.nextLine();
                    System.out.println("Nhập số điện thoại : ");
                    soDienThoai = scanner.nextLine();
                    System.out.println("Nhập mật khẩu : ");
                    matKhau = scanner.nextLine();
                    break;
                case 2:
                    if (hoTen == null || hoTen.trim().isEmpty()) {
                        System.out.println("Chưa có thông tin họ tên hoặc họ tên trống!");
                    }

                    hoTen = hoTen.trim().replaceAll("\\s+", " ");
                    String[] words = hoTen.split(" ");
                    for (String w : words) {
                        sb.append(Character.toUpperCase(w.charAt(0)))
                                .append(w.substring(1).toLowerCase())
                                .append(" ");
                    }
                    String ketQua = sb.toString().trim();
                    System.out.println("Họ tên sau chuẩn hóa: " + ketQua);
                    break;
                case 3:
                    System.out.println("Kiểm tra email hợp lệ");
                    String emailRegex = "^[\\w.-]+@[\\w.-]+\\.\\w{2,}$";
                    Pattern patternEmail = Pattern.compile(emailRegex);
                    Matcher matcherEmail = patternEmail.matcher(email);
                    if (email.isEmpty()) {
                        System.out.println("Chưa nhập email!");
                        return;
                    }
                    if (matcherEmail.matches()) {
                        System.out.println("=> Email (" + email + ") hợp lệ.");
                    } else {
                        System.out.println("=> Email (" + email + ") KHÔNG hợp lệ.");
                    }
                    break;
                case 4:
                    System.out.println("Kiểm tra số điện thoại hợp lệ");
                    String phoneRegex = "^(0|\\+84)(3[2-9]|5|7|8[1-9]|9[0-46-9])\\d{7}";
                    Pattern patternPhone = Pattern.compile(phoneRegex);
                    Matcher matcherPhone = patternPhone.matcher(soDienThoai);
                    if (soDienThoai.isEmpty()) {
                        System.out.println("Chưa nhập số điện thoại!");
                        return;
                    }
                    if (matcherPhone.matches()) {
                        System.out.println("=> Số điện thoại (" + soDienThoai + ") hợp lệ.");
                    } else {
                        System.out.println("=> Số điện thoại (" + soDienThoai + ") KHÔNG hợp lệ.");
                    }
                    break;
                case 5:
                    System.out.println("Kiểm tra mật khẩu hợp lệ");
                    String passRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\",./<>?]).{8,}$";
                    Pattern patternPass = Pattern.compile(passRegex);
                    Matcher matcherPass = patternPass.matcher(matKhau);
                    if (matKhau.isEmpty()) {
                        System.out.println("Chưa nhập số điện thoại!");
                        return;
                    }
                    if (matcherPass.matches()) {
                        System.out.println("=> Mật khẩu (" + matKhau + ") hợp lệ.");
                    } else {
                        System.out.println("=>  Mật khẩu (" + matKhau + ") KHÔNG hợp lệ.");
                    }
                    break;
                case 6:
                    System.out.println("Đã kết thúc chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại (1-6).");
                    break;
            }
            if (luaChon == 6){
                break;
            }
        }
    }
}
