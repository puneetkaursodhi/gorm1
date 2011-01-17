package com.intelligrape

class Album {
    String title
    SortedSet songs
    static  hasMany = [songs:Song]
    Date dateCreated
    Date lastUpdated
    static constraints = {
        songs(nullable: true)
    }
    String toString(){
        return title
    }
}
