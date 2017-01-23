package demo

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(PlayerController)
@Mock([Player])
class PlayerControllerSpec extends Specification {

    def "test update"() {
        when:
        def  player = new Player(name: 'Sergio',
                game: 'XCOM: Enemy Unkown',
                region: 'Spain',
                wins: 3,
                losses: 2
        )
        player.save()
        params.id = player.id
        params.name = 'Sergio del Amo'
        params.game = 'XCOM 2'
        params.region = 'USA'
        params.wins = 4
        controller.update() // <1>

        then: 'respond model has no errors'
        !model.player.hasErrors()

        and: 'player properties have been updated correctly'
        model.player.name == 'Sergio del Amo'
        model.player.game == 'XCOM 2'
        model.player.region == 'USA'

        and: 'non existing properties in the command object have not been modified'
        model.player.wins == 3
        model.player.losses == 2
    }
}
