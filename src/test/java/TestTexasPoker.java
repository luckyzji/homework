import TexasPoker.TexasPoker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTexasPoker {

    //测试高牌(散牌)
    @Test
    public void testHighCard(){
        TexasPoker th = new TexasPoker("Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C AH");
        String result = th.judge();
        Assertions.assertEquals("White wins",result);
        System.out.println(result);
    }

    //测试高牌和一对(win)
    @Test
    public void testHighCardAndOnePair(){
        TexasPoker th = new TexasPoker("Black: 2H 3D 5S 9C KD White: 2C 2H 4S 8C AH");
        String result = th.judge();
        Assertions.assertEquals("White wins",result);
        System.out.println(result);
    }

    //测试两对和三条(win)
    @Test
    public void testTowPairsAndThree(){
        TexasPoker th = new TexasPoker("Black: 2H 2S 5H 5S KH White: 4C 4D 4S 5C 6H");
        String result = th.judge();
        Assertions.assertEquals("White wins",result);
        System.out.println(result);
    }

    //测试同花顺(win)和顺子
    @Test
    public void testSameColorAndSequence(){
        TexasPoker th = new TexasPoker("Black: 2H 3H 5H 9H KH White: 2C 3H 4S 5C 6H");
        String result = th.judge();
        Assertions.assertEquals("Black wins",result);
        System.out.println(result);
    }

    //测试同花顺
    @Test
    public void testSameColorSequence(){
        TexasPoker th = new TexasPoker("Black: 2H 3H 4H 5H 6H White: 3C 4C 5C 6C 7C");
        String result = th.judge();
        Assertions.assertEquals("White wins",result);
        System.out.println(result);
    }

    //测试顺子(win)和三条
    @Test
    public void testSequenceAndThree(){
        TexasPoker th = new TexasPoker("Black: AH 2C 3H 4S 5H White: 2C 2H 2S 5C 6H");
        String result = th.judge();
        Assertions.assertEquals("Black wins",result);
        System.out.println(result);
    }

    //测试四条(win)和同花
    @Test
    public void testSameColorAndFour(){
        TexasPoker th = new TexasPoker("Black: 6H 6C 6S 6D 5H White: 9C 5C 7C KC AC");
        String result = th.judge();
        Assertions.assertEquals("Black wins",result);
        System.out.println(result);
    }

    //测试四条和葫芦(win)
    @Test
    public void testFourAndGourd(){
        TexasPoker th = new TexasPoker("Black: 6H 6C 6S 6D 5H White: 3C 3S 3D 2C 2S");
        String result = th.judge();
        Assertions.assertEquals("White wins",result);
        System.out.println(result);
    }

    //测试葫芦和同花顺(win)
    @Test
    public void testGourdAndSameColorSequence(){
        TexasPoker th = new TexasPoker("Black: 3C 3S 3D 2C 2S White: AH 2H 3H 4H 5H");
        String result = th.judge();
        Assertions.assertEquals("White wins",result);
        System.out.println(result);
    }
}
