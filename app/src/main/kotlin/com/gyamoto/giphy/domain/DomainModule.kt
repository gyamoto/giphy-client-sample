package com.gyamoto.giphy.domain

import com.gyamoto.api.Api
import com.gyamoto.api.ApiBuilder
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.singleton

val domainModule = Kodein.Module {

    bind<Api>() with singleton { ApiBuilder.build() }
}
