package react.katex.demo

import scala.scalajs.js
import scala.scalajs.js.annotation._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom
import react.katex._

object LatexDemo {

  val component = ScalaComponent.builder[Unit]("LatexDemo")
    .render_P { _ =>
      <.div(
        KatexInline(KatexInline.props(math = """\int_0^\infty e^{-x^2} dx=\frac{\sqrt{\pi}}{2}"""))
      )
    }
    .build

  def apply() = component()
}

@JSExportTopLevel("Demo")
object Demo {
  @JSImport("katex/dist/katex.min.css", JSImport.Default)
  @js.native
  object ReactKatexStyles extends js.Object

  @JSExport
  def main(): Unit = {
    // needed to load the styles
    ReactKatexStyles

    val container = Option(dom.document.getElementById("root")).getOrElse {
      val elem = dom.document.createElement("div")
      elem.id = "root"
      dom.document.body.appendChild(elem)
      elem
    }
    LatexDemo().renderIntoDOM(container)
    ()
  }
}
