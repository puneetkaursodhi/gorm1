package com.intelligrape

import org.codehaus.groovy.grails.commons.ConfigurationHolder


class UtilController {

    def index = {

    }

    def get = {
        Song song = Song.get(2)
        render song
    }
    def getAll = {
        List<Song> songList = Song.getAll()
        render songList
        render "<br>"
        List<Song> songList1 = Song.getAll([1, 3, 5])
        render songList1
        render "<br>"
        List<Song> songList2 = Song.getAll(1..4)
        render songList2
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
        List<Song> songList = Song.findAll("from Song where title='Hey sohna' or  album=:albums", [albums: Album.get(1)])
        render songList
        render "<br>"
        songList = Song.findAllWhere(title: 'Aadat')
        render songList
        render "<br>"
        songList = Song.findAllByIdAndAlbum(1, Album.get(1))
        render songList
        render "<br>"
        songList = Song.findAllByTitleLike('%aa%')
        render songList
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
        List<Song> songList=Song.list()
        render songList
        render "<br>"
        songList=Song.list([offset:2,max:5])
        render songList
        render "<br>"

    }

}
