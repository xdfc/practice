package Test;

public class StringTest {
    public static void main(String[] args){
        String str = " ";
        String result = "";

        if(str.equals(" ")){
            System.out.println("%20");
        }else if(str.length()==0){
            System.out.println("");
        }else{
            String[] s = str.split(" ");
            for(int i =0;i<s.length;i++){
                if(i==s.length-1){
                    result = result + s[i];
                }else{
                    result = result + s[i] + "%20";
                }
            }
            System.out.println(result);
        }

    }
}
