package mid;

public class LeetCode012 {

    /**
     * 枚举即可
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] aLab = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(num > 0){
            while (aLab[index] <= num){
                sb.append(roman[index]);
                num-=aLab[index];
            }
            index++;
        }
        return sb.toString();
    }
}
