package com.kyamamoto.kodein.domain

import com.kyamamoto.giphy.Api
import com.kyamamoto.giphy.ApiBuilder
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.singleton

/**
 * Created by kyamamoto on 2018/01/15.
 */
val domainModule = Kodein.Module {

    bind<Api>() with singleton { ApiBuilder.build() }
}
