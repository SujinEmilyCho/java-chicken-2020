package view;

import domain.Bill;
import domain.storeInfo.Menu;
import domain.storeInfo.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_FORMAT = "└ %s ┘";

    public static void printMain() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }

    public static void printTables(List<Table> tables, List<Boolean> orderStatus) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(orderStatus);
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    private static void printBottomLine(List<Boolean> orderStatus) {
        for (final boolean status : orderStatus) {
            System.out.printf(BOTTOM_FORMAT, convertString(status));
        }
        System.out.println();
    }

    private static String convertString(boolean status) {
        if (status) {
            return "₩";
        }
        return "─";
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    public static void printTotalPrice(double totalPrice) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(totalPrice + "원");
    }

    public static void printOrders(List<Bill> bills) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        for (Bill bill : bills) {
            System.out.println(String.format("%s, %d, %d", bill.getMenu(), bill.getQuantity(), bill.getPrice()));
        }
    }
}
