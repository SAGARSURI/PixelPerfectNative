package com.example.android.pixelperfectnative.framework.network
import com.squareup.moshi.Json


data class PhotoEntity(
    @field:Json(name = "results")
    val results: List<Result> = listOf(),
    @field:Json(name = "total")
    val total: Int = 0,
    @field:Json(name = "total_pages")
    val totalPages: Int = 0
) {
    data class Result(
        @field:Json(name = "alt_description")
        val altDescription: String = "",
        @field:Json(name = "categories")
        val categories: List<Any> = listOf(),
        @field:Json(name = "color")
        val color: String = "",
        @field:Json(name = "created_at")
        val createdAt: String = "",
        @field:Json(name = "current_user_collections")
        val currentUserCollections: List<Any> = listOf(),
        @field:Json(name = "description")
        val description: String? = null,
        @field:Json(name = "height")
        val height: Int = 0,
        @field:Json(name = "id")
        val id: String = "",
        @field:Json(name = "liked_by_user")
        val likedByUser: Boolean = false,
        @field:Json(name = "likes")
        val likes: Int = 0,
        @field:Json(name = "links")
        val links: Links = Links(),
        @field:Json(name = "promoted_at")
        val promotedAt: String? = null,
        @field:Json(name = "tags")
        val tags: List<Tag> = listOf(),
        @field:Json(name = "updated_at")
        val updatedAt: String = "",
        @field:Json(name = "urls")
        val urls: Urls = Urls(),
        @field:Json(name = "user")
        val user: User = User(),
        @field:Json(name = "width")
        val width: Int = 0
    ) {
        data class Links(
            @field:Json(name = "download")
            val download: String = "",
            @field:Json(name = "download_location")
            val downloadLocation: String = "",
            @field:Json(name = "html")
            val html: String = "",
            @field:Json(name = "self")
            val self: String = ""
        )

        data class Tag(
            @field:Json(name = "source")
            val source: Source = Source(),
            @field:Json(name = "title")
            val title: String = "",
            @field:Json(name = "type")
            val type: String = ""
        ) {
            data class Source(
                @field:Json(name = "ancestry")
                val ancestry: Ancestry = Ancestry(),
                @field:Json(name = "cover_photo")
                val coverPhoto: CoverPhoto = CoverPhoto(),
                @field:Json(name = "description")
                val description: String = "",
                @field:Json(name = "meta_description")
                val metaDescription: String = "",
                @field:Json(name = "meta_title")
                val metaTitle: String = "",
                @field:Json(name = "subtitle")
                val subtitle: String = "",
                @field:Json(name = "title")
                val title: String = ""
            ) {
                data class Ancestry(
                    @field:Json(name = "category")
                    val category: Category = Category(),
                    @field:Json(name = "type")
                    val type: Type = Type()
                ) {
                    data class Category(
                        @field:Json(name = "pretty_slug")
                        val prettySlug: String = "",
                        @field:Json(name = "slug")
                        val slug: String = ""
                    )

                    data class Type(
                        @field:Json(name = "pretty_slug")
                        val prettySlug: String = "",
                        @field:Json(name = "slug")
                        val slug: String = ""
                    )
                }

                data class CoverPhoto(
                    @field:Json(name = "alt_description")
                    val altDescription: String = "",
                    @field:Json(name = "categories")
                    val categories: List<Any> = listOf(),
                    @field:Json(name = "color")
                    val color: String = "",
                    @field:Json(name = "created_at")
                    val createdAt: String = "",
                    @field:Json(name = "current_user_collections")
                    val currentUserCollections: List<Any> = listOf(),
                    @field:Json(name = "description")
                    val description: String = "",
                    @field:Json(name = "height")
                    val height: Int = 0,
                    @field:Json(name = "id")
                    val id: String = "",
                    @field:Json(name = "liked_by_user")
                    val likedByUser: Boolean = false,
                    @field:Json(name = "likes")
                    val likes: Int = 0,
                    @field:Json(name = "links")
                    val links: Links = Links(),
                    @field:Json(name = "promoted_at")
                    val promotedAt: String = "",
                    @field:Json(name = "updated_at")
                    val updatedAt: String = "",
                    @field:Json(name = "urls")
                    val urls: Urls = Urls(),
                    @field:Json(name = "user")
                    val user: User = User(),
                    @field:Json(name = "width")
                    val width: Int = 0
                ) {
                    data class Links(
                        @field:Json(name = "download")
                        val download: String = "",
                        @field:Json(name = "download_location")
                        val downloadLocation: String = "",
                        @field:Json(name = "html")
                        val html: String = "",
                        @field:Json(name = "self")
                        val self: String = ""
                    )

                    data class Urls(
                        @field:Json(name = "full")
                        val full: String = "",
                        @field:Json(name = "raw")
                        val raw: String = "",
                        @field:Json(name = "regular")
                        val regular: String = "",
                        @field:Json(name = "small")
                        val small: String = "",
                        @field:Json(name = "thumb")
                        val thumb: String = ""
                    )

                    data class User(
                        @field:Json(name = "accepted_tos")
                        val acceptedTos: Boolean = false,
                        @field:Json(name = "bio")
                        val bio: String = "",
                        @field:Json(name = "first_name")
                        val firstName: String = "",
                        @field:Json(name = "id")
                        val id: String = "",
                        @field:Json(name = "instagram_username")
                        val instagramUsername: String = "",
                        @field:Json(name = "last_name")
                        val lastName: String = "",
                        @field:Json(name = "links")
                        val links: Links = Links(),
                        @field:Json(name = "location")
                        val location: String = "",
                        @field:Json(name = "name")
                        val name: String = "",
                        @field:Json(name = "portfolio_url")
                        val portfolioUrl: Any? = null,
                        @field:Json(name = "profile_image")
                        val profileImage: ProfileImage = ProfileImage(),
                        @field:Json(name = "total_collections")
                        val totalCollections: Int = 0,
                        @field:Json(name = "total_likes")
                        val totalLikes: Int = 0,
                        @field:Json(name = "total_photos")
                        val totalPhotos: Int = 0,
                        @field:Json(name = "twitter_username")
                        val twitterUsername: String = "",
                        @field:Json(name = "updated_at")
                        val updatedAt: String = "",
                        @field:Json(name = "username")
                        val username: String = ""
                    ) {
                        data class Links(
                            @field:Json(name = "followers")
                            val followers: String = "",
                            @field:Json(name = "following")
                            val following: String = "",
                            @field:Json(name = "html")
                            val html: String = "",
                            @field:Json(name = "likes")
                            val likes: String = "",
                            @field:Json(name = "photos")
                            val photos: String = "",
                            @field:Json(name = "portfolio")
                            val portfolio: String = "",
                            @field:Json(name = "self")
                            val self: String = ""
                        )

                        data class ProfileImage(
                            @field:Json(name = "large")
                            val large: String = "",
                            @field:Json(name = "medium")
                            val medium: String = "",
                            @field:Json(name = "small")
                            val small: String = ""
                        )
                    }
                }
            }
        }

        data class Urls(
            @field:Json(name = "full")
            val full: String = "",
            @field:Json(name = "raw")
            val raw: String = "",
            @field:Json(name = "regular")
            val regular: String = "",
            @field:Json(name = "small")
            val small: String = "",
            @field:Json(name = "thumb")
            val thumb: String = ""
        )

        data class User(
            @field:Json(name = "accepted_tos")
            val acceptedTos: Boolean = false,
            @field:Json(name = "bio")
            val bio: Any? = null,
            @field:Json(name = "first_name")
            val firstName: String = "",
            @field:Json(name = "id")
            val id: String = "",
            @field:Json(name = "instagram_username")
            val instagramUsername: String = "",
            @field:Json(name = "last_name")
            val lastName: String = "",
            @field:Json(name = "links")
            val links: Links = Links(),
            @field:Json(name = "location")
            val location: String = "",
            @field:Json(name = "name")
            val name: String = "",
            @field:Json(name = "portfolio_url")
            val portfolioUrl: String = "",
            @field:Json(name = "profile_image")
            val profileImage: ProfileImage = ProfileImage(),
            @field:Json(name = "total_collections")
            val totalCollections: Int = 0,
            @field:Json(name = "total_likes")
            val totalLikes: Int = 0,
            @field:Json(name = "total_photos")
            val totalPhotos: Int = 0,
            @field:Json(name = "twitter_username")
            val twitterUsername: String = "",
            @field:Json(name = "updated_at")
            val updatedAt: String = "",
            @field:Json(name = "username")
            val username: String = ""
        ) {
            data class Links(
                @field:Json(name = "followers")
                val followers: String = "",
                @field:Json(name = "following")
                val following: String = "",
                @field:Json(name = "html")
                val html: String = "",
                @field:Json(name = "likes")
                val likes: String = "",
                @field:Json(name = "photos")
                val photos: String = "",
                @field:Json(name = "portfolio")
                val portfolio: String = "",
                @field:Json(name = "self")
                val self: String = ""
            )

            data class ProfileImage(
                @field:Json(name = "large")
                val large: String = "",
                @field:Json(name = "medium")
                val medium: String = "",
                @field:Json(name = "small")
                val small: String = ""
            )
        }
    }
}