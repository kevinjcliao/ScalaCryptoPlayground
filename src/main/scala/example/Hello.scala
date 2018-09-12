package example

import java.security.SecureRandom
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import BigInt._


object Hello extends App {
  val random = new SecureRandom()
  val startKey = BigInt(1024, 200, random)
  val base = BigInt(1024, 200, random)

  val alicePrivateKey = BigInt(64, 100, random)
  val bobPrivateKey = BigInt(64, 100, random)

  val aliceSentKey = base.modPow(alicePrivateKey, startKey)
  val bobSentKey   = base.modPow(bobPrivateKey, startKey)

  val aliceSecretKey = bobSentKey.modPow(alicePrivateKey, startKey)
  val bobSecretKey = aliceSentKey.modPow(bobPrivateKey, startKey)

  println(s"Alice Key: $aliceSecretKey")
  println(s"Bob Key: $bobSecretKey")
}
