package react
package katex

import scala.scalajs.js
import js.annotation.JSImport
import japgolly.scalajs.react._
import japgolly.scalajs.react.component.Js.{RawMounted, UnmountedMapped}
import japgolly.scalajs.react.internal.Effect.Id

trait Katex extends js.Object

object KatexInline {

  @js.native
  @JSImport("react-katex", "InlineMath")
  object RawComponent extends js.Object

  @js.native
  trait Props extends js.Object {
    var errorColor: js.UndefOr[String]
    var math: String
    // var renderError: js.UndefOr[String]PropTypes.func
  }

  def props(
    math: String
  ): Props = {
    val p = (new js.Object).asInstanceOf[Props]
    p.math = math
    p
  }

  val component = JsComponent[Props, Children.None, Null](RawComponent)

  def apply(p: Props)
    : UnmountedMapped[Id, Props, Null, RawMounted[Props, Null], Props, Null] =
    component.apply(p)
}
