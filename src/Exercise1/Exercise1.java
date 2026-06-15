package Exercise1;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int diem;
        int tongSoSinhVien = 0;
        int tongDiem = 0;
        int svDat = 0;
        int svTruot = 0;
        int svXuatSac = 0;
        int svGioi = 0;
        int diemCaoNhat = Integer.MIN_VALUE;
        int diemThapNhat = Integer.MAX_VALUE;
        int[] arr = new int[10000];
        int size = 0;
        while (true) {
            System.out.println(" ");
            System.out.println("""
                    ***************MENU NHẬP ĐIỂM***************
                    1. Nhập danh sách điểm sinh viên
                    2. In danh sách điểm
                    3. Tính điểm trung bình của các sinh viên
                    4. Tìm điểm cao nhất và thấp nhất
                    5. Đếm số lượng sinh viên đạt và trượt
                    6. Sắp xếp điểm tăng dần
                    7. Thống kê số lượng sinh viên giỏi và xuất sắc
                    8. Thoát
                    """);
            System.out.print("Lựa chọn của bạn: ");

            // Kiểm tra dữ liệu đầu vào của menu để tránh lỗi crash chương trình
            if (!scanner.hasNextInt()) {
                System.out.println("Cảnh báo: Vui lòng chỉ nhập số từ 1 đến 8!");
                scanner.next(); // Đọc bỏ giá trị sai
                continue;
            }
            int luaChon = Integer.parseInt(scanner.nextLine());

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập điểm của sinh viên: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Cảnh báo: Điểm số phải là một số thực!");
                        scanner.next();
                        continue;
                    }
                    diem = Integer.parseInt((scanner.nextLine()));
                    tongSoSinhVien++;
                    tongDiem +=diem;
                    // Kiểm tra khoảng điểm hợp lệ
                    if (diem < 0 || diem > 10) {
                        System.out.println("Cảnh báo: Điểm phải nằm trong khoảng từ 0 đến 10 ");
                        continue;
                    }
                    if (diem > diemCaoNhat) {
                        diemCaoNhat = diem;
                    }
                    if (diem < diemThapNhat) {
                        diemThapNhat = diem;
                    }
                    String xepLoai;
                    if (diem >= 5) {
                        xepLoai = "Đạt";
                        svDat++;
                    }else{
                        xepLoai = "Trượt";
                        svTruot++;
                    }
                    if (diem > 9) {
                        xepLoai = "Xuất sắc";
                        svXuatSac++;
                    }else if (diem >= 8){
                        xepLoai ="Giỏi";
                        svGioi++;
                    }
                    System.out.println("-> Sinh viên : " + xepLoai);
                    if (size >= arr.length){
                        System.out.println("Đầy bộ nhớ ko thể nhập được nữa !");
                    }
                    arr[size] = diem;
                    size++;
                    System.out.println("Nhập thành công !");
                    break;
                case 2:
                    System.out.println("\n--- Danh sách điểm ---");
                    if (size == 0){
                        System.out.println("Không có điểm của sinh viên nào !");
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
                    int diemTB = tongDiem / tongSoSinhVien;
                    System.out.println("Điểm trung bình của các sinh viên là : "+diemTB);
                    break;
                case 4:
                    System.out.println("Điểm cao nhất: " + diemCaoNhat);
                    System.out.println("Điểm thấp nhất: " + diemThapNhat);
                    break;
                case 5:
                    System.out.println("Số sinh viên đạt: " + svDat);
                    System.out.println("Số sinh viên trượt: " + svTruot);
                    break;
                case 6:
                    for ( int i =0 ; i < size - 1 ; i++){
                        int minIndex = i;
                        for ( int j = i + 1 ; j < size ; j++){
                            if(arr[j] < arr[minIndex]){
                                minIndex = j;
                            }
                        }
                        int temp = arr[minIndex];
                        arr[minIndex] = arr[i];
                        arr[i] =  temp;
                    }
                    System.out.println("Sắp xếp điểm tăng dần ");
                    System.out.print("[");
                    for ( int i = 0; i < size ;i++){
                        System.out.print(arr[i]);
                        if ( i < size - 1){
                            System.out.print(",");
                        }
                    }
                    System.out.println("]");
                    break;
                case 7:
                    System.out.println("Số sinh viên giỏi: " + svGioi);
                    System.out.println("Số sinh viên xuất sắc: " + svXuatSac);
                    break;
                case 8:
                    System.out.println("Đã kết thúc chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại (1-8).");
                    break;
            }
            if (luaChon == 8){
                break;
            }
        }
    }
}
