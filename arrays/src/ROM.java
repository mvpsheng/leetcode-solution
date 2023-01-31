/**
 * @auther gxs
 * @create 2020-12-01-8:38
 */
public class ROM {
    public static void main(String[] args) {
        for (int i = 0; i < 32; i++) {
            System.out.println("rom["+i+"]= 32'h"+binaryToDecimal(i));
        }
    }
    public static int binaryToDecimal(int n){
               int t = 0;  //用来记录位数
              int bin = 0; //用来记录最后的二进制数
             int r = 0;  //用来存储余数
              while(n != 0){
                       r = n % 2;
                       n = n / 2;
                       bin = (int) (r * Math.pow(10,t));
                       t++;
                }
                 return bin;
      }
}
