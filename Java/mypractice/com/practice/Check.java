package mypractice.com.practice;

public class Check {
    public static void main(String[] args) {

        boolean checking = false;
        String path = "D:\\spark-files\\order_177546\\supplier_po_243546\\art_detail_1\\H1177546_Patent Awards 2023 NarrowSlot opt4324-h.eps";
        String pidOrPath = defaultString(path).trim();
        if ((pidOrPath) != null) {
            checking  = true;
        }

        System.out.println(checking);
    }
    public static String defaultString(String str) {
        return defaultString(str, "");
    }
    public static String defaultString(String str, String defaultStr) {
        return str == null ? defaultStr : str;
    }
}
