package com.ryan.stage1.model3.homework5;

import sun.security.mscapi.CPublicKey;

import java.util.*;

public class homework5 {

    public static void sort(List<String> list) {
        Collections.sort(list, (o1, o2) -> {
            String numOrder="3,4,5,6,7,8,9,10,J,Q,K,A,2,小王,大王";
            int x=numOrder.indexOf(o1);
            int y=numOrder.indexOf(o2);
            if(x>y){
                return -1;
            }else if(x<y){
                return 1;
            }else{
                return 0;
            }
        });
    }

    public static void main(String[] args) {


        ArrayList<String> cards = new ArrayList<>();
        String[] species = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "小王", "大王"};

        //存储玩家扑克牌
        ArrayList<String> play1 = new ArrayList<>();
        ArrayList<String> play2 = new ArrayList<>();
        ArrayList<String> play3 = new ArrayList<>();
        ArrayList<String> holeCards = new ArrayList<>();

        //存储扑克牌
        for (String s : species) {
            if (s.equals("小王") || s.equals("大王")) {
                cards.add(s);
            } else {
                for (int i = 0; i < 4; i++) {
                    cards.add(s);
                }
            }
        }

        //随机洗牌
        Collections.shuffle(cards);
        System.out.println(cards.size());
        System.out.println(cards);

        //发牌
        for (int i = 0; i < cards.size(); i++) {
            //获取牌面
            String card = cards.get(i);

            if(i>=51){
                holeCards.add(card);       //留底牌
            }else{
                if(i % 3 == 0){            //分给一号玩家
                    play1.add(card);
                }else if(i % 3 == 1){      //分给二号玩家
                    play2.add(card);

                }else{                      //分给三号玩家
                    play3.add(card);
                }
            }
        }

        //排序
        sort(play1);
        sort(play2);
        sort(play3);
        sort(holeCards);



        System.out.println("----------------最后排序---------------");
        System.out.println("玩家1" + play1);
        System.out.println("玩家2" + play2);
        System.out.println("玩家3" + play3);
        System.out.println("底牌" + holeCards);

    }
}
