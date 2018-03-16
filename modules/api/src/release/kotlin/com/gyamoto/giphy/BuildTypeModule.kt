package com.gyamoto.giphy

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.singleton

val buildTypeModule = Kodein.Module {

    bind<BuildTypeConfig>() with singleton { ReleaseBuildType() }
}
