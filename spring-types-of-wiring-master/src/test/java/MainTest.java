import koschei.KoscheiTheDeathless;
import koschei.config.AppConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class MainTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void mainTest() {
        String text = "There is an ocean in the world , tree on the island , tree on the island , hare on the tree , duck in a rabbit , egg in duck , needle in the egg , Koshchei's death on the needle :(";

        KoscheiTheDeathless koscheiTheDeathless =
                applicationContext.getBean(KoscheiTheDeathless.class);
        System.out.println(koscheiTheDeathless.getRulesByDeth());
        String testText = koscheiTheDeathless.getRulesByDeth();

        if (!testText.contains(text) && testText.length() <= text.length()) {
            Assert.fail("Test fall");
        }
    }

}
