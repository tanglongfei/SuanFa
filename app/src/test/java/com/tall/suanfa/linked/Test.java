package com.tall.suanfa.linked;

import java.util.LinkedList;

/**
 * Created by Jett on 2018/11/28.
 */

public class Test {
    @org.junit.Test
    public void testRadixSort(){
        LinkedList<Mahjong> list=new LinkedList<Mahjong>();
        list.add(new Mahjong(3,1));
        list.add(new Mahjong(2,3));
        list.add(new Mahjong(3,7));
        list.add(new Mahjong(1,1));
        list.add(new Mahjong(3,8));
        list.add(new Mahjong(2,2));
        list.add(new Mahjong(3,2));
        list.add(new Mahjong(1,3));
        list.add(new Mahjong(3,9));
        System.out.println(list);
        radixSort(list);
        System.out.println(list);
    }

    /**
     * 麻将排序
     * @param list
     */
    public static void radixSort(LinkedList<Mahjong> list){
        //先对点数进行分组
        LinkedList[] rankList=new LinkedList[9];
        for (int i=0;i<rankList.length;i++){
            rankList[i]=new LinkedList();
        }
        //把数据一个一个的放入到对应的组中
        while(list.size()>0){
            //取一个
            Mahjong m=list.remove();
            //放到组中
            rankList[m.rank-1].add(m);
        }
        //把9个组合到一起
        for (int i = 0; i < rankList.length; i++) {
            list.addAll(rankList[i]);
        }

        //先花色数进行分组
        LinkedList[] suitList=new LinkedList[3];
        for (int i=0;i<suitList.length;i++){
            suitList[i]=new LinkedList();
        }
        //把数据一个一个的放入到对应的组中
        while(list.size()>0){
            //取一个
            Mahjong m=list.remove();
            //放到组中
            suitList[m.suit-1].add(m);
        }
        //把3个组合到一起
        for (int i = 0; i < suitList.length; i++) {
            list.addAll(suitList[i]);
        }

    }
}
