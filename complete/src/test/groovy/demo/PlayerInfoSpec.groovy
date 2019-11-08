package demo

import spock.lang.Specification

@SuppressWarnings(['MethodName', 'DuplicateListLiteral'])
class PlayerInfoSpec extends Specification {

    @SuppressWarnings(['JUnitPublicNonTestMethod'])
    def "test PlayerInfo.region can be null"() {
        expect:
        new PlayerInfo(region: null).validate(['region'])
    }

    @SuppressWarnings(['JUnitPublicNonTestMethod'])
    def "test PlayerInfo.name can be blank"() {
        when:
        def playerInfo = new PlayerInfo(name: '')

        then:
        !playerInfo.validate(['name'])
        playerInfo.errors['name'].code == 'blank'

        when:
        playerInfo = new PlayerInfo(name: null)

        then:
        !playerInfo.validate(['name'])
        playerInfo.errors['name'].code == 'nullable'
    }

    @SuppressWarnings(['JUnitPublicNonTestMethod'])
    def "test PlayerInfo.game can be blank"() {
        when:
        def playerInfo = new PlayerInfo(game: '')

        then:
        !playerInfo.validate(['game'])
        playerInfo.errors['game'].code == 'blank'

        when:
        playerInfo = new PlayerInfo(game: null)

        then:
        !playerInfo.validate(['game'])
        playerInfo.errors['game'].code == 'nullable'
    }
}
