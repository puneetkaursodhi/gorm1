package com.intelligrape

import org.codehaus.groovy.grails.commons.ConfigurationHolder


class UtilController {

    def index = {

    }

    def get = {
        Song song = Song.get(2)
        render song
    }
    def list = {
        List<Song> songs = Song.list()
        render songs
        render "<br>"
        songs = Song.list([offset: 1, max: 5])
        render songs
        render "<br>"
        songs = Song.list(sort: 'dateCreated', order: 'desc')
        render songs
        render "<br>"
        songs = Song.list([offset: 2, max: 5, sort: 'dateCreated', order: 'desc'])
        render songs
        render "<br>"
    }
    def getAll = {
        List<Song> songs = Song.getAll()
        render songs
        render "<br>"
        songs = Song.getAll([1, 3, 5])
        render songs
        render "<br>"
        songs = Song.getAll(1..4)
        render songs
        render "<br>"
    }
    def find = {
        Song song = Song.find("from Song where title='Aadat'")
        render song
        render "<br>"
        song = Song.find("from Song where title =?", ['Aadat'])
        render song
        render "<br>"
        song = Song.find("from Song where title =:title", [title: 'Aadat'])
        render song
        render "<br>"
    }
    def findBy = {
        Song song = Song.findWhere(title: 'Aadat')
        render song
        render "<br>"
        song = Song.findById(1)
        render song
        render "<br>"
        song = Song.findByIdAndAlbum(2, Album.get(2))
        render song
        render "<br>"
        song = Song.findByTitleNotEqual('xyz')
        render song
        render "<br>"

        song = Song.findByTitleLike("%aa%")
        render song
        render "<br>"
    }
    def findAll = {
        List<Song> songs = Song.findAll("from Song where title='Hey sohna' or  album in(:albums)", [albums: Album.list([offset:1,max:10])])
        render songs
        render "<br>"
        songs = Song.findAllWhere(title: 'Aadat')
        render songs
        render "<br>"
        songs = Song.findAllByIdAndAlbum(1, Album.get(1))
        render songs
        render "<br>"
        songs = Song.findAllByTitleLike('%aa%',[offset:1,max:10])
        render songs
        render "<br>"
    }
    def countBy = {
        int count = Song.count()
        render "no of song : ${count}"
        count = Song.countByAlbum(Album.get(3)) //Case Insensitive
        render "<br>no of songs  in album no 3 is ${count}"
    }
    def validateObject = {
        Album album = new Album(title: "Doorie")
        Album album2 = new Album()
        boolean isValidated = album.validate()
        render "${isValidated}<br>"
        boolean isValidated1 = album2.validate()
        render isValidated1
    }
    def pagination = {
        List<Song> songs = Song.list()
        render songs
        render "<br>"
        songs = Song.list([offset: 2, max: 5])
        render songs
        render "<br>"
        songs = Song.findAllByTitleLike('%aa%',[offset:0,max:10])
        render songs
        render "<br>"

    }

}
