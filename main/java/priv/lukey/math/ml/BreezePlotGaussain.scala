package priv.lukey.math.ml

import breeze.plot.{Figure, hist}

object BreezePlotGaussain {
  def main(args: Array[String]): Unit = {
    val f = Figure()
    val p = f.subplot(2,1,1)
    val g = breeze.stats.distributions.Gaussian(0,1)
    p += hist(g.sample(100000),100)
    p.title = "A normal distribution"
    f.saveas("/Users/lukey/Downloads/plot-gaussain-100000.png")
  }
}
