package demo

import grails.testing.spock.OnceBefore
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.exceptions.HttpClientResponseException
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import grails.testing.mixin.integration.Integration

@SuppressWarnings(['LineLength', 'MethodName'])
@Integration
class PlayerControllerFuncSpec extends Specification {

    @Shared
    @AutoCleanup
    private HttpClient client

    @SuppressWarnings(['JUnitPublicNonTestMethod'])
    @OnceBefore
    void init() {
        String baseUrl = "http://localhost:$serverPort" // <1>
        this.client  = HttpClient.create(baseUrl.toURL())
    }

    @SuppressWarnings(['JUnitTestMethodWithoutAssert'])
    void 'test save validation'() {
        when:
        Map<String, Object> json = [name : 'Bob Smith',
                                    wins : 42,
                                    losses : 'abc',]
        client.toBlocking().exchange(HttpRequest.POST('/player/save', json)
                .accept(MediaType.APPLICATION_JSON_TYPE), Map) // <2>

        then:
        HttpClientResponseException e = thrown()
        e.status == HttpStatus.UNPROCESSABLE_ENTITY // <3>
        e.response.body().errors.size() == 2
        e.response.body().errors.find { it.field == 'losses' }.message == 'Property losses is type-mismatched'
        e.response.body().errors.find { it.field == 'game' }.message ==
                'Property [game] of class [class demo.Player] cannot be null'
    }
}
