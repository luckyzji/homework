package TexasPoker;

import java.util.ArrayList;
import java.util.Collections;

public class TexasPoker {
    private String input;
    private String []inputs;
    private Pokers White;
    private Pokers Black;

    public TexasPoker(String input) {
        this.input = input;
        this.inputs=input.split(" ");
    }
    public void setBlack(int start){
        ArrayList<Integer> pokers = new ArrayList<Integer>();
        ArrayList<String> colors = new ArrayList<String>();
        for (int i = start; i <start+5 ; i++) {
            if(inputs[i].length()==2){
                String tmp=inputs[i].substring(0,1);
                pokers.add(setPokerNum(tmp));
                colors.add(inputs[i].substring(1));
            }
            else {
                pokers.add(Integer.parseInt(inputs[i].substring(0,2)));
                colors.add(inputs[i].substring(2,3));
            }
        }
        Black = new Pokers(pokers,colors);
    }

    public void setWhite(int start){
        ArrayList<Integer> pokers = new ArrayList<Integer>();
        ArrayList<String> colors = new ArrayList<String>();
        for ( int i=start; i <start+5 ; i++) {
            if(inputs[i].length()==2){
                String tmp=inputs[i].substring(0,1);
                pokers.add(setPokerNum(tmp));
                colors.add(inputs[i].substring(1));
            }
            else{
                pokers.add(Integer.parseInt(inputs[i].substring(0,2)));
                colors.add(inputs[i].substring(2));
            }
        }
        White = new Pokers(pokers,colors);
    }
    public String judge(){
        if("Black:".equals(inputs[0])){
            this.setBlack(1);
            this.setWhite(7);
        }
        else{
                this.setBlack(7);
                this.setWhite(1);
        }

        int blackScore;
        int whiteScore;
        blackScore = Black.judgeCards();
        whiteScore = White.judgeCards();
        //System.out.println("blackScore:"+blackScore+"whiteScore:"+whiteScore);
        if(blackScore>whiteScore)return "Black wins";
        else if (whiteScore>blackScore)return "White wins";
        else{
            if(this.comparePoker()==1)return "Black wins";
            else if (this.comparePoker()==2)return "White wins";
            else return"Tie";
        }
    }
    public int comparePoker(){
        Collections.sort(Black.pokers);
        Collections.sort(White.pokers);
        for(int i=4;i>=0;i--){
            if(Black.pokers.get(i)>White.pokers.get(i))return 1;
            if (Black.pokers.get(i)<White.pokers.get(i)) return 2;
        }
        return 0;
    }

    public int setPokerNum(String tmp){
        int num;
        if(tmp.equals("J"))num=11;
        else if(tmp.equals("Q"))num=12;
        else if(tmp.equals("K"))num=13;
        else if(tmp.equals("A"))num=14;
        else{
            num=Integer.parseInt(tmp);
        }
        return num;
    }

}
