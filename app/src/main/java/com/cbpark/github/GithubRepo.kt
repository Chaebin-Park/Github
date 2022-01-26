package com.cbpark.github

import com.google.gson.annotations.SerializedName

data class GithubRepo(
    @SerializedName("name") val name: String,   // Repo 제목
    @SerializedName("id") val id: String,       // 일련번호
    @SerializedName("created_at") val date: String, // 생성일
    @SerializedName("html_url") val url: String,    // Repo 사이트 주소
    @SerializedName("avatar_url") val avatarUrl: String,    // Repo 사이트 주소
    @SerializedName("language") val language: String,    // 사용 언어
    @SerializedName("private") val isPrivate: Boolean    // Private 여부
)
