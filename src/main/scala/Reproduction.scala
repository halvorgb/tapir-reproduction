import io.circe.Json
import sttp.tapir._
import io.circe.generic.auto._
import sttp.tapir.json.circe._

object Reproduction {
  final case class JsonField(field: Json)

  final case class OptionalStringField(field: Option[String])

  final case class OptionalJsonField(field: Option[Json])

  final case class OptionalJsonFieldV2(field: Option[Json])

  // compiles
  val _: EndpointIO[JsonField] = jsonBody[JsonField]
  // compiles
  val _: EndpointIO[OptionalStringField] = jsonBody[OptionalStringField]

  /** doesn't compile:
   * Error:(25, 39) Cannot find a codec for type: Reproduction.C, formatted as: sttp.tapir.CodecFormat.Json.
   * Did you define a codec for: Reproduction.C?
   * Did you import the codecs for: sttp.tapir.CodecFormat.Json?
   * Is there an implicit schema for: Reproduction.C, and all of its components?
   * (codecs are looked up as implicit values of type Codec[Reproduction.C, sttp.tapir.CodecFormat.Json, _];
   * schemas are looked up as implicit values of type Schema[Reproduction.C])
   * val cInput: EndpointIO[C] = jsonBody[C]
   */
  val _: EndpointIO[OptionalJsonField] = jsonBody[OptionalJsonField]

  implicit val validator: Validator[OptionalJsonFieldV2] = Validator.pass
  // compiles
  val _: EndpointIO[OptionalJsonFieldV2] = jsonBody[OptionalJsonFieldV2]

}