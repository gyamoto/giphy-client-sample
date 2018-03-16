package com.gyamoto.api

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.singleton

val sourceModule = Kodein.Module {

    bind<SourceType>() with singleton { NetworkApi() }
}
