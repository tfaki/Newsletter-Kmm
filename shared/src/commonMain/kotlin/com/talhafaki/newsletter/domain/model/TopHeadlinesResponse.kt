package com.talhafaki.newsletter.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Created by talhafaki on 5.06.2022.
 */

@Serializable
data class TopHeadlinesResponse(
    @SerialName("status")
    val status: String? = null,
    @SerialName("totalResults")
    val totalResults: Int? = null,
    @SerialName("articles")
    val articles: List<Article>? = null
)

@Serializable
data class Article(
    @SerialName("source")
    val source: Source? = null,
    @SerialName("author")
    val author: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("url")
    val url: String? = null,
    @SerialName("urlToImage")
    val urlToImage: String? = null,
    @SerialName("publishedAt")
    val publishedAt: String? = null,
    @SerialName("content")
    val content: String? = null
)

@Serializable
data class Source(
    @SerialName("id")
    val id: String? = null,
    @SerialName("name")
    val name: String? = null
)
