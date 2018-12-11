package priv.lukey.math.ml

import breeze.linalg.{*, DenseMatrix}

object pcaMatrix {
  def main(args: Array[String]): Unit = {
    val msData = DenseMatrix(
      (2.5,2.4),(0.5,0.7),(2.2,2.9),(1.9,2.2),(3.1,3.0),
      (2.3,2.7),(2.0,1.6),(1.0,1.1),(1.5,1.6),(1.1,0.9))

    val pca = breeze.linalg.princomp(msData)
    print("Center",msData(*,::) - pca.center)
    //数据的协方差矩阵
    print("covariance matrix",pca.covmat)
    //该协方差矩阵排好序的特征值
    print("eigen values",pca.eigenvalues)
    //特征向量
    print("eigen vectors",pca.loadings)
    print(pca.scores)

  }
}
