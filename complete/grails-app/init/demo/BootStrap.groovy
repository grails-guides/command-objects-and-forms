package demo

import groovy.transform.CompileStatic

@SuppressWarnings(['LineLength', 'DuplicateNumberLiteral'])
@CompileStatic
class BootStrap {

    def init = { servletContext ->

        Player.saveAll(
                new Player(name: 'Alexis Barnett', game: 'Pandemic', region: 'EAST', wins:  96, losses:  30),
                new Player(name: 'Shelia Welch', game: 'Twilight Struggle', region: 'CENTRAL', wins:  83, losses:  20),
                new Player(name: 'Lillian Cortez', game: 'Terra Mystica', region: 'CENTRAL', wins:  83, losses:  92),
                new Player(name: 'Catherine Newton', game: 'Scythe', region: 'WEST', wins:  66, losses:  40),
                new Player(name: 'Manuel Weber', game: '7 Wonders', wins:  59, losses:  41),
                new Player(name: 'Abel Casey', game: 'Puerto Rico', region: 'WEST', wins:  21, losses:  36),
                new Player(name: 'Tabitha Bowman', game: 'The Castles of Burgundy', region: 'EAST', wins: 102, losses:  12),
                new Player(name: 'Leonard Terry', game: 'Agricola', region: 'WEST', wins:  82, losses:  11),
                new Player(name: 'Kenneth Chambers', game: 'Power Grid', wins: 119, losses: 105),
                new Player(name: 'Roy Price', game: 'Caylus', wins: 100, losses: 100)
        )
    }

    def destroy = {
    }
}
