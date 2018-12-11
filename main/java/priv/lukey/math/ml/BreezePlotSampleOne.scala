package priv.lukey.math.ml

import breeze.linalg._
//这个是breeze-viz依赖
import breeze.plot._

object BreezePlotSampleOne {
  def main(args: Array[String]): Unit = {
    val f = Figure()
    val p = f.subplot(0)
    val x = DenseVector(0.0,0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8)
    val y = DenseVector(1.1,2.1,0.5,1.0,3.0,1.1,0.0,0.5,2.5)
    p += plot(x,y)
    p.xlabel = "x axis"
    p.ylabel = "y axis"

    f.saveas("/Users/lukey/Downloads/BreezePlotSampleOne.png")
  }
}
