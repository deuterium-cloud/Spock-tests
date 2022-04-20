package cloud.deuterium.spock.anime

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification

/**
 * Created by Milan Stojkovic 20-Apr-2022
 * https://spockframework.org/spock/docs/1.3/all_in_one.html#_spock_web_console
 * https://spockframework.org/spock/docs/1.3/module_spring.html
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
