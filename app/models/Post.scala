package models
import org.joda.time.DateTime
import play.api.libs.json.{Json, OFormat}
import scalikejdbc.WrappedResultSet
import skinny.orm.{Alias, SkinnyCRUDMapper}
import common.DateTimeFormatter._

case class Post(
                 id: Long,
                 desc: String,
                 image: String,
                 userId: Long,
                 likeCount: Int,
                 shareCount: Int,
                 createdAt:  Option[DateTime],
                 updatedAt:  Option[DateTime]
               )

object Post extends SkinnyCRUDMapper[Post]{

  implicit val format: OFormat[Post] = Json.format[Post]

  override lazy val tableName = "posts"
  override lazy val primaryKeyFieldName = "id"
  override def defaultAlias: Alias[Post] = createAlias("posts")

  override def extract(rs: WrappedResultSet, n: scalikejdbc.ResultName[Post]): Post = new Post(
    id = rs.get(n.id),
    desc = rs.get(n.desc),
    image = rs.get(n.image),
    userId = rs.get(n.userId),
    likeCount = rs.get(n.likeCount),
    shareCount = rs.get(n.shareCount),
    createdAt = rs.get(n.createdAt),
    updatedAt = rs.get(n.updatedAt)
  )
}
