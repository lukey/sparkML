package priv.lukey.math.ml

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.linalg.{Matrix, SingularValueDecomposition, Vectors,Vector}
import org.apache.spark.mllib.linalg.distributed.RowMatrix

object SparkSVDExampleOne {
  def main(args: Array[String]): Unit = {
    val denseData = Seq(
      Vectors.dense(0.0,1.0,2.0,1.0,5.0,3.3,2.1),
      Vectors.dense(3.0,4.0,5.0,3.1,4.5,5.1,3.3),
      Vectors.dense(6.0,7.0,8.0,2.1,6.0,6.7,6.8),
      Vectors.dense(9.0,0.0,1.0,3.4,4.3,1.0,1.0)
    )

    val spConfig = (new SparkConf).setMaster("local[*]").setAppName("SparkSVDDemo")
    val sc = new SparkContext(spConfig)
    val mat: RowMatrix = new RowMatrix(sc.parallelize(denseData,2))
    //计算前20个奇异值和对应的奇异向量
    val svd: SingularValueDecomposition[RowMatrix,Matrix] = mat.computeSVD(7,computeU = true)
    val U: RowMatrix = svd.U//U因子为一个RowMatrixz
    val s: Vector  = svd.s//各奇异值保存在一个本地密集向量中
    val V: Matrix = svd.V//V因子为一个本地密集矩阵
    println("U: \n" + U)
    println("s: \n" + s)
    println("V: \n" + V)
    sc.stop()
  }
}
