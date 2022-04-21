package cloud.deuterium.spock.anime

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification

/**
 * Created by Milan Stojkovic 20-Apr-2022
 */

@SpringBootTest
class AppTest extends Specification {

    @Autowired
    ApplicationContext context

    def "test context loads"() {
        expect: "context in not a null"
        context != null
        context.containsBean("animeController")
        context.containsBean("animeServiceImpl")
        context.containsBean("animeRepository")
    }
}
