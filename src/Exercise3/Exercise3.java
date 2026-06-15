package Exercise3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = new String[10000];
        int size = 0;
        String regex = "^[0-9]{2}[A-Z]-[0-9]{3}\\.[0-9]{2}$";
        Pattern pattern =Pattern.compile(regex);
        while (true) {
            System.out.println(" ");
            System.out.println("""
                    ******************QUẢN LÝ NGƯỜI DÙNG****************
                    
                    1. Thêm các biển số xe
                    2. Hiển thị danh sách biển số xe
                    3. Tìm kiếm biển số xe
                    4. Tìm biển số xe theo mã tỉnh
                    5. Sắp xếp biển số xe tăng dần
                    6. Thoát
                    
                    """);

            System.out.print("Lựa chọn của bạn: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Cảnh báo: Vui lòng chỉ nhập số từ 1 đến 6!");
                scanner.next();
                continue;
            }
            int luaChon = Integer.parseInt(scanner.nextLine());

            switch (luaChon) {
                case 1:
                    System.out.println("--- Thêm biển số xe ---");
                    if (size == 0) {
                        System.out.print("Nhập số lượng biển cần nhập : ");
                        size = Integer.parseInt(scanner.nextLine());
                        if (size <= 0) {
                            System.out.println("Nhập sai hoặc không đúng số lượng !");
                        } else {
                            for (int i = 0; i < size; i++) {
                                while (true) {
                                    System.out.print("Nhập biển xe thứ " + (i + 1) + ":");
                                    String input = scanner.nextLine().toUpperCase().trim();
                                    Matcher matcher = pattern.matcher(input);
                                    if (matcher.matches()) {
                                        arr[i] = input;
                                        break;
                                    } else {
                                        System.out.println("Không đúng định dạng (VD: 30F-123.45) Vui lòng nhập lại !");
                                    }
                                }
                                System.out.println("Thêm thành công");
                            }
                        }
                    }else {
                        while (true) {
                            System.out.print("Nhập biển số xe :");
                            String input = scanner.nextLine().toUpperCase().trim();
                            Matcher matcher = pattern.matcher(input);
                            if (matcher.matches()) {
                                arr[size] = input;
                                size++;
                                break;
                            } else {
                                System.out.println("Không đúng định dạng (VD: 30F-123.45) Vui lòng nhập lại !");
                            }
                        }
                        System.out.println("Thêm thành công");
                    }
                    break;
                case 2:
                    System.out.println("Biển số hiện có ");
                    if (size == 0){
                        System.out.println("Không có biển số xe nào !\n");
                    }else {
                        System.out.print("[");
                        for ( int i = 0; i < size ;i++){
                            System.out.print(arr[i]);
                            if ( i < size - 1){
                                System.out.print(",");
                            }
                        }
                        System.out.println("]");
                    }
                    break;
                case 3:
                    System.out.println("Tìm kiếm biển số xe");
                    if (size > 0) {
                        while (true) {
                            System.out.print("Nhập biển só xe muốn tìm : ");
                            String searchInput = scanner.nextLine().toUpperCase();
                            Matcher matcherSearch = pattern.matcher(searchInput);
                            if (matcherSearch.matches()) {
                                for (int i = 0; i < size; i++) {
                                    if (arr[i] != null && arr[i].equals(searchInput)) {
                                        System.out.println("Đã tìm thấy biển số xe " + searchInput + " tại vị trí thứ " + (i + 1));
                                        break;
                                    }
                                    if (i == size - 1) {
                                        System.out.println("Không tìm thấy biển số xe muốn tìm !");
                                    }
                                }
                                break;
                            } else {
                                System.out.println("Biển số xe bạn nhập không đúng định dạng (VD: 30F-123.45). Vui lòng nhập lại!");
                            }
                        }
                    }else {
                        System.out.println("Chưa có dữ liệu");
                    }
                    break;
                case 4:
                    System.out.println("Tìm biển số xe theo mã tỉnh ");
                    if (size > 0) {
                        int count = 0;
                        while (true) {
                            System.out.print("Nhập mã tỉnh muốn tìm (2 chữ số): ");
                            String search = scanner.nextLine().trim();
                            Pattern pattern1 = Pattern.compile("^[0-9]{2}$");
                            Matcher matcher = pattern1.matcher(search);

                            if (matcher.matches()) {
                                StringBuilder stringBuilder = new StringBuilder("[");

                                for (int i = 0; i < size; i++) {
                                    if (arr[i] != null && arr[i].substring(0, 2).equals(search)) {
                                        if (count > 0) {
                                            stringBuilder.append(", ");
                                        }
                                        stringBuilder.append(arr[i]);
                                        count++;
                                    }
                                }
                                stringBuilder.append("]");

                                if (count > 0) {
                                    System.out.println("Danh sách biển số tìm theo tỉnh muốn tìm: ");
                                    System.out.println(stringBuilder);
                                } else {
                                    System.out.println("Không tìm thấy biển số xe nào của tỉnh muốn tìm !");
                                }
                                break;
                            } else {
                                System.out.println("Mã tỉnh bạn nhập không đúng định dạng!");
                            }
                        }
                    }else {
                        System.out.println("Chưa có dữ liệu");
                    }
                    break;
                case 5:
                    if (size > 0) {
                        System.out.println("Danh sách biển số xe sắp xếp tăng dần :");
                        for (int i = 0; i < size - 1; i++) {
                            int minIndex = i;
                            int min = Integer.parseInt(arr[minIndex].substring(0, 2));
                            int minAfter = Integer.parseInt(arr[minIndex].substring(4).replace(".", ""));

                            for (int j = i + 1; j < size; j++) {
                                int start = Integer.parseInt(arr[j].substring(0, 2));

                                if (start < min) {
                                    minIndex = j;
                                    min = start;
                                    minAfter = Integer.parseInt(arr[minIndex].substring(4).replace(".", ""));
                                } else if (start == min) {
                                    int after = Integer.parseInt(arr[j].substring(4).replace(".", ""));
                                    if (after < minAfter) {
                                        minIndex = j;
                                        minAfter = after;
                                    }
                                }
                            }
                            String temp = arr[minIndex];
                            arr[minIndex] = arr[i];
                            arr[i] = temp;
                        }
                        System.out.print("[");
                        for (int i = 0; i < size; i++) {
                            System.out.print(arr[i]);
                            if (i < size - 1) {
                                System.out.print(",");
                            }
                        }
                        System.out.println("]");
                    }else {
                        System.out.println("Chưa có dữ liệu");
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
