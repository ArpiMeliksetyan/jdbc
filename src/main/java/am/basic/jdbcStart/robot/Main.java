package am.basic.jdbcStart.robot;

import am.basic.jdbcStart.robot.foot.Foot;
import am.basic.jdbcStart.robot.foot.ToshibaFoot;
import am.basic.jdbcStart.robot.hand.Hand;
import am.basic.jdbcStart.robot.head.Head;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Robot robot = (Robot) applicationContext.getBean(Robot.class);
        robot.hit();
        robot.move();
        robot.spaek();

    }
}
