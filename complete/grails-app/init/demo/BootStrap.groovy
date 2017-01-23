package demo

import demo.Player

class BootStrap {

    def init = { servletContext ->
        [[name: 'Alexis Barnett', game: 'Pandemic', region: 'EAST', wins:  96, losses:  30],
         [name: 'Shelia Welch', game: 'Twilight Struggle', region: 'CENTRAL', wins:  83, losses:  20],
         [name: 'Lillian Cortez', game: 'Terra Mystica', region: 'CENTRAL', wins:  83, losses:  92],
         [name: 'Catherine Newton', game: 'Scythe', region: 'WEST', wins:  66, losses:  40],
         [name: 'Manuel Weber', game: '7 Wonders', wins:  59, losses:  41],
         [name: 'Abel Casey', game: 'Puerto Rico', region: 'WEST', wins:  21, losses:  36],
         [name: 'Tabitha Bowman', game: 'The Castles of Burgundy', region: 'EAST', wins: 102, losses:  12],
         [name: 'Leonard Terry', game: 'Agricola', region: 'WEST', wins:  82, losses:  11],
         [name: 'Kenneth Chambers', game: 'Power Grid', wins: 119, losses: 105],
         [name: 'Roy Price', game: 'Caylus', wins: 100, losses: 100]].each {
            new Player(it).save()
        }
    }

    def destroy = {
    }
}
