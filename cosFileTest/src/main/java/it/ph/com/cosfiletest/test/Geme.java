package it.ph.com.cosfiletest.test;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;


/**
 * @author: P H
 * @时间: 2023/2/21
 * @描述: 游戏
 */
@Service
public class Geme {
    private static final Logger log = Logger.getLogger(String.valueOf(Geme.class));

    /**
     * @return: java.util.List<java.lang.String>
     * @创建者: P H
     * @时间: 2023/2/21
     * @描述: 扑克牌游戏
     **/

    public Map<String, List<String>> pokerGame() {
        Map<String, List<String>> resultMap = new HashMap<>(3);
        //创建花色数组
        String[] decorList = {"♠", "♥", "♦", "♣"};
        //创建点数集合
        String[] pointList = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        //创建卡牌集合
        List<String> cardList = new ArrayList<>();
        Arrays.asList(decorList).forEach(a -> Arrays.asList(pointList).forEach(b -> cardList.add(a + b)));
        cardList.add("大王");
        cardList.add("小王");
        //洗牌（打乱顺序）
        System.out.println("开始洗牌!");
        Collections.shuffle(cardList);
        System.out.println("洗牌结束!");
        log.info("洗牌后的卡牌：" + cardList);
        //定义地主牌
        String landlord = "♠3";
        //三张地主牌集合
        List<String> landlordCardList = new ArrayList<>();
        //生成三张地主牌
        Random random = new Random();
        int i = 0;
        while (i < 3) {
            int brandIndex = random.nextInt(cardList.size());
            //判断是否取得是同一张牌并且不能是地主牌
            if (!landlordCardList.contains(cardList.get(brandIndex)) && !landlord.equals(cardList.get(brandIndex))) {
                //将牌放入到地主牌集合
                landlordCardList.add(cardList.get(brandIndex));
                //从卡牌集合删除这张牌
                cardList.remove(cardList.get(brandIndex));
                i++;
            }
        }
        resultMap.put("地主牌", landlordCardList);
        log.info("生成的地主牌：" + landlordCardList);
        log.info("取出3张地主牌后的卡牌集合：" + cardList);
        //创建玩家一的卡牌集合
        List<String> playerOneList = new ArrayList<>();
        //创建玩家二的卡牌集合
        List<String> playerTwoList = new ArrayList<>();
        //创建玩家三的卡牌集合
        List<String> playerThreeList = new ArrayList<>();
        //开始发牌
        log.info("开始发牌!");
        for (int a = 0; a < cardList.size(); a++) {
            switch (a % 3) {
                //给一号玩家发牌
                case 0:
                    playerOneList.add(cardList.get(a));
                    //判断时候是地主牌
                    if (cardList.get(a).equals(landlord)) {
                        playerOneList.addAll(landlordCardList);
                        log.info("一号玩家是地主");
                    }
                    break;
                //给二号玩家发牌
                case 1:
                    playerTwoList.add(cardList.get(a));
                    //判断时候是地主牌
                    if (cardList.get(a).equals(landlord)) {
                        playerTwoList.addAll(landlordCardList);
                        log.info("二号玩家是地主");
                    }
                    break;
                //给三号玩家发牌
                case 2:
                    playerThreeList.add(cardList.get(a));
                    //判断时候是地主牌
                    if (cardList.get(a).equals(landlord)) {
                        playerThreeList.addAll(landlordCardList);
                        log.info("三号玩家是地主");
                    }
                    break;
                default:
                    break;
            }
        }
        //玩家一的牌
        List<String> landlordOneHand = new ArrayList<>();
        //玩家一的牌
        List<String> landlordTwoHand = new ArrayList<>();
        //玩家一的牌
        List<String> landlordThreeHand = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>(3);
        map.put("玩家一", playerOneList);
        map.put("玩家二", playerTwoList);
        map.put("玩家三", playerThreeList);
        //玩家牌面排序（先更具花色，再更具点数排序）
        log.info("整理牌序!");
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue().contains("大王")) {
                switch (key) {
                    case "玩家一":
                        landlordOneHand.add("大王");
                        playerOneList.remove("大王");
                        break;
                    case "玩家二":
                        landlordTwoHand.add("大王");
                        playerTwoList.remove("大王");
                        break;
                    case "玩家三":
                        landlordThreeHand.add("大王");
                        playerThreeList.remove("大王");
                        break;
                    default:
                        break;
                }
            }
            //点数
            for (String point1 : pointList) {
                //花色
                for (String decor1 : decorList) {
                    if (entry.getValue().contains(decor1 + point1)) {
                        switch (key) {
                            case "玩家一":
                                landlordOneHand.add(decor1 + point1);
                                break;
                            case "玩家二":
                                landlordTwoHand.add(decor1 + point1);
                                break;
                            case "玩家三":
                                landlordThreeHand.add(decor1 + point1);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        log.info("发牌结束!");
        log.info("一号玩家的牌：" + landlordOneHand);
        log.info("二号玩家的牌：" + landlordTwoHand);
        log.info("三号玩家的牌：" + landlordThreeHand);
        resultMap.put("一号玩家的牌：", landlordOneHand);
        resultMap.put("二号玩家的牌：", landlordTwoHand);
        resultMap.put("三号玩家的牌：", landlordThreeHand);
        return resultMap;
    }

    public static void main(String[] args) {
        Geme geme = new Geme();
        geme.pokerGame();
    }
}
