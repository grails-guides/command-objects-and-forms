package command.objects.and.forms

import demo.Player

class BootStrap {

    def init = { servletContext ->
        [[name: 'Matthew Moss', game: 'Agricola', region: 'East', wins: 12, losses: 4],
         [name: 'Jeff Brown', game: 'Power Grid', region: 'Central', wins: 9, losses: 2],
         [name: 'Lindsay Moss', game: 'Shadows Over Camelot', wins: 13, losses: 11]].each {
            new Player(it).save()
        }
    }

    def destroy = {
    }
}
