package shubham.fretron.resource

import com.fasterxml.jackson.databind.ObjectMapper
import shubham.fretron.model.User
import shubham.fretron.service.UserService
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/user/v1")
class UserResource {
    var userService = UserService()
    var objectMapper = ObjectMapper()

    @POST
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun createUser(request: String): Response {
        var user = objectMapper.readValue(request, User::class.java) //To convert the Json string into User object
        var createdUser = userService.createUser(user)
        if (createdUser.id == null) {
            return Response.ok().entity("id not found").build()
        } else {
            return Response.ok().entity(createdUser.toString()).build()
        }
    }

    @GET
    @Path("/users")
    @Produces(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON)
    fun getAll(): Response {
        userService.fetchAllUsers()
        return Response.ok().entity(userService.fetchAllUsers()).build()
    }

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getUserById(@PathParam("id") userId: String):Response {
        var fetchedUser: User? = userService.fetchUserById(userId)
        if (fetchedUser == null) {
            return Response.ok().entity("id not found").build()
        } else {
            return Response.ok().entity(userService.fetchUserById(userId).toString()).build()
        }
    }

    @Path("/user")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun updateUser(@QueryParam("id") userId: String,request: String):Response {
        val user = objectMapper.readValue(request, User::class.java)
        var updatedUser: User? = userService.updateUser(userId, user)
        if (updatedUser == null) {
            return Response.ok().entity("id not found").build()
        }
        else{
            return Response.ok().entity(userService.updateUser(userId, user).toString()).build()
    }
    }

    @Path("/user/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteUser(@PathParam("id") userId: String):Response{
       var deletedUser:User? = userService.deleteUser(userId)
            if(deletedUser==null){
                return Response.ok().entity("id not found").build()
            }
            else{
                return Response.ok().entity(deletedUser.toString()).build()
            }
        }
    }
