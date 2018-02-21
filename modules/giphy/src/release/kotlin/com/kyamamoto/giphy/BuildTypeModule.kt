package com.kyamamoto.giphy

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.singleton

/**
 * Created by kyamamoto on 2018/01/22.
 */
val buildTypeModule = Kodein.Module {

    bind<BuildTypeConfig>() with singleton { ReleaseBuildType() }
}
