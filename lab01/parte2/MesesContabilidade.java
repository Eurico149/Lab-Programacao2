import java.util.*;

public class MesesContabilidade{
    public static void main(String[] args){
        Map<String, Integer> meses = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        meses.put("mar", 120);
        meses.put("ago", 230);
        meses.put("set", 299);
        meses.put("jan", 151);
        meses.put("fev", 231);
        meses.put("out", 192);
        meses.put("nov", 123);
        meses.put("abr", 421);
        meses.put("mai", 840);
        meses.put("jul", 129);
        meses.put("jun", 423);
        meses.put("dez", 299);

        System.out.println(meses.get(sc.nextLine()));
    }
}
