package com.roboxue.niffler.examples.slimmer_pr

import com.roboxue.niffler.{Implementation, Niffler}

/**
  * @author rxue
  * @since 1/1/18.
  */
object Engine1 extends Niffler with EngineBase {

  import EngineBase._

  override def scoreDocImpl: Implementation[Int] = scoreDoc.dependsOn(file1, file2) { (file1, file2) =>
    // ...magic 1, shouldBe sometime smarter in production
    1
  }
}
