package shubham.fretron.service

import shubham.fretron.model.User
import shubham.fretron.respository.UserRepository
import java.lang.Exception
import javax.ws.rs.NotFoundException

class UserService {

    val userRepository = UserRepository()


    fun createUser(user: User): User {

        if (user.id.isEmpty() || user.name.isEmpty()) throw NotFoundException("Invalid user")
        else {
            return userRepository.createUser(user)
        }
    }

    fun fetchUserById(userId: String):User? {
           return userRepository.fetchUserById(userId)
    }

    fun updateUser(id: String,user: User):User?{
            return userRepository.updateUser(id, user)
    }

    fun deleteUser(id: String): User? {
            return userRepository.deleteUser(id)
    }

    fun fetchAllUsers():ArrayList<User>{
       return userRepository.fetchAllUsers()
    }

}