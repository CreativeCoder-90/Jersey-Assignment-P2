package shubham.fretron.respository

import shubham.fretron.model.User

class UserRepository {

    companion object{
        var users = ArrayList<User>()
    }

    fun createUser(user: User):User{
        users.add(user)
        return user
    }

    fun fetchAllUsers():ArrayList<User>{
        return users
    }

    fun fetchUserById(user_id:String):User?{
        var user:User? = null
        for (user2 in users){
            if(user2.id==user_id){
                user=user2
            }
        }
        return user
    }

    fun updateUser(userId: String, user: User):User?{
        var user:User? =null
        for (user2 in users){
            if(user2.id==userId){
                user=user2
                users.remove(user2)
                user.name="Mr. ".plus(user.name)
                users.add(user)
            }
        }
        return user
    }

    fun deleteUser(userId:String):User?{
        var user:User? =null
        for (user2 in users){
            if(user2.id==userId){
                user=user2
                users.remove(user2)
                break
            }
        }
        return user
    }
}