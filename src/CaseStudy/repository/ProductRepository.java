package CaseStudy.repository;

import CaseStudy.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductRepository {
    public static final String SRC_product = "src/CaseStudy/data/sp.csv";
    File file = new File(SRC_product);
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        File file = new File(SRC_product);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            Product product;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                product = new Product(Integer.parseInt(temp[0]),temp[1],Integer.parseInt(temp[2]),temp[3],temp[4]);
                products.add(product);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return products;
    }
    public void save(Product s) {
        File file = new File(SRC_product);
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(s.getId() + "," + s.getName() + "," + s.getPrice() + "," + s.getDateOfManufacture() + "," + s.getExpiryDate());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }

    private void writeFile(List<Product> products, boolean append) {
        File file = new File(SRC_product);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, append))) {
            for (Product temp : products) {
                bufferedWriter.write(toString(temp));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }
    private String toString(Product s) {
        return s.getId() + "," + s.getName() + "," + s.getPrice() + "," + s.getDateOfManufacture() + "," + s.getExpiryDate();
    }


    public void deleteByID(int id) {
        List<Product> products = getAll();
        boolean found = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                found = true;
                writeFile(products, false);
                System.out.println("Xóa thành công.");
                break;
            }
        }
        if (!found) {
            System.out.println("ID không tồn tại.");
        }
    }

    public Product findByID(int id) {
        List<Product> products = getAll();
        for (Product prd : products) {
            if (prd.getId() == id) {
                return prd;
            }
        }
        System.out.println("ID không tồn tại.");
        return null;
    }

    public void chainByID(int id) {
        List<Product> products = getAll();
        Product ws = findByID(id);
        if (ws == null) {
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin mới (nhấn Enter để giữ nguyên giá trị hiện tại):");

        System.out.print("Mời bạn nhập tên (" + ws.getName() + "): ");
        String name = scanner.nextLine();
        if (!name.trim().isEmpty()) {
            ws.setName(name);
        }

        System.out.print("Mời bạn nhập giá (" + ws.getPrice() + "): ");
        String PriceString = scanner.nextLine();
        if (!PriceString.trim().isEmpty()) {
            Pattern salaryPattern = Pattern.compile("^\\d+$");
            Matcher salaryMatcher = salaryPattern.matcher(PriceString);
            if (salaryMatcher.matches()) {
                ws.setPrice(Integer.parseInt(PriceString));
            } else {
                System.out.println("Lương phải là số. Không thay đổi lương.");
            }
        }

        System.out.print("Mời bạn nhập ngày sản xuất (" + ws.getDateOfManufacture() + "): ");
        String DateOfManufacture = scanner.nextLine();
        if (!DateOfManufacture.trim().isEmpty()) {
            ws.setDateOfManufacture(DateOfManufacture);
        }



        System.out.print("Mời bạn nhập hạn sử dụng (" + ws.getExpiryDate() + "): ");
        String ExpiryDate = scanner.nextLine();
        if (!ExpiryDate.trim().isEmpty()) {
            ws.setExpiryDate(ExpiryDate);
        }

        // Cập nhật danh sách và ghi lại vào file
        int index = products.size();
        for (int i = 0; i < index; i++) {
            if (products.get(i).getId() == id) {
                products.set(i, ws);
                break;
            }
        }

        writeFile(products, false);
        System.out.println("Cập nhật thông tin thành công.");
    }
}

