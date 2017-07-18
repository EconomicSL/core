package org.economicsl.core.acl


import org.economicsl.core.acl.acts.CommunicativeAct

import scala.collection.GenSet


/**
  *
  *
  */
trait Message {

  /** Denotes the identity of the sender of the message, that is, the name of the agent of the communicative act.
    *
    * @return
    * @note The `sender` parameter will be a parameter of most ACL messages. It is possible to omit the sender parameter if, for example, the agent sending the ACL message wishes to remain anonymous. The sender parameter refers to the agent which performs the communicative act giving rise to this ACL message.
    */
  def sender: Option[Sender]

  def receiver: GenSet[Receiver]

  def performative: CommunicativeAct

}
