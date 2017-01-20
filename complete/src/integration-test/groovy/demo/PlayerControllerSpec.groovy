package demo

import grails.plugins.rest.client.RestBuilder
import grails.test.mixin.integration.Integration
import org.springframework.beans.factory.annotation.Value
import spock.lang.Specification

@Integration
class PlayerControllerSpec extends Specification {

    def "test save validation"() {
        given:
        RestBuilder rest = new RestBuilder()

        when:
        def resp = rest.post("http://localhost:${serverPort}/player/save") { // <1>
            header("Accept", "application/json") // <2>
            header("Content-Type", "application/json") // <3>
            json {
                name = 'Bob Smith'
                wins = 42
                losses = 'abc'
            }
        }

        then:
        resp.status == 422 // <4>
        resp.json.errors.size() == 2
        resp.json.errors.find { it.field == 'losses' }.message == 'Property losses is type-mismatched'
        resp.json.errors.find { it.field == 'game' }.message == 'Property [game] of class [class demo.Player] cannot be null'
    }
}
