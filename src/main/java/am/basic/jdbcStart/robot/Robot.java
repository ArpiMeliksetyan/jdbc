package am.basic.jdbcStart.robot;

import am.basic.jdbcStart.robot.foot.Foot;
import am.basic.jdbcStart.robot.hand.Hand;
import am.basic.jdbcStart.robot.head.Head;

public class Robot {

    private Foot foot;
    private Hand hand;
    private Head head;

    public Robot(Foot foot, Hand hand, Head head) {
        this.foot = foot;
        this.hand = hand;
        this.head = head;
    }

    public void hit(){
        hand.hit();
    }
    public void move(){
        foot.move();
    }
    public void spaek(){
        head.spaek();
    }
}
