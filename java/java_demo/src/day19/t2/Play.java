package day19.t2;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Play {
    public void game(){
        Scanner input=new Scanner(System.in);
        GameSystem gameSystem=new GameSystem();
        String yesOrNo="Y";
        Monster monster;
        Player player;
        int sumExperience=0;//玩家玩一个流程所获得经验值
        int sumBlood=0;//玩一个流程对怪所造的血
        Map map= gameSystem.readFile("c:\\1\\game.bin");//读档
        if(map==null){
            map=new HashMap();
        }
        if(map.size()<=0){
            player=new Player(0,2000,1000,0);
            monster=new Monster(1000000,1000);
        }else {
            monster=(Monster) map.get("monster");
            player=(Player) map.get("player");
        }
        System.out.println("1.开始游戏");
        System.out.println("2.查看玩家信息");
        System.out.println("3.查看怪信息");
        System.out.println("4.退出");
        System.out.println("请输入：");
        int number=input.nextInt();
        switch (number) {
            case 1:
                System.out.println("游戏开始！");
                //玩家操作
                do {
                    int blood = (int) (Math.random() * 2000);//攻击造成的血量
                    if (blood > monster.getMonsterDefense()) {//破防
                        sumExperience += blood;//获得经验
                        sumBlood += blood;//怪物掉血
                    } else {
                        System.out.println("MISS,这下没有破防哦！");
                    }
                    System.out.println("恭喜打出了" + blood + "血,经验+" + blood);
                    System.out.println("是否继续打怪(Y/N)");
                    yesOrNo = input.next();
                } while (yesOrNo.equals("Y"));
                //结算玩家
                while (sumExperience >= (player.getPlaysRank() + 1) * 1000) {
                    player.setPlaysRank(player.getPlaysRank() + 1);
                    sumExperience = sumExperience - ((player.getPlaysRank() + 1) * 1000);
                }
                player.setPlaysExperience(sumExperience);
                //结算怪物
                monster.setMonsterBlood(monster.getMonsterBlood() - sumBlood);
                map.clear();
                map.put("player", player);
                map.put("monster", monster);
                gameSystem.saveFile(map, "c:\\1\\game.bin");//存档
                game();
                break;
            case 2:
                System.out.println( "等级：" + player.getPlaysRank() + "\n攻击力：" + player.getPlaysAttack()
                        + "\n防御：" + player.getPlaysDefense() + "\n经验：" + player.getPlaysExperience());
                game();
                break;
            case 3:
                System.out.println("血量："+monster.getMonsterBlood()+"\n防御："+monster.getMonsterDefense());
                game();
                break;
            case 4:
                System.out.println("退出成功");
                System.exit(0);
                break;
            default:
                System.out.println("您的输入有误！");
                game();
                break;
        }
    }
    public static void main(String[] args) {
       Play play=new Play();
       play.game();
    }
}
