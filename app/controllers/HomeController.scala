package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json.JsObject
import play.api.libs.json.Json
import akka.http.scaladsl.model.HttpHeader
import play.api.Logger

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */

  val logger: Logger = Logger(getClass)

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def hello() = Action { implicit request: Request[AnyContent] =>

    val json: JsObject =
        Json.obj("hello" -> "world", "language" -> "scala")
    Ok(json)
  }

  def ping() = Action { implicit request: Request[AnyContent] =>
    Ok("pong")
  }

  def getUser() = Action { implicit request: Request[AnyContent] =>
    val id: String = request.getQueryString("id").getOrElse("0")
    val name: String = "Test"
    val json: JsObject =
      Json.obj("id" -> id, "name" -> name)
    Ok(json)
  }

  // POSTメソッドでメールアドレスと氏名とパスワードを受け取りユーザー登録を行う
  def registerUser() = Action { implicit request: Request[AnyContent] =>
    val response: JsObject =
      Json.obj("email" -> "OK", "name" -> "OK")
    Ok(response)
  }

}

