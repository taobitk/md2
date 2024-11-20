package CaseStudy.repository;

import CaseStudy.entity.WaterSalesman;
import CaseStudy.view.View;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WaterSalesmanRepository {
    public static final String SRC_waterSaleman = "src/CaseStudy/data/nv.csv";

    public List<WaterSalesman> getAll() {
        List<WaterSalesman> waterSalesmans = new ArrayList<>();
        File file = new File(SRC_waterSaleman);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            WaterSalesman waterSalesman;
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                waterSalesman = new WaterSalesman(Integer.parseInt(temp[0]), temp[1], temp[2], Integer.parseInt(temp[3]), temp[4]);
                waterSalesmans.add(waterSalesman);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return waterSalesmans;
    }

    public void save(WaterSalesman s) {
        File file = new File(SRC_waterSaleman);
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(s.getId() + "," + s.getName() + "," + s.getAddress() + "," + s.getSalary() + "," + s.getPosition());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }

    private void writeFile(List<WaterSalesman> waterSalesmans, boolean append) {
        File file = new File(SRC_waterSaleman);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, append))) {
            for (WaterSalesman temp : waterSalesmans) {
                bufferedWriter.write(toString(temp));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }

    private String toString(WaterSalesman s) {
        return s.getId() + "," + s.getName() + "," + s.getAddress() + "," + s.getSalary() + "," + s.getPosition();
    }

    public void deleteByID(int id) {
        List<WaterSalesman> waterSalesmens = getAll();
        boolean found = false;
        for (int i = 0; i < waterSalesmens.size(); i++) {
            if (waterSalesmens.get(i).getId() == id) {
                waterSalesmens.remove(i);
                found = true;
                writeFile(waterSalesmens, false);
                System.out.println("Xóa thành công.");
                break;
            }
        }
        if (!found) {
            System.out.println("ID không tồn tại.");
        }
    }

    public WaterSalesman findById(int id) {
        List<WaterSalesman> waterSalesmens = getAll();
        for (WaterSalesman ws : waterSalesmens) {
            if (ws.getId() == id) {
                return ws;
            }
        }
        System.out.println("ID không tồn tại.");
        return null;
    }

    public void chain(int id) {
        List<WaterSalesman> waterSalesmens = getAll();
        WaterSalesman ws = findById(id);
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

        System.out.print("Mời bạn nhập địa chỉ (" + ws.getAddress() + "): ");
        String address = scanner.nextLine();
        if (!address.trim().isEmpty()) {
            ws.setAddress(address);
        }

        System.out.print("Mời bạn nhập lương (" + ws.getSalary() + "): ");
        String salaryStr = scanner.nextLine();
        if (!salaryStr.trim().isEmpty()) {
            Pattern salaryPattern = Pattern.compile("^\\d+$");
            Matcher salaryMatcher = salaryPattern.matcher(salaryStr);
            if (salaryMatcher.matches()) {
                ws.setSalary(Integer.parseInt(salaryStr));
            } else {
                System.out.println("Lương phải là số. Không thay đổi lương.");
            }
        }

        System.out.print("Mời bạn nhập chức vụ (" + ws.getPosition() + "): ");
        String position = scanner.nextLine();
        if (!position.trim().isEmpty()) {
            ws.setPosition(position);
        }

        // Cập nhật danh sách và ghi lại vào file
        for (int i = 0; i < waterSalesmens.size(); i++) {
            if (waterSalesmens.get(i).getId() == id) {
                waterSalesmens.set(i, ws);
                break;
            }
        }

        writeFile(waterSalesmens, false);
        System.out.println("Cập nhật thông tin thành công.");
    }
}
