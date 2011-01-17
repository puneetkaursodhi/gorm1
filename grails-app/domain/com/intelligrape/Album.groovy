package com.intelligrape

class Album {
    String title
    SortedSet songs
    static  hasMany = [songs:Song]
    static constraints = {
        songs(nullable: true)
    }
    String toString(){
        return title
    }
//    void setSongs(Collection c){
//        songs=new TreeSet(c)
//    }
}
