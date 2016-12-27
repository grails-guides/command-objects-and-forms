//tag::indexShow[]
package demo

import org.springframework.http.HttpStatus

class PlayerController {
    def index() {
        respond Player.list(params), model: [playerCount: Player.count()]
    }

    def show(Player player) {
        respond player
    }
    //end::indexShow[]

    //tag::create[]
    def create() {
        respond new Player(params)
    }
    //end::create[]

    //tag::save-full[]
    //tag::save[]
    def save(Player player) {
        //end::save[]
        //tag::save-handleErrors[]
        if (player == null) {
            render status: HttpStatus.NOT_FOUND
            return
        }

        if (player.hasErrors()) {
            respond player.errors, view: 'create'
            return
        }
        //end::save-handleErrors[]

        player.save flush: true
        respond player, [status: HttpStatus.CREATED]
        //tag::save[]
    }
    //end::save[]
    //end::save-full[]
//tag::indexShow[]
}
//end::indexShow[]
