package org.economicsl.core.acl.acts

import org.economicsl.core.acl.{Receiver, Sender}

import scala.collection.{GenSet, immutable}


case class CallForProposal(sender: Sender, receivers: GenSet[Receiver], content: String)
    extends CommunicativeAct {

  val replyTo: Option[Receiver] = Some(sender)

}


object CallForProposal {

  def apply(sender: Sender, receiver: Receiver, content: String): CallForProposal = {
    val receivers = immutable.HashSet(receiver)
    new CallForProposal(sender, receivers, content)
  }

}