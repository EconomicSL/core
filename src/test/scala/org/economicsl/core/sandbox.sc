import org.economicsl.core.securities.Stock
import play.api.libs.json.Json


// Create a class for modeling stock issued by a particular company. */
class AppleStock extends Stock {

  val ticker: String = "APPL"

}


object AppleStock {

  def apply(): AppleStock = new AppleStock()
}

val apple1 = AppleStock()
val apple2 = AppleStock()

// Both have same JSON reprs...
Json.toJson(apple1)
Json.toJson(apple2)

// ... but are different objects in the heap...
apple1 == apple2

// ...and therefore can be stored in a Set together!
val apples = Set(apple1, apple2)




