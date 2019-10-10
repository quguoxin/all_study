package day16;




import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WorldCup {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Map<Integer,String> map=new HashMap<Integer, String>();
        map.put(1930,"乌拉圭");
        map.put(1934,"意大利");
        map.put(1938,"意大利");
        map.put(1950,"乌拉圭");
        map.put(1954,"西德");
        map.put(1958,"巴西");
        map.put(1962,"巴西");
        map.put(1966,"英格兰");
        map.put(1970,"巴西");
        map.put(1974,"西德");
        map.put(1978,"阿根廷");
        map.put(1982,"意大利");
        map.put(1986,"阿根廷");
        map.put(1990,"西德");
        map.put(1994,"巴西");
        map.put(1998,"法国");
        map.put(2002,"巴西");
        map.put(2006,"意大利");
        map.put(2010,"西班牙");
        Check check=new Check();
        check.checkTeam(map);
    }
}
