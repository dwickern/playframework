/*
 * Copyright (C) from 2022 The Play Framework Contributors <https://github.com/playframework>, 2011-2021 Lightbend Inc. <https://www.lightbend.com>
 */

package play.api.cluster.sharding.typed

import jakarta.inject.Inject
import jakarta.inject.Provider
import jakarta.inject.Singleton
import org.apache.pekko.actor.typed.scaladsl.adapter._
import org.apache.pekko.actor.ActorSystem
import org.apache.pekko.annotation.InternalApi
import org.apache.pekko.cluster.sharding.typed.scaladsl.ClusterSharding
import play.api.inject._

@InternalApi
final class ClusterShardingModule extends SimpleModule(bind[ClusterSharding].toProvider[ClusterShardingProvider])

/** Provider for the Pekko Typed ClusterSharding (Scala) */
@Singleton
@InternalApi
class ClusterShardingProvider @Inject() (val actorSystem: ActorSystem) extends Provider[ClusterSharding] {
  val get: ClusterSharding = ClusterSharding(actorSystem.toTyped)
}
