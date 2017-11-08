package com.giphy

import com.giphy.model.PaginationResponse
import com.giphy.model.Response
import retrofit2.http.GET

/**
 * https://developers.giphy.com/docs/
 */
interface Api {

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
            api_key: String,
            q: String,
            limit: Int? = 25,
            offset: Int? = null,
            rating: String?,
            lang: String? = null,
            fmt: String? = null
    ): List<PaginationResponse>

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
            api_key: String,
            limit: Int? = 25,
            offset: Int? = null,
            rating: String?,
            fmt: String? = null
    ): List<PaginationResponse>

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
            api_key: String,
            tag: String? = null,
            rating: String?,
            fmt: String? = null
    ): List<Response>
}
