package controllers

import models.Post
import play.api.libs.json.JsValue

import javax.inject.Inject
import play.api.libs.json.Json._
import play.api.mvc.{Action, AnyContent, InjectedController}
import services.PostService

class PostController @Inject()(postService: PostService) extends InjectedController {
  def getPosts: Action[AnyContent] = Action {
    val products = postService.getPosts()
    Ok(toJson(products))
  }

  def getPost(id: Int): Action[AnyContent] = Action {
    val product = postService.getPostById(id)
    Ok(toJson(product))
  }

  def addPost(): Action[JsValue] = Action(parse.json) { implicit request =>
    val newProduct = request.body.as[Post]
    val record = postService.addPost(newProduct)
    if (record > 0) Ok(toJson(newProduct)) else InternalServerError(toJson("error"))
  }

  def updatePost(id: Int): Action[JsValue] = Action(parse.json) { implicit request =>
    val updateProduct = request.body.as[Post]
    val record = postService.updatePost(id, updateProduct)
    if (record > 0) Ok(toJson("success")) else InternalServerError(toJson("error"))
  }

  def deletePost(id: Int): Action[AnyContent] = Action { implicit request =>
    val record = postService.deletePost(id)
    if (record > 0) Ok(toJson("success")) else InternalServerError(toJson("error"))
  }
}

