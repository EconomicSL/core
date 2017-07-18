package org.economicsl.core.acl.acts

import org.economicsl.core.acl.{Receiver, Sender}

import scala.collection.GenSet


trait CommunicativeAct {

  /* Participants in communication */

  def sender: Option[Sender]

  def receivers: GenSet[Receiver]

  def replyTo: Option[Receiver]

  /* Content of the message */

  def content: Any

  /* Description of the content */


}
