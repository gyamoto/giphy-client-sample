package com.giphy

import com.giphy.model.PaginationResponse
import com.giphy.model.Response
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * https://developers.giphy.com/docs/
 */
interface Api {

    companion object {
        const val DEFAULT_LIMIT = 25
    }

    /**
     * Search all GIPHY GIFs for a word or phrase. Punctuation will be stripped and ignored. Use a plus or url encode for phrases. Example paul+rudd, ryan+gosling or american+psycho.
     *
     * @param api_key GIPHY API Key.
     * @param q Search query term or prhase.
     * @param limit The maximum number of records to return.
     * @param offset An optional results offset. Defaults to 0.
     * @param rating Filters results by specified rating.
     * @param lang Specify default language for regional content; use a 2-letter ISO 639-1 language code. See list of supported languages here.
     * @param fmt Used to indicate the expected response format. Default is Json.
     */
    @GET("/v1/gifs/search")
    fun search(
            @Query("api_key") api_key: String,
            @Query("q") q: String,
            @Query("limit") limit: Int? = DEFAULT_LIMIT,
            @Query("offset") offset: Int? = null,
            @Query("rating") rating: String? = null,
            @Query("lang") lang: String? = null,
            @Query("fmt") fmt: String? = null
    ): Single<PaginationResponse>

    /**
     * Fetch GIFs currently trending online. Hand curated by the GIPHY editorial team. The data returned mirrors the GIFs showcased on the GIPHY homepage. Returns 25 results by default.
     *
     * @param api_key GIPHY API Key.
     * @param limit The maximum number of records to return.
     * @param offset An optional results offset. Defaults to 0.
     * @param rating Filters results by specified rating.
     * @param fmt Used to indicate the expected response format. Default is Json.
     */
    @GET("/v1/gifs/trending")
    fun trending(
            @Query("api_key") api_key: String,
            @Query("limit") limit: Int? = DEFAULT_LIMIT,
            @Query("offset") offset: Int? = null,
            @Query("rating") rating: String? = null,
            @Query("fmt") fmt: String? = null
    ): Single<PaginationResponse>

    /**
     * Returns a random GIF, limited by tag. Excluding the tag parameter will return a random GIF from the GIPHY catalog.
     *
     * @param api_key GIPHY API Key.
     * @param tag Filters results by specified tag.
     * @param rating Filters results by specified rating.
     * @param fmt Used to indicate the expected response format. Default is Json.
     */
    @GET("/v1/gifs/random")
    fun random(
            @Query("api_key") api_key: String,
            @Query("tag") tag: String? = null,
            @Query("rating") rating: String? = null,
            @Query("fmt") fmt: String? = null
    ): Single<Response>
}
