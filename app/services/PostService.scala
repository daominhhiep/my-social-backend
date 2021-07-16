package services

import models.Post
import scalikejdbc.{AutoSession, DB, DBSession}

class PostService {

  def getPosts()(implicit session: DBSession = AutoSession): List[Post] = {
    Post.findAll()
  }

  def getPostById(id: Int): Option[Post] = DB readOnly { implicit session =>
    Post.findById(id)
  }

  def addPost(post: Post)(implicit session: DBSession = AutoSession): Long = {
    Post.createWithAttributes(
      'desc -> post.desc,
      'image -> post.image,
      'user_id -> post.userId,
      'like_count -> post.likeCount,
      'share_count -> post.shareCount
    )
  }

  def updatePost(id: Int, post: Post)(implicit session: DBSession = AutoSession):Int = {
    Post.updateById(id).withAttributes(
      'desc -> post.desc,
      'image -> post.image,
      'user_id -> post.userId,
      'like_count -> post.likeCount,
      'share_count -> post.shareCount
    )
  }

  def deletePost(id: Int)(implicit session: DBSession = AutoSession): Int = {
    Post.deleteById(id)
  }

}
