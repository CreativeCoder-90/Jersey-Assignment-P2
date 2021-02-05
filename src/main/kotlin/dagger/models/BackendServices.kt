package dagger.models

import javax.inject.Inject
import javax.inject.Named
import shubham.fretron.resource.UserResource as UserResource1

class BackendServices @Inject constructor( var uri:String, var port:Int, var userResource: shubham.fretron.resource.UserResource ) {

}