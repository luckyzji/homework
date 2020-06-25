package TexasPoker;

import java.util.*;

public class Pokers {
    List<Integer> pokers ;
    List<String> colors ;

    public Pokers(ArrayList<Integer> pokers, ArrayList<String> colors) {
        this.pokers = pokers;
        this.colors = colors;
    }

    //判断牌型
    public int judgeCards(){
        int countTwo=0;
        int countThree=0;
        int countFour=0;
        int i;
        int judge[] = new int[16];
        for (i = 2; i <16 ; i++) {
            judge[i]=0;
        }

        for(int num : pokers){
            judge[num]++;
        }
        for (i =2; i <16 ; i++) {
            if(judge[i]==2) countTwo++;
            if (judge[i]==3)countThree++;
            if (judge[i]==4)countFour++;
        }
        //四条
        if (countFour==1)return 6;
        //葫芦
        if (countThree==1&&countTwo==1)return 7;
        //三条
        if(countThree==1)return 3;
        //一对
        if(countTwo==1)return 1;
        //两对
        if (countTwo==2)return 2;
        //同花顺
        if (this.sameColor()&&this.isSequence())return 8;
        //顺子
        if(this.isSequence())return 4;
        //同花
        if (this.sameColor())return 5;
        //高牌(散牌)
        return 0;
    }

    //判断是否是顺子
    public boolean isSequence(){
        Collections.sort(pokers);
        int i;
        for (i = 0; i <pokers.size()-2; i++) {
            if(pokers.get(i)+1!=pokers.get(i+1))return false;
        }
        if (pokers.get(i)+1==pokers.get(i+1))return true;
        return pokers.get(0)==2&&pokers.get(i+1)==14;
    }
    //判断是否为同花
    public boolean sameColor(){
        for (int i = 0; i <colors.size()-1 ; i++) {
            if (!colors.get(i).equals(colors.get(i+1)))return false;
        }
        return true;
    }
}
