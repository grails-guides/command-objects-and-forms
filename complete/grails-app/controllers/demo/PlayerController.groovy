package demo

class PlayerController {

    //tag::actionIndex[]
    def index() {
        respond Player.list(params), model:[playerCount: Player.count()]
    }
    //end::actionIndex[]

}
