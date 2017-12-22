package com.roboxue.niffler

import scala.concurrent.duration.FiniteDuration

/**
  * (A) -> B, (A) -> C, (B,C) -> D, (A,D) -> E
  * @author rxue
  * @since 12/19/17.
  */
sealed trait CachingPolicy

object CachingPolicy {

  /**
    * Never cached, even within same execution. In the example above, A will be evaluated twice when evaluating E
    */
  case object Never extends CachingPolicy

  /**
    * Cached within execution. In the example above, A will be evaluated once when evaluating E,
    * however the [[ExecutionCache]] in the [[ExecutionResult]] will not contain A's result
    */
  case object WithinExecution extends CachingPolicy

  /**
    * Cached after execution. In the example above, A will be evaluated once when evaluating E,
    * the [[ExecutionCache]] in the [[ExecutionResult]] will also contain A's result
    */
  case object Forever extends CachingPolicy

  /**
    * Cached after execution with a ttl. In the example above, A will be evaluated once when evaluating E,
    * the [[ExecutionCache]] in the [[ExecutionResult]] will also contain A's result, but won't be used after expiration
    */
  case class Timed(duration: FiniteDuration) extends CachingPolicy
}