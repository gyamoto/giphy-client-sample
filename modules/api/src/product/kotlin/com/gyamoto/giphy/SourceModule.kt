package com.gyamoto.giphy

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.singleton
import com.gyamoto.api.NetworkApi
import com.gyamoto.api.SourceType

val sourceModule = Kodein.Module {

    bind<SourceType>() with singleton { NetworkApi() }
}
