package shubham.fretron.model

class User {

    lateinit var id: String
    lateinit var name:String
    lateinit var age: String

    constructor()

    constructor(id: String, name:String, age: String):this(){
        this.id = id
        this.name = name
        this.age = age
    }

    override fun toString(): String {
        return "User(id='$id', name='$name', age='$age')"
    }
}
