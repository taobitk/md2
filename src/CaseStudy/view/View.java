package CaseStudy.view;

import CaseStudy.controller.ProductController;
import CaseStudy.controller.WaterSalemanController;
import CaseStudy.entity.Product;
import CaseStudy.entity.WaterSalesman;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class View {
    public static void main(String[] args) {
        while (true) {
            System.out.println("---------Ở đây chúng tôi bán nước chứ ko bán Nước--------- ");
            System.out.println("1. Quản lý nhân viên");
            System.out.println("2. Quản lý Sản phẩm");
            System.out.println("3. Thoát");
            System.out.println("Mời bạn nhập lựa chọn");

            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    QlNV();
                    break;
                case 2:
                    QLSP();
                    break;
                case 3:
                    System.out.println("chúc bạn 1 ngày tốt lành");
                    return;
                default:
                    System.out.println("mời bạn nhận lại");
            }
        }
    }

    private static void QLSP() {
        while (true) {
            System.out.println("-----------------------------------------");
            System.out.println("Menu quản lý sản phẩm");
            System.out.println("1. Hiển thị danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Sửa thông tin sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo ID");
            System.out.println("6. Quay lại");
            System.out.print("Nhập lựa chọn: ");
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());
            List<Product> products = new ArrayList<>();
            switch (choice) {
                case 1:
                    System.out.println("-----------------------------------------");
                    System.out.println("1. Hiển thị danh sách sản phẩm");
                    products = ProductController.getAll();
                    display(products);
                    break;
                case 2:
                    System.out.println("-----------------------------------------");
                    System.out.println("2. Thêm mới sản phẩm");
                    Product product = inputPRD();
                    ProductController.save(product);
                    break;
                case 3:
                    System.out.println("-----------------------------------------");
                    System.out.println("sửa sản phẩm");
                    int CId = inputDID();
                    chainPRD(CId);
                    break;
                case 4:
                    System.out.println("-----------------------------------------");
                    System.out.println("xóa sản phẩm theo ID");
                    int dId = inputDID();
                    deletePRD(dId);
                    break;
                case 5:
                    System.out.println("-----------------------------------------");
                    System.out.println("tìm kiếm sản phẩm theo ID");
                    int fId = inputDID();
                    findFRD(fId);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("mời bạn nhận lại");
            }
        }
    }




    public static <T> void display(List<T> list) {
        for (T anyThing : list) {
            System.out.println(anyThing);
        }
    }

    private static void QlNV() {
        while (true) {
            System.out.println("-----------------------------------------");
            System.out.println("Menu quản lý nhân viên");
            System.out.println("1. Hiển thị danh sách nhân viên");
            System.out.println("2. Thêm mới nhân viên");
            System.out.println("3. Sửa thông tin nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Tìm kiếm nhân viên theo ID");
            System.out.println("6. Quay lại");
            System.out.print("Nhập lựa chọn: ");
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());
            List<WaterSalesman> waterSalesman = new ArrayList<>();
            switch (choice) {
                case 1:
                    System.out.println("-----------------------------------------");
                    System.out.println("Hiển thị danh sách nhân viên: ");
                    waterSalesman = WaterSalemanController.getAll();
                    display(waterSalesman);
                    break;
                case 2:
                    System.out.println("thêm mới nhân viên");
                    System.out.println("-----------------------------------------");
                    WaterSalesman ws = inputWS();
                    WaterSalemanController.save(ws);
                    break;
                case 3:
                    System.out.println("-----------------------------------------");
                    System.out.println("sửa nhân viên");
                    int CId = inputDID();
                    chainWS(CId);
                    break;
                case 4:
                    System.out.println("-----------------------------------------");
                    System.out.println("xóa nhân viên theo ID");
                    int dId = inputDID();
                    deleteWS(dId);
                    break;
                case 5:
                    System.out.println("-----------------------------------------");
                    System.out.println("tìm kiếm nhân viên theo ID");
                    int fId = inputDID();
                    findWS(fId);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("mời bạn nhận lại");
            }
        }
    }

    private static int inputDID() {
        Pattern idPattern = Pattern.compile("^[1-9]\\d{3}$");
        while (true) {
            System.out.print("nhập ID: ");
            Scanner scanner = new Scanner(System.in);
            String sid = scanner.nextLine();
            Matcher idMatcher = idPattern.matcher(sid);
            if (!idMatcher.matches()) {
                System.out.println("ID phải là số và phải là 4 số và số đầu tiên phải khác 0.");
                continue;
            }
            return Integer.parseInt(sid);
        }
    }

    private static void chainWS(int cId) {
        WaterSalemanController.chain(cId);
    }
    private static void chainPRD(int cId) {
        ProductController.chain(cId);
    }

    private static void deleteWS(int id) {
        WaterSalemanController.deleteWS(id);
    }
    private static void deletePRD(int id) {
        ProductController.deletePRD(id);
    }


    private static void findWS(int id) {
        System.out.println(WaterSalemanController.findWS(id));
    }

    private static void findFRD(int id) {
        System.out.println(ProductController.findPRD(id));
    }

    private static WaterSalesman inputWS() {
        int id = inputId();
        String name = inputName();
        String address = inputAddress();
        int sarly = inputSalary();
        String position = inputPosition();
        return new WaterSalesman(id, name, address, sarly, position);
    }

    private static Product inputPRD() {
        int id = inputId();
        String name = inputName();
        int Price = inputPrice();
        String dateOfManufacture ;
        String expiryDate;
        while (true) {
            dateOfManufacture = inputDate();
            expiryDate = inputDate2();
            if (!checkDate(dateOfManufacture, expiryDate)) {
                System.out.println("Ngày sản xuất phải trước ngày hết hạn. Hãy nhập lại.");
            } else {
                break;
            }
        }
        return new Product(id, name, Price, dateOfManufacture, expiryDate);
    }



    private static String inputDate() {
        Scanner scanner = new Scanner(System.in);
        Pattern datePattern = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$");
        while (true) {
            System.out.print(" nhập ngày sản xuất hợp lệ định dạng dd/mm/yyyy: ");
            String date = scanner.nextLine();
            Matcher nameMatcher = datePattern.matcher(date);
            if (!nameMatcher.matches()) {
                continue;
            }
            return date;
        }
    }

    private static String inputDate2() {
        Scanner scanner = new Scanner(System.in);
        Pattern datePattern = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$");
        while (true) {
            System.out.print("nhập hạn sử dụng hợp lệ định dạng dd/mm/yyyy: ");
            String date = scanner.nextLine();
            Matcher nameMatcher = datePattern.matcher(date);
            if (!nameMatcher.matches()) {
                continue;
            }
            return date;
        }
    }
    private static boolean checkDate(String dateOfManufacture, String expiryDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate manufactureDate = LocalDate.parse(dateOfManufacture, formatter);
            LocalDate expiry = LocalDate.parse(expiryDate, formatter);
            return manufactureDate.isBefore(expiry);
        } catch (DateTimeParseException e) {
            System.out.println("Định dạng ngày không hợp lệ!");
            return false;
        }
    }


    private static int inputPrice() {
        Scanner scanner = new Scanner(System.in);
        Pattern salaryPattern = Pattern.compile("^\\d+$");
        while (true) {
            System.out.print("Mời bạn nhập giá: ");
            String sarlyStr = scanner.nextLine();
            Matcher salaryMatcher = salaryPattern.matcher(sarlyStr);
            if (!salaryMatcher.matches()) {
                System.out.println("giá phải là số.");
                continue;
            }
            return Integer.parseInt(sarlyStr);
        }
    }


    private static int inputId() {
        Scanner scanner = new Scanner(System.in);
        Pattern idPattern = Pattern.compile("^[1-9]\\d{3}$");
        while (true) {
            System.out.print("Mời bạn nhập ID: ");
            String idStr = scanner.nextLine();
            Matcher idMatcher = idPattern.matcher(idStr);
            if (!idMatcher.matches()) {
                System.out.println("ID phải là số và phải là 4 số và số đầu tiên phải khác 0.");
                continue;
            }
            return Integer.parseInt(idStr);
        }
    }

    private static String inputName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mời bạn nhập tên: ");
        return scanner.nextLine();
    }

    private static String inputAddress() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mời bạn nhập địa chỉ: ");
        return scanner.nextLine();
    }

    private static int inputSalary() {
        Scanner scanner = new Scanner(System.in);
        Pattern salaryPattern = Pattern.compile("^\\d+$");
        while (true) {
            System.out.print("Mời bạn nhập lương: ");
            String sarlyStr = scanner.nextLine();
            Matcher salaryMatcher = salaryPattern.matcher(sarlyStr);
            if (!salaryMatcher.matches()) {
                System.out.println("Lương phải là số.");
                continue;

            }
            return Integer.parseInt(sarlyStr);
        }
    }

    private static String inputPosition() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mời bạn nhập chức vụ: ");
        return scanner.nextLine();
    }
}
