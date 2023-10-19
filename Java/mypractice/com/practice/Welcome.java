package mypractice.com.practice;

public class Welcome {

    public static String convertToAscii(String productName) {
        try {
            String convertedProductName = productName.replaceAll("[^\\x00-\\x7F]", "");
            return convertedProductName;
        } catch (Exception e) {
            e.printStackTrace();
            return productName;
        }

    }

    public static void main(String[] args) {
       String product =  convertToAscii("20008");
       System.out.println("THIS IS PRODUCT : "+product);
    }
}
