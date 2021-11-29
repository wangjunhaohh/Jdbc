import java.util.Arrays;

public class Node {
    int val;
    Node next;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
    public void addFirst(int e){

    }
}
class demo{
    public static void main(String[] args) {
//        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
        int a[]=plusOne(new int[]{8,9,9,9});
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }

    }
    public static int removeElement(int[] nums, int val) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(val!=nums[i]){
                nums[j]=nums[i];
                j++;
            }
        }

        return j;
    }
    public static int[] plusOne(int[] digits) {
        int a[]=new int[digits.length+1];
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]!=9){
                digits[i]+=1;
                return digits;
            }
            digits[i]=0;
        }
        a[0]=1;
        return a;
    }
}
